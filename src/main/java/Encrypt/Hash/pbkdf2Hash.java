package Encrypt.Hash;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;

public class pbkdf2Hash {
    @DisplayName("Test PBKDF2 Hash function.")
    @Test
    public void testCase() {
        String message = "Message for Hash";
        byte [] salt = "message for Salt.".getBytes(StandardCharsets.UTF_8);
        System.out.println("Origin Message: " + message);
        System.out.println("Salt: " + salt);

        KeySpec spec = new PBEKeySpec(message.toCharArray(), salt, 65536, 128);
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte [] digest = factory.generateSecret(spec).getEncoded();
            String hashMessage = DatatypeConverter.printHexBinary(digest).toUpperCase();
            System.out.println("PBKDF2 Hash: " + hashMessage);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @BeforeAll
    public static void BeforeAll(){
        System.out.println("Test Start");
    }

    @AfterAll
    public static void AfterAll(){
        System.out.println("Test End");
    }
}
