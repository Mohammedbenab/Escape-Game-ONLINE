package com.sdz.modeJeu;

import java.util.Scanner;

public class SaisiCombi implements Proposition{

	@Override
	public int combinaison(int combinaison) {
		System.out.println("Choisir une combinaison");
		Scanner sc = new Scanner(System.in);
		try {
			combinaison = sc.nextInt();
			return combinaison;
		}finally {
			sc.close();
		}
		
		
	}

}
