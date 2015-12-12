package model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dao.CarDAO;
import model.dto.CarDTO;
import model.dto.CarRateDTO;
import model.dto.CarRentTotalDTO;
import model.dto.CarResDTO;
import util.DBUtil;

public class CarServiceImpl implements CarServiceIF {
	private static CarServiceImpl instance = new CarServiceImpl();
	private CarServiceImpl() {}
	public static CarServiceImpl getInstance() {
		return instance;
	}
	private CarDAO dao = CarDAO.getInstance();
	
	@Override
	public ArrayList<CarDTO> carAll() throws SQLException {
		return dao.carAll();
	}
	@Override
	public boolean insertCar(CarDTO car) throws SQLException {
		return dao.insertCar(car);
	}
	@Override
	public int deleteCar(int i) throws SQLException {
		return dao.deleteCar(i);
	}

	@Override
	public ArrayList<CarResDTO> resInfoList(String id) throws SQLException{
		return dao.resInfoList(id);
	}
	
	@Override
	public ArrayList<CarRateDTO> rateInfoList() throws SQLException{
		return dao.rateInfoList();
	}

	@Override
	public ArrayList<CarDTO> rentCarList(int day, String carKind, int agtNo) throws SQLException {
		return dao.rentCarList(day, carKind, agtNo);
	}

	@Override
	public CarRentTotalDTO paymentInformation(String memID, int carNo, int day, int agtNo, int option) throws SQLException {
		return dao.paymentInformation(memID, carNo, day, agtNo, option);
	}
	
	@Override
	public boolean carPayment(String memID, CarRentTotalDTO crt) throws SQLException {
		Connection con = null;
		boolean result = false;
		
		try {
			con = DBUtil.getConnectionNotAuto();
			dao.registerReservation(memID, crt, con);
			dao.updateCarState(crt, con);
			con.commit();
			result = true;
		} catch(SQLException e) {
			con.rollback();
			e.printStackTrace();
			System.out.println("rollback");
		}finally {
			DBUtil.close(con);
		}
		
		return result;
	}

	@Override
	public boolean cancleReservation(int resNo, String memID, int carNo, int reMoney) throws SQLException {
		Connection con = null;
		boolean result = false;
		
		try {
			con = dao.resDeleteBackup(memID,reMoney);
			con = dao.resDeleteMileUpdate(con, carNo, memID);
			con = dao.resDeleteStateChange(con, carNo);
			con = dao.resDelete(con,resNo);
			con.commit();
			result = true;
		}catch(SQLException e) {
			e.printStackTrace();
			con.rollback();
		} finally {
			DBUtil.close(con);
		}
		
		return result;
	}
	
	@Override
	public int carCancleReturnMoney(String memID, int resNo) throws SQLException {
		return dao.carCancleReturnMoney(memID, resNo);
	}
}