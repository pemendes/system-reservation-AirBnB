package mendes.airbnb.reservations;

import java.text.SimpleDateFormat;
import java.util.Date;

import mendes.airbnb.logements.Logement;

public class Sejour {
	Date dateArrivee;
	int nbNuits;
	Logement logement;
	int nbVoyageurs;
	
	public Sejour(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
		
		this.dateArrivee = dateArrivee;
		this.nbNuits = nbNuits;
		this.logement = logement;
		this.nbVoyageurs = nbVoyageurs;
	}
	
	public void afficher(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		int prixSejour = logement.getTarifParNuit() * nbNuits;
		logement.afficher();
		System.out.println("La date d'arrivée est le " + sdf.format(dateArrivee) + " pour " + nbNuits + " nuits.");
		System.out.println("Le prix de ce séjour est de " + prixSejour + "€.");
	}
}
