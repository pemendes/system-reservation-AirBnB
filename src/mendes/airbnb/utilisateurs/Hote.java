package mendes.airbnb.utilisateurs;

public class Hote extends Personne {

	private final int delaiDeReponse;

	public Hote(String pPrenom, String pNom, int pAge, int delaiDeReponse) {
		super(pPrenom, pNom, pAge);

		this.delaiDeReponse = delaiDeReponse;
	}

	@Override
	public void afficher() {
		super.afficher();
		System.out.println(" qui s'engage dans un delai de : " + delaiDeReponse + " h");
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}
		
		if (obj instanceof Hote) {
			
			Hote hote = (Hote) obj;
			return super.equals(obj) && this.delaiDeReponse == hote.delaiDeReponse;
		}

		return false;
	}	
}