
public class TestVoisture {

	public static void main(String[] args) {
		
		Voiture voiture = new Voiture ();
		Voiture voiture1 = new Voiture ("noire", "Mercedez", 2014);
		Voiture voiture2 = new Voiture ("blanche", "Renault", 2009);
		
		//System.out.println(voiture1.année); les attibuts ne sont pas accessible en dehort de la classe
		//voiture1.couleur = "trdjcfv"; impossible car les variables d'instances sont private
		//System.out.println(voiture1.couleur);
		
		System.out.println("la voiture 1 est une "+voiture1.getmarque()+ " de couleur "+ voiture1.getCouleur()+ " et d'année "
				+ voiture1.getAnnée());
		
		//Par l'intervention des Setteurs, on peut changer le contenu des variable;
		
		voiture1.setCouleur("verte");
		System.out.println(voiture1.getAnnée());
		System.out.println("la voiture 1 est une "+voiture1.getmarque()+ " de couleur "+ voiture1.getCouleur()+ " et d'année "+ voiture1.getAnnée());
		//Appel de la methode descriptionVoiture()
		System.out.println(voiture1.toString());
		System.out.println(voiture1.comparerVoiture(voiture2));
		
		Moto moto= new Moto();
		System.out.println(moto.toString());
		System.out.println("######################");
		/************************************/
		Voiture tableau[] = new Voiture[6];
		String tab1[]= {"blanche", "verte", "noire", "grise", "metal", "orange"};
		String tab2[] = {"Citroen", "Mazda", "Porsh", "T-max", "X-max", "Kawasaki"};
		int tab3[] = {2008, 2015, 2017, 2018, 2005, 2019};
		
		
		int i;
		for ( i= 0; i < 6; i++ ) {
			if (i < 3) {
				Voiture v = new Voiture (tab2[i], tab1[i], tab3[i]);
				tableau[i] = v;
				//System.out.println(v.desciption());
			}
			else {
				Moto m = new Moto (tab2[i], tab1[i], tab3[i], 750);
				tableau[i] = m;
				//System.out.println(m.decription());
			}
		}
		System.out.println("###########################");
		for(Object obj : tableau) {
			/**
			 * Ici on ne soucie pas du type de l'objet pour afficher la methode toString(),
			 * java s'en charge lui même. c'est ce que l'on appel un polymorphe.
			 * si le nom de la methode n'était pas connue alors, il aurait fallu presiser le type de l'objet
			 * exemple ((Ville)v).decrisToi();
			 */
			System.out.println(obj.toString());
		}
		
	}
}
	

