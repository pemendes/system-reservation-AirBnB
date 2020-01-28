package mendes.airbnb.reservations;

import java.text.ParseException;
import java.util.Date;

import mendes.airbnb.outils.Utile;
import mendes.airbnb.utilisateurs.Personne;

public class Reservation {
	private int identifiant;
	private Sejour sejour;
	private Personne voyageur;
	private boolean estValidee;
	private Date dateDeReservation;
	
	public Reservation(Personne voyageur, Sejour sejour, Date dateDeReservation) {
		identifiant = 0;
		this.voyageur = voyageur;
		this.sejour = sejour;
		estValidee = false;
		this.dateDeReservation = dateDeReservation;
		
	}
	
	public void afficher() throws ParseException{
		voyageur.afficher();
		String date = Utile.afficherMaDate(dateDeReservation);
		System.out.print(" a fait une réservation chez ");
		sejour.afficher();
		System.out.println();
		System.out.println("Reservation faite le " + date + ".");
	}

}
