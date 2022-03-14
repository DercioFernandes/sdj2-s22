package dk.via.session1.exercise1_8;

public class Bear implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(10000);
            System.out.println("Bear is well-rested");
        } catch (InterruptedException e) {
            System.out.println("Bear is angry");
        }
    }
}
