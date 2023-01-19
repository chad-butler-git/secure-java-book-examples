package ch4_passwords;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import java.util.Arrays;

public class Pbkdf2Example {
    
    //private static final String ALGORITHM = "PBKDF2WithHmacSHA512";
    private static final String ALGORITHM = "PBKDF2WithHmacSHA512";

    public static void main(String[] args) {
        char[] charPwd = new char[] {'p','a','s','s','w','o','r','d'};
        
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[8];
        byte[] hash;
        
        random.nextBytes(salt);
        
        KeySpec spec = new PBEKeySpec(charPwd, salt, 65536, 512);
        Arrays.fill(charPwd, '\0'); //zero out password array to remove from memory
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
            hash = factory.generateSecret(spec).getEncoded();
        }
        catch (NoSuchAlgorithmException ex) {
            throw new IllegalStateException("Unknown algorithm: " + ALGORITHM);
        }
        catch (InvalidKeySpecException ex) {
            throw new IllegalStateException("Invalid SecretKeyFactory", ex);
        }
        
        System.out.println("Salt: " + Arrays.toString(salt));
        System.out.println("Hashed password: " + Arrays.toString(hash));
    }

}
