package dk.via.json;

import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class MathClientImplementation implements MathClient {
    private final static HashMap<String, MathClientImplementation> instances = new HashMap<>();
    private static final String EXIT_JSON = """
    {"operator": "exit"}
    """;

    private final Socket socket;
    private final PrintWriter output;
    private final BufferedReader input;
    private final Gson gson;

    private MathClientImplementation(String host, int port) throws IOException {
        this.socket = new Socket(host, port);
        OutputStream outputStream = socket.getOutputStream();
        this.output = new PrintWriter(outputStream);
        InputStream inputStream = socket.getInputStream();
        this.input = new BufferedReader(new InputStreamReader(inputStream));
        this.gson = new Gson();
    }

    public String getHost() {
        return socket.getInetAddress().getHostAddress();
    }

    public int getPort() {
        return socket.getPort();
    }

    public synchronized static MathClientImplementation getInstance(String host, int port) throws IOException {
        String key = host + ":" + port;
        if (!instances.containsKey(key)) {
            MathClientImplementation instance = new MathClientImplementation(host, port);
            instances.put(key, instance);
        }
        return instances.get(key);
    }

    @Override
    public double plus(double operand1, double operand2) throws IOException {
        Expression expression = new Expression("+", operand1, operand2);
        String json = gson.toJson(expression);
        output.println(json);
        output.flush();
        String resultJson = input.readLine();
        Result result = gson.fromJson(resultJson, Result.class);
        return result.getValue();
    }

    @Override
    public double minus(double operand1, double operand2) throws IOException {
        Expression expression = new Expression("-", operand1, operand2);
        String json = gson.toJson(expression);
        output.println(json);
        output.flush();
        String resultJson = input.readLine();
        Result result = gson.fromJson(resultJson, Result.class);
        return result.getValue();
    }

    @Override
    public void close() throws IOException {
        instances.remove(this);
        output.println(EXIT_JSON);
        output.flush();
        socket.close();
    }
}
