package Thread.Threads;

public class testThread extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread sleep for 5 seconds.");
    }
}
