package mendes.airbnb.reservations;

import java.util.Date;

import mendes.airbnb.logements.Logement;

public class SejourCourt extends Sejour implements ConditionsTarifairesInterface {

	public SejourCourt(Date dateArrivee, int pNbNuits, Logement logement, int pNbVoyageurs) {
		super(dateArrivee, pNbNuits, logement, pNbVoyageurs);
	}

	@Override
	public void miseAJourDuTarif() {
		tarif = nbNuits * logement.getTarifParNuit();
	}

	@Override
	public boolean verificationNombreDeNuits() {
		if (nbNuits >= 1 && nbNuits <= 31) {
			return true;
		}
		return false;
	}

	@Override
	public boolean beneficePromotion() {
		return false;
	}

	@Override
	public void afficher() {
		super.afficher();
	}
}
