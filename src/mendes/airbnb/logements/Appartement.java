package mendes.airbnb.logements;

import mendes.airbnb.utilisateurs.Hote;

public class Appartement extends Logement {
	private int numeroEtage;
	private int superficieBalcon;
	
	

	public Appartement(Hote hote, int tarifParNuit, String adresse, int superficie, int nbVoyageursMax, int numeroEtage,
			int superficieBalcon) {
		super(hote, tarifParNuit, adresse, superficie, nbVoyageursMax);
		this.numeroEtage = numeroEtage;
		this.superficieBalcon = superficieBalcon;
	}

	@Override
	public void afficher() {
		String isBalcon = (superficieBalcon > 0) ? "Oui" : "Non";
		hote.afficher();
		System.out.println("Le logement est une maison située au " + adresse + ".");
		System.out.println("Superficie : " + getSuperficie() + "m2");
		System.out.println("Balcon : " + isBalcon);  
	}	

	@Override
	public int getSuperficieTotal() {
		return getSuperficie() + superficieBalcon;
	}

}
