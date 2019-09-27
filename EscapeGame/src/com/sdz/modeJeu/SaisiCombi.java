package com.sdz.modeJeu;

import java.util.Scanner;

public class SaisiCombi implements Proposition{

	@Override
	public void combinaison(int combinaison) {
		System.out.println("Choisir une combinaison");
		Scanner sc = new Scanner(System.in);
		try {
			combinaison = sc.nextInt();
			System.out.println("Proposition " + combinaison + " ->");
		}finally {
			sc.close();
		}
		
	}

}
