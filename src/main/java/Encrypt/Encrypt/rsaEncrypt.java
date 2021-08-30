package Encrypt.Encrypt;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.crypto.Cipher;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.*;
import java.security.spec.EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class rsaEncrypt {
    @DisplayName("Test RSA Encrypt function.")
    @Test
    public void testCase() {
        try {
            /*** build Generator with 2048bits key ***/
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(2048);
            KeyPair pair = generator.generateKeyPair();

            /*** build public and private keys ***/
            PrivateKey privateKey = pair.getPrivate();
            PublicKey publicKey = pair.getPublic();

                /*** build a file to store public key ***/
                FileOutputStream fos = new FileOutputStream("public.key");
                fos.write(publicKey.getEncoded());
                File publicKeyFile = new File("public.key");
                byte[] publicKeyBytes = Files.readAllBytes(publicKeyFile.toPath());

                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
                keyFactory.generatePublic(publicKeySpec);

            /*** build message ***/
            String secretMessage = "Message for Encrypt.";
            System.out.println("Origin Message: " + secretMessage);

            /*** do Encrypt ***/
            Cipher encryptCipher = Cipher.getInstance("RSA");
            encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] secretMessageBytes = secretMessage.getBytes(StandardCharsets.UTF_8);
            byte[] encryptedMessageBytes = encryptCipher.doFinal(secretMessageBytes);
            System.out.println("RSA Encrypt: " + encryptedMessageBytes);

            /*** do Decrypt ***/
            Cipher decryptCipher = Cipher.getInstance("RSA");
            decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decryptedMessageBytes = decryptCipher.doFinal(encryptedMessageBytes);
            String decryptedMessage = new String(decryptedMessageBytes, StandardCharsets.UTF_8);
            System.out.println("RSA Decrypt: " + decryptedMessage);

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
