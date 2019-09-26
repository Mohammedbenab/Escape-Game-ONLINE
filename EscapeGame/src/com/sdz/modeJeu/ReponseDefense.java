package com.sdz.modeJeu;
public class ReponseDefense implements Reponse{

	public void repondre(int[] attaque, int[] defense) {
		int[][] tab = {attaque, defense};
				
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; j++) {
			if (attaque[i][j] < defense[i][j]) {}
			}
		}
	}
}