package util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	private static Properties info = new Properties();
	private DBUtil(){};
	
	static {
		try {
			info.load(new FileReader("dbinfo.properties"));
			info.load(new FileReader("memberSql.properties"));
			info.load(new FileReader("boardSql.properties"));
			info.load(new FileReader("mileageSql.properties"));
			info.load(new FileReader("carSql.properties"));
			info.load(new FileReader("adminSql.properties"));
			Class.forName(info.getProperty("jdbc.driver"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Properties getInfo(){
		return info;
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(info.getProperty("jdbc.url"), info.getProperty("jdbc.id"), info.getProperty("jdbc.pw"));
	}
	
	public static Connection getConnectionNotAuto() throws SQLException {
		Connection con = DriverManager.getConnection(info.getProperty("jdbc.url"), info.getProperty("jdbc.id"), info.getProperty("jdbc.pw"));
		con.setAutoCommit(false);
		return con;
	}

	public static void close(Connection con, PreparedStatement pstmt, ResultSet rset) {
		try {
			if (rset != null) {
				rset.close();
				rset = null;
			}
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection con, PreparedStatement pstmt) {
		try {
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement pstmt, ResultSet rset) {
		try {
			if (rset != null) {
				rset.close();
				rset = null;
			}
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement pstmt) {
		try {
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection con) {
		try {
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
