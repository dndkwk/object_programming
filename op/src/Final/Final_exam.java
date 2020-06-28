package Final;

//2015112232�����
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
		// �������� �ƴ��� �������ִ� �Լ�
		try {
			double n = Double.parseDouble(s);
			return true;// �����϶�
		} catch (NumberFormatException e) {
			return false;// �����϶�
		}
	}

	public static double sum(String a, String b, String c, String d) {
		// �ձ��ϱ�
		double temp = Double.parseDouble(a) + Double.parseDouble(b) + Double.parseDouble(c) + Double.parseDouble(d);

		return temp;
	}

	public static void putDB(ArrayList<String> array) {
		// DB�� �����ϱ�
		Connection con = null;// ������ ���̽��� ������ ���� ��ü
		PreparedStatement pstmt = null; // SQL���� ������ ���̽��� ������ ���� ��ü
		Statement stmt = null;
		String driver = "org.mariadb.jdbc.Driver";

		// ������ ���� ����
		String url = "jdbc:mariadb://localhost:3306/mydb?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String pw = "1234";

		String[] input;// ������ ���� ����

		try {
			Class.forName(driver);// ����̹� Ŭ������ �������� ����
			// ����̹� �Ŵ��� ��ü�� ���� Ŀ�ؼ��� ����
			con = DriverManager.getConnection(url, user, pw);

			String table;
			String insert = "INSERT INTO STUDENT VALUES (?,?,?,?,?,?,?,?)";

			// ���̺� ����
			stmt = con.createStatement();
			table = "create table if not exists STUDENT"
					+ "(sn int,name varchar(20),attend int,hw int,mid int,fin int,sum double,rank int);";
			stmt.execute(table); // ���̺� ����
			stmt.execute("ALTER TABLE student convert to charset utf8;"); // ���̺� charset�ٲ㼭 �ѱ� ���� ����

			pstmt = con.prepareStatement(insert);

			// ������ �ֱ�
			for (int i = 0; i < array.size(); i++) {
				input = array.get(i).split(",|\n");// ���ڿ��� ������.
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
			System.out.println("�����߻�:" + e);
		} finally { // �ڿ� ����
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				System.out.println("DB ���� ����");
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		int number; // �ο��� ����
		String input;
		ArrayList<String> array = new ArrayList<>();

		while (true) {
			System.out.print("�л����� �Է��ϼ���>>");
			input = sc.nextLine();

			if (check(input)) {
				number = Integer.parseInt(input);
				break;
			}
			System.out.print("�ٽ��Է�");
		}

		System.out.println("�й�, ����, �⼮, ����, �߰�, �⸻ �Է�: ");
		for (int i = 0; i < number; i++) { // �ַܼ� �Է¹ޱ�
			String data = sc.nextLine();
			String[] sub_data = data.split(",");
			// ���� ���ǰ� �ȸ����� ���� �ٽ� �Է�
			if (sub_data.length != 6) {
				i--;
				System.out.println("�ٽ��Է�");
				continue;
			}
			if (!check(sub_data[0])) {
				i--;
				System.out.println("�ٽ��Է�");
				continue;
			} else if (check(sub_data[1])) {
				i--;
				System.out.println("�ٽ��Է�");
				continue;
			} else if (!check(sub_data[2])) {
				i--;
				System.out.println("�ٽ��Է�");
				continue;
			} else if (!check(sub_data[3])) {
				i--;
				System.out.println("�ٽ��Է�");
				continue;
			} else if (!check(sub_data[4])) {
				i--;
				System.out.println("�ٽ��Է�");
				continue;
			} else if (!check(sub_data[5])) {
				i--;
				System.out.println("�ٽ��Է�");
				continue;
			}
			array.add(data + "\n"); // ���� ���� �ʼ�
		}

		// �ַܼ� �Է¹��� ���� input���Ͽ� ����
		try {
			// ���� ��ü ����
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

		// input���� �а� �հ�� ��� ���ϱ�
		try {
			File file = new File("C:\\Users\\Baek Guen Joo\\Desktop\\inputFile.csv");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = "";
			String[] a;// split�Լ��� ���е� string�� ����
			String[] b;
			int[] rank;
			// ���� ���پ� ����
			while ((line = br.readLine()) != null) {
				array.add(line);
			}

			rank = new int[array.size()];

			for (int i = 0; i < array.size(); i++) {
				a = array.get(i).split(",");
				array.set(i, array.get(i) + "," + Double.toString(sum(a[2], a[3], a[4], a[5])));// �߰� �⸻ ��
			}

			// ��� ���ϱ�
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
				array.set(i, array.get(i) + "," + rank[i] + "\n");// ���� ����
			}

			System.out.println("�й�, ����, �⼮, ����, �߰�, �⸻, �հ�, ���: ");
			for (int i = 0; i < array.size(); i++) {
				System.out.print(array.get(i));
			}
			putDB(array); // DB�� �ֱ�

			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
		} catch (IOException e) {
			System.out.println("IOException");
		}

		// output���Ͽ� ����
		try {
			// ���� ��ü ����
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
