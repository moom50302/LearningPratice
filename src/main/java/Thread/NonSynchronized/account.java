package Thread.NonSynchronized;

public class account {
    private int money;
    private int milliSecondBase = 10;

    public void withdraw(int withdrawMoney) {
        try {
            int totalTime = milliSecondBase * (int)(10*Math.random());
            //System.out.println("This move need : " + totalTime + " secs to finish.");

            Thread.sleep(totalTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if((money - withdrawMoney) < 0) {
            System.out.println("Not enough money now $ : " + money + " $");
            return;
        }

        money -= withdrawMoney;
        System.out.println("Withdraw $ : " + withdrawMoney + " $");
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
