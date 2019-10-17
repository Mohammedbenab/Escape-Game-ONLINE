package fr.benab.projet1.creatGame;

import fr.benab.projet1.gamer.GamerMachine;
import fr.benab.projet1.gamer.GamerMen;

public class BuildGame {
	
	private Builder builder;
	
	public BuildGame(Builder pBuilder) {
		builder = pBuilder;
	}
	
	public GamerMachine creatGamerMachine() {
		builder.creatGamerMachine();
		return builder.getObjetMachine();
	}
	
	public GamerMen creatGamerMen() {
		builder.creatGamerMen();
		return builder.getObjetMen();
	}
	
	public Menu creatMenu() {
		builder.creatMenu();
		return builder.getMenu();
	}
}
