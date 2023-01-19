package ch4_passwords;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

public class Argon2Example {

    public static void main(String[] args) {
        int saltLength = 16; // 128 bits
        int hashLength = 32; // 256 bits
        int parallelism = 1;
        int memoryInKb = 10240; // 10 MB
        int iterations = 10;
        CharSequence password = "correct horse battery staple";
        
        Argon2PasswordEncoder passwordEncoder = new Argon2PasswordEncoder(saltLength, hashLength, parallelism, memoryInKb, iterations);

        String hashedpwd = passwordEncoder.encode(password);
        password = "";
        
        System.out.println(hashedpwd);
    }

}
