package Encrypt.Encrypt;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.nio.charset.StandardCharsets;
import java.security.Key;

public class aesEncrypt {
    @DisplayName("Test AES Encrypt function.")
    @Test
    public void testCase() {
        try {
            String secretMessage = "Message for Encrypt.";
            System.out.println("Origin Message: " + secretMessage);

            /*** Set Key ***/
            KeyGenerator generator = KeyGenerator.getInstance("AES");
            generator.init(256);
            Key key = generator.generateKey();

            /*** do Encrypt ***/
            Cipher encryptCipher = Cipher.getInstance("AES");
            encryptCipher.init(Cipher.ENCRYPT_MODE, key);
            byte [] secretMessageBytes = secretMessage.getBytes(StandardCharsets.UTF_8);
            byte [] encryptedMessageBytes = encryptCipher.doFinal(secretMessageBytes);
            System.out.println("AES Encrypt: " + encryptedMessageBytes);

            /*** do Decrypt ***/
            Cipher decryptCipher = Cipher.getInstance("AES");
            decryptCipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptedMessageBytes = decryptCipher.doFinal(encryptedMessageBytes);
            String decryptedMessage = new String(decryptedMessageBytes, StandardCharsets.UTF_8);
            System.out.println("AES Decrypt: " + decryptedMessage);

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
