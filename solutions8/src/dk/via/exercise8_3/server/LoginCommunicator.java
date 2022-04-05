package dk.via.exercise8_3.server;

import com.google.gson.Gson;
import dk.via.exercise8_3.model.Login;

import java.io.*;
import java.net.Socket;

public class LoginCommunicator implements Runnable {
    private final Socket socket;
    private final Broadcaster broadcaster;
    private final Gson gson;

    public LoginCommunicator(Socket socket, Broadcaster broadcaster) {
        this.socket = socket;
        this.broadcaster = broadcaster;
        this.gson = new Gson();
    }

    @Override
    public void run() {
        try {
            communicate();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void communicate() throws IOException {
        broadcaster.addRecipient(socket);
        try {
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream);
            while(true) {
                String request = reader.readLine();
                if (request.equals("connect")) {
                    writer.println("Login required");
                    writer.flush();
                    String loginJson = reader.readLine();
                    Login login = gson.fromJson(loginJson, Login.class);
                    if (login.getUsername().isBlank() || login.getPassword().isBlank()) { // In real situations: Replace with proper check
                        writer.println("Not approved");
                    } else {
                        writer.println("Approved"); // In real situation: Return a unique token as proof of login
                        broadcaster.broadcast(loginJson);
                    }
                    writer.flush();
                } else {
                    writer.println("Disconnected");
                    writer.flush();
                    break;
                }
            }
        } finally {
            broadcaster.removeRecipient(socket);
            socket.close();
        }
    }
}
