package Thread.Future;

import org.junit.jupiter.api.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class test {

    private work work = new work();

    @DisplayName("Test Future : All In All Out.")
    @Test
    public void testCase1(){

        Future<String> future1 = new workExecutorService().serviceAsync(work);
        Future<String> future2 = new workExecutorService().serviceAsync(work);
        Future<String> future3 = new workExecutorService().serviceAsync(work);

        while(!future1.isDone() || !future2.isDone() || !future3.isDone()){
            try {
                System.out.println("Keep waiting 1 sec.");
                Thread.sleep((int)(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            System.out.println(future1.get());
            System.out.println(future2.get());
            System.out.println(future3.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
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
