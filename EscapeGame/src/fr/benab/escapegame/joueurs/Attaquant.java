package fr.benab.escapegame.joueurs;
import fr.benab.escapegame.imode.ModeJeu;
import fr.benab.escapegame.imode.Proposition;

public class Attaquant extends Joueurs{
	public Attaquant() {}

	public Attaquant(Proposition proposition, ModeJeu modejeu) {
		super(proposition, modejeu);
	}

}
