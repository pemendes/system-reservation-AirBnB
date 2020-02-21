package mendes.airbnb;

import java.text.ParseException;
import java.util.Date;

import mendes.airbnb.logements.Appartement;
import mendes.airbnb.logements.Logement;
import mendes.airbnb.logements.Maison;
import mendes.airbnb.outils.MaDate;
import mendes.airbnb.outils.Utile;
import mendes.airbnb.reservations.Reservation;
import mendes.airbnb.reservations.Sejour;
import mendes.airbnb.reservations.SejourCourt;
import mendes.airbnb.reservations.SejourLong;
import mendes.airbnb.utilisateurs.Hote;
import mendes.airbnb.utilisateurs.Voyageur;

public class Main {

	public static void main(String[] args) throws ParseException {

		// ----------------------------------------------------
		// Données - Personnes et Logements
		Hote hote1 = new Hote("Peter", "Bardu", 31, 12);
		Hote hote2 = new Hote("Michel", "Jordan", 34, 1);
		Voyageur voyageur1 = new Voyageur("Jean", "Mi", 24);
		Voyageur voyageur2 = new Voyageur("Emma", "Martin", 31);

		Maison maison = new Maison("Maison 21", hote1, 100, "81 rue Colbert", 60, 4, 1000, true);
		Appartement appartement1 = new Appartement("Appart 231", hote1, 60, "83 rue Colbert", 60, 4, 2, 10);
		Appartement appartement2 = new Appartement("Appart 232", hote2, 130, "85 rue Colbert", 60, 4, 1, 0);

		// ----------------------------------------------------
		// Critère de séjour

		// Date dateArrivee = Utile.stringToDate("01/07/2020");
		Date dateArrivee = new MaDate(9, 3, 2020);
		int nbNuits = 2;
		int nbVoyageurs = 2;
		Logement logement = maison;

		Sejour sejour;

		if (nbNuits < 6) {
			sejour = new SejourCourt(dateArrivee, nbNuits, logement, nbVoyageurs);
		} else {
			sejour = new SejourLong(dateArrivee, nbNuits, logement, nbVoyageurs);
		}

		// Problème 1
		//dateArrivee.setYear(98);

		// Problème 2
		//Date dateDeSejour = sejour.getDateArrivee();
		//dateDeSejour.setYear(67);

		// Problème 3
		//sejour.setLogement(appartement1);


		try {
		
			Reservation reservation = new Reservation(0, sejour, voyageur1);
			
			// Problème 3.2 et 3.3
			Utile.sendEmail((Reservation)reservation.clone());
			
			reservation.afficher();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}