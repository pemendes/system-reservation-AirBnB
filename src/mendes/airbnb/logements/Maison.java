package mendes.airbnb.logements;

import mendes.airbnb.utilisateurs.Hote;

public class Maison extends Logement {
	private int superficieJardin;
	private boolean possedePiscine;

	public Maison(Hote hote, int tarifParNuit, String adresse, int superficie, int nbVoyageursMax,
			int pSuperficieJardin, boolean pPossedePiscine) {
		super(hote, tarifParNuit, adresse, superficie, nbVoyageursMax);
		superficieJardin = pSuperficieJardin;
		possedePiscine = pPossedePiscine;
	}

	@Override
	public void afficher() {
		String isPiscine = (possedePiscine == true) ? "Oui" : "Non";
		String isJardin = superficieJardin > 0 ? "Oui" : "Non";
		hote.afficher();
		System.out.println("Le logement est une maison située au " + adresse + ".");
		System.out.println("Superficie : " + getSuperficie() + "m2");
		System.out.println("Jardin : " + isJardin + " (" + superficieJardin + "m2)");
		System.out.println("Balcon : " + isPiscine);
	}

	@Override
	public int getSuperficieTotal() {
		return getSuperficie() + superficieJardin;
	}
}
