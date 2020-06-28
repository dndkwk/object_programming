package Final_TCP;

import java.sql.*;

public class JdbcConnect {

	private Connection con = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public JdbcConnect(String dbName, String rootpw) throws Exception {
		try {
			// sql 드라이버 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("드라이버 연결 성공");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("오류 : " + cnfe);
		}
		
		Connection con = null;
		String url = "jdbc:mariadb://localhost:3306/mydb?useUnicode=true&characterEncoding=utf8";
		String id = "root";
		String pw = "1234";
		
		try {
			con = DriverManager.getConnection(url, id, pw);
			stmt = con.createStatement();
			System.out.println("연결 성공");

		} catch (SQLException e) {
			System.out.println("오류 : " + e);
		}
	}

	public boolean closeDB() {
		//사용한 객체들을 닫아준다.
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (stmt != null)
				stmt.close();
			if (con != null)
				con.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	void excuteUpdate(String sql) throws SQLException {
		// statement 용 update문 실행
		if (stmt != null)
			stmt.executeUpdate(sql);
	}

	public ResultSet executeQuery(String sql) throws SQLException {
		// PreparedStatement 용 쿼리문 실행 메소드
		if (stmt != null) {
			rs = stmt.executeQuery(sql);
			return rs;
		} else {
			return null;
		}
	}


}
