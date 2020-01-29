package mendes.airbnb.logements;

import mendes.airbnb.utilisateurs.Hote;
import mendes.airbnb.utilisateurs.Personne;

public abstract class Logement {
	protected Hote hote;
	private int tarifParNuit;
	protected String adresse;
	private int superficie;
	private int nbVoyageursMax;

	public Logement(Hote hote, int tarifParNuit, String adresse, int superficie, int nbVoyageursMax) {
		this.hote = hote;
		this.tarifParNuit = tarifParNuit;
		this.adresse = adresse;
		this.superficie = superficie;
		this.nbVoyageursMax = nbVoyageursMax;
	}	

	public Hote getHote() {
		return hote;
	}

	public int getTarifParNuit() {
		return tarifParNuit;
	}

	public String getAdresse() {
		return adresse;
	}

	public int getSuperficie() {
		return superficie;
	}

	public int getNbVoyageursMax() {
		return nbVoyageursMax;
	}
	

	
	public abstract int getSuperficieTotal();

	public abstract void afficher();
}
