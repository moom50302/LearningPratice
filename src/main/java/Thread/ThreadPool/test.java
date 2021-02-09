package Thread.ThreadPool;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class test {

    static Logger logger = LoggerFactory.getLogger(test.class);

    @DisplayName("Test ThreadPool : Test Case 1 : Normal Loop Check")
    @Test
    public void testCase1() {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        threadPoolExecutor.submit(() -> {
            Thread.sleep(3000);
            return null;
        });
        threadPoolExecutor.submit(() -> {
            Thread.sleep(3000);
            return null;
        });
        threadPoolExecutor.submit(() -> {
            Thread.sleep(3000);
            return null;
        });
        threadPoolExecutor.submit(() -> {
            Thread.sleep(9000);
            return null;
        });

        while(threadPoolExecutor.getActiveCount() > 0){
            logger.debug("Pool Size: " + threadPoolExecutor.getPoolSize());
            logger.debug("Activity Threads: " + threadPoolExecutor.getActiveCount());
            logger.debug("Queue Size: " + threadPoolExecutor.getQueue().size());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @DisplayName("Test ThreadPool : Test Case 2 : awaitTermination Check")
    @Test
    public void testCase2() {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        threadPoolExecutor.submit(() -> {
            Thread.sleep(3000);
            return null;
        });
        threadPoolExecutor.submit(() -> {
            Thread.sleep(3000);
            return null;
        });
        threadPoolExecutor.submit(() -> {
            Thread.sleep(3000);
            return null;
        });
        threadPoolExecutor.submit(() -> {
            Thread.sleep(9000);
            return null;
        });

        /* ThreadPoolExecutor before using shutdown(), all false */
        logger.debug("isTerminated: " + threadPoolExecutor.isTerminated());
        logger.debug("isTerminating: " + threadPoolExecutor.isTerminating());

        threadPoolExecutor.shutdown();

        /* ThreadPoolExecutor after using shutdown(),
        * isShutdown() => true; isTerminated() => false; isTerminating() => false */
        logger.debug("isShutdown: " + threadPoolExecutor.isShutdown());
        logger.debug("isTerminated: " + threadPoolExecutor.isTerminated());
        logger.debug("isTerminating: " + threadPoolExecutor.isTerminating());

        try {
            /* awaitTermination encounter executing task, return false */
            logger.debug("awaitTermination: "+threadPoolExecutor.awaitTermination(3, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /* ThreadPoolExecutor after using shutdown(),
         * isTerminated() => false; isTerminating() => true */
        logger.debug("isTerminated: " + threadPoolExecutor.isTerminated());
        logger.debug("isTerminating: " + threadPoolExecutor.isTerminating());

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            /* all tasks finished, return true */
            logger.debug("awaitTermination: "+threadPoolExecutor.awaitTermination(3, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /* ThreadPoolExecutor after using shutdown(),
         * isTerminated() => true; isTerminating() => false */
        logger.debug("isTerminated: " + threadPoolExecutor.isTerminated());
        logger.debug("isTerminating: " + threadPoolExecutor.isTerminating());
    }

    public void test3(){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
    }

    @BeforeAll
    public static void BeforeAll(){
        logger.debug("Test Start");
    }

    @AfterAll
    public static void AfterAll(){
        logger.debug("Test End");
    }
}
