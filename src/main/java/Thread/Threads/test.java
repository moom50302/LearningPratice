package Thread.Threads;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class test {

    @DisplayName("Test Thread and Runnable")
    @Test
    public void testCase1() {
        new Thread(new testRunnable()).start();
        new testThread().start();

        int i = 0;

        while (i < 10){

            System.out.println("Now is " + i + " second.");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i += 1;
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
