package fr.benab.projet1.game;

/**
 * 
 * @author Benabdallah 
 * 
 *Interface permettant de constituer une conbinaison d'attaque.
 */
public interface IAttack {
	
	String proposition() throws Exception;
	String resProp(String response, String proposition) throws Exception;
}
