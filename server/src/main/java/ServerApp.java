import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void main(String[] args) throws IOException {
        args[0] = "server";
        TwoWayCommunicationServer S = new TwoWayCommunicationServer(args);

    }
}
