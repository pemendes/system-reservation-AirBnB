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

		Logement maison = new Maison("Maison", hote, 40, "292 rue Colbert, 37000 Tours", 140, 1, 500, true);
		Logement appartement = new Appartement("Appartement", hote, 35, "46 Rue des Canonniers, 59800 Lille", 72, 2, 3, 0);

		MaDate dateArrivee = new MaDate(5, 12, 2016);
		int nbNuits = 0;
		int nbVoyageurs = 0;
		Sejour sejour;
		
		if (nbNuits > 5) {
			sejour = new SejourLong(dateArrivee, nbNuits, appartement, nbVoyageurs);
		} else {
			sejour = new SejourCourt(dateArrivee, nbNuits, maison, nbVoyageurs);
		}

		Reservation reservation = new Reservation(0, sejour, voyageur);

		System.out.println("");
		reservation.afficher();
	}
}
