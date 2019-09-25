package com.sdz.modeJeu;

import java.util.Scanner;

public class SaisiCombi implements Proposition{
	public void combinaison() {
		Scanner combiSaisi = new Scanner(System.in);
		try {
			int combinaison = combiSaisi.nextInt();
			System.out.println("Proposition " + combinaison + " ->");
		}finally {
			combiSaisi.close();
		}
	}

}
