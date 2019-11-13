package game;

import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PropertyValues {

	private static Logger logger = LogManager.getLogger(Game.class);

	/**
	 * 
	 * @param value key recuperer dans le fichier config.properties. Elle peut etre
	 *              modifier sur le fichier pour eviter de changer cette valeur dans
	 *              toute l'application
	 * @return valeur de la clé recuperée dans le fichier properties
	 */

	public String getValuesProp(String value) {
		String value1 = null;
		Properties prop = new Properties();
		String propFileName = "config.properties";
		InputStream intputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		try {
			prop.load(intputStream);
			value1 = prop.getProperty(value);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Fichier introuvable");
		}
		return value1;
	}
	
	public String getCombiSize() {
		String val = this.getValuesProp("pCombiSize");
		return val;
				
	}
	
	public String getNbrEssai() {
		String val = this.getValuesProp("pNbrEssai");
		return val;
	}
	
	public String getDevMode() {
		String val = this.getValuesProp("pDevMode");
		return val;
	}
}
