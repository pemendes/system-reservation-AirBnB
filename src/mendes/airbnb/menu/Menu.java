package mendes.airbnb.menu;

import java.util.Scanner;

public class Menu {
	
	public static Scanner sc;  

	public static void main(String[] args) {
		System.out.println("Bienvenue chez AirBnB");
		
		sc = new Scanner(System.in);
		
		sc.close();

	}
	
	static void listerMenu() {
		System.out.println("Saisir une option :");
		System.out.println("1 : Liste des hôtes");
		System.out.println("2 : Liste des logements");
		System.out.println("3 : Liste des voyageurs");
		System.out.println("4 : Liste des réservations");
		System.out.println("Fermer le programme");
		
		int option = sc.nextInt();
	}
}
