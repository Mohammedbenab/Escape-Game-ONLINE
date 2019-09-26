package com.sdz.modeJeu;

import java.util.Random;

public class RandomCombi implements Proposition{
	public void combinaison() {
		Random combiRendom = new Random();
		int nombre = combiRendom.nextInt(9998 + 1) + 1000;
		System.out.println("Proposition " + nombre + " ->");
	}

}
