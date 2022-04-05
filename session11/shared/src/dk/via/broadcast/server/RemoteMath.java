package dk.via.broadcast.server;

import dk.via.broadcast.model.Expression;
import dk.via.broadcast.model.Result;
import dk.via.remote.observer.RemotePropertyChangeListener;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteMath extends Remote {
    Result evaluate(Expression e) throws RemoteException;

    void addPropertyChangeListener(RemotePropertyChangeListener<Result> listener) throws RemoteException;

    void removePropertyChangeListener(RemotePropertyChangeListener<Result> listener) throws RemoteException;
}
