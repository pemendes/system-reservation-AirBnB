package mendes.airbnb;


import java.text.ParseException;
import java.util.Date;
import mendes.airbnb.logements.Logement;
import mendes.airbnb.reservations.Reservation;
import mendes.airbnb.reservations.Sejour;
import mendes.airbnb.utilisateurs.Personne;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		String dateEntree = "05/12/2016";
		Date dateDeReservasion = new Date();	
		
		Personne voyageur = new Personne("Maxime", "Albert", 29);
		Personne hote = new Personne("Peter", "Bardu", 28);
		
		Logement logement = new Logement(hote, 40, "81 Rue Colbert, 37000 Tours", 140, 1);
		
		Sejour sejour = new Sejour(dateEntree, 4, logement, 2);
		
		Reservation reservation = new Reservation(voyageur, sejour, dateDeReservasion);
		
		reservation.afficher();		
	}
}
