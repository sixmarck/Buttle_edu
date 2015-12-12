package model.dto;

public class Member {
	private String id;
	private String pw;
	private String name;
	private String addr;
	private String ph;
	
	public Member() {
		super();
	}

	public Member(String id, String pw, String name, String addr, String ph) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.addr = addr;
		this.ph = ph;
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

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPh() {
		return ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if(!id.equals("admin")) {
			builder.append("Member [id=");
			builder.append(id);
			/*builder.append(", pw=");
			builder.append(pw);*/
			builder.append(", name=");
			builder.append(name);
			builder.append(", addr=");
			builder.append(addr);
			builder.append(", ph=");
			builder.append(ph);
			builder.append("]");
		}
		return builder.toString();
	}
	
	
}
