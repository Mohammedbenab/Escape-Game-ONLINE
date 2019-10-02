
public class Voiture {
	//Les variable d'instances ne sont pas proteg�es et peuvent donc �tre modifi�es
	// Il faut les privatiser pour les securiser
	// je remplace private par protected pour laisser ma classe moto acc�der au variable
	protected String couleur;
	protected String marque;
	protected int ann�e;
	protected char categorie;
	
// Constructeur par defaut
	public Voiture() {
		couleur = "Inconnue";
		marque = "Inconnue";
		ann�e = 0;
		this.setCategorie();
	}
	
	//Constructeur avec des paramettres
	public Voiture (String smarque, String scouleur, int sann�e) {
		couleur = scouleur;
		marque = smarque;
		ann�e = sann�e;
		this.setCategorie();
	}
	
	// Accesseurs et mutateurs ou Getters et Setters
	
	////////:Accesseurs//////
	public String getCouleur () { //m�me type que la varibale qu'elle retour
		return couleur; 
	}
	public String getmarque() {
		return marque;
	}
	public int getAnn�e() {
		return ann�e;
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
	public void setAnn�e(int sann�e) {
		ann�e = sann�e;
		this.setCategorie();
	}
	private void setCategorie() {
		int bornAnn�e[] = {2009,2019};
		char cat�gorie[] = {'V', 'R'};
		int i = 0;
		while (i < bornAnn�e.length && this.ann�e > bornAnn�e[i]) 
			i++;
		
		this.categorie = cat�gorie[i];
	}
	//Methode pour retourner la description de la voiture
	public String toString () {
		/**
		 * toString est une methode h�rit� du type objet dans java lors de la cr�ation d'un nouvel objet
		 */
		return "le v�hicule est une "+this.getmarque()+" de couleur "+this.getCouleur()+" et d'ann�e "+this.getAnn�e()+ " est de cat�gorie "+ this.categorie;
	}
	public String comparerVoiture(Voiture voiture1) {
		String str = new String();
		if (voiture1.getAnn�e() > this.ann�e) {
			str = "La "+ voiture1.getmarque()+" est plus r�cente que "+ "la "+this.marque;
		}
		else 
			str = "La "+ this.marque+" est plus r�cente que "+ "la "+voiture1.getmarque();
		return str;
	}
	
}
