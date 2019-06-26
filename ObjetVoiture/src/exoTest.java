import java.util.Arrays;
import java.util.OptionalInt;

public class exoTest {

	public static void main(String[] args) {
		
		/**
		 * Exercice sur la valeur la plus proche d'un nombre ( ici 0)
		 */
		
		int maxVal = Integer.MAX_VALUE;
	       int minVal = Integer.MIN_VALUE;
	       
	       int array[] = {5, -24, 1, -5, 37, -7, 61, 99, -10, 3};
	  
	       for (int nombre:array)
	         System.out.print(nombre+" ");
	  
	       for(int i = 0; i < array.length; i++){
	    	 
	         if(array[i] > 0 && array[i] < maxVal)
	           maxVal = array[i];
	         if(array[i] < 0 && array[i] > minVal)
	           minVal = array[i];
	       }

	       System.out.print("\nValeur positive proche de 0 = "+maxVal);
	       System.out.print("\nValeur négative proche de 0 = "+minVal);
	       if (Math.abs(maxVal) > Math.abs(minVal)) {
	    	   System.out.println("\nLa valeur la proche de 0 est : "+minVal);
	       }
	       else if(Math.abs(minVal) == Math.abs(maxVal)){
	    	   System.out.println("\nLa valeur la proche de 0 est : "+maxVal);
	       }else {
	    	   System.out.println("\nLa valeur la proche de 0 est : "+maxVal);
	       }
	       System.out.println();
	       System.out.println("Exercice sur les chaines de caractères");
	       System.out.println("Renvoyer les majuscule ou miniscule");
	       
	       /**
	        * Attention, si je demande l'occurence d'un tableau de String, alors java me renvoie le nombre de String
	        * et non pas le nombre de caractère. Il considère que le tableau a un seul indice s'il ya une seul chaine de
	        * caractére.
	        */
	       String chaineCara = "Bonjour à Tous !";
	       int nbrCar = 0;
	       for (int i = 0; i < chaineCara.length(); i++) {
	    	   
	    	   nbrCar++;
	       }
	       /**
	        * Ici, je renvoie le nombre de caractère
	        */
	       System.out.println(nbrCar);
	       /**
	        * je demande la position d'une sous chaine
	        */
	       System.out.println(chaineCara.indexOf("Tous"));
	       /**
	        * Chaine inverse
	        */
	       System.out.println("Chaine retournée depuis la fin");
	       String chaine = "Commen ça va !";
	       String chainResu = " ";
	       for (int n = chaine.length()-1; n > -1; n--) {
	    	  chainResu += chaine.charAt(n);
	       }
	       System.out.print(chainResu);
	       System.out.println();
	       String chaineMaju = chaine.toUpperCase();
	       System.out.print(chaineMaju);
	       
	       System.out.println();
	       String chaineMini = chaine.toLowerCase();
	       System.out.print(chaineMini);
	       
		}     
		
	}

