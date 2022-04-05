package dk.via.math.client;

import java.rmi.registry.Registry;

public class StartClient {
    public static void main(String[] args) throws Exception {
        MathClient client = new MathClientImplementation("localhost", Registry.REGISTRY_PORT);
        System.out.println(client.add(2, 2));
    }
}
