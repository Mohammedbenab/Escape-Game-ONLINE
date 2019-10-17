package fr.benab.projet1.creatGame;

import fr.benab.projet1.gamer.GamerMachine;
import fr.benab.projet1.gamer.GamerMen;

public abstract class Builder {
	protected GamerMen gamerMen;
	protected GamerMachine gamerMachine;
	protected Menu menu;
	
	public void creatGamerMen() {
		gamerMen = new GamerMen();
	}
	
	public GamerMen getObjetMen() {
		return gamerMen;
	}
	
	public void creatGamerMachine() {
		gamerMachine = new GamerMachine();
	}
	
	public GamerMachine getObjetMachine() {
		return gamerMachine;
	}
	
	public void creatMenu() {
		menu = new Menu();
	}
	
	public Menu getMenu() {
		return menu;
	}
		
}
