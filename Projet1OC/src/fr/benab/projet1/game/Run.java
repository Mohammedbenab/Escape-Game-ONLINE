package fr.benab.projet1.game;

public class Run implements Runnable{
protected Game game;
protected IAttack attaq;
protected IDefend defense;
public Run (IAttack attaq, IDefend defense) {
	this.attaq = attaq;
	this.defense = defense;
}
public Game getGame() {
	return this.game;
}
	@Override
	public void run() {
		try {
			getGame().treatment();
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}

}
