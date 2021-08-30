package Encrypt.Hash;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.*;

public class md5Hash {
    @DisplayName("Test MD5 Hash function.")
    @Test
    public void testCase() {
        String message = "Message for Hash";
        System.out.println("Origin Message: " + message);

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(message.getBytes(StandardCharsets.UTF_8));
            byte[] digest = md.digest();
            String hashMessage = DatatypeConverter.printHexBinary(digest).toUpperCase();
            System.out.println("MD5 Hash Message: " + hashMessage);
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
