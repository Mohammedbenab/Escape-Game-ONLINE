package fr.benab.projet1.creatGame;

import java.util.Scanner;


public class Menu extends Builder{
	
	protected GameMode gameMode;
	protected String reponse;
	
	public void yourGameMode(GameMode gameMode) {
		gameMode.gameMode();
	}
	
	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	
	
	public void Reponse (String gamerAtt, String gamerDef) {
		String resultat = "";
		
		int i = 0;
		while (i < gamerAtt.length()) {
			if (gamerAtt.charAt(i) > gamerDef.charAt(i)) {
				resultat += "-";
			}else if (gamerAtt.charAt(i) < gamerDef.charAt(i)) {
				resultat += "+";
			}else resultat += "=";
			i++;
		}		
		System.out.println(resultat);
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
		this.choiceMenu(nbr);
	}
	
	public void choiceMenu(int nbr) {
		if (nbr == 0) {
			System.out.println("Vous avez choisi de quitter le jeu");
			this.yourGameMode(new Exit());
			System.exit (0);
		}else if (nbr == 1) {
			System.out.println("Vous avez choisi le mode Challenger");
			this.yourGameMode(new Challenge());
		}else if (nbr == 2) {
			System.out.println("Vous avez choisi le mode Defense");
			this.yourGameMode(new Defense());
		}else if (nbr == 3) {
			System.out.println("Vous avez choisi le mode Duel");
			this.yourGameMode(new Duel());
		}else {
			System.out.println("Veuillez choisir une option dans le menu");
			this.choiceMenu(nbr);
		}
		
	}
}
