package mendes.airbnb.outils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * classe Utile qui permet de construire et afficher une date en appelant ses méthode
 * construirDate() pour créer une date et afficherDate() pour afficher une date.
 * @author pedro
 * @since 28/01/2020
 * @version 1001
 */

public class Utile {
	
	private static String pattern = "dd/MM/yyyy";
	private static SimpleDateFormat sdf = new SimpleDateFormat(pattern); 
	
	
	/**
	 * Méthode permettant de créer un objet date à partir d'un parametre String au format pattern("dd/MM/yyy")
	 * dd: pour le jour
	 * MM: pour le mois
	 * yyyy: pour l'année
	 * (e.g. String date = "01/01/1970" ===> Date date)
	 * @param date String au format pattern("dd/MM/yyy")
	 * @return ma date est initialisée
	 * @throws ParseException
	 */
	public static Date construirDate(String date) throws ParseException {
		Date d = sdf.parse(date);
		return d;
	}
	
	/**
	 * Affichage de la date sous forme de string 
	 * @param date
	 * @return
	 */
	public static String afficherMaDate(Date date) {
		String s = sdf.format(date);
		return s;
	}	
}
