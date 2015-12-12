package util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	private static Properties info = new Properties();
	private DBUtil(){}
	
	public static Properties getInfo() {
		return info;
	}
	
	static {
		try {
			info.load(new FileReader("dbinfo.properties"));
			info.load(new FileReader("sql.properties"));
			Class.forName(info.getProperty("jdbc.driver"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(info.getProperty("jdbc.url"), info.getProperty("jdbc.id"), info.getProperty("jdbc.pw"));
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
