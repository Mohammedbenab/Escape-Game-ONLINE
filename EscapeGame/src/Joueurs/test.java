package Joueurs;

public class test {

	public static void main(String[] args) {

		/*
		 * nbEssai représente le nombre d'essaie qu'il sera autorisé a une joureur pour trouver la combinaison
		 * de l'adverssaire.
		 */
		int nbEssai = 0;
		char option = ' ';
		
		while (nbEssai <= 5) {
		
			for (Menu choix : Menu.values()) {
				System.out.println(choix.getOption() + " : " + choix.name());
			}
			if (option == '0') {
				System.out.println("Au revoir !");
				break;
			}
			
			else if(option == '1') {
				System.out.println("Vous venez de choisir le mode Challenger");
				System.out.println("Vous etes en position d'attaque, et vous devez trouver la combianison de 4chiffre");
				
			}
		}
		
		
		
	}

}
