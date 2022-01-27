package ch2_log_injection;

import java.util.logging.Logger;
import java.util.regex.Pattern;


public class LogInjectionFixed {
    private static final Pattern alphaNumPattern = Pattern.compile("[\\w\\s]*");
    
    public static void main(String[] args) {
        logInject("42\nINFO: User logged out: root");

    }
    
    public static void logInject(String input) {
        Logger log = 
                Logger.getLogger(LogInjectionFixed.class.getName());
        try {
            int num = Integer.parseInt(input);
            log.info("parsed input: " + num);
        }
        catch (NumberFormatException e) {
            if (alphaNumPattern.matcher(input).matches()) {
                log.warning("Could not parse input: " + input);
            }
            else {
                log.warning("Could not parse input: "
                        + "non-alphanumeric input provided");
            }
        }
    }
}
