package fr.benab.escapegame.combinaison;

import java.util.Random;

import fr.benab.escapegame.imode.Proposition;

public class RandomCombi implements Proposition{

	@Override
	public int combinaison(int combinaison) {
		Random nombre = new Random();
		int combinaison1 = nombre.nextInt(8998 + 1) + 1000;
		return combinaison1;
	}

}
