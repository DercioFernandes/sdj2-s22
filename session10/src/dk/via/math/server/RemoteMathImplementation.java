package dk.via.math.server;

import dk.via.math.model.Expression;
import dk.via.math.model.Result;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteMathImplementation implements RemoteMath {
    public Result evaluate(Expression e) throws RemoteException {
        double operand1 = e.getOperand1();
        double operand2 = e.getOperand2();
        double r = switch(e.getOperator()) {
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "*" -> operand1 * operand2;
            case "/" -> operand1 / operand2;
            default -> throw new RemoteException("Illegal operand");
        };
        return new Result(r, e);
    }
}
