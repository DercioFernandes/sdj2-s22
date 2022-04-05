package dk.via.exercise8_3.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class MessageListener implements Runnable {
    private final Socket socket;
    private final LoginClientImplementation client;

    public MessageListener(Socket socket, LoginClientImplementation client) {
        this.socket = socket;
        this.client = client;
    }

    public void run() {
        try {
            listen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listen() throws IOException {
        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        while(true) {
            String message = reader.readLine();
            if (message == null || message.equals("Disconnected")) {
                // Connection is closing
                client.closeSocket();
                break;
            } else if (message.equals("broadcast")) {
                String actualMessage = reader.readLine();
                client.receiveBroadcast(actualMessage);
            } else {
                client.receiveResponse(message);
            }
        }
    }
}
