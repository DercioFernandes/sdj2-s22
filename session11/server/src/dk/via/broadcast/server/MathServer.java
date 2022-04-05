package dk.via.broadcast.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MathServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        RemoteMath math = new RemoteMathImplementation();
        registry.bind("math", math);
        System.out.println("Server running on " + Registry.REGISTRY_PORT);
    }
}
