package mendes.airbnb;


import java.text.ParseException;

import mendes.airbnb.logements.Appartement;
import mendes.airbnb.logements.Maison;
import mendes.airbnb.outils.MaDate;
import mendes.airbnb.reservations.Reservation;
import mendes.airbnb.reservations.Sejour;
import mendes.airbnb.utilisateurs.Hote;
import mendes.airbnb.utilisateurs.Voyageur;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		// ----------------------------------------------------
				// Données - Personnes et Logements
				Hote personne1 = new Hote("Peter", "Bardu", 31, 12);
				Voyageur personne2 = new Voyageur("Michel", "Jordan", 34);
				Voyageur personne3 = new Voyageur("Jean", "Mi", 24);
				Hote personne4 = new Hote("Emma", "Martin", 31, 2);

				Maison logement1 = new Maison(personne1, 100, "81 rue Colbert", 80, 4, 40, true);
				Appartement logement2 = new Appartement(personne1, 60, "83 rue Colbert", 60, 4, 1, 20);
				Maison logement3 = new Maison(personne4, 130, "85 rue Colbert", 60, 4, 20, false);

				// ----------------------------------------------------
				// Critère de séjour
				//Date dateArrivee = Utile.stringToDate("01/07/2020");
				MaDate dateArrivee = new MaDate(01, 7, 2020);
				int nbNuits = 2;
				int nbVoyageurs = 2;
				Appartement logement = logement2;

				Sejour sejour = new Sejour(dateArrivee, nbNuits, logement, nbVoyageurs);

				Reservation reservation = new Reservation(0, sejour, personne3);
				reservation.afficher();
				
				//System.out.println("----------- Test MaDate -----------");
				
				//MaDate d = new MaDate("04/01/2020");
				//System.out.println(d.toString());
			}
}

