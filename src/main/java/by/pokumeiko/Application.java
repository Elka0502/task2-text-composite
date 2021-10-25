package by.pokumeiko;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.pokumeiko.service.*;

public class Application  
{
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
		
	public static void main(String args[]){
	  LOGGER.info("Start");
	  Frame showWindows =  new Frame();
	  showWindows.frame();
	}
	
}
