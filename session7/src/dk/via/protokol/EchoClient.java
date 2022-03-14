package dk.via.protokol;

import java.io.Closeable;
import java.io.IOException;

public interface EchoClient extends Closeable {
    String echo(String message) throws IOException;

    String uppercase(String message) throws IOException;
}
