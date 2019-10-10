package fr.benab.projet1.creatjoueurs;

import fr.benab.projet1.icreatjoueurs.ICreatJoueurs;
import fr.benab.projet1.joueurs.*;

public class CreatJoueurHom implements ICreatJoueurs{

	@Override
	public Attaquant getAttaquant() {
		return new HomAttaquant();
	}

	@Override
	public Defenseur getDefenseur() {
		return new HomDefenseur();
	}

}
