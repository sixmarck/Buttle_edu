package model.dto;

import java.util.Date;

public class CarResDTO {
	private int resNo;
	private int carNo;
	private String carName;
	private Date resDate;
	private Date resStartDate;
	private Date resEndDate;
	private int resOption;
	private int resTotal;
	
	public CarResDTO() {
		super();
	}
	
	public CarResDTO(int resNo, int carNo, String carName, Date resDate,
			Date resStartDate, Date resEndDate, int resOption, int resTotal) {
		super();
		this.resNo = resNo;
		this.carNo = carNo;
		this.carName = carName;
		this.resDate = resDate;
		this.resStartDate = resStartDate;
		this.resEndDate = resEndDate;
		this.resOption = resOption;
		this.resTotal = resTotal;
	}
	
	public int getResNo() {
		return resNo;
	}
	
	public void setResNo(int resNo) {
		this.resNo = resNo;
	}
	
	public int getCarNo() {
		return carNo;
	}
	
	public void setCarNo(int carNo) {
		this.carNo = carNo;
	}
	
	public String getCarName() {
		return carName;
	}
	
	public void setCarName(String carName) {
		this.carName = carName;
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
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CarResDTO [resNo=");
		builder.append(resNo);
		builder.append(", carNo=");
		builder.append(carNo);
		builder.append(", carName=");
		builder.append(carName);
		builder.append(", resDate=");
		builder.append(resDate);
		builder.append(", resStartDate=");
		builder.append(resStartDate);
		builder.append(", resEndDate=");
		builder.append(resEndDate);
		builder.append(", resOption=");
		builder.append(resOption);
		builder.append(", resTotal=");
		builder.append(resTotal);
		builder.append("]");
		return builder.toString();
	}
}
