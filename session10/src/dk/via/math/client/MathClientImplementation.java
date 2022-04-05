package dk.via.math.client;

import dk.via.math.model.Expression;
import dk.via.math.model.Result;
import dk.via.math.server.RemoteMath;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MathClientImplementation implements MathClient {
    private RemoteMath math;

    public MathClientImplementation(String host, int port) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(host, port);
        math = (RemoteMath) registry.lookup("math");
    }

    @Override
    public double add(double operand1, double operand2) throws IOException {
        Expression expression = new Expression("+", operand1, operand2);
        Result result = math.evaluate(expression);
        return result.getValue();
    }

    @Override
    public double subtract(double operand1, double operand2) throws IOException {
        Expression expression = new Expression("-", operand1, operand2);
        Result result = math.evaluate(expression);
        return result.getValue();
    }

    @Override
    public double multiply(double operand1, double operand2) throws IOException {
        Expression expression = new Expression("*", operand1, operand2);
        Result result = math.evaluate(expression);
        return result.getValue();
    }

    @Override
    public double divide(double operand1, double operand2) throws IOException {
        Expression expression = new Expression("/", operand1, operand2);
        Result result = math.evaluate(expression);
        return result.getValue();
    }
}
