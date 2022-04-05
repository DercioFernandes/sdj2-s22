package dk.via.math.client;

import java.io.IOException;

public interface MathClient {
    double add(double operand1, double operand2) throws IOException;
    double subtract(double operand1, double operand2) throws IOException;
    double multiply(double operand1, double operand2) throws IOException;
    double divide(double operand1, double operand2) throws IOException;
}
