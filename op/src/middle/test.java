package middle;
//2015112232�����
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {
	String driver = "org.mariadb.jdbc.Driver";
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public test() {
		try {
			Class.forName(driver);//����̹� Ŭ������ �������� ����
			//����̹� �Ŵ��� ��ü�� ���� Ŀ�ؼ��� ����
			con = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/mysql", "root", "1234");

			if (con != null) {
				System.out.println("DB ���� ����");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
		} catch (SQLException e) {
			System.out.println("DB ���� ����");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		test dbcon = new test();
	}

}
