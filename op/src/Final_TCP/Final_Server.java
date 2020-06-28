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
			System.out.println("서버:연결중...");
			ServerSocket serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(SERVERPORT));
			ResultSet rs = null;

			// client에서 input받기
			Socket client = serverSocket.accept();
			BufferedReader in;
			String str;

			// client에 output보내기
			OutputStream os = client.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw);

			// JDBC 연결
			JdbcConnect jdbc = new JdbcConnect("mydb", "1234");
			while (true) {
				System.out.println("서버:받는중...");
				try {
					in = new BufferedReader(new InputStreamReader(client.getInputStream()));
					str = in.readLine();// input 읽기
					if (str.contains("INSERT")) {// 신규입력
						System.out.println("신규입력");
						rs = jdbc.executeQuery(str);

					} else if (str.contains("UPDATE")) {// 업데이트
						System.out.println("업데이트");
						jdbc.excuteUpdate(str);
					} else if (str.contains("SELECT")) {// 출력
						System.out.println("출력");
						rs = jdbc.executeQuery(str);

						while (rs.next()) { // 다음 값이 없을때까지 출력
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
							try { //결과 값 제출
								pw.println(result);
								pw.flush();
								Thread.sleep(200);
							} catch (InterruptedException e) {
								System.out.println("InterruptedException");
							}
						}

					} else if (str.equals("3")) { 
						// 종료:3 이 들어오면 while문 빠져나간다
						System.out.println("종료");
						break;
					} else if (str.contains("ALTER") || str.contains("CREATE")) {
						//테이블 생성 및 한글 입력 설정
						jdbc.excuteUpdate(str);
					} else {// 그외
						System.out.println(str);
					}

				} catch (Exception e) {
					System.out.println("서버:에러");
					e.printStackTrace();
					System.out.println();
				}
			}

			jdbc.closeDB();// 종료
			client.close();
			System.out.println("서버: 끝");

		} catch (Exception e) {
			System.out.println("서버:에러");
			e.printStackTrace();
		}
		return;
	}

	public static void main(String[] args) {

		Thread ServerThread = new Thread(new Final_Server());
		ServerThread.start();
	}

}
