package Thread.completableFuture;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static java.lang.Thread.sleep;

public class test {

    /*** Complete Basic logic ***/
//    public static CompletableFuture<Void> runAsync(Runnable runnable) {
//        CompletableFuture<Void> future = new CompletableFuture<>();
//        ForkJoinPool.commonPool().execute(() -> {
//            try {
//                runnable.run();
//                future.complete(null);
//            } catch (Throwable throwable) {
//                future.completeExceptionally(throwable);
//            }
//        });
//
//        return future;
//    }

    @DisplayName("Test CompletableFuture: whenComplete() ")
    @Test
    public void testCase1() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "Hello World!";
        }).whenComplete((result, throwable)->{
            System.out.println(result);
            test();
        });

        future.get();
    }

    @DisplayName("Test CompletableFuture: handle() ")
    @Test
    public void testCase2() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "Hello World!";
        }).handle((result, throwable)->{
            test();
            return result;
        });

        String getString = future.get();
        System.out.println(getString);
    }

    public void test(){
        System.out.println("Finish!!");
    }

    @DisplayName("Test CompletableFuture: thenRun() and thenApply() ")
    @Test
    public void testCase3() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.runAsync(() -> {
            try {
                sleep(1000);
                System.out.println("Stop at First Runnable");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).thenRun(()->{
            try {
                sleep(1000);
                System.out.println("Stop at Second Runnable");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).thenApply((result)->{
            return "Hello World!";
        }).whenComplete((result, throwable)->{
            System.out.println(result);
            test();
        });

        future.get();
    }

    @DisplayName("Test CompletableFuture: thenAccept() and thenCompose() ")
    @Test
    public void testCase4() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            return "Hello";
        }).thenCompose(result -> {
            return CompletableFuture.supplyAsync(() -> {return result+" World!";});
        }).thenAccept(result -> {
            System.out.println("Got Result:" +result);
        });

        future.get();
    }

    @DisplayName("Test CompletableFuture: runAfterBoth()")
    @Test
    public void testCase5() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            System.out.println("Run 1");
        });

        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            System.out.println("Run 2");
        });

        CompletableFuture<Void> future3 = future1.runAfterBoth(future2, ()->{
            System.out.println("Run 3");
        }).whenComplete((Void, throwable)->{
            System.out.println("Finished future3.");
        });

        future3.get();
    }

    @DisplayName("Test CompletableFuture: thenAcceptBoth()")
    @Test
    public void testCase6() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            return 100;
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            return 200;
        });

        CompletableFuture<Void> future3 = future1.thenAcceptBoth(future2, (result1, result2)->{
            System.out.println(result1 + result2);
        });

        future3.get();
    }

    @DisplayName("Test CompletableFuture: thenCombine()")
    @Test
    public void testCase7() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            return 100;
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            return 200;
        });

        CompletableFuture<Integer> future3 = future1.thenCombine(future2, (result1, result2)->{
            return result1 + result2;
        });

        Integer getInt = future3.get();
        System.out.println(getInt);
    }

    @DisplayName("Test CompletableFuture: runAfterEither()")
    @Test
    public void testCase8() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            /*** the fastest would be the output ***/
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Run 1");
        });

        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            /*** the fastest would be the output ***/
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Run 2");
        });

        CompletableFuture<Void> future3 = future1.runAfterEither(future2, ()->{
            System.out.println("Run 3");
        }).whenComplete((Void, throwable)->{
            /*** if the deadline bigger than the rest Future, it can finish its task. ***/
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finished future3.");
        });

        future3.get();
    }

    @DisplayName("Test CompletableFuture: acceptEither()")
    @Test
    public void testCase9() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            /*** the fastest would be the output ***/
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            /*** the fastest would be the output ***/
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 200;
        });

        CompletableFuture<Void> future3 = future1.acceptEither(future2, (result)->{
            /*** if the deadline bigger than the rest Future, it can finish its task. ***/
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(result);
        });

        future3.get();
    }

    @DisplayName("Test CompletableFuture: applyToEither()")
    @Test
    public void testCase10() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            /*** the fastest would be the output ***/
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            /*** the fastest would be the output ***/
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 200;
        });

        CompletableFuture<Integer> future3 = future1.applyToEither(future2, (result)->{
            return result;
        });

        Integer getInt = future3.get();
        System.out.println(getInt);

        /*** if the deadline bigger than the rest Future, it can finish its task. ***/
        try {
            sleep(2000);
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
