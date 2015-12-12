package model.dto;

import java.util.Date;

public class ReturnCarDTO {
	private int resNo;
	private String memID;
	private int agtNo;
	private String carState;
	private Date resEndDate;
	private Date toDay;
	private String dueState;
	
	public ReturnCarDTO() {
		super();
	}
	
	public ReturnCarDTO(int resNo, String memID, int agtNo, String carState, Date resEndDate, Date toDay, String dueState) {
		super();
		this.resNo = resNo;
		this.memID = memID;
		this.agtNo = agtNo;
		this.carState = carState;
		this.resEndDate = resEndDate;
		this.toDay = toDay;
		this.dueState = dueState;
	}

	public int getResNo() {
		return resNo;
	}

	public void setResNo(int resNo) {
		this.resNo = resNo;
	}

	public String getMemID() {
		return memID;
	}

	public void setMemID(String memID) {
		this.memID = memID;
	}

	public int getAgtNo() {
		return agtNo;
	}

	public void setAgtNo(int agtNo) {
		this.agtNo = agtNo;
	}

	public String getCarState() {
		return carState;
	}

	public void setCarState(String carState) {
		this.carState = carState;
	}

	public Date getResEndDate() {
		return resEndDate;
	}

	public void setResEndDate(Date resEndDate) {
		this.resEndDate = resEndDate;
	}

	public Date getToDay() {
		return toDay;
	}

	public void setToDay(Date toDay) {
		this.toDay = toDay;
	}

	public String getDueState() {
		return dueState;
	}

	public void setDueState(String dueState) {
		this.dueState = dueState;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReturnCarDTO [resNo=");
		builder.append(resNo);
		builder.append(", memID=");
		builder.append(memID);
		builder.append(", agtNo=");
		builder.append(agtNo);
		builder.append(", carState=");
		builder.append(carState);
		builder.append(", resEndDate=");
		builder.append(resEndDate);
		builder.append(", toDay=");
		builder.append(toDay);
		builder.append(", dueState=");
		builder.append(dueState);
		builder.append("]");
		return builder.toString();
	}
}