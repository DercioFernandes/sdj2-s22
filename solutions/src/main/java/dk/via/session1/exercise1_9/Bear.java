package dk.via.session1.exercise1_9;

import java.util.List;

public class Bear implements Runnable {
    private final List<Thread> bears;

    public Bear(List<Thread> bears) {
        this.bears = bears;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10000);
            System.out.println("Bear is well-rested");
        } catch (InterruptedException e) {
            System.out.println("Bear is angry");
            for(Thread bear: bears) {
                if (bear.getState() == Thread.State.TIMED_WAITING) {
                    bear.interrupt();
                }
            }
        }
    }
}
