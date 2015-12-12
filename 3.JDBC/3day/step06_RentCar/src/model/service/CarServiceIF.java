package model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.CarDTO;
import model.dto.CarRateDTO;
import model.dto.CarRentTotalDTO;
import model.dto.CarResDTO;

public interface CarServiceIF {
	public ArrayList<CarDTO> carAll() throws SQLException;
	public boolean insertCar(CarDTO car) throws SQLException;
	public int deleteCar(int i) throws SQLException;
	public boolean cancleReservation(int resNo, String memID, int carNo, int reMoney) throws SQLException;
	public ArrayList<CarResDTO> resInfoList(String id) throws SQLException ;
	public ArrayList<CarRateDTO> rateInfoList() throws SQLException;
	public ArrayList<CarDTO> rentCarList(int day, String carKind, int agtNo) throws SQLException;
	public CarRentTotalDTO paymentInformation(String memID, int carNo, int day, int agtNo, int option) throws SQLException;
	public boolean carPayment(String memID, CarRentTotalDTO crt) throws SQLException;
	public int  carCancleReturnMoney(String memID, int resNo) throws SQLException;
}