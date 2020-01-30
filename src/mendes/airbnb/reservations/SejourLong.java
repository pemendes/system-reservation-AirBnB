package mendes.airbnb.reservations;

import java.util.Date;

import mendes.airbnb.logements.Logement;

public class SejourLong extends Sejour implements ConditionsTarifairesInterface {

	private final int PROMOTION_EN_POURCENTAGE;
	private int promotion;

	public SejourLong(Date dateArrivee, int pbNuits, Logement logement, int pbVoyageurs,
			int pPROMOTION_EN_POURCENTAGE) {

		super(dateArrivee, pbNuits, logement, pbVoyageurs);
		PROMOTION_EN_POURCENTAGE = pPROMOTION_EN_POURCENTAGE;
		//promotion = super.getTarif() - (getTarif() * PROMOTION_EN_POURCENTAGE / 100);
		promotion = super.getTarif() * PROMOTION_EN_POURCENTAGE / 100;				
	}

	@Override
	public boolean beneficePromotion() {
		if (nbNuits >= 6) {
			return true;
		}
		return false;
	}

	@Override
	public int getTarif() {
		//return super.getTarif() - promotion;
		return super.getTarif() - promotion;
	}

	@Override
	public void afficher() {
		super.afficher();
		System.out.println("(" + promotion + "€ de promotion).");
	}

	@Override
	public boolean verificationNombreDeNuits() {
		if (nbNuits >= 1 && nbNuits <= 31) {
			return true;
		}
		return false;
	}

}
