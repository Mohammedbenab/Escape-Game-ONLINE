package com.sdz.modeJeu;

public class ReponseDefense implements Reponse{
	
	@Override
	public void repondre(int attaque, int defense) {
		
		char[] attCombi = Integer.toString(attaque).toCharArray();
		char[] defCombi = Integer.toString(defense).toCharArray();
		char[][] tab = {attCombi, defCombi};
				System.out.println(tab);
		//for (int i = 0; i < tab.length; i++) {
			//for (int j = 0; j < tab[i].length; j++) {
			//}
		//}
	}

}