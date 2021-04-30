package ch1_os_command_injection;

/**
* WARNING: This is a vulnerable code example that should not be used
* in other applications.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OSCommandInjectionVuln {
    public static void main(String[] args) {
        Process proc = null;

        try {
            String user_input;
            BufferedReader br = new BufferedReader(new 
                    InputStreamReader(System.in));
            System.out.println("Enter a username: ");
            user_input = br.readLine();

            Runtime rt = Runtime.getRuntime();
            proc = rt.exec("ls /home/" + user_input);

            BufferedReader stdInput = new BufferedReader(new 
                    InputStreamReader(proc.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(proc.getErrorStream()));

            // Read standard output from the command
            String s = null;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            // Read standard error from the command
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }

        }
        catch(Exception e) {
        }
        finally{
                if (null != proc)
                        proc.destroy();
        }
    }
}
