package fr.benab.projet1.gamer;

import java.util.Arrays;
import java.util.Random;

public class GamerMachine implements IAttack, IDefend{


	@Override
	public String combiSecret() {
		
		int[]tab = new int[4];
		
		for (int i = 0; i < tab.length; i++)  {  
	    	tab[i] = (int) ((Math.random() * ( 9 - 0 )) + 0);
	    	System.out.print(tab[i]);
    	}
		String combi = Arrays.toString(tab);
		return combi;
	}

	@Override
	public String proposition(String[] reponse) {
		
		String combinaison = null;
		int[]tab = new int[4];
		
		if (reponse == null && combinaison == null) {

			for (int i = 0; i < tab.length; i++)  {  
		    	tab[i] = (int) ((Math.random() * ( 9 - 0 )) + 0);
		    	System.out.print(tab[i]);
	    	}
		combinaison = Arrays.toString(tab);
		
		}else if (reponse != null) {
			
			for(int j = 0; j < tab.length; j++) {
				if (reponse[j] == "+"){
					tab[j] = (int) (Math.random() * ( 9 - tab[j] )) ;
				}else if(reponse[j] == "-") {
					tab[j] = (int) (Math.random() * ( tab[j] - 0 ));
				}else tab[j] = tab[j];
			}
			combinaison = Arrays.toString(tab);
		}
		return combinaison;
	}

}
