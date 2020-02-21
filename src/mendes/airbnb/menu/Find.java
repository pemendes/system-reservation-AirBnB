package mendes.airbnb.menu;

import java.util.ArrayList;

import mendes.airbnb.logements.Appartement;
import mendes.airbnb.logements.Logement;
import mendes.airbnb.logements.Maison;

public class Find {

	public static Maison findMaisonByName(String s , ArrayList<Logement> listLogement) {
		boolean verifName= false;
		Maison maison = null;
		for (int i = 0; i < listLogement.size(); i++) {
			if (( listLogement.get(i)).getName().equals(s)) {
				verifName= true;
				maison =  (Maison) listLogement.get(i);
				return maison ;
			}
		}
		if (verifName) {
			return maison ;
		}
		return maison;
	}
	
	public static Appartement findAppartementByName(String s , ArrayList<Logement> listLogement) {
		boolean verifName= false;
		Appartement appartement = null;
		for (int i = 0; i < listLogement.size(); i++) {
			if (( listLogement.get(i)).getName().equals(s)) {
				verifName= true;
				appartement =  (Appartement) listLogement.get(i);
				return appartement ;
			}
		}
		if (verifName) {
			return appartement ;
		}
		return appartement;
	}
	
	public static Logement findLogementByName(String s , ArrayList<Logement> listLogement) {
		boolean verifName= false;
		Logement logement = null;
		for (int i = 0; i < listLogement.size(); i++) {
			if (( listLogement.get(i)).getName().equals(s)) {
				verifName= true;
				logement =  listLogement.get(i);
				return logement ;
			}
		}
		if (verifName) {
			return logement ;
		}
		return logement;
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Logement> T findLogementByNameWithGenericity(String s , ArrayList<Logement> listLogement) {
		boolean verifName= false;
		T logement = null;
		for (int i = 0; i < listLogement.size(); i++) {
			if (( listLogement.get(i)).getName().equals(s)) {
				verifName= true;
				logement =  (T) listLogement.get(i);
				return logement ;
			}
		}
		if (verifName) {
			return logement ;
		}
		return logement;
	}
}
