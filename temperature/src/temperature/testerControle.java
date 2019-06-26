package temperature;

import java.util.Scanner;

public class testerControle {

	public static void main(String[] args) {
		System.out.println("##Convertisseur de température##");
		Scanner sc = new Scanner(System.in);
		char reponse = 'O';
		int choixMenu = 0;
		int valeur;
		
		while (reponse == 'O'){
			choixMenu = 0;
			while (choixMenu != 1 && choixMenu != 2) {

				System.out.println("Choisissez le mode de conversion : ");
				System.out.println("-----------------------------------");
		        System.out.println("1 - Convertisseur Celsius - Fahrenheit");
		        System.out.println("2 - Convertisseur Fahrenheit - Celsius ");
		        choixMenu = sc.nextInt();
		        
		        if (choixMenu != 1 && choixMenu != 2) {
		        	System.out.println("Votre choix est incorrecte, choisir une option dans le menu !");
		        	}
	        }
			
			System.out.println("Entrer la valeur que vous souhaitez convertir: ");
			valeur = sc.nextInt();
			
					if (choixMenu == 1) {
						System.out.println(((9 * valeur)/5) + 35);
						
					}else if (choixMenu == 2) {
						System.out.println(((valeur - 32) * 5)/9);		
					}
					reponse = ' ';
					sc.nextLine();
			
					while (reponse != 'O' && reponse != 'N'){   
						  System.out.println("Autre conversion ? O/N : ");
						  reponse = sc.nextLine().charAt(0);
						  
						  }
					}
		System.out.println("Merci et à bientôt !");

		}
		 
	}

