package dk.via.broadcast.client;

import java.io.IOException;

public class StartClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        MathClient client = new MathClientImplementation("localhost", 8888);
        client.addPropertyChangeListener(evt -> System.out.println(evt.getNewValue()));
        System.out.println(client.plus(2, 2));
        Thread.sleep(10_000);
        client.close();
    }
}
