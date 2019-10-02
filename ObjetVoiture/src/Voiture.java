
public class Voiture {
	//Les variable d'instances ne sont pas protegées et peuvent donc être modifiées
	// Il faut les privatiser pour les securiser
	// je remplace private par protected pour laisser ma classe moto accéder au variable
	protected String couleur;
	protected String marque;
	protected int année;
	protected char categorie;
	
// Constructeur par defaut
	public Voiture() {
		couleur = "Inconnue";
		marque = "Inconnue";
		année = 0;
		this.setCategorie();
	}
	
	//Constructeur avec des paramettres
	public Voiture (String smarque, String scouleur, int sannée) {
		couleur = scouleur;
		marque = smarque;
		année = sannée;
		this.setCategorie();
	}
	
	// Accesseurs et mutateurs ou Getters et Setters
	
	////////:Accesseurs//////
	public String getCouleur () { //même type que la varibale qu'elle retour
		return couleur; 
	}
	public String getmarque() {
		return marque;
	}
	public int getAnnée() {
		return année;
	}
	public char getCategorie() {
		return categorie;
	}
	///////Mutateurs////////
	public void setCouleur(String scouleur) {
		couleur = scouleur;
	}
	public void setMarque(String smarque) {
		marque = smarque;
	}
	public void setAnnée(int sannée) {
		année = sannée;
		this.setCategorie();
	}
	private void setCategorie() {
		int bornAnnée[] = {2009,2019};
		char catégorie[] = {'V', 'R'};
		int i = 0;
		while (i < bornAnnée.length && this.année > bornAnnée[i]) 
			i++;
		
		this.categorie = catégorie[i];
	}
	//Methode pour retourner la description de la voiture
	public String toString () {
		/**
		 * toString est une methode hérité du type objet dans java lors de la création d'un nouvel objet
		 */
		return "le véhicule est une "+this.getmarque()+" de couleur "+this.getCouleur()+" et d'année "+this.getAnnée()+ " est de catégorie "+ this.categorie;
	}
	public String comparerVoiture(Voiture voiture1) {
		String str = new String();
		if (voiture1.getAnnée() > this.année) {
			str = "La "+ voiture1.getmarque()+" est plus récente que "+ "la "+this.marque;
		}
		else 
			str = "La "+ this.marque+" est plus récente que "+ "la "+voiture1.getmarque();
		return str;
	}
	
}
