package model.dto;

import java.sql.Date;

public class BoardDTO {
	private int boaNo;
	private Date boaDate;
	private String boaTitle;
	private String boaContent;
	private String memID;
	
	public BoardDTO() {
		super();
	}
	
	public BoardDTO(int boaNo, Date boaDate, String boaTitle,
			String boaContent,String memID) {
		super();
		this.boaNo = boaNo;
		this.boaDate = boaDate;
		this.boaTitle = boaTitle;
		this.boaContent = boaContent;
		this.memID = memID;
	}
	
	public BoardDTO( String boaTitle, String boaContent ,String memID) {
		super();
		this.boaTitle = boaTitle;
		this.boaContent = boaContent;
		this.memID = memID;
	}
	
	public int getBoaNo() {
		return boaNo;
	}
	
	public void setBoaNo(int boaNo) {
		this.boaNo = boaNo;
	}
	
	public Date getBoaDate() {
		return boaDate;
	}
	
	public void setBoaDate(Date boaDate) {
		this.boaDate = boaDate;
	}
	
	public String getBoaTitle() {
		return boaTitle;
	}
	
	public void setBoaTitle(String boaTitle) {
		this.boaTitle = boaTitle;
	}
	
	public String getBoaContent() {
		return boaContent;
	}
	
	public void setBoaContent(String boaContent) {
		this.boaContent = boaContent;
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
		builder.append("BoardDTO [boaNo=");
		builder.append(boaNo);
		builder.append(", boaDate=");
		builder.append(boaDate);
		builder.append(", boaTitle=");
		builder.append(boaTitle);
		builder.append(", boaContent=");
		builder.append(boaContent);
		builder.append(", memID=");
		builder.append(memID);
		builder.append("]");
		return builder.toString();
	}
}