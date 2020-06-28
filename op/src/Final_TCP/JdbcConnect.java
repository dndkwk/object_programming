package Final_TCP;

import java.sql.*;

public class JdbcConnect {

	private Connection con = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public JdbcConnect(String dbName, String rootpw) throws Exception {
		try {
			// sql ����̹� �ε�
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("����̹� ���� ����");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("���� : " + cnfe);
		}
		
		Connection con = null;
		String url = "jdbc:mariadb://localhost:3306/mydb?useUnicode=true&characterEncoding=utf8";
		String id = "root";
		String pw = "1234";
		
		try {
			con = DriverManager.getConnection(url, id, pw);
			stmt = con.createStatement();
			System.out.println("���� ����");

		} catch (SQLException e) {
			System.out.println("���� : " + e);
		}
	}

	public boolean closeDB() {
		//����� ��ü���� �ݾ��ش�.
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
		// statement �� update�� ����
		if (stmt != null)
			stmt.executeUpdate(sql);
	}

	public ResultSet executeQuery(String sql) throws SQLException {
		// PreparedStatement �� ������ ���� �޼ҵ�
		if (stmt != null) {
			rs = stmt.executeQuery(sql);
			return rs;
		} else {
			return null;
		}
	}


}
