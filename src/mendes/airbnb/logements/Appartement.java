package mendes.airbnb.logements;

import mendes.airbnb.utilisateurs.Hote;

public class Appartement extends Logement {
	private int numeroEtage;
	private int superficieBalcon;

	public Appartement(String type, Hote hote, int tarifParNuit, String adresse, int superficie, int nbVoyageursMax,
			int numeroEtage, int superficieBalcon) {
		super(type, hote, tarifParNuit, adresse, superficie, nbVoyageursMax);
		this.numeroEtage = numeroEtage;
		this.superficieBalcon = superficieBalcon;
	}

	@Override
	public int getSuperficieTotal() {
		return getSuperficie() + superficieBalcon;
	}

	@Override
	public void afficher() {
		String isBalcon = (superficieBalcon > 0) ? "Oui" : "Non";
		getHote().afficher();
		System.out
				.println("Le logement est un appartement située au " + getAdresse() + " au " + numeroEtage + "ème étage.");
		System.out.println("Superficie : " + getSuperficie() + "m2");
		System.out.println("Balcon : " + isBalcon);
	}
}
