package Thread.NonSynchronized;

public class counter {
    private int number = 0;
    private int milliSecondBase = 10;

    public void calculate() {

        int totalTime = milliSecondBase * (int)(10*Math.random());

        try {
            Thread.sleep(totalTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        setNumber(getNumber()+1);

        System.out.println("This move spend : " + totalTime + " secs to finish. Now is : " + getNumber());
    }

    private void setNumber(int addNumber){
        this.number = addNumber;
    }

    public int getNumber(){
        return this.number;
    }

    public void setMilliSecondBase(int newMilliSecondBase){
        this.milliSecondBase = newMilliSecondBase;
    }
}
