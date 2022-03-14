package dk.via.echo;

import java.io.IOException;

public class StartEchoClient {
    public static void main(String[] args) throws IOException {
        EchoClient client = new EchoClient("10.154.144.46", 8888);
        String reply = client.echo("Hello, World!");
        System.out.println(reply);
        reply = client.echo("Goodbye, World!");
        System.out.println(reply);
        client.close();
    }
}
