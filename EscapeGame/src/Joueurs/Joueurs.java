package Joueurs;
import com.sdz.modeJeu.*;
public abstract class Joueurs {
	
	protected Proposition proposition = new AucuneCombi();
	protected Reponse reponse = new ReponseNull();
	
	public Joueurs(Proposition proposition, Reponse reponse) {
		this.proposition = proposition;
		this.reponse = reponse;
	}
	
	
	//Constructor par defaut
	public Joueurs() {};
	
	// Méthode de défense
	public void votreProposition() {
		proposition.combinaison();
	}
	
	//Méthode de réponse
	public void votreReponse() {
		reponse.repondre();
	}
	
	//
	public void setStrategie(Proposition proposition) {
		this.proposition = proposition;
	}
	
	//
	public void setReponse(Reponse reponse) {
		this.reponse = reponse;
	}

}
