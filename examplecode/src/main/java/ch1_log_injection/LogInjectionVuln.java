package ch1_log_injection;

/**
* WARNING: This is a vulnerable code example that should not be used
* in other applications.
*/

import java.util.logging.Logger;

public class LogInjectionVuln {
    public static void main(String[] args) {
        LogInject("42\nINFO: User logged out: root");
    }

    public static void LogInject(String input) {
        Logger log = 
                Logger.getLogger(LogInjectionVuln.class.getName());
        try {
            int num = Integer.parseInt(input);
            log.info("parsed input: " + num);
        }
        catch (NumberFormatException e) {
            log.warning("Could not parse input: " + input);
        }
    }
}
