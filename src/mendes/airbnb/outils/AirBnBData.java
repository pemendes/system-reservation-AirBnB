package mendes.airbnb.outils;

import java.util.ArrayList;

import mendes.airbnb.logements.Logement;
import mendes.airbnb.menu.ParserLogementsXML;
import mendes.airbnb.utilisateurs.Hote;


public class AirBnBData {

	private static AirBnBData INSTANCE;
	
	private ArrayList<Hote> listHotes;
	private ArrayList<Logement> listLogements;
	
	private AirBnBData() {
		listHotes = new ArrayList<>();
		listLogements = new ArrayList<>();
		ParserLogementsXML.parse("Logements.xml", listHotes, listLogements);
	}
	
	public static AirBnBData getInstance() {
		
		if (INSTANCE == null) {
			INSTANCE = new AirBnBData();
		}
		
		return INSTANCE;
	}

	public ArrayList<Logement> getListLogements() {
		return listLogements;
	}
	
	public ArrayList<Hote> getListHotes() {
		return listHotes;
	}
	
}