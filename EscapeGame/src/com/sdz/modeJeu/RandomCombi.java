package com.sdz.modeJeu;

import java.util.Random;

public class RandomCombi implements Proposition{

	@Override
	public void combinaison(int combinaison) {
		Random nombre = new Random();
		int combinaison1 = nombre.nextInt(8998 + 1) + 1000;
		System.out.println("Proposition " + combinaison1 + " ->");
	}

}
