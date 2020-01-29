package mendes.airbnb.outils;

import java.util.Date;

public class MaDate extends Date {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur permettant de créer une date à partir de jour mois année (e.g. jour :
	 * 2, mois : 4, année : 2020 pour le 2 Avril 2020)
	 * 
	 * @param jour  le jour de la date entre 1 et 31
	 * @param mois  le mois de la date entre 1 et 12 (e.g. 1 pour janvier)
	 * @param annee l'année de la date (e.g. 2020 pour l'année 2020)
	 * @return ma date bien initialisée
	 */
	@SuppressWarnings("deprecation")
	public MaDate(int pJour, int pMois, int pAnnee) {
		super(pAnnee - 1900, pMois - 1, pJour);
	}

	@SuppressWarnings("deprecation")
	public MaDate(String pDate) {
		super(pDate);
	}

	/**
	 * 
	 * @param date obj date à afficher
	 * @return une chaîne de caractères au format jour/mois/année
	 */
	@SuppressWarnings("deprecation")
	@Override
	public String toString() {
		int year = this.getYear();
		int month = this.getMonth();
		int date = this.getDate();
		return date + "/" + (month + 1) + "/" + (year + 1900);

	}
}
