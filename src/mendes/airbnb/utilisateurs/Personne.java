package mendes.airbnb.utilisateurs;

/**
 * classe qui représente une personne avec un prénom, un nom et un age.
 * @author Pedro
 * @since 28/01/2020
 * @version 1001
 *
 */

public class Personne {
	private String prenom;
	private String nom;
	private int age;
	
	/**
	 * Constructeur de la classe personne avec les parametre: 
	 * @param prenom
	 * 			pour le this.prenom
	 * @param nom
	 * 			pour le this.nom
	 * @param age
	 * 			pour le this.age
	 */
	
	public Personne(String prenom, String nom, int age) {
		
		this.prenom = prenom;
		this.nom = nom;
		this.age = age;
	}
	
	/**
	 * Affichage de la personne dans la console au format prénom nom (age ans)
	 * (e.g Pedro Mendes (38 ans)
	 */
	
	public void afficher() {
		System.out.print(prenom + " " + nom + " (" + age + " ans)");
	}	
}
