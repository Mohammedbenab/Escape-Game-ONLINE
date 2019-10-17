package fr.benab.projet1.creatGame;

import fr.benab.projet1.gamer.GamerMachine;
import fr.benab.projet1.gamer.GamerMen;

public abstract class GameBuild {
	protected GamerMen gamerMen;
	protected GamerMachine gamerMachine;
	protected Menu menu;
	
	public void creatGamerMen() {
		gamerMen = new GamerMen();
	}
	
	public void creatGamerMachine() {
		gamerMachine = new GamerMachine();
	}
	
	public void creatMenu() {
		menu = new Menu();
	}
	
	public Menu getReponse() {
		return reponse();
	}
	 public abstract void Reponse();
	
	
	
}
