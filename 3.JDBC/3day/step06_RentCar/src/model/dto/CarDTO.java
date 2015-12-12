package model.dto;

import java.util.Date;

public class CarDTO {
	private int carNo;
	private int agtNo;
	private String carName;
	private String carNum;
	private String carPax;
	private String carKind;
	private int carPrice;
	private String carFuel;
	private String carState;
	private Date carDate;	
	private int resNo;
	private Date resDate;
	private Date resStartDate;
	private Date resEndDate;
	private int resOption;
	private int resTotal;
	private String memID;
	
	public CarDTO() {
		super();
	}
	
	public CarDTO(int resNo,String carName, Date resEndDate, int resOption, int resTotal,String memID) {
		super();
		
		this.resNo = resNo;
		this.resEndDate = resEndDate;
		this.resOption = resOption;
		this.resTotal = resTotal;
		this.memID = memID;
	}
	
	public CarDTO(int agtNo, String carName, String carNum, String carPax, String carKind, int carPrice, String carFuel) {
		super();
		this.agtNo = agtNo;
		this.carName = carName;
		this.carNum = carNum;
		this.carPax = carPax;
		this.carKind = carKind;
		this.carPrice = carPrice;
		this.carFuel = carFuel;
	}
	
	public CarDTO(int carNo, String carName, String carPax, int carPrice, String carFuel) {
		super();
		this.carNo = carNo;
		this.carName = carName;
		this.carPax = carPax;
		this.carPrice = carPrice;
		this.carFuel = carFuel;
	}
	
	public CarDTO(String memID, int resNo){
		super();
		this.memID = memID;
		this.resNo = resNo;
	}

	public int getCarNo() {
		return carNo;
	}
	
	public void setCarNO(int carNo) {
		this.carNo = carNo;
	}
	
	public int getAgtNo() {
		return agtNo;
	}
	
	public void setAgtNo(int agtNo) {
		this.agtNo = agtNo;
	}
	
	public String getCarName() {
		return carName;
	}
	
	public void setCarName(String carName) {
		this.carName = carName;
	}
	
	public String getCarNum() {
		return carNum;
	}
	
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	
	public String getCarPax() {
		return carPax;
	}
	
	public void setCarPax(String carPax) {
		this.carPax = carPax;
	}
	
	public String getCarKind() {
		return carKind;
	}
	
	public void setCarKind(String carKind) {
		this.carKind = carKind;
	}
	
	public int getCarPrice() {
		return carPrice;
	}
	
	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}
	
	public String getCarFuel() {
		return carFuel;
	}
	
	public void setCarFuel(String carFuel) {
		this.carFuel = carFuel;
	}
	
	public String getCarState() {
		return carState;
	}
	
	public void setCarState(String carState) {
		this.carState = carState;
	}
	
	public Date getCarDate() {
		return carDate;
	}
	
	public void setCarDate(Date carDate) {
		this.carDate = carDate;
	}
	
	public int getResNo() {
		return resNo;
	}
	
	public void setResNo(int resNo) {
		this.resNo = resNo;
	}
	
	public Date getResDate() {
		return resDate;
	}
	
	public void setResDate(Date resDate) {
		this.resDate = resDate;
	}
	
	public Date getResStartDate() {
		return resStartDate;
	}
	
	public void setResStartDate(Date resStartDate) {
		this.resStartDate = resStartDate;
	}
	
	public Date getResEndDate() {
		return resEndDate;
	}
	
	public void setResEndDate(Date resEndDate) {
		this.resEndDate = resEndDate;
	}
	
	public int getResOption() {
		return resOption;
	}
	
	public void setResOption(int resOption) {
		this.resOption = resOption;
	}
	
	public int getResTotal() {
		return resTotal;
	}
	
	public void setResTotal(int resTotal) {
		this.resTotal = resTotal;
	}
	
	public String getMemID() {
		return memID;
	}
	
	public void setMemID(String memID) {
		this.memID = memID;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CarDTO [carNo=");
		builder.append(carNo);
		builder.append(", agtNo=");
		builder.append(agtNo);
		builder.append(", carName=");
		builder.append(carName);
		builder.append(", carNum=");
		builder.append(carNum);
		builder.append(", carPax=");
		builder.append(carPax);
		builder.append(", carKind=");
		builder.append(carKind);
		builder.append(", carPrice=");
		builder.append(carPrice);
		builder.append(", carFuel=");
		builder.append(carFuel);
		builder.append(", carState=");
		builder.append(carState);
		builder.append(", carDate=");
		builder.append(carDate);
		builder.append("]");
		return builder.toString();
	}
}