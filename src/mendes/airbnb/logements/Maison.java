package mendes.airbnb.logements;

import mendes.airbnb.utilisateurs.Hote;

public class Maison extends Logement {
	private int superficieJardin;
	private boolean possedePiscine;



	public Maison(String type, Hote hote, int tarifParNuit, String adresse, int superficie, int nbVoyageursMax,
			int superficieJardin, boolean possedePiscine) {
		super(type, hote, tarifParNuit, adresse, superficie, nbVoyageursMax);
		this.superficieJardin = superficieJardin;
		this.possedePiscine = possedePiscine;
	}

	@Override
	public void afficher() {
		String isPiscine = (possedePiscine == true) ? "Oui" : "Non";
		String isJardin = superficieJardin > 0 ? "Oui" : "Non";
		getHote().afficher();
		System.out.println("Le logement est une maison située au " + getAdresse() + ".");
		System.out.println("Superficie : " + getSuperficie() + "m2");
		System.out.println("Jardin : " + isJardin + " (" + superficieJardin + "m2)");
		System.out.println("Balcon : " + isPiscine);
	}

	@Override
	public int getSuperficieTotal() {
		return getSuperficie() + superficieJardin;
	}
}
