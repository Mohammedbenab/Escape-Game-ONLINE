package fr.benab.projet1.game;

import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PropertyValues {
	
	private static Logger logger = LogManager.getLogger(Game.class);
	
	public String getValuesProp(String value) {
		String value1 = null;
		Properties prop = new Properties();
		String propFileName = "config.properties";
		InputStream intputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		try {
			prop.load(intputStream);
			value1 = prop.getProperty(value);
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("Fichier introuvable");
		}
		return value1;
		
	}
}
