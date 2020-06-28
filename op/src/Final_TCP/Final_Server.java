package Final_TCP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;

public class Final_Server implements Runnable {

	public static final int SERVERPORT = 8080;

	@Override
	public void run() {
		try {
			System.out.println("����:������...");
			ServerSocket serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(SERVERPORT));
			ResultSet rs = null;

			// client���� input�ޱ�
			Socket client = serverSocket.accept();
			BufferedReader in;
			String str;

			// client�� output������
			OutputStream os = client.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw);

			// JDBC ����
			JdbcConnect jdbc = new JdbcConnect("mydb", "1234");
			while (true) {
				System.out.println("����:�޴���...");
				try {
					in = new BufferedReader(new InputStreamReader(client.getInputStream()));
					str = in.readLine();// input �б�
					if (str.contains("INSERT")) {// �ű��Է�
						System.out.println("�ű��Է�");
						rs = jdbc.executeQuery(str);

					} else if (str.contains("UPDATE")) {// ������Ʈ
						System.out.println("������Ʈ");
						jdbc.excuteUpdate(str);
					} else if (str.contains("SELECT")) {// ���
						System.out.println("���");
						rs = jdbc.executeQuery(str);

						while (rs.next()) { // ���� ���� ���������� ���
							int s_num = rs.getInt(1);
							String s_name = rs.getString(2);
							int attend = rs.getInt(3);
							int homework = rs.getInt(4);
							int mid = rs.getInt(5);
							int fin = rs.getInt(6);
							int sum = rs.getInt(7);
							int rank = rs.getInt(8);
							String result = s_num + " " + s_name + " " + attend + " " + homework + " " + mid + " " + fin
									+ " " + sum + " " + rank;
							System.out.println(result);
							try { //��� �� ����
								pw.println(result);
								pw.flush();
								Thread.sleep(200);
							} catch (InterruptedException e) {
								System.out.println("InterruptedException");
							}
						}

					} else if (str.equals("3")) { 
						// ����:3 �� ������ while�� ����������
						System.out.println("����");
						break;
					} else if (str.contains("ALTER") || str.contains("CREATE")) {
						//���̺� ���� �� �ѱ� �Է� ����
						jdbc.excuteUpdate(str);
					} else {// �׿�
						System.out.println(str);
					}

				} catch (Exception e) {
					System.out.println("����:����");
					e.printStackTrace();
					System.out.println();
				}
			}

			jdbc.closeDB();// ����
			client.close();
			System.out.println("����: ��");

		} catch (Exception e) {
			System.out.println("����:����");
			e.printStackTrace();
		}
		return;
	}

	public static void main(String[] args) {

		Thread ServerThread = new Thread(new Final_Server());
		ServerThread.start();
	}

}
