package mendes.airbnb.menu;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import mendes.airbnb.logements.Appartement;
import mendes.airbnb.logements.Logement;
import mendes.airbnb.logements.Maison;
import mendes.airbnb.utilisateurs.Hote;

public class ParserLogementsXML {
	
	public static void parser(String pathName, ArrayList<Hote> listHotes, ArrayList<Logement> listLogements) {
				
		try {

			File file = new File(pathName);

			DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(file);

			Element logements = document.getDocumentElement();
			System.out.println(logements.getNodeName()); // Logements

			NodeList nodeDeLogements = logements.getChildNodes();
			
			for (int i = 0; i < nodeDeLogements.getLength(); i++) {
				
				if (nodeDeLogements.item(i).getNodeType() == Node.ELEMENT_NODE) {
					Element elementLogement = (Element) nodeDeLogements.item(i);
					
					// Hote
					Element elementHote = (Element) elementLogement.getElementsByTagName("hote").item(0);
					
					String prenom  = elementHote.getElementsByTagName("prenom").item(0).getTextContent();
					String nom = elementHote.getElementsByTagName("nom").item(0).getTextContent();
					int age = Integer.parseInt(elementHote.getElementsByTagName("age").item(0).getTextContent());
					int delaiReponse = Integer.parseInt(elementHote.getElementsByTagName("delaiReponse").item(0).getTextContent());
					
					// Création de l'hôte que l'on va ajouter seulement s'il n'est pas dans la liste du point de vue de son état
					Hote hote = new Hote(prenom, nom, age, delaiReponse);
										
					// On cherche (à la main) si cet hôte est déjà dans la liste
					boolean isPresent = false;
					for (int j = 0; j < listHotes.size(); j++) {
						
						if (listHotes.get(j).equals(hote)) {
							isPresent = true;
							hote = listHotes.get(j);
							break;
						}
					}
					
					// Ou sinon on utilise la méthode contains de List
					//boolean isPresent = listHotes.contains(hote);
					//listHotes.indexOf(hote); // A utiliser sans la méthode contains
					
					if (!isPresent) {
						listHotes.add(hote);						
					}
									
					// Le logement
					int tarifParNuit = Integer.parseInt(elementLogement.getElementsByTagName("tarifParNuit").item(0).getTextContent());
					String adresse = elementLogement.getElementsByTagName("adresse").item(0).getTextContent();
					int superficie = Integer.parseInt(elementLogement.getElementsByTagName("superficie").item(0).getTextContent());
					int nbVoyageursMax = Integer.parseInt(elementLogement.getElementsByTagName("nbVoyageursMax").item(0).getTextContent());
					
					if(elementLogement.getNodeName().equals("Maison")) {
						int superficieJardin = Integer.parseInt(elementLogement.getElementsByTagName("superficieJardin").item(0).getTextContent());
						boolean possedePiscine = Integer.parseInt(elementLogement.getElementsByTagName("possedePiscine").item(0).getTextContent()) == 1;

						Maison maison = new Maison(hote, tarifParNuit, adresse, superficie, nbVoyageursMax, superficieJardin, possedePiscine);
						listLogements.add(maison);
						
					} else if(elementLogement.getNodeName().equals("Appartement")) {
						int  superficieBalcon = Integer.parseInt(elementLogement.getElementsByTagName("superficieBalcon").item(0).getTextContent());
						int  numeroEtage = Integer.parseInt(elementLogement.getElementsByTagName("numeroEtage").item(0).getTextContent());
						
						Appartement appartement = new Appartement(hote, tarifParNuit, adresse, superficie, nbVoyageursMax, numeroEtage, superficieBalcon);
						listLogements.add(appartement);
					}					
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
	}
	
	
}