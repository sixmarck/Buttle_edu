package model.dto;

public class SessionDTO {
	private String memID;
	private String memName;
	private String disGrade;
	private int agtNo;
	private int mileage;
	
	public SessionDTO() {
		super();
	}
	
	public SessionDTO(String memID, String memName, String disGrade, int agtNo,
			int mileage) {
		super();
		this.memID = memID;
		this.memName = memName;
		this.disGrade = disGrade;
		this.agtNo = agtNo;
		this.mileage = mileage;
	}

	public String getMemID() {
		return memID;
	}
	
	public void setMemID(String memID) {
		this.memID = memID;
	}
	
	public String getMemName() {
		return memName;
	}
	
	public void setMemName(String memName) {
		this.memName = memName;
	}
	
	public String getDisGrade() {
		return disGrade;
	}
	
	public void setDisGrade(String disGrade) {
		this.disGrade = disGrade;
	}
	
	public int getAgtNo() {
		return agtNo;
	}
	
	public void setAgtNo(int agtNo) {
		this.agtNo = agtNo;
	}
	
	public int getMileage() {
		return mileage;
	}
	
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SessionDTO [memID=");
		builder.append(memID);
		builder.append(", memName=");
		builder.append(memName);
		builder.append(", disGrade=");
		builder.append(disGrade);
		builder.append(", agtNo=");
		builder.append(agtNo);
		builder.append(", mileage=");
		builder.append(mileage);
		builder.append("]");
		return builder.toString();
	}
}