package mendes.airbnb.menu;

import java.util.InputMismatchException;

import mendes.airbnb.utilisateurs.Hote;

class GestionHotes {

	static void listerHotes() {

		System.out.println("-------------------------------------");
		System.out.println("Liste des hôtes ");

		for (int i = 0; i < Menu.listHotes.size(); i++) {
			Hote hote = Menu.listHotes.get(i);
			System.out.print("Numéro " + (i + 1) + " : ");
			hote.afficher();
		}

		System.out.println("Saisir une option : ");
		System.out.println("1 : Ajouter un hôte");
		System.out.println("2 : Supprimer un hôte");
		System.out.println("3 : Retour");

		try {
			switch (Menu.choix(3)) {
			case 1:
				ajouterHote();
				break;
			case 2:
				supprimerHote();
				break;
			case 3:
				Menu.listerMenu();
				break;
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Une erreur est survenue lors de la suppression d'un hôte");
			listerHotes();
		}catch (Exception e) {
			Menu.scanner.next();
			System.out.println("Une erreur est survenue");
			listerHotes();
		}
	}

	private static void ajouterHote() throws Exception {

		System.out.println("-------------------------------------");
		System.out.println("Ajouter un nouvel hôte");

		System.out.print("Le prénom :");
		String prenom = Menu.scanner.next();

		System.out.print("Le nom :");
		String nom = Menu.scanner.next();

		System.out.print("L'age :");
		int age = Menu.scanner.nextInt();

		System.out.print("Delai :");
		int delaiReponse = Menu.scanner.nextInt();

		Hote hote = new Hote(nom, prenom, age, delaiReponse);

		Menu.listHotes.add(hote);

		listerHotes();
	}

	/**
	 * 
	 * @throws IndexOutOfBoundsException
	 *             si...
	 * @throws InputMismatchException
	 *             si...
	 */
	private static void supprimerHote() throws IndexOutOfBoundsException, InputMismatchException {

		System.out.println("-------------------------------------");
		System.out.println("Supprimer un hôte");

		System.out.println("Numéro ?");
		int indice = Menu.scanner.nextInt();

		Menu.listHotes.remove(indice);

		listerHotes();
	}

}