package Thread.Future;

public class work {

    private String name;

    public work(String name){
        this.name = name;
    }

    public String doWork(){
        int totalWorkTime = (int)(10000*Math.random());

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
