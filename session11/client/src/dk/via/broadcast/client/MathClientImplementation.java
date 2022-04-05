package dk.via.broadcast.client;

import dk.via.broadcast.model.Expression;
import dk.via.broadcast.model.Result;
import dk.via.broadcast.server.RemoteMath;
import dk.via.remote.observer.RemotePropertyChangeEvent;
import dk.via.remote.observer.RemotePropertyChangeListener;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MathClientImplementation extends UnicastRemoteObject implements MathClient, RemotePropertyChangeListener<Result> {
    private final RemoteMath math;
    private final PropertyChangeSupport support;

    public MathClientImplementation(String host, int port) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(host, port);
        math = (RemoteMath) registry.lookup("math");
        math.addPropertyChangeListener(this);
        support = new PropertyChangeSupport(this);
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

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void close() throws IOException {
        math.removePropertyChangeListener(this);
        UnicastRemoteObject.unexportObject(this, true);
    }

    @Override
    public void propertyChange(RemotePropertyChangeEvent<Result> event) throws RemoteException {
        support.firePropertyChange(event.getPropertyName(), event.getOldValue(), event.getNewValue());
    }
}
