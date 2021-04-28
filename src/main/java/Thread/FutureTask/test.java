package Thread.FutureTask;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class test {

    private work work1, work2;
    private final workExecutorService workExecutorService = new workExecutorService();

    @DisplayName("Test Future : All In, All Out.")
    @Test
    public void testCase1() throws ExecutionException, InterruptedException {
        work1 = new work("work_"+1, 6);
        work2 = new work("work_"+2, 2);

        FutureTask futureTask1 = new FutureTask(() -> {
            return work1.doWork();
        });

        FutureTask futureTask2 = new FutureTask(() -> {
            return work2.doWork();
        });

        workExecutorService.serviceAsync(futureTask1);
        workExecutorService.serviceAsync(futureTask2);

        System.out.println("Before Getting FutureTask Value.");
        System.out.println(futureTask1.get().toString());
        System.out.println(futureTask2.get().toString());
        System.out.println("After Getting FutureTask Value.");
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
