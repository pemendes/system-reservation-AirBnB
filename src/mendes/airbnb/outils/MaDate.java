package mendes.airbnb.outils;

import java.util.Date;

public class MaDate extends Date {
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("deprecation")
	public MaDate(int pJour, int pMois, int pAnnee) {
		super(pAnnee - 1900, pMois - 1, pJour);
	}
		
	
	@Override
	public String toString() {
		int year = this.getYear();
		int month = this.getMonth();
		int date = this.getDate();
		
		return date + "/" + (month + 1) + "/" + (year + 1900);
	}
}
