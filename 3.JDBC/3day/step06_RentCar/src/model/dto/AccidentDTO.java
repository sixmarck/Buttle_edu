package model.dto;

public class AccidentDTO{
	private int accNo;
	private String accDate;
	private String accContent;
	private String memID;
	
	public AccidentDTO() {
		super();
	}
	
	public AccidentDTO(String memID, String accContent) {
		super();
		this.memID = memID;
		this.accContent = accContent;
	}
	
	public AccidentDTO(int accNo, String accDate, String accContent,
			String memID) {
		super();
		this.accNo = accNo;
		this.accDate = accDate;
		this.accContent = accContent;
		this.memID = memID;
	}
	
	public int getAccNo() {
		return accNo;
	}
	
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	
	public String getAccDate() {
		return accDate;
	}
	
	public void setAccDate(String accDate) {
		this.accDate = accDate;
	}
	
	public String getAccContent() {
		return accContent;
	}
	
	public void setAccContent(String accContent) {
		this.accContent = accContent;
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
		builder.append("accidentDTO [accNo=");
		builder.append(accNo);
		builder.append(", accDate=");
		builder.append(accDate);
		builder.append(", accContent=");
		builder.append(accContent);
		builder.append(", memID=");
		builder.append(memID);
		builder.append("]");
		return builder.toString();
	}
}