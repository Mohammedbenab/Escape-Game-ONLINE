package Joueurs;
import com.sdz.modeJeu.*;
public abstract class Joueurs {
	protected int combinaison;
	protected int attaque;
	protected int defense;
	
	protected Proposition proposition = new AucuneCombi();
	protected Reponse reponse = new ReponseNull();
	
	public Joueurs(Proposition proposition, Reponse reponse) {
		this.proposition = proposition;
		this.reponse = reponse;
	}
	
	
	//Constructor par defaut
	public Joueurs() {};
	
	// M�thode de d�fense
	public void votreProposition(Proposition proposition) {
		proposition.combinaison(combinaison);
	}
	
	//M�thode de r�ponse
	public void votreReponse(Reponse reponse) {
		reponse.repondre(attaque, defense);
	}
	
	//
	public void setProposition(Proposition proposition) {
		this.proposition = proposition;
	}
	
	//
	public void setReponse(Reponse reponse) {
		this.reponse = reponse;
	}

}
