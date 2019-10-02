
public class Moto extends Voiture {
	private int puissance;
	
	//Constructeur pa defaut
	
	public Moto() {
		/*
		 * this.couleur = "rouge"; je ne peut utiliser cette variable de classe seulement si elle est public ou protected
		 */
		super();
		/*
		 * le super recuper le constructeur par defaut de la clasee m�re
		 */
		puissance = 0;
	}
	//Constructeur d'initialisation
	
	public Moto(String marque, String couleur, int ann�e, int puissance) {
		/**
		 * super doit imperativement contenir des paramettre sinon il renvoit le constructeur par defaut
		 */
		super(marque, couleur, ann�e);
	this.puissance = puissance;
	}

	public String toString() {
		/**
		 * Si je ne redefinie pas cette fonction qui est prensente dans la classe voiture alors, c'est celle de la classe voiture qui sera 
		 * appel� lors de mon programme
		 */
		String str = super.toString()+ ", son moteur est de "+this.puissance+ " centimetre cube.";
		return str;
	}
	public int getPuissance() {
		return puissance;
	}
	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}
	
}
