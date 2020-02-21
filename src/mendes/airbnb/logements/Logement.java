package mendes.airbnb.logements;

import mendes.airbnb.utilisateurs.Hote;
import mendes.airbnb.outils.Comparable;

public abstract class Logement implements Comparable {

	private final String name;
	private final Hote hote;
	private final int tarifParNuit;
	private final String adresse;
	private final int superficie;
	private final int nbVoyageursMax;

	public Logement(String name, Hote hote, int tarifParNuit, String adresse, int superficie, int nbVoyageursMax) {
		super();
		this.hote = hote;
		this.tarifParNuit = tarifParNuit;
		this.adresse = adresse;
		this.superficie = superficie;
		this.nbVoyageursMax = nbVoyageursMax;
		this.name = name;
	}

	public int getTarifParNuit() {
		return tarifParNuit;
	}
	
	public int getSuperficie() {
		return superficie;
	}
	
	public int getNbVoyageursMax() {
		return nbVoyageursMax;
	}
	
	public Hote getHote() {
		return hote;
	}

	public void afficher() {
		hote.afficher();
		System.out.println(".");		
		System.out.println("L'adresse : " + adresse);
	}
	
	public abstract int getSuperficieTotale();

	public String getName() {
		return name;
	}

	@Override
	public int getValueToCompare() {
		return tarifParNuit;
	}
	
}