package dk.via.session1.exercise1_9;

import java.util.ArrayList;

public class Start {
    public static void main(String[] args) {
        ArrayList<Thread> bearThreads = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            Thread bearThread = new Thread(new Bear(bearThreads));
            bearThreads.add(bearThread);
        }
        Thread manThread = new Thread(new PokingMan(bearThreads.get(0)));
        for(Thread bearThread: bearThreads) {
            bearThread.start();
        }
        //manThread.start();
    }
}
