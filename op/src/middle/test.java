package middle;
//2015112232백근주
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
			Class.forName(driver);//드라이버 클래스를 동적으로 생성
			//드라이버 매니저 객체를 통해 커넥션을 만듬
			con = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/mysql", "root", "1234");

			if (con != null) {
				System.out.println("DB 접속 성공");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		test dbcon = new test();
	}

}
