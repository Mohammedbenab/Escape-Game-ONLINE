package fr.benab.projet1.game;

import java.util.Properties;
import java.io.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PropertyValues {

	private static Logger logger = LogManager.getLogger(Game.class);

	/**
	 * 
	 * @param value key recuperer dans le fichier config.properties. Elle peut etre
	 *              modifier sur le fichier pour eviter de changer cette valeur dans
	 *              toute l'application
	 * @return valeur de la cl� recuper�e dans le fichier properties
	 * @throws IOException
	 */

	public String getValuesProp(String value) throws IOException {
		String value1 = null;
		Properties prop = new Properties();
		String propFileName = "config.properties";
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		try {
			prop.load(inputStream);
			value1 = prop.getProperty(value);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
			logger.error("Fichier config.properties non trouv�");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return value1;
	}
	
	/**
	 * La m�thode getCombiSize() permet de recup�rer la taille attrubi�e � la combinaison
	 * dasn le fichier config.properties
	 * @param val est initialis� par defaut, si le fichier properties n'existe pas ou l�ve une exception
	 * @return la taille de la combinaison
	 */
	public String getCombiSize(){
		String val = "4";
		try {
			val = this.getValuesProp("pCombiSize");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return val;
	}
	
	/**
	 * La m�thode getNbrEssai() permet de r�cup�rer le nombre d'essai possible dans le fichier
	 * config.properties
	 * @param val est initialis� par defaut, si le fichier properties n'est pas trouv�.
	 * @return val, qui est le nombre d'essai possible de tentative.
	 */

	public String getNbrEssai(){
		String val = "4";
		try {
			val = this.getValuesProp("pNbrEssai");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return val;
	}
	
	/**
	 * La m�thode getDevMode() renvoie une String contenant une valeur boolean pour passer en 
	 * mode d�veloppeur
	 * @param val est initialis� par d�faut, si le fichier properties n'est pas trouv�
	 * @return une String qui sera transform� en valeur boolean
	 */
	public String getDevMode(){
		String val = "false";
		try {
			val = this.getValuesProp("pDevMode");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return val;
	}
}
