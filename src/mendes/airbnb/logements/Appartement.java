package mendes.airbnb.logements;

import mendes.airbnb.utilisateurs.Hote;

public class Appartement extends Logement {

	public final int numeroEtage;
	public final int superficieBalcon;

	public Appartement(String name, Hote hote, int tarifParNuit, String adresse, int superficie, int nbVoyageursMax,
			int numEtage, int superficieBalcon) {
		super(name, hote, tarifParNuit, adresse, superficie, nbVoyageursMax);

		this.numeroEtage = numEtage;
		this.superficieBalcon = superficieBalcon;
	}

	@Override
	public void afficher() {
		super.afficher();
		System.out.println("Je suis un appartement");

	}

	@Override
	public int getSuperficieTotale() {
		return superficieBalcon + getSuperficie();
	}

	public int getSuperficieBalcon() {
		return superficieBalcon;
	}

}