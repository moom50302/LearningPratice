package Encrypt.Encode;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class base64Encode {
    @DisplayName("Test Old Version Way of Base64 Encode function.")
    @Test
    public void testCase_OldVersionWay() {
        String secretMessage = "Message for Base64 Encoding";
        System.out.println("Origin Message: " + secretMessage);

        try{
            BASE64Encoder encoder = new BASE64Encoder();
            String encodedSecretMessage = encoder.encode(secretMessage.getBytes(StandardCharsets.UTF_8));
            System.out.println("Message Encoded: " + encodedSecretMessage);

            BASE64Decoder decoder = new BASE64Decoder();
            String decodedSecretMessage = new String(decoder.decodeBuffer(encodedSecretMessage), StandardCharsets.UTF_8);
            System.out.println("Message Decoded: " + decodedSecretMessage);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @DisplayName("Test New Version Way of Base64 Encode function.")
    @Test
    public void testCase_NewVersionWay() {
        String secretMessage = "Message for Base64 Encoding";
        System.out.println("Origin Message: " + secretMessage);

        try{
            Base64.Encoder encoder = Base64.getEncoder();
            String encodedSecretMessage = encoder.encodeToString(secretMessage.getBytes(StandardCharsets.UTF_8));
            System.out.println("Message Encoded: " + encodedSecretMessage);

            Base64.Decoder decoder = Base64.getDecoder();
            String decodedSecretMessage = new String(decoder.decode(encodedSecretMessage), StandardCharsets.UTF_8);
            System.out.println("Message Decoded: " + decodedSecretMessage);
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
