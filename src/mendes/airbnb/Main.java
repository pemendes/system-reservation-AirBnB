package mendes.airbnb;

import java.text.ParseException;

import mendes.airbnb.logements.Appartement;
import mendes.airbnb.logements.Logement;
import mendes.airbnb.logements.Maison;
import mendes.airbnb.outils.MaDate;
import mendes.airbnb.reservations.Reservation;
import mendes.airbnb.reservations.Sejour;
import mendes.airbnb.reservations.SejourCourt;
import mendes.airbnb.reservations.SejourLong;
import mendes.airbnb.utilisateurs.Hote;
import mendes.airbnb.utilisateurs.Voyageur;

public class Main {

	public static void main(String[] args) throws ParseException {

		System.out.println("Bienvenue chez AirBnB");
		System.out.println("Réservation n°1");
		System.out.println("");

		Hote hote = new Hote("Peter", "Bardu", 31, 12);
		// Hote hote1 = new Hote("Emma", "Martin", 31, 2);
		Voyageur voyageur = new Voyageur("Maxime", "Albert", 29);
		// Voyageur voyageur2 = new Voyageur("Michel", "Jordan", 34);

		Logement maison = new Maison(hote, 40, "292 rue Colbert, 37000 Tours", 140, 1, 500, true);
		Logement appartement = new Appartement(hote, 35, "46 Rue des Canonniers, 59800 Lille", 72, 2, 3, 0);

		MaDate dateArrivee = new MaDate(5, 12, 2016);
		int nbNuits = 4;
		int nbNuits1 = 7;
		int nbVoyageurs = 2;

		Sejour sejourCourt = new SejourCourt(dateArrivee, nbNuits, maison, nbVoyageurs);
		Sejour sejourLong = new SejourLong(dateArrivee, nbNuits1, appartement, nbVoyageurs);

		Reservation reservation1 = new Reservation(0, sejourCourt, voyageur);
		Reservation reservation2 = new Reservation(0, sejourLong, voyageur);

		System.out.println("--------- Court séjour ---------");
		System.out.println("");
		reservation1.afficher();
		System.out.println("");
		System.out.println("");
		System.out.println("Réservation n°2");
		System.out.println("");
		System.out.println("--------- Long séjour ---------");
		System.out.println("");
		reservation2.afficher();
	}
}
