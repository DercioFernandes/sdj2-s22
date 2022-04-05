package dk.via.broadcast.client;

import java.rmi.registry.Registry;

public class StartClient {
    public static void main(String[] args) throws Exception {
        MathClient client = new MathClientImplementation("localhost", Registry.REGISTRY_PORT);
        client.addPropertyChangeListener(evt -> System.out.println(evt.getNewValue()));
        System.out.println(client.add(2, 2));
        Thread.sleep(10_000);
        client.close();
    }
}
