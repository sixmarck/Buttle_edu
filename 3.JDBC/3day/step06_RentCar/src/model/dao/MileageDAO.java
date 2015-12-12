package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import model.dto.CarRentTotalDTO;
import util.DBUtil;
import util.Util;

public class MileageDAO {
	private static MileageDAO instance = new MileageDAO();
	private MileageDAO() {}
	public static MileageDAO getInstance() {
		return instance;
	}
	private static Properties info = DBUtil.getInfo();
	
	public Connection mileageCharge(String mileCode, int inputMoney, String memID) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = DBUtil.getConnectionNotAuto();
			pstmt = con.prepareStatement(info.getProperty("mileageCharge"));
			pstmt.setString(1, mileCode);
			pstmt.setInt(2, inputMoney);
			pstmt.setString(3, memID);
			
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
		}
		
		return con;
	}
	
	public Connection mileageUpdate(Connection con, int inputMoney, String memID) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			int money = MemberDAO.getInstance().getMemberMileage(memID, con);
			pstmt = con.prepareStatement(info.getProperty("mileageUpdate"));
			pstmt.setInt(1, money);
			pstmt.setInt(2, inputMoney);
			pstmt.setString(3, memID);
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
		}
		
		return con;
	}

	public Connection mileageUsage(String memID, CarRentTotalDTO crt, Connection con) throws SQLException{
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(info.getProperty("mileageUsage"));
			pstmt.setString(1, Util.MILECODE[1]);
			pstmt.setInt(2, crt.getResTotal());
			pstmt.setString(3, memID);
			pstmt.executeUpdate();
			mileageUsageUpdate(con, crt.getResTotal(), memID);
		} finally {
			DBUtil.close(pstmt);
		}
		
		return con;
	}
	
	public Connection mileageUsageUpdate(Connection con, int inputMoney, String memID) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			int money = MemberDAO.getInstance().getMemberMileage(memID, con);
			pstmt = con.prepareStatement(info.getProperty("mileageUsageUpdate"));
			pstmt.setInt(1, money);
			pstmt.setInt(2, inputMoney);
			pstmt.setString(3, memID);
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(pstmt);
		}
		
		return con;
	}
}