package mendes.airbnb.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import mendes.airbnb.logements.Appartement;
import mendes.airbnb.logements.Logement;
import mendes.airbnb.logements.Maison;
import mendes.airbnb.reservations.Reservation;
import mendes.airbnb.utilisateurs.Hote;
import mendes.airbnb.utilisateurs.Voyageur;

public class Menu {

	static Scanner scanner;

	static ArrayList<Hote> listHotes;
	static ArrayList<Logement> listLogements;
	static ArrayList<Voyageur> listVoyageurs;
	static ArrayList<Reservation> listReservations;

	public static void main(String[] args) {

		System.out.println("Bienvenu chez aribnb");

		scanner = new Scanner(System.in);
		listHotes = new ArrayList<>();
		listLogements = new ArrayList<>();
		ParserLogementsXML.parse("logements.xml", listHotes, listLogements);

		// Méthodes 1
		Optional<Maison> optionalMaison = findMaisonByName("Maison 5678");
		
		// Avec un optional on test avant que la ref n'est pas null de cette manière
		if (optionalMaison.isPresent()) {
			Maison maison = optionalMaison.get();
			maison.afficher();
		}
		
		/*
		// On doit faire ça mais on n'est pas obligé...
		if (maison1 != null) {
			maison1.afficher();	
		}
		*/
		
		Appartement appartement1 = findAppartementByName("Appartement 2");
		
		// Méthode 2
		Maison maison2 = (Maison) findLogementByName("Maison 2");
		Appartement appartement2 = (Appartement) findLogementByName("Appartement 2");
		
		// Méthode 3
		Maison maison3 = findLogementByNameByGenericity("Maison 2");
		Appartement appartement3 = findLogementByNameByGenericity("Appartement 2");
		
		scanner.close();
	}

	static void listerMenu() {

		System.out.println("-------------------------------------");
		System.out.println("Saisir une option : ");
		System.out.println("1 : Liste des hôtes");
		System.out.println("2 : Liste des logements");
		System.out.println("3 : Liste des voyageurs");
		System.out.println("4 : Liste des réservations");
		System.out.println("5 : Fermer le programme");

		switch (choix1(5)) {
		case 1:
			GestionHotes.listerHotes();
			break;
		case 2:
			GestionLogements.listerLogements();
			break;
		case 3:
			GestionVoyageurs.listerVoyageurs();
			break;
		case 4:
			GestionReservations.listerReservations();
			break;
		case 5:
			System.out.println("A bientôt");
			break;
		}
	}

	static int choix1(int maxValue) {

		int result = 0;

		do {

			System.out.println("Saisir une entier entre 1 et " + maxValue);
			try {
				result = scanner.nextInt();
			} catch (Exception e) {
				String s = scanner.next();
				System.out.println(s + " n'est pas une bonne saisie");
			}

		} while (!(result > 0 && result <= maxValue));

		return result;

	}

	static int choix(int maxValue) {

		int choix = 0;

		boolean choixOk = false;

		do {

			try {
				choix = scanner.nextInt();

				if (choix < 1 || choix > maxValue) {
					System.out.println("Erreur ce n'est pas entre 1 et " + maxValue);
				} else {
					choixOk = true;
				}

			} catch (Exception e) {
				String s = scanner.next();
				System.out.println("Erreur " + s + " n'est pas un entier, svp saisir un truc entre 1 et " + maxValue);
			}

		} while (!choixOk);

		return choix;
	}

	private static void init() {

		listHotes = new ArrayList<>();
		listLogements = new ArrayList<>();
		listVoyageurs = new ArrayList<>();
		listReservations = new ArrayList<>();

		// Création des Hotes
		Hote hote1 = new Hote("Peter", "Bardu", 28, 12);
		Hote hote2 = new Hote("Patrick", "Martin", 32, 12);
		Hote hote3 = new Hote("Jeanne", "Voisin", 26, 24);
		Hote hote4 = new Hote("Maurice", "Meunier", 46, 12);

		listHotes.add(hote1);
		listHotes.add(hote2);
		listHotes.add(hote4);
		listHotes.add(hote3);

		// Création de Logement
		Maison maison1 = new Maison("Maison1", hote1, 40, "18 Bis rue Romain Rolland, 37230 Fondettes", 140, 2, 500, true);
		Maison maison2 = new Maison("Maison2", hote1, 35, "146 Rue George Sand, 59553 Cuincy", 120, 2, 200, false);
		Maison maison3 = new Maison("Maison3", hote1, 60, "13 Rue de la Liberté, 62800 Liévin", 90, 4, 2000, true);
		Appartement appartement1 = new Appartement("Appartement1", hote1, 35, "46 Rue des Canonniers, 59800 Lille", 72, 2, 3, 20);
		Appartement appartement2 = new Appartement("Appartement2", hote1, 35, "111 Rue Colbert, 37000 Tours", 42, 2, 2, 0);

		listLogements.add(maison1);
		listLogements.add(maison2);
		listLogements.add(maison3);
		listLogements.add(appartement1);
		listLogements.add(appartement2);

		// Création de voyageurs
		Voyageur voyageur1 = new Voyageur("Alain", "Favre", 54);
		Voyageur voyageur2 = new Voyageur("Maxime", "Albert", 29);

		listVoyageurs.add(voyageur1);
		listVoyageurs.add(voyageur2);
	}

	// ------------------------------------------------------------------
	// Méthodes 1
	static Optional<Maison> findMaisonByName(String name) {
		
		Maison maison = null;
		
		for (Logement logement : listLogements) {
			if(logement instanceof Maison && logement.getName().equals(name)) {
				maison = (Maison) logement;
				break;
			}
		}
		
		return Optional.ofNullable(maison);
	}

	static Appartement findAppartementByName(String name) {
		
		for (Logement logement : listLogements) {
			if(logement instanceof Appartement && logement.getName().equals(name)) {
				return (Appartement) logement;
			}
		}
		return null;
	}

	// ------------------------------------------------------------------
	// Méthodes 2
	static Logement findLogementByName(String name) {
		
		for (Logement logement : listLogements) {
			if(logement.getName().equals(name)) {
				return logement;
			}
		}
		
		return null;
	}

	// ------------------------------------------------------------------
	// Méthodes 3.1
	@SuppressWarnings("unchecked")
	static <T extends Logement> T findLogementByNameByGenericity(String name) {
		
		for (Logement logement : listLogements) {
			if(logement.getName().equals(name)) {
				return (T) logement;
			}
		}
		
		return null;
	}
	
	// Méthodes 3.2
	static <T extends Logement> Optional<T> findLogementByNameByGenericity2(String name) {
		
		T result = null;
		
		for (Logement logement : listLogements) {
			if(logement.getName().equals(name)) {
				result = (T) logement;
				break;
			}
		}
		
		return Optional.ofNullable(result);
	}
	


}