package Joueurs;
import java.util.Scanner;

import com.sdz.modeJeu.*;
public abstract class Joueurs {
	protected int combinaison;
	
	protected Proposition proposition = new AucuneCombi();
	protected ModeJeu modejeu = new Quitter();
	
	public Joueurs(Proposition proposition, ModeJeu modejeu) {
		this.proposition = proposition;
		this.modejeu = modejeu;
	}
	//Constructor par defaut
	public Joueurs() {};
	/*
	 * Methode pour afficher le menu
	 */
	public void afficherMenu() {
		System.out.println("0: Quitter le programme");
		System.out.println("1: Mode Challeger");
		System.out.println("2: Mode Defense");
		System.out.println("3: Mode Duel");
		
	}
	/*
	 * Les possibilités du menu
	 */
	public void choixMenu(int nbr) {
		if (nbr == 0) {
			System.out.println("Vous avez choisi de quitter le jeu");
			this.votreModeJeu(new Quitter());
			System.exit (0);
		}else if (nbr == 1) {
			System.out.println("Vous avez choisi le mode Challenger");
			this.votreModeJeu(new Challenger());
		}else if (nbr == 2) {
			System.out.println("Vous avez choisi le mode Defense");
			this.votreModeJeu(new Defense());
		}else if (nbr == 3) {
			System.out.println("Vous avez choisi le mode Duel");
			this.votreModeJeu(new Duel());
		}else {
			System.out.println("Veuillez choisir une option dans le menu");
			this.choixMenu(nbr);
		}
		
	}
	/*
	 * Méthode pour saisir le choix de l'utilisateur
	 */
	public void menuChoixUtilisateur() {
		this.afficherMenu();
		Scanner sc = new Scanner(System.in);
		int nbr = sc.nextInt();
		this.choixMenu(nbr);
	}
	
	// Méthode de défense
	public void votreProposition(Proposition proposition) {
		proposition.combinaison(combinaison);
	}
	
	//Méthode de réponse
	public void votreModeJeu(ModeJeu modejeu) {
		modejeu.modeJeu();
	}
	
	//
	public void setProposition(Proposition proposition) {
		this.proposition = proposition;
	}
	
	//
	public void setReponse(ModeJeu modejeu) {
		this.modejeu = modejeu;
	}

}
