package model.domain;

public class DqTestBean {
	private String id;
	private int age;
	
	public DqTestBean() {
		super();
	}

	public DqTestBean(String id) {
		super();
		this.id = id;
	}
	
	public DqTestBean(int age) {
		super();
		this.age = age;
	}
	
	public DqTestBean(String id, int age) {
		super();
		this.id = id;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DqTestBean [id=");
		builder.append(id);
		builder.append(", age=");
		builder.append(age);
		builder.append("]");
		return builder.toString();
	}
}