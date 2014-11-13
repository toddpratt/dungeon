import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Connection extends Thread {
    private Socket socket;
    private DungeonServer server;
    private BufferedReader reader;
    private PrintWriter writer;
    private boolean connected = false;
    
    Connection(Socket newSocket, DungeonServer newServer) throws IOException {
        socket = newSocket;
        server = newServer;
        reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        writer = new PrintWriter(socket.getOutputStream(), true);
    }
    
    public void run() {
        connected = true;
        do {
            String inputLine = "failure";
            try {
                inputLine = reader.readLine();
            } catch (IOException e) {
                connected = false;
                e.printStackTrace();
            }
            if (inputLine == null) {
                connected = false;
            } else if (inputLine.startsWith("stats")) {
                writer.println("things");
            } else {
                System.out.println(inputLine);
            }
        } while(connected);
        server.removeConnection(this);
    }
}
