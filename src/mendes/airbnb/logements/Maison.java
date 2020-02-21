package mendes.airbnb.logements;

import mendes.airbnb.utilisateurs.Hote;

public class Maison extends Logement {

	private final int superficieJardin;
	private final boolean possedePiscine;
	
	public Maison(String name, Hote hote, int tarifParNuit, String adresse, int superficie, int nbVoyageursMax, int superficieJardin,
			boolean possedePiscine) {
		super(name, hote, tarifParNuit, adresse, superficie, nbVoyageursMax);
		this.superficieJardin = superficieJardin;
		this.possedePiscine = possedePiscine;
	}
	
	@Override
	public void afficher() {
		super.afficher();
		System.out.println("Je suis une maison");
	}
	
	@Override
	public int getSuperficieTotale() {
		return superficieJardin + getSuperficie();
	}
	
}