package mendes.airbnb.logements;

import mendes.airbnb.utilisateurs.Hote;

public abstract class Logement {
	private String type;
	private Hote hote;
	private int tarifParNuit;
	private String adresse;
	private int superficie;
	private int nbVoyageursMax;
	
	public Logement(String type, Hote hote, int tarifParNuit, String adresse, int superficie, int nbVoyageursMax) {
		this.type = type;
		this.hote = hote;
		this.tarifParNuit = tarifParNuit;
		this.adresse = adresse;
		this.superficie = superficie;
		this.nbVoyageursMax = nbVoyageursMax;
	}
	
	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
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
