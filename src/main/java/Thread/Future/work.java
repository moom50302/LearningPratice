package Thread.Future;

public class work {

    public String doWork(){
        int totalWorkTime = (int)(10000*Math.random());

        System.out.println("This work need : " +totalWorkTime + " secs to finish.");

        try {
            Thread.sleep(totalWorkTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "After " + totalWorkTime + " secs, the work done.";
    }
}
