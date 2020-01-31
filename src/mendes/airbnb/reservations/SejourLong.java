package mendes.airbnb.reservations;

import java.util.Date;

import mendes.airbnb.logements.Logement;

public class SejourLong extends Sejour implements ConditionsTarifairesInterface {

	private static final int PROMOTION_EN_POURCENTAGE = 20;
	private int promotion;

	public SejourLong(Date dateArrivee, int pbNuits, Logement logement, int pbVoyageurs) {
		super(dateArrivee, pbNuits, logement, pbVoyageurs);
	}

	@Override
	public boolean beneficePromotion() {
		if (nbNuits >= 6) {
			return true;
		}
		return false;
	}


	@Override
	public boolean verificationNombreDeNuits() {
		if (nbNuits >= 1 && nbNuits <= 31) {
			return true;
		}
		return false;
	}

	@Override
	public void miseAJourDuTarif() {
		tarif = nbNuits * logement.getTarifParNuit();
		promotion =  tarif * PROMOTION_EN_POURCENTAGE / 100;	
		tarif = tarif - promotion;
	}

	@Override
	public void afficher() {
		super.afficher();
		System.out.println("(" + promotion + "€ de promotion).");
	}
}
