package dk.via.session1.exercise1_9;

public class PokingMan implements Runnable {
    private Thread bearThread;

    public PokingMan(Thread bearThread) {
        this.bearThread = bearThread;
    }

    public void run() {
        try {
            Thread.sleep(1000);
            bearThread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("Interrupted for some reason");
        }
    }
}
