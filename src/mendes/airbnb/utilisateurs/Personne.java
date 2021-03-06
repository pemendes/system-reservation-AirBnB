package mendes.airbnb.utilisateurs;

import mendes.airbnb.outils.Comparable;

/**
 * classe qui représente une personne avec un prénom, un nom et un age.
 * 
 * @author Pedro
 * @since 28/01/2020
 * @version 1001
 *
 */
public class Personne implements Comparable {
	
	private final String nom;
	private final String prenom;
	private final int age;

	/**
	 * Constructeur de la classe personne avec les parametre:
	 * 
	 * @param prenom pour le this.prenom
	 * @param nom    pour le this.nom
	 * @param age    pour le this.age
	 */
	public Personne(String pPrenom, String pNom, int pAge) {
		nom = pNom;
		prenom = pPrenom;
		age = pAge;
	}
	
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}
		
		if (obj instanceof Personne) {
			
			Personne personne = (Personne) obj;
			
			return this.prenom.equals(personne.prenom) 
					&& this.nom.equals(personne.nom) 
					&& this.age == personne.age;	
		}
		
		return false;
	}

	/**
	 * Affichage de la personne dans la console au format prénom nom (age ans) (e.g
	 * Pedro Mendes (38 ans)
	 */
	public void afficher() {
		System.out.print(prenom + " " + nom);
	}

	@Override
	public int getValueToCompare() {
		return age;
	}
	
}

