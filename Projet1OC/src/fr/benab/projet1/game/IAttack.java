package fr.banab.projet1.game;

/**
 * 
 * @author Benabdallah 
 * 
 *Interface permettant de constituer une conbinaison d'attaque.
 */
public interface IAttack {
	
	public abstract String proposition() throws Exception;
	public String resProp(String response, String proposition) throws Exception;
}
