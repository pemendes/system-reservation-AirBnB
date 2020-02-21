package mendes.airbnb.reservations;

import java.util.Date;

import mendes.airbnb.logements.Logement;
import mendes.airbnb.outils.Utile;

public abstract class Sejour implements SejourInterface, Cloneable {

	protected Date dateArrivee;
	protected int nbNuits;
	protected Logement logement;
	protected int nbVoyageurs;
	protected int tarif;

	public Sejour(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
		this.dateArrivee = (Date) dateArrivee.clone();
		this.nbNuits = nbNuits;
		this.logement = logement;
		this.nbVoyageurs = nbVoyageurs;

		miseAJourTarif();
	}

	protected abstract void miseAJourTarif();

	@Override
	public void afficher() {
		logement.afficher();
		System.out.println("La date d'arrivée : " + dateArrivee);
	}

	@Override
	public boolean verficationDateArrivee() {
		Date dateCourante = new Date();
		return dateCourante.before(dateArrivee);
	}

	@Override
	public boolean verificationNombreDeVoyageurs() {
		return nbVoyageurs >= 1 && nbVoyageurs <= logement.getNbVoyageursMax();
	}

	public Date getDateArrivee() {
		return (Date) dateArrivee.clone();
	}

	public void setDateArrivee(Date dateArrivee) {
		if (dateArrivee == null) {
			throw new IllegalArgumentException("La dateArrivee est null");
		}
		
		this.dateArrivee = (Date) dateArrivee.clone();
	}

	/**
	 * 
	 * @param logement
	 * @throws IllegalArgumentException
	 */
	public void setLogement(Logement logement) throws IllegalArgumentException {

		if (logement == null) {
			throw new IllegalArgumentException("Le logement est null");
		}

		this.logement = logement;
		miseAJourTarif();
	}


	public Object clone() {
		Sejour sejour = null;
		try {
			// On récupère l'instance à renvoyer par l'appel de la 
			// méthode super.clone()
			sejour =(Sejour) super.clone();
		} catch(CloneNotSupportedException cnse) {
			// Ne devrait jamais arriver car nous implémentons 
			// l'interface Cloneable
			cnse.printStackTrace(System.err);
		}
		
		// On clone l'attribut de type Date qui n'est pas immuable.
		sejour.dateArrivee = (Date) dateArrivee.clone();
		
		// On ne clone pas logement car il est immuable
		// On ne clone pas nbNuits, nbVoyageurs car se sont des types primitifs (passage par valeur).
		
		// on renvoie le clone
		return sejour;
	}
}