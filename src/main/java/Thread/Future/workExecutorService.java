package Thread.Future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class workExecutorService {

    private ExecutorService executorService = Executors.newFixedThreadPool(3);

    public Future<String> serviceAsync(work work){
        return executorService.submit(()->service(work));
    }

    private String service(work work){
        return work.doWork();
    }

}
