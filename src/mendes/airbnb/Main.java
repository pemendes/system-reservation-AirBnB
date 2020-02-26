package mendes.airbnb;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import mendes.airbnb.logements.Appartement;
import mendes.airbnb.logements.Logement;
import mendes.airbnb.logements.Maison;
import mendes.airbnb.outils.MaDate;
import mendes.airbnb.outils.Search;
import mendes.airbnb.outils.Search.SearchBuilder;
import mendes.airbnb.outils.Utile;
import mendes.airbnb.reservations.Reservation;
import mendes.airbnb.reservations.Sejour;
import mendes.airbnb.reservations.SejourFactory;
import mendes.airbnb.utilisateurs.Hote;
import mendes.airbnb.utilisateurs.Voyageur;

public class Main {

	public static void main(String[] args) throws ParseException {

		// ----------------------------------------------------
		// Données - Personnes et Logements
		Hote hote1 = new Hote(null, "Bardu", 31, 12);
		Hote hote2 = new Hote("Michel", "Jordan", 34, 1);
		Voyageur voyageur1 = new Voyageur("Jean", "Mi", 24);
		Voyageur voyageur2 = new Voyageur("Emma", "Martin", 31);

		Maison maison = new Maison("Maison 21", hote1, 100, "81 rue Colbert", 60, 4, 1000, true);
		Appartement appartement1 = new Appartement("Appart 231", hote1, 60, "83 rue Colbert", 60, 4, 2, 10);
		Appartement appartement2 = new Appartement("Appart 232", hote2, 1300, "85 rue Colbert", 60, 4, 1, 0);

		// ----------------------------------------------------
		// Critère de séjour
		Date dateArrivee = new MaDate(9, 3, 2020);
		int nbNuits = 3;
		int nbVoyageurs = 2;
		Logement logement = maison;

		Sejour sejour = SejourFactory.getSejour(dateArrivee, nbNuits, logement, nbVoyageurs);

		try {
			Reservation reservation = new Reservation(0, sejour, voyageur1);
			// reservation.afficher();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		// ----------------------------------------------------
		// Recherche + affichage du résultat
		Search search = new Search.SearchBuilder(2).build();
		search.result().forEach(Logement::afficher);
		
		
	}
}