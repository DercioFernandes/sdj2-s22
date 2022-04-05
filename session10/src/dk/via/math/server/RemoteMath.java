package dk.via.math.server;

import dk.via.math.model.Expression;
import dk.via.math.model.Result;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteMath extends Remote {
    Result evaluate(Expression exp) throws RemoteException;
}
