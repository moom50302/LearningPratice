package Thread.Threads;

public class testRunnable implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Runnable sleep for 5 seconds.");
    }
}
