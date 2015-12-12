package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import model.dto.CarDTO;
import model.dto.CarRateDTO;
import model.dto.CarRentTotalDTO;
import model.dto.CarResDTO;
import model.dto.MemberOneSalsDTO;
import util.DBUtil;
import util.Util;

public class CarDAO {
	private static CarDAO instance = new CarDAO();
	private CarDAO() {}
	public static CarDAO getInstance() {
		return instance;
	}
	private static Properties info = DBUtil.getInfo();

	public ArrayList<CarDTO> carAll() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<CarDTO> carDataAll = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(info.getProperty("carAll"));
			rset = pstmt.executeQuery();
			carDataAll = new ArrayList<CarDTO>();
			while (rset.next()) {
				carDataAll.add(new CarDTO(rset.getInt(2), rset.getString(3),
						rset.getString(4), rset.getString(5),
						rset.getString(6), rset.getInt(7), rset.getString(8)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}

		return carDataAll;
	}

	public int carCancleReturnMoney(String memID, int resNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int returnMoney = 0;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(info.getProperty("carCancleReturnMoney"));
			pstmt.setString(1, memID);
			pstmt.setInt(2, resNo);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				returnMoney = rset.getInt(1);
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}

		return returnMoney;
	}

	public boolean insertCar(CarDTO car) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean result = false;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(info.getProperty("insertCar"));
			pstmt.setInt(1, car.getAgtNo());
			pstmt.setString(2, car.getCarName());
			pstmt.setString(3, car.getCarNum());
			pstmt.setString(4, car.getCarPax());
			pstmt.setString(5, car.getCarKind());
			pstmt.setInt(6, car.getCarPrice());
			pstmt.setString(7, car.getCarFuel());
			int i = pstmt.executeUpdate();
			if (i == 1) {
				result = true;
			}
		} finally {
			DBUtil.close(con, pstmt, null);
		}
		
		return result;
	}

	public int deleteCar(int i) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(info.getProperty("deleteCar"));
			pstmt.setInt(1, i);
			result = pstmt.executeUpdate();
		} finally {
			DBUtil.close(con, pstmt);
		}
		
		return result;
	}

	public ArrayList<CarResDTO> resInfoList(String id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<CarResDTO> resInfoAll = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(info.getProperty("resInfoList"));
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			resInfoAll = new ArrayList<CarResDTO>();
			while (rset.next()) {
				resInfoAll.add(new CarResDTO(rset.getInt(1), rset.getInt(2), rset.getString(3), rset.getDate(4), rset.getDate(5),
						rset.getDate(6), rset.getInt(7), rset.getInt(8)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		
		return resInfoAll;
	}

	public ArrayList<CarRateDTO> rateInfoList() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<CarRateDTO> rateInfoAll = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(info.getProperty("rateInfoList"));
			rset = pstmt.executeQuery();
			rateInfoAll = new ArrayList<CarRateDTO>();
			while (rset.next()) {
				rateInfoAll.add(new CarRateDTO(rset.getString(1), rset.getString(2), rset.getInt(3)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		
		return rateInfoAll;
	}

	public ArrayList<CarDTO> rentCarList(int day, String carKind, int agtNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<CarDTO> list = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(info.getProperty("rentCarList"));
			pstmt.setInt(1, agtNo);
			pstmt.setString(2, carKind);
			rset = pstmt.executeQuery();
			list = new ArrayList<CarDTO>();
			while (rset.next()) {
				list.add(new CarDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getInt(4), rset.getString(5)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		
		return list;
	}

	public CarRentTotalDTO paymentInformation(String memID, int carNo, int day, int agtNo, int option) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemberOneSalsDTO mo = null;
		CarRentTotalDTO crt = null;
		
		try {
			mo = MemberDAO.getInstance().selectMemberOneSals(memID);
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(info.getProperty("selectCarAvailableOne"));
			pstmt.setInt(1, carNo);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				crt = new CarRentTotalDTO(rset.getInt(1), rset.getString(2), rset.getInt(3), rset.getInt(4), rset.getString(5), agtNo,
						option, day, mo.getMemMileage(), mo.getDisValue(), 
						(int) ((int) (rset.getInt(4) * day + Util.CAROPTION[option]) * (1 - mo.getDisValue())));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		
		return crt;
	}

	public void registerReservation(String memID, CarRentTotalDTO crt, Connection con) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			MileageDAO.getInstance().mileageUsage(memID, crt, con);
			pstmt = con.prepareStatement(info.getProperty("registerReservation"));
			pstmt.setInt(1, crt.getDay());
			if (crt.getCarOption() == 0) {
				pstmt.setString(2, null);
			} else {
				pstmt.setInt(2, crt.getCarOption());
			}
			pstmt.setInt(3, crt.getResTotal());
			pstmt.setInt(4, crt.getAgtNo());
			pstmt.setString(5, memID);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
		}
	}

	public void updateCarState(CarRentTotalDTO crt, Connection con) throws SQLException {
		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(info.getProperty("updateCarState"));
			pstmt.setInt(1, crt.getCarNo());
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
		}
	}

	public Connection resDelete(Connection con, int resNo) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(info.getProperty("resDelete"));
			pstmt.setInt(1, resNo);
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
		}
		
		return con;
	}

	public Connection resDeleteBackup(String memID, int reMoney) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBUtil.getConnectionNotAuto();
			pstmt = con.prepareStatement(info.getProperty("resDeleteBackup"));
			pstmt.setString(1, Util.MILECODE[2]);
			pstmt.setInt(2, reMoney);
			pstmt.setString(3, memID);
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
		}
		
		return con;
	}

	public Connection resDeleteMileUpdate(Connection con, int carNo, String memID) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(info.getProperty("resDeleteMileUpdate"));
			pstmt.setInt(1, carNo);
			pstmt.setString(2, memID);
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
		}
		
		return con;
	}

	public Connection resDeleteStateChange(Connection con, int carNo) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(info.getProperty("resDeleteStateChange"));
			pstmt.setInt(1, carNo);
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
		}
		
		return con;
	}

	public static int getCarNum(int resNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int carNum = 0;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(info.getProperty("getCarNum"));
			pstmt.setInt(1, resNo);
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		
		return carNum;
	}
}