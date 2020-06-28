import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class clientLauncher {

	public static void main(String[] args) {

		Socket server = null;
        String serIp = "127.0.0.1"; // ������
        int port = 10789; // ��Ʈ��ȣ
 
        try {
            server = new Socket(serIp, port);
 
            if (server != null) {
                System.out.println("client : " + server.toString());
            }
 
            server.close();
 
            
            
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

	}

}
