package mendes.airbnb.reservations;

import java.text.ParseException;

import mendes.airbnb.logements.Logement;
import mendes.airbnb.outils.Utile;

public class Sejour {
	private String dateArrivee;
	private int nbNuits;
	private Logement logement;
	private int nbVoyageurs;
	
	public Sejour(String dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
		
		this.dateArrivee = dateArrivee;
		this.nbNuits = nbNuits;
		this.logement = logement;
		this.nbVoyageurs = nbVoyageurs;
	}
	
	public void afficher() throws ParseException{
		
		int prixSejour = logement.getTarifParNuit() * nbNuits;
		String date = Utile.afficherMaDate(Utile.construirDate(dateArrivee));
		
		logement.afficher();
		System.out.println("La date d'arrivée est le " + date + " pour " + nbNuits + " nuits.");
		System.out.println("Le prix de ce séjour est de " + prixSejour + "€.");
	}
}
