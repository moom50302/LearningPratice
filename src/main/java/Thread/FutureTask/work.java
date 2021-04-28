package Thread.FutureTask;

public class work {

    private String name;
    private int work_time;

    public work(String name, int work_time){
        this.name = name;
        this.work_time = work_time;
    }

    public String doWork(){
        int totalWorkTime = (int)(1000*this.work_time);

        System.out.println(name + " start and it needs : " +totalWorkTime + " secs to finish.");

        try {
            Thread.sleep(totalWorkTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + " done.");

        return "After " + totalWorkTime + " secs, " + name + " done.";
    }
}
