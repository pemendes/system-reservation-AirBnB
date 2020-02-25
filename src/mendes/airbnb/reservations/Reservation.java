package mendes.airbnb.reservations;

import java.util.Date;

import mendes.airbnb.utilisateurs.Voyageur;

public class Reservation implements Cloneable {

	private int identifiant;
	private Sejour sejour;
	private Voyageur voyageur;
	private boolean estValidee;
	private Date dateDeReservation;

	/**
	 * 
	 * @param identifiant
	 * @param sejour
	 * @param voyageur
	 * @throws IllegalArgumentException
	 */
	public Reservation(int identifiant, Sejour sejour, Voyageur voyageur) throws IllegalArgumentException {

		// Problème 3.1
		if (sejour == null || voyageur == null) {
			throw new IllegalArgumentException("Sejour ou voyageur null");
		}

		if (!sejour.verficationDateArrivee()) {
			throw new IllegalArgumentException("Date d'arrivée non valide");
		}

		if (!sejour.verificationNombreDeNuits()) {
			throw new IllegalArgumentException("Nombre de nuits non valide");
		}

		if (!sejour.verificationNombreDeVoyageurs()) {
			throw new IllegalArgumentException("Nombre de voyageurs non valide");
		}

		this.identifiant = identifiant;
		this.sejour = sejour;
		this.voyageur = voyageur;
		estValidee = false;
		dateDeReservation = new Date();
	}

	public void setEstValidee(boolean estValidee) {
		this.estValidee = estValidee;
	}

	public void afficher() {
		voyageur.afficher();
		System.out.print(" qui a fait une réservation (validée ? " + estValidee + ") chez ");
		sejour.afficher();
	}
	
	public Sejour getSejour() {
		return sejour;
	}
	
	public Object clone() {
		
		Reservation reservation = null;
		
		try {
			reservation = (Reservation) super.clone();
			reservation.sejour = (Sejour) sejour.clone();
			reservation.dateDeReservation = (Date) dateDeReservation.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return reservation;
	}
	
	
}