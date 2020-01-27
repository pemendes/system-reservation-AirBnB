package mendes.airbnb.reservations;

import java.util.Date;

import mendes.airbnb.utilisateurs.Personne;

public class Reservation {
	int identifiant;
	Sejour sejour;
	Personne voyageur;
	Boolean estValidee;
	Date dateDeReservation;
	
	public Reservation(Personne voyageur, Sejour sejour, Date dateDeReservation) {
		this.voyageur = voyageur;
		this.sejour = sejour;
		this.dateDeReservation = dateDeReservation;
	}
	
	public void afficher(){
		voyageur.afficher();
		System.out.print(" a fait une réservation chez ");
		sejour.afficher();
	}

}
