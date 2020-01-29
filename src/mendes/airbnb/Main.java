package mendes.airbnb;


import java.text.ParseException;
import java.util.Date;
import mendes.airbnb.logements.Logement;
import mendes.airbnb.outils.Utile;
import mendes.airbnb.reservations.Reservation;
import mendes.airbnb.reservations.Sejour;
import mendes.airbnb.utilisateurs.Personne;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		// ----------------------------------------------------
				// Données - Personnes et Logements
				Personne personne1 = new Personne("Peter", "Bardu", 31);
				Personne personne2 = new Personne("Michel", "Jordan", 34);
				Personne personne3 = new Personne("Jean", "Mi", 24);
				Personne personne4 = new Personne("Emma", "Martin", 31);

				Logement logement1 = new Logement(personne1, 100, "81 rue Colbert", 60, 4);
				Logement logement2 = new Logement(personne1, 60, "83 rue Colbert", 60, 4);
				Logement logement3 = new Logement(personne4, 130, "85 rue Colbert", 60, 4);

				// ----------------------------------------------------
				// Critère de séjour
				Date dateArrivee = Utile.stringToDate("01/07/2020");
				int nbNuits = 2;
				int nbVoyageurs = 2;
				Logement logement = logement2;

				Sejour sejour = new Sejour(dateArrivee, nbNuits, logement, nbVoyageurs);

				Reservation reservation = new Reservation(0, sejour, personne3);
				reservation.afficher();
			}
}

