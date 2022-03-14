package dk.via.session2.exercise2_4;

public class BurgerBar {
    private int numberOfBurgers;
    private int maxNumberOfBurgers;

    public BurgerBar(int maxNumberOfBurgers) {
        this.numberOfBurgers = 0;
        this.maxNumberOfBurgers = maxNumberOfBurgers;
    }

    public synchronized void makeBurger(String employeeName) {
        while (numberOfBurgers >= maxNumberOfBurgers) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        numberOfBurgers++;
        System.out.println(employeeName + " made a burger. " + numberOfBurgers + " left");
        notifyAll();
    }

    public synchronized void eatBurger(String customerName) {
        while (numberOfBurgers <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        numberOfBurgers--;
        System.out.println(customerName + " ate a burger. " + numberOfBurgers + " left.");
        notifyAll ();
    }

    public synchronized int getNumberOfBurgers() {
        return numberOfBurgers;
    }
}
