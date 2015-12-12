package model.service;

import java.sql.SQLException;

import model.dto.CarRentTotalDTO;

public interface MileageServiceIF {
	public boolean mileageCharge(String mileCode, int inputMoney, String memid )  throws SQLException;
	public boolean mileageCharge(String mileCode, int inputMoney, String memid, CarRentTotalDTO crt)  throws SQLException;
}
