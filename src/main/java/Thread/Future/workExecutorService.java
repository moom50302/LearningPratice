package Thread.Future;

import java.util.concurrent.*;

public class workExecutorService {

    private final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 60L, TimeUnit.SECONDS,new ArrayBlockingQueue(3));

    public Future<String> serviceAsync(work work){
        return threadPoolExecutor.submit(()->service(work));
    }

    private String service(work work){
        return work.doWork();
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