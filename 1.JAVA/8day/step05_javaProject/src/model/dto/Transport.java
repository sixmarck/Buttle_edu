package model.dto;

public class Transport {
	private String no;
	private String id;
	private String sender;
	private String senderAddr;
	private String senderPh;
	private String receiver;
	private String receiverAddr;
	private String receiverPh;
	private String state;
	private String startDate;
	private String endDate;
	
	public Transport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transport(String no, String id, String sender, String senderAddr,
			String senderPh, String receiver, String receiverAddr,
			String receiverPh, String state, String startDate) {
		super();
		this.no = no;
		this.id = id;
		this.sender = sender;
		this.senderAddr = senderAddr;
		this.senderPh = senderPh;
		this.receiver = receiver;
		this.receiverAddr = receiverAddr;
		this.receiverPh = receiverPh;
		this.state = state;
		this.startDate = startDate;
	}
	
	public Transport(String no, String id, String sender, String senderAddr,
			String senderPh, String receiver, String receiverAddr,
			String receiverPh, String state, String startDate, String endDate) {
		super();
		this.no = no;
		this.id = id;
		this.sender = sender;
		this.senderAddr = senderAddr;
		this.senderPh = senderPh;
		this.receiver = receiver;
		this.receiverAddr = receiverAddr;
		this.receiverPh = receiverPh;
		this.state = state;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSenderAddr() {
		return senderAddr;
	}

	public void setSenderAddr(String senderAddr) {
		this.senderAddr = senderAddr;
	}

	public String getSenderPh() {
		return senderPh;
	}

	public void setSenderPh(String senderPh) {
		this.senderPh = senderPh;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getReceiverAddr() {
		return receiverAddr;
	}

	public void setReceiverAddr(String receiverAddr) {
		this.receiverAddr = receiverAddr;
	}

	public String getReceiverPh() {
		return receiverPh;
	}

	public void setReceiverPh(String receiverPh) {
		this.receiverPh = receiverPh;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Transport [no=");
		builder.append(no);
		builder.append(", id=");
		builder.append(id);
		builder.append(", sender=");
		builder.append(sender);
		builder.append(", senderAddr=");
		builder.append(senderAddr);
		/*builder.append(", senderPh=");
		builder.append(senderPh);*/
		builder.append(", receiver=");
		builder.append(receiver);
		/*builder.append(", receiverAddr=");
		builder.append(receiverAddr);
		builder.append(", receiverPh=");
		builder.append(receiverPh);*/
		builder.append(", state=");
		builder.append(state);
		builder.append(", startDate=");
		builder.append(startDate);
		if(!endDate.equals("null")) {
			builder.append(", endDate=");
			builder.append(endDate);
		}
		builder.append("]");
		
		return builder.toString();
	}

}
