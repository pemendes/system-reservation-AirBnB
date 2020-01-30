package mendes.airbnb.utilisateurs;

public class Hote extends Personne {
	private int delaiDeReponse;

	public Hote(String pPrenom, String pNom, int pAge, int pdelaiDeReponse) {
		super(pPrenom, pNom, pAge);
		delaiDeReponse = pdelaiDeReponse;
	}

	@Override
	public void afficher() {
		super.afficher();
		if (delaiDeReponse > 0) {
			System.out.println(" qui s'engage à répondre dans les " + delaiDeReponse + " heures.");
		} else {
			System.out.println(" qui s'engage à répondre dans l'heure");
		}
	}
}
