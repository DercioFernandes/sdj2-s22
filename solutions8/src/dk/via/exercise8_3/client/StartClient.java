package dk.via.exercise8_3.client;

import java.io.IOException;

public class StartClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        LoginClient client = new LoginClientImplementation("localhost", 8888);
        client.addPropertyChangeListener(evt -> System.out.println(evt.getNewValue()));
        System.out.println(client.login("Administrator", "abcd1234"));
        Thread.sleep(10_000);
        client.close();
    }
}
