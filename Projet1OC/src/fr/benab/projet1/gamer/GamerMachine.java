package fr.benab.projet1.gamer;

import java.util.Arrays;

public class GamerMachine implements IAttack, IDefend{


	@Override
	public String combiSecret() {
		
		//int[]tab = new int[4];
		String combiSecret = "";
		for (int i = 0; i < 4; i++)  {  
	    	combiSecret += Integer.toString((int) ((Math.random() * ( 9 - 0 )) + 0));
    	}
		//combiSecret = Arrays.toString(tab);
		return combiSecret;
	}

	@Override
	public String proposition(String reponse) {
		
		String combinaison = null;
		int[]tab = new int[4];
		char [] reponseT = reponse.toCharArray();
		
		if (reponseT == null) {

			for (int i = 0; i < tab.length; i++)  {  
		    	tab[i] = (int) ((Math.random() * ( 9 - 0 )) + 0);
		    	System.out.print(tab[i]);
	    	}
		combinaison = Arrays.toString(tab);
		
		}else if (reponseT != null) {
			
			for(int j = 0; j < tab.length; j++) {
				if (reponseT[j] == '+'){
					tab[j] = (int) (Math.random() * ( 9 - tab[j] )) ;
				}else if(reponseT[j] == '-') {
					tab[j] = (int) (Math.random() * ( tab[j] - 0 ));
				}else tab[j] = tab[j];
			}
			combinaison = Arrays.toString(tab);
		}
		return combinaison;
	}

}
