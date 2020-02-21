package mendes.airbnb.reservations;

import java.util.Date;

import mendes.airbnb.logements.Logement;

public class SejourCourt extends Sejour implements ConditionTarifaireInterface {

	public SejourCourt(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
		super(dateArrivee, nbNuits, logement, nbVoyageurs);	
	}

	@Override
	protected void miseAJourTarif() {
		this.tarif = nbNuits * logement.getTarifParNuit();
	}	
	
	@Override
	public void afficher() {	
		super.afficher();
		System.out.println("Le tarif est : " + tarif + " euros ");
	}

	@Override
	public boolean benefiniePromotion() {
		return false;
	}

	@Override
	public int getTarif() {
		return tarif;
	}

	@Override
	public boolean verificationNombreDeNuits() {
		return nbNuits >= 1 && nbNuits <= 5;
	}	
}