package Joueurs;

public enum Menu {
	Quitter(0), Challenger(1), Defenseur(2), Duel(3);
	
	private int option;
	
	Menu(int option){
		this.option = option;
	}
	
	public int getOption() {
		return option;
	}

}
