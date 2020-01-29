package mendes.airbnb.outils;

import java.util.Date;

/**
 * 
 * @author peterbardu
 *
 */
public class Utile {
	
	/**
	 * Méthode permettant de créer une date à partir d'une chaîne de caractères au format mois/jour/année (e.g. 04/02/2020 pour le 2 Avril 2020)
	 * <br>
	 * <b>ATTENTION FORMAT AMERICAIN</b> 
	 * @param pStringDate au format mois/jour/année (e.g. 04/02/2020 pour le 2 Avril 2020)
	 * @return ma date bien initialisée
	 */
	public static Date stringToDate(String pStringDate) {
		return new Date(pStringDate);
	}
	
	/**
	 * Méthode permettant de créer une date à partir de jour mois année (e.g. jour : 2, mois : 4, année : 2020 pour le 2 Avril 2020)
	 * @param jour le jour de la date entre 1 et 31
	 * @param mois le mois de la date entre 1 et 12 (e.g. 1 pour janvier)
	 * @param annee l'année de la date (e.g. 2020 pour l'année 2020) 
	 * @return ma date bien initialisée
	 */
	public static Date stringToDate(int jour, int mois, int annee) {
		return new Date(annee - 1900, mois - 1, jour);
	}
	
	/**
	 * 
	 * @param date obj date à afficher
	 * @return une chaîne de caractères au format jour/mois/année
	 */
	public static String dateToString(Date date) {
		return date.getDate() + "/" + (date.getMonth() + 1)+ "/" + (date.getYear() + 1900);
	}
}