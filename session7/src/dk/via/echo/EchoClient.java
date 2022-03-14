package dk.via.echo;

import java.io.*;
import java.net.Socket;

public class EchoClient {
    private final Socket socket;
    private final PrintWriter writer;
    private final BufferedReader reader;

    public EchoClient(String host, int port) throws IOException {
        socket = new Socket(host, port);
        OutputStream outputStream = socket.getOutputStream();
        writer = new PrintWriter(outputStream);
        InputStream inputStream = socket.getInputStream();
        reader = new BufferedReader(new InputStreamReader(inputStream));
    }

    public String echo(String message) throws IOException {
        writer.println(message);
        writer.flush();
        return reader.readLine();
    }

    public void close() throws IOException {
        writer.println("exit");
        writer.flush();
        socket.close();
    }
}
