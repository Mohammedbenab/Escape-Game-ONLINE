package Joueurs;
import java.util.Random;
//import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		/*System.out.println("saisir une combinaison: ");
		Scanner test1 = new Scanner(System.in);
		int combinaison = test1.nextInt();
		if (combinaison >= 1000 && combinaison < 10000)
		System.out.println(combinaison);
		else {
			Scanner test2 = new Scanner(System.in);
			int combinaison2 = test2.nextInt();
			System.out.println(combinaison2);

		}*/
		Random rnd = new Random();
		System.out.println("nombre rendom compris entre un intervalle");
		int nombre = rnd.nextInt(9998 + 1) + 1000;
		System.out.println(nombre);
		System.out.println(nombre%1000);
		
		int[] defense = {1,2,3,3,2,5,58};
		int[] attaque = {45,5,9,8,15,8,72};
		
		int[][] tab = {defense,attaque};
				
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; j++) {
			if (i < j) {
				System.out.println("+");
			}else if (i > j){
				System.out.println("-");
			}else System.out.println("=");
		}
		System.out.println();
		
		}
	}

}
