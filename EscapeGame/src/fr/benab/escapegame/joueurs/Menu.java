package fr.benab.escapegame.joueurs;

public enum Menu {
	Quitter("0"), Challenger("1"), Defenseur("2"), Duel("3");
	
	private String option;
	
	Menu(String option){
		this.option = option;
	}
	
	public String afficherMenu() {
		return getOption() + " : " + name();
	}
	
	public String getOption() {
		return option;
	}

}
