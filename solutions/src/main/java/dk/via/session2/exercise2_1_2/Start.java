package dk.via.session2.exercise2_1_2;

public class Start {
    public static void main(String[] args) throws InterruptedException {
        dk.via.session2.exercise2_1_2.Counter counter = new dk.via.session2.exercise2_1_2.Counter();
        Thread thread1 = new Thread(() -> {
            for(int i = 0; i < 1000; i++) {
                counter.incrementDooku();
                counter.incrementDracula();
            }
        });
        Thread thread2 = new Thread(() -> {
            for(int i = 0; i < 500; i++) {
                counter.incrementDooku();
                counter.incrementDracula();
                counter.incrementDracula();
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Dooku: " + counter.getCountDooku());
        System.out.println("Dracula: " + counter.getCountDracula());
    }
}
