package com.sdz.modeJeu;

public class ReponseNull implements Reponse{

	@Override
	public void repondre(int attaque, int defense) {
		System.out.println(attaque);
		System.out.println(defense);
		
	}

}
