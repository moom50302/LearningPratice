package Thread.NonSynchronized;

import org.junit.jupiter.api.*;

public class testCounter {

    private counter counter = new counter();

    @DisplayName("Test Synchronization: Non-Static Method, 10 ms (Usually See)")
    @RepeatedTest( value = 10, name="{displayName} 第{currentRepetition}次測試，總共需要執行{totalRepetitions}次 ")
    public void testCase1(){
        counter.setMilliSecondBase(10);

        new Thread(() -> counter.calculate()).start();
        new Thread(() -> counter.calculate()).start();
        new Thread(() -> counter.calculate()).start();
        new Thread(() -> counter.calculate()).start();
        new Thread(() -> counter.calculate()).start();
        new Thread(() -> counter.calculate()).start();
        new Thread(() -> counter.calculate()).start();
        new Thread(() -> counter.calculate()).start();
        new Thread(() -> counter.calculate()).start();
        new Thread(() -> counter.calculate()).start();

        try {
            Thread.sleep((int)(1000*2));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @DisplayName("Test Synchronization: Non-Static Method, 100 ms (Medium See)")
    @RepeatedTest( value = 10, name="{displayName} 第{currentRepetition}次測試，總共需要執行{totalRepetitions}次 ")
    public void testCase2(){
        counter.setMilliSecondBase(100);

        new Thread(() -> counter.calculate()).start();
        new Thread(() -> counter.calculate()).start();
        new Thread(() -> counter.calculate()).start();
        new Thread(() -> counter.calculate()).start();
        new Thread(() -> counter.calculate()).start();
        new Thread(() -> counter.calculate()).start();
        new Thread(() -> counter.calculate()).start();
        new Thread(() -> counter.calculate()).start();
        new Thread(() -> counter.calculate()).start();
        new Thread(() -> counter.calculate()).start();

        try {
            Thread.sleep((int)(1000*2));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @DisplayName("Test Synchronization: Non-Static Method, 1000 ms (Hard See)")
    @RepeatedTest( value = 10, name="{displayName} 第{currentRepetition}次測試，總共需要執行{totalRepetitions}次 ")
    //@Test
    public void testCase3(){
        counter.setMilliSecondBase(1000);

        new Thread(() -> counter.calculate()).start();
        new Thread(() -> counter.calculate()).start();
        new Thread(() -> counter.calculate()).start();
        new Thread(() -> counter.calculate()).start();
        new Thread(() -> counter.calculate()).start();
        new Thread(() -> counter.calculate()).start();
        new Thread(() -> counter.calculate()).start();
        new Thread(() -> counter.calculate()).start();
        new Thread(() -> counter.calculate()).start();
        new Thread(() -> counter.calculate()).start();

        try {
            Thread.sleep((int)(1000*2));
        } catch (InterruptedException e) {
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

    @BeforeEach
    public void BeforeEach(){ System.out.println("");}
}
