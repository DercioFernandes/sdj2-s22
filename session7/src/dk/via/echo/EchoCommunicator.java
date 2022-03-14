package dk.via.echo;

import java.io.*;
import java.net.Socket;

public class EchoCommunicator implements Runnable {
    private final Socket socket;

    public EchoCommunicator(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter writer = new PrintWriter(outputStream);
            while(true) {
                String message = reader.readLine();
                if (message.equals("exit")) {
                    break;
                }
                System.out.println(message);
                writer.println(message);
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
