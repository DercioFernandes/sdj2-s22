package dk.via.broadcast.client;

import java.beans.PropertyChangeListener;
import java.io.Closeable;
import java.io.IOException;

public interface MathClient extends Closeable {
    double add(double operand1, double operand2) throws IOException;
    double subtract(double operand1, double operand2) throws IOException;
    double multiply(double operand1, double operand2) throws IOException;
    double divide(double operand1, double operand2) throws IOException;

    void addPropertyChangeListener(PropertyChangeListener listener);

    void removePropertyChangeListener(PropertyChangeListener listener);
}
