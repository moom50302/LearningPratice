package Encrypt.Hash;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;

public class bcryptHash {
    @DisplayName("Test BCrypt Hash function.")
    @Test
    public void testCase() {
        String message = "Message for Hash";
        String hash = BCrypt.hashpw(message, BCrypt.gensalt(11));
        System.out.println("BCrypt Hash Message: " + hash);
        Boolean b = BCrypt.checkpw(message, hash);
        System.out.println(b);
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
