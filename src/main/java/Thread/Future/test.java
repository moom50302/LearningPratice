package Thread.Future;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

public class test {

    private work work;
    private final workExecutorService workExecutorService = new workExecutorService();

    @DisplayName("Test Future : All In, All Out.")
    @Test
    public void testCase1(){

        List<Future<String>> list = new ArrayList<>(10);

        /*** 隨機出數且不重複 ***/
//        IntStream.range(0, 10).parallel().forEach(
//                number -> {
//                    work = new work("work_"+number);
//                    System.out.println("Add new work: work_" +number);
//                    list.add(workExecutorService.serviceAsync(work));
//                }
//        );

        /*** 固定出數且不重複 ***/
        for(int number = 0; number< 10; number++){
            work = new work("work_"+number);
            System.out.println("Add new work: work_" +number);
            list.add(workExecutorService.serviceAsync(work));
        }

        System.out.println("Running Future List For-Loop.");

        for(Future<String> future: list){
            try {
                /*** 一次觀看一種結果操作 ***/
                System.out.println(future.isDone());
                System.out.println(future.cancel(true)); // 須拿掉 try () catch {}
                System.out.println(future.get().toString());
                System.out.println(future.get(100, TimeUnit.MILLISECONDS).toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
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
