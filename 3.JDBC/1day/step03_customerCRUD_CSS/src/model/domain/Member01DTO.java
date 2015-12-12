package model.domain;

import java.util.Date;

public class Member01DTO {
	private String id;
	private String pw;
	private String name;
	private Date memDate;
	
	public Member01DTO() {
		super();
	}

	public Member01DTO(String id, String pw, String name, Date memDate) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.memDate = memDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getMemDate() {
		return memDate;
	}

	public void setMemDate(Date memDate) {
		this.memDate = memDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Member01DTO [id=");
		builder.append(id);
		builder.append(", pw=");
		builder.append(pw);
		builder.append(", name=");
		builder.append(name);
		builder.append(", memDate=");
		builder.append(memDate);
		builder.append("]");
		return builder.toString();
	}
	
}
