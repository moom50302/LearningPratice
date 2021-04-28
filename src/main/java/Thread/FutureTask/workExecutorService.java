package Thread.FutureTask;

import Thread.Future.work;

import java.util.concurrent.*;

public class workExecutorService {

    private final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 60L, TimeUnit.SECONDS,new ArrayBlockingQueue(3));

    public void serviceAsync(FutureTask futureTask){
        threadPoolExecutor.submit(futureTask);
    }

    public boolean isFinish(){
        return threadPoolExecutor.getActiveCount() <= 0;
    }

    public void doShutdown(){
        threadPoolExecutor.shutdown();

        try {
            if(!threadPoolExecutor.awaitTermination(5000, TimeUnit.SECONDS))
                return;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while(!threadPoolExecutor.isTerminated() || threadPoolExecutor.isTerminating()){
            System.out.println("Is terminating.");
        }

        System.out.println("Is terminated.");
    }
}