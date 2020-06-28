import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class serverLauncher {

	public static void main(String[] args) {
		Socket client = null;
		ServerSocket server = null;

		int port = 10789;

		try {
			server = new ServerSocket(port);
			client = server.accept(); // call set up

			if (client != null) {
				System.out.println("client : " + client.toString());
			}

			client.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
