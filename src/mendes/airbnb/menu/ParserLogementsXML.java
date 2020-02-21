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

	public static void parse(String path, ArrayList<Hote> listHotes, ArrayList<Logement> listLogements) {

		if (listHotes == null || listLogements == null) {
			return;
		}
		
		try {
			File file = new File(path);

			DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(file);

			System.out.println(document.getChildNodes().getLength());
			
			Node node = document.getChildNodes().item(0); // Logements
			
			for (int i = 0; i < node.getChildNodes().getLength(); i++) {
				
				Node nodeItem = node.getChildNodes().item(i); 

				if (nodeItem.getNodeType() == Node.ELEMENT_NODE) {
					
					Element element = (Element) nodeItem;// Appartement / Maison
					
					Element nodeHote = (Element) element.getElementsByTagName("hote").item(0); // hote
					String prenom = nodeHote.getElementsByTagName("prenom").item(0).getTextContent();
					String nom = nodeHote.getElementsByTagName("nom").item(0).getTextContent();
					int age = Integer.parseInt(nodeHote.getElementsByTagName("age").item(0).getTextContent());
					int delaiReponse = Integer.parseInt(nodeHote.getElementsByTagName("delaiReponse").item(0).getTextContent());
					
					Hote newHote = new Hote(prenom, nom, age, delaiReponse);
					
					boolean isPresent = false;
					for (Hote hote : listHotes) {
						if (hote.equals(newHote)) {
							isPresent = true;
							newHote = hote;
							break;
						}
					}
					
					if (!isPresent) {
						listHotes.add(newHote);	
					}
					
					int tarifParNuit = Integer.parseInt(element.getElementsByTagName("tarifParNuit").item(0).getTextContent());
					String adresse = element.getElementsByTagName("adresse").item(0).getTextContent();
					int superficie= Integer.parseInt(element.getElementsByTagName("superficie").item(0).getTextContent());
					int nbVoyageursMax= Integer.parseInt(element.getElementsByTagName("nbVoyageursMax").item(0).getTextContent());
					
					String name = element.getAttribute("name");
					
					if (element.getNodeName().equals("Appartement")) {
						int numeroEtage = Integer.parseInt(element.getElementsByTagName("numeroEtage").item(0).getTextContent());
						int superficieBalcon = Integer.parseInt(element.getElementsByTagName("superficieBalcon").item(0).getTextContent());
						Appartement appartement = new Appartement(name, newHote, tarifParNuit, adresse, superficie, nbVoyageursMax, numeroEtage, superficieBalcon);
						
						listLogements.add(appartement);
					}

					if (element.getNodeName().equals("Maison")) {
						int superficieJardin = Integer.parseInt(element.getElementsByTagName("superficieJardin").item(0).getTextContent());
						int possedePiscine = Integer.parseInt(element.getElementsByTagName("possedePiscine").item(0).getTextContent());
						Maison maison = new Maison(name, newHote, tarifParNuit, adresse, superficie, nbVoyageursMax, superficieJardin, possedePiscine == 0 ? false : true);
						
						listLogements.add(maison);
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();		
		}
		
		
	}
	
	
}