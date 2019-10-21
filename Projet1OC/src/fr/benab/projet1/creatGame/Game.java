package fr.benab.projet1.creatGame;

import java.util.Scanner;

import fr.benab.projet1.gamer.GamerMachine;
import fr.benab.projet1.gamer.GamerMen;
import fr.benab.projet1.gamer.IAttack;
import fr.benab.projet1.gamer.IDefend;


public class Game {
	
	private IAttack attack;
	private IDefend defender;
	
	public void menu (int nbr) {
		if (nbr == 0) {
			System.out.println("Vous avez choisi de quitter le jeu");
			System.exit (0);
		}else if (nbr == 1) {
			System.out.println("Vous avez choisi le mode Challenger");
			defender = new GamerMachine();
			attack = new GamerMen();
			this.treatment();
		}else if (nbr == 2) {
			System.out.println("Vous avez choisi le mode Defense");
			defender = new GamerMen();
			attack = new GamerMachine();
			this.treatment();
		}else if (nbr == 3) {
			System.out.println("Vous avez choisi le mode Duel");
			//IAttack[] attack = {new GamerMachine(), new GamerMen()};
			//IDefend[] defender = {new GamerMachine(), new GamerMen()};
		}else {
			System.out.println("Veuillez choisir une option dans le menu");
			this.menuChoicePlayer();
		}
		
	}

	
	public void desplayMenu() {
		System.out.println("0: Quitter le programme");
		System.out.println("1: Mode Challeger");
		System.out.println("2: Mode Defense");
		System.out.println("3: Mode Duel");
	}
	
	public void menuChoicePlayer() {
		this.desplayMenu();
		Scanner sc = new Scanner(System.in);
		int nbr = sc.nextInt();
		this.menu(nbr);
	}
	
	public String Response (String gamerAtt, String gamerDef) {
		
		String resultat = "";
		
		int i = 0;
		while (i < gamerAtt.length()) {
			if (Integer.valueOf("" + gamerAtt.charAt(i)) > Integer.valueOf("" + gamerDef.charAt(i))) {
				resultat += "-";
			}else if (Integer.valueOf("" + gamerAtt.charAt(i)) < Integer.valueOf("" + gamerDef.charAt(i))) {
				resultat += "+";
			}else resultat += "=";
			i++;
		}		
		return resultat;
	}
	
	public void treatment() {
		int nbrEssai = 0;
		String defense = defender.combiSecret();
		String attaq = attack.proposition();
		System.out.println("1111111111111111");
		while (nbrEssai < 5) {
			String reponse = Response(attaq, defense);
			System.out.println("Proposition : " + attaq +" Reponse " + reponse);
			attaq = attack.resProp(reponse, attaq);
			System.out.println("2222222222222222");
			if (defense.equals(attaq)) {
				System.out.println("La combinaison a été trouver : " + defense);
				this.menuChoicePlayer();
			}else if (nbrEssai == 4 && !defense.equals(attaq)){
				System.out.println("Vous n'avez pas trouvé la combinaison : " + defense);
				this.menuChoicePlayer();
			}
			nbrEssai++;
		}
	}
	
}
