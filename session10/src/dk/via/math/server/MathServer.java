package dk.via.math.server;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MathServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        RemoteMath math = new RemoteMathImplementation();
        Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        Remote exported = UnicastRemoteObject.exportObject(math, 8888);
        registry.bind("math", exported);
        System.out.println("Server running on " + Registry.REGISTRY_PORT);
    }
}
