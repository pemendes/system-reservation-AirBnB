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

	public Reservation(int identifiant, Sejour sejour, Personne voyageur) {
		this.identifiant = identifiant;
		this.sejour = sejour;
		this.voyageur = voyageur;
		estValidee = false;
		dateDeReservation = new Date();
	}

	public void afficher() {
		voyageur.afficher();
		System.out.print(" qui a fait une réservation chez ");
		sejour.afficher();
	}
}
