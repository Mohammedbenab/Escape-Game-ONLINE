package fr.benab.projet1.creatjoueurs;

import fr.benab.projet1.icreatjoueurs.ICreatJoueurs;
import fr.benab.projet1.joueurs.*;

public class CreatJoueurOrdi implements ICreatJoueurs{

	@Override
	public Attaquant getAttaquant() {
		return new OrdiAttaquant();
	}

	@Override
	public Defenseur getDefenseur() {
		return new OrdiDefenseur();
	}

	}

