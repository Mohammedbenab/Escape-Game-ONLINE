package fr.benab.projet1.game;

import java.util.logging.Logger;

public class LoggerExample {
 
	  static Logger logger = Logger.getLogger(LoggerExample.class.getName());
	  
	  public static void main(String[] args) {
		  
	    logger.info("msg d'information");
	    logger.warning("msg d'avertissement");
	    logger.severe("hfciug");
	    }
}
