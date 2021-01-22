package Thread.NonSynchronized;

public class account {
    private int money;
    private int milliSecondBase = 10;

    public void withdraw(int withdrawMoney) {
        try {
            int totalTime = (int)(milliSecondBase*Math.random());
            System.out.println("This move need : " + totalTime + " secs to finish.");

            Thread.sleep(totalTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if((money - withdrawMoney) < 0) {
            System.out.println("Not enough money now $ : " + money + " $");
            return;
        }

        money -= withdrawMoney;
        System.out.println("Now remains $ : " + money + " $");
    }

    public void deposit(int depositMoney){
        money += depositMoney;
        System.out.println("Now have $ : " + money + " $");
    }

    public int getMoney(){
        return this.money;
    }

    public void setMilliSecondBase(int newMilliSecondBase){
        this.milliSecondBase = newMilliSecondBase;
    }
}
