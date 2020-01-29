package mendes.airbnb.reservations;

import java.util.Date;

import mendes.airbnb.logements.Logement;
import mendes.airbnb.outils.Utile;

public class Sejour {
	
	private Date dateArrivee;
	private int nbNuits;
	private Logement logement;
	private int nbVoyageurs;
	
	public Sejour(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {	
		this.dateArrivee = dateArrivee;
		this.nbNuits = nbNuits;
		this.logement = logement;
		this.nbVoyageurs = nbVoyageurs;
	}

	public void afficher() {
		logement.afficher();
		System.out.println("La date d'arrivée : " + Utile.dateToString(dateArrivee));	
		
		int tarif = nbNuits * logement.getTarifParNuit();
		System.out.println("Le tarif est : " + tarif + " euros ");
	}
}
