package dk.via.session1.exercise1_8;

public class Start {
    public static void main(String[] args) {
        Thread bearThread = new Thread(new Bear());
        Thread manThread = new Thread(new PokingMan(bearThread));
        bearThread.start();
        manThread.start();
    }
}
