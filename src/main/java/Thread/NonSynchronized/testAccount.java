package Thread.NonSynchronized;

import org.junit.jupiter.api.*;

public class testAccount {

    private account account = new account();

    @DisplayName("Test Synchronization: Non-Static Method, 10 ms (Usually See)")
    @RepeatedTest( value = 10, name="{displayName} 第{currentRepetition}次測試，總共需要執行{totalRepetitions}次 ")
    public void testCase1(){
        account.deposit(3000);
        account.setMilliSecondBase(10);

        new Thread(() -> account.withdraw(1000)).start();
        new Thread(() -> account.withdraw(1000)).start();
        new Thread(() -> account.withdraw(1000)).start();
        new Thread(() -> account.withdraw(1000)).start();
        new Thread(() -> account.withdraw(1000)).start();

        try {
            Thread.sleep((int)(1000*2));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @DisplayName("Test Synchronization: Non-Static Method, 100 ms (Medium See)")
    @RepeatedTest( value = 10, name="{displayName} 第{currentRepetition}次測試，總共需要執行{totalRepetitions}次 ")
    public void testCase2(){
        account.deposit(3000);
        account.setMilliSecondBase(100);

        new Thread(() -> account.withdraw(1000)).start();
        new Thread(() -> account.withdraw(1000)).start();
        new Thread(() -> account.withdraw(1000)).start();
        new Thread(() -> account.withdraw(1000)).start();
        new Thread(() -> account.withdraw(1000)).start();

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
        account.deposit(5000);
        account.setMilliSecondBase(1000);

        new Thread(() -> account.withdraw(1000)).start();
        new Thread(() -> account.withdraw(1000)).start();
        new Thread(() -> account.withdraw(1000)).start();
        new Thread(() -> account.withdraw(1000)).start();
        new Thread(() -> account.withdraw(1000)).start();

        try {
            Thread.sleep((int)(1000*10));
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
}
