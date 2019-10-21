package fr.benab.projet1.gamer;

import java.util.Arrays;
import java.util.Random;


public class GamerMachine implements IAttack, IDefend{

	String combiAttaq;
	
	@Override
	public String combiSecret() {
		
		String combiSecret = "";
		for (int i = 0; i < 4; i++)  {  
	    	combiSecret += Integer.toString((int) ((Math.random() * ( 9 - 0 )) + 0));
    	}
		return combiSecret;
	}

	@Override
	public String proposition() {
		combiAttaq = "";
		for (int i = 0; i < 4; i++)  {  
		    combiAttaq += Integer.toString((int) ((Math.random() * ( 9 - 0 )) + 0));
	    }
		return combiAttaq;
	}
		
	@Override
	public String resProp(String response, String combiAttaq) {
		
		String reaction = "";
		Random r = new Random();
		for(int j = 0; j < response.length(); j++) {
			if (response.charAt(j) == '+'){
				reaction += Integer.toString(Integer.parseInt(""+combiAttaq.charAt(j)) + (int) ((Math.random() * ( 9 - Integer.parseInt(""+combiAttaq.charAt(j))))));
			}else if(response.charAt(j) == '-') {
				reaction += Integer.toString((int) ((Math.random() * ( Integer.parseInt(""+combiAttaq.charAt(j)) - 0 ))));
			}else reaction += combiAttaq.charAt(j);
			}
		return reaction;
		}
		
	}

