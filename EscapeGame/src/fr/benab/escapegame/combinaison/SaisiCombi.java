package fr.benab.escapegame.combinaison;

import java.util.Scanner;

import fr.benab.escapegame.imode.Proposition;

public class SaisiCombi implements Proposition{

	@Override
	public int combinaison(int combinaison) {
		System.out.println("Choisir une combinaison");
		Scanner sc = new Scanner(System.in);

			combinaison = sc.nextInt();
			return combinaison;
		}
}
