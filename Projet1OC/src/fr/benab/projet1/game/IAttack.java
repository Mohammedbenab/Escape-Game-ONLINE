package fr.benab.projet1.game;


public interface IAttack {
	
	public abstract String proposition() throws Exception;
	public String resProp(String response, String proposition) throws Exception;
}
