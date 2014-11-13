package cf.todd.dungeon;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.ArrayList;

public class DungeonServer {

	private ServerSocket serverSocket;
	private List<Connection> connections = new ArrayList<Connection>();

	public DungeonServer(int port) throws IOException {
		serverSocket = new ServerSocket(port, 5);
	}
	
	public static void main(String[] args) throws IOException {
		DungeonServer server = new DungeonServer(13021);
		server.Serve();
	}
	
	public void Serve() throws IOException {
		while(true) {
			Socket socket = serverSocket.accept();
			Connection connection = new Connection(socket, this);
			connections.add(connection);
			connection.start();
		}
	}
	
	public void removeConnection(Connection connection) {
		connections.remove(connection);
	}
}
