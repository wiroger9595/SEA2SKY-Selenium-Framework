package log4jFile;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.LoggerNameAwareMessage;;


public class Log4jInfo {
	private static Logger Logger = LogManager.getLogger(Log4jInfo.class);
	
	public static void main(String[] args) {
		System.out.println("\n Hello ");
		
		Logger.info("This is information msg");
		Logger.error("This is an error msg");
		Logger.warn("This is an warning msg");
		Logger.fatal("This is an fatal msg");
		
		System.out.println("\n All Finish");

	}
}
