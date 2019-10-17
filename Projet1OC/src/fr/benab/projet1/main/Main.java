package fr.benab.projet1.main;

import fr.benab.projet1.creatGame.BuildGame;
import fr.benab.projet1.creatGame.Builder;
import fr.benab.projet1.creatGame.Menu;


public class Main {

	public static void main(String[] args) {
		Builder lMenu = new Menu();
		BuildGame lBuilderGamer = new BuildGame(lMenu);
		
		Menu menu = lBuilderGamer.creatMenu();
		menu.menuChoicePlayer();
		
		

		

	}

}
