package ch2_log_injection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogInjectFixed_Log4J {
    private static final Logger logger = LogManager.getLogger(LogInjectFixed_Log4J.class);

    public static void main(String[] args) {
        logInject("42\nINFO : User logged out: root");
    }
    
    public static void logInject(String input) {
        
        try {
            int num = Integer.parseInt(input);
            logger.info("parsed input: " + num);
        }
        catch (NumberFormatException e) {
            logger.warn("Could not parse input: " + input);
        }
    }

}
