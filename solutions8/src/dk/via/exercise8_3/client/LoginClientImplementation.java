package dk.via.exercise8_3.client;

import com.google.gson.Gson;
import dk.via.exercise8_3.model.Login;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.*;
import java.net.Socket;

public class LoginClientImplementation implements LoginClient {
    private final Socket socket;
    private final PrintWriter writer;
    private final Gson gson;
    private final PropertyChangeSupport support;
    private String latestResponse;

    public LoginClientImplementation(String host, int port) throws IOException {
        this.socket = new Socket(host, port);
        OutputStream outputStream = socket.getOutputStream();
        this.writer = new PrintWriter(outputStream);
        this.gson = new Gson();
        this.support = new PropertyChangeSupport(this);
        MessageListener messageListener = new MessageListener(socket, this);
        Thread thread = new Thread(messageListener);
        thread.start();
    }

    @Override
    public synchronized boolean login(String username, String password) throws IOException {
        writer.println("connect");
        writer.flush();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String firstReply = latestResponse;
        System.out.println(firstReply);
        if (!firstReply.equals("Login required")) {
            throw new IOException("Protocol error");
        }
        Login login = new Login(username, password);
        String loginJson = gson.toJson(login);
        System.out.println("Sending login");
        writer.println(loginJson);
        writer.flush();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return latestResponse.equals("Approved");
    }

    @Override
    public synchronized void close() throws IOException {
        writer.println("exit");
        writer.flush();
    }

    public void closeSocket() throws IOException {
        socket.close();
    }

    public void receiveBroadcast(String message) {
        Login login = gson.fromJson(message, Login.class);
        support.firePropertyChange("login", null, login);
    }

    public synchronized void receiveResponse(String response) {
        latestResponse = response;
        notify();
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}
