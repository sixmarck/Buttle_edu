package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "tiger");
	}
	
	// query용[select] 자원반환
	public static void close(Connection con, Statement pstmt, ResultSet rs) {
		try{
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	// DML용 자원반환
	public static void close(Connection con, Statement pstmt) {
		try{
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
