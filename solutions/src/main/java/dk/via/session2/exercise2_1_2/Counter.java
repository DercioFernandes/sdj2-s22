package dk.via.session2.exercise2_1_2;

public class Counter {
    private int countDooku;
    private int countDracula;

    private final Object lockDooku;
    private final Object lockDracula;

    public Counter() {
        countDooku = 0;
        countDracula = 0;
        lockDooku = new Object();
        lockDracula = new Object();
    }

    public void incrementDooku() {
        synchronized(lockDooku) {
            countDooku++;
        }
    }

    public void incrementDracula() {
        synchronized(lockDracula) {
            countDracula++;
        }
    }

    public int getCountDooku() {
        return countDooku;
    }

    public int getCountDracula() {
        return countDracula;
    }
}
