package mendes.airbnb.reservations;

import java.util.Date;

import mendes.airbnb.logements.Logement;
import mendes.airbnb.outils.Utile;

public abstract class Sejour implements SejourInterface {

	private Date dateArrivee;
	protected int nbNuits;
	protected Logement logement;
	private int nbVoyageurs;
	protected int tarif;

	public Sejour(Date dateArrivee, int pNbNuits, Logement logement, int pNbVoyageurs) {
		this.dateArrivee = dateArrivee;
		nbNuits = pNbNuits;
		this.logement = logement;
		nbVoyageurs = pNbVoyageurs;
		tarif = getTarif();
	}

	@Override
	public boolean verficationDateArrivee() {
		Date dateDuJour = new Date();
		if (dateArrivee.after(dateDuJour)) {
			return true;
		}
		return false;
	}

	@Override
	public abstract boolean verificationNombreDeNuits();

	// public abstract int miseAJourDuTarif();

	@Override
	public boolean verificationNombreDeVoyageurs() {
		if (nbVoyageurs > 0 && nbVoyageurs <= logement.getNbVoyageursMax()) {
			return true;
		}
		return false;

		// return nbVoyageurs >0 && nbVoyageurs <= logement.getNbVoyageursMax();
	}

	public int getTarif() {
		return tarif = nbNuits * logement.getTarifParNuit();
	}
	
	@Override
	public void afficher() {
		logement.afficher();
		System.out.println("La date d'arrivée : " + Utile.dateToString(dateArrivee) + " pour " + nbNuits + " nuits.");
		System.out.print("Le prix de ce séjour est de : " + getTarif() + " euros ");
	}
}
