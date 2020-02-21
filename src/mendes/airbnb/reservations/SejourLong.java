package mendes.airbnb.reservations;

import java.util.Date;

import mendes.airbnb.logements.Logement;

public class SejourLong extends Sejour implements ConditionTarifaireInterface {

	private static final int PROMOTION_EN_POURCENTAGE = 20;

	private int promotion;

	public SejourLong(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
		super(dateArrivee, nbNuits, logement, nbVoyageurs);
	}

	@Override
	protected void miseAJourTarif() {
		int tarifInitial = nbNuits * logement.getTarifParNuit();
		promotion = tarifInitial * PROMOTION_EN_POURCENTAGE / 100;
		tarif = tarifInitial - promotion;
	}	
	
	@Override
	public void afficher() {
		super.afficher();
		
		System.out.println("Le tarif est : " + tarif + " euros dont " + promotion + " euros de promotion");
	}
	
	@Override
	public boolean benefiniePromotion() {
		return true;
	}

	@Override
	public int getTarif() {
		return tarif;
	}

	@Override
	public boolean verificationNombreDeNuits() {
		return nbNuits >= 6 && nbNuits <= 31;
	}

}