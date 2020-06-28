package Final;

//2015112232백근주
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Final_exam {

	public static boolean check(String s) {
		// 숫자인지 아닌지 구별해주는 함수
		try {
			double n = Double.parseDouble(s);
			return true;// 숫자일때
		} catch (NumberFormatException e) {
			return false;// 문자일때
		}
	}

	public static double sum(String a, String b, String c, String d) {
		// 합구하기
		double temp = Double.parseDouble(a) + Double.parseDouble(b) + Double.parseDouble(c) + Double.parseDouble(d);

		return temp;
	}

	public static void putDB(ArrayList<String> array) {
		// DB에 저장하기
		Connection con = null;// 데이터 베이스와 연결을 위한 객체
		PreparedStatement pstmt = null; // SQL문을 데이터 베이스에 보내기 위한 객체
		Statement stmt = null;
		String driver = "org.mariadb.jdbc.Driver";

		// 연결을 위한 정보
		String url = "jdbc:mariadb://localhost:3306/mydb?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String pw = "1234";

		String[] input;// 데이터 저장 변수

		try {
			Class.forName(driver);// 드라이버 클래스를 동적으로 생성
			// 드라이버 매니저 객체를 통해 커넥션을 만듬
			con = DriverManager.getConnection(url, user, pw);

			String table;
			String insert = "INSERT INTO STUDENT VALUES (?,?,?,?,?,?,?,?)";

			// 테이블 생성
			stmt = con.createStatement();
			table = "create table if not exists STUDENT"
					+ "(sn int,name varchar(20),attend int,hw int,mid int,fin int,sum double,rank int);";
			stmt.execute(table); // 테이블 생성
			stmt.execute("ALTER TABLE student convert to charset utf8;"); // 테이블 charset바꿔서 한글 깨짐 방지

			pstmt = con.prepareStatement(insert);

			// 데이터 넣기
			for (int i = 0; i < array.size(); i++) {
				input = array.get(i).split(",|\n");// 문자열로 나눈다.
				pstmt.setInt(1, Integer.parseInt(input[0]));
				pstmt.setString(2, input[1]);
				pstmt.setInt(3, Integer.parseInt(input[2]));
				pstmt.setInt(4, Integer.parseInt(input[3]));
				pstmt.setInt(5, Integer.parseInt(input[4]));
				pstmt.setInt(6, Integer.parseInt(input[5]));
				pstmt.setDouble(7, Double.parseDouble(input[6]));
				pstmt.setInt(8, Integer.parseInt(input[7]));
				pstmt.executeUpdate();
			}

		} catch (Exception e) {
			System.out.println("오류발생:" + e);
		} finally { // 자원 해제
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				System.out.println("DB 접속 실패");
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		int number; // 인원수 저장
		String input;
		ArrayList<String> array = new ArrayList<>();

		while (true) {
			System.out.print("학생수를 입력하세요>>");
			input = sc.nextLine();

			if (check(input)) {
				number = Integer.parseInt(input);
				break;
			}
			System.out.print("다시입력");
		}

		System.out.println("학번, 성명, 출석, 과제, 중간, 기말 입력: ");
		for (int i = 0; i < number; i++) { // 콘솔로 입력받기
			String data = sc.nextLine();
			String[] sub_data = data.split(",");
			// 만일 조건과 안맞으면 정보 다시 입력
			if (sub_data.length != 6) {
				i--;
				System.out.println("다시입력");
				continue;
			}
			if (!check(sub_data[0])) {
				i--;
				System.out.println("다시입력");
				continue;
			} else if (check(sub_data[1])) {
				i--;
				System.out.println("다시입력");
				continue;
			} else if (!check(sub_data[2])) {
				i--;
				System.out.println("다시입력");
				continue;
			} else if (!check(sub_data[3])) {
				i--;
				System.out.println("다시입력");
				continue;
			} else if (!check(sub_data[4])) {
				i--;
				System.out.println("다시입력");
				continue;
			} else if (!check(sub_data[5])) {
				i--;
				System.out.println("다시입력");
				continue;
			}
			array.add(data + "\n"); // 한줄 띄우기 필수
		}

		// 콘솔로 입력받은 정보 input파일에 저장
		try {
			// 파일 객체 생성
			File file = new File("C:\\Users\\Baek Guen Joo\\Desktop\\inputFile.csv");
			FileWriter fw = new FileWriter(file);
			for (int i = 0; i < array.size(); i++) {
				fw.append(array.get(i));
			}
			array.clear();
			fw.close();
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
		} catch (IOException e) {
			System.out.println("IOException");
		}

		// input파일 읽고 합계와 등수 구하기
		try {
			File file = new File("C:\\Users\\Baek Guen Joo\\Desktop\\inputFile.csv");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = "";
			String[] a;// split함수로 구분된 string들 저장
			String[] b;
			int[] rank;
			// 파일 한줄씩 저장
			while ((line = br.readLine()) != null) {
				array.add(line);
			}

			rank = new int[array.size()];

			for (int i = 0; i < array.size(); i++) {
				a = array.get(i).split(",");
				array.set(i, array.get(i) + "," + Double.toString(sum(a[2], a[3], a[4], a[5])));// 중간 기말 합
			}

			// 등수 구하기
			for (int i = 0; i < array.size(); i++) {
				rank[i] = 1;
				a = array.get(i).split(",");
				for (int j = 0; j < array.size(); j++) {
					b = array.get(j).split(",");
					if (Double.parseDouble(a[6]) < Double.parseDouble(b[6])) {
						rank[i]++;
					}
				}
			}

			for (int i = 0; i < array.size(); i++) {
				array.set(i, array.get(i) + "," + rank[i] + "\n");// 한줄 띄우기
			}

			System.out.println("학번, 성명, 출석, 과제, 중간, 기말, 합계, 등수: ");
			for (int i = 0; i < array.size(); i++) {
				System.out.print(array.get(i));
			}
			putDB(array); // DB에 넣기

			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
		} catch (IOException e) {
			System.out.println("IOException");
		}

		// output파일에 저장
		try {
			// 파일 객체 생성
			File file = new File("C:\\Users\\Baek Guen Joo\\Desktop\\outputFile.csv");
			FileWriter fw = new FileWriter(file);
			for (int i = 0; i < array.size(); i++) {
				fw.append(array.get(i));
			}
			array.clear();
			fw.close();
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
		} catch (IOException e) {
			System.out.println("IOException");
		}

		sc.close();
	}
}
