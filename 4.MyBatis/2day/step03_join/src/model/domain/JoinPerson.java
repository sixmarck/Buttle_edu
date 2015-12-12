package model.domain;

import java.util.List;

public class JoinPerson {
	private String id;
	private String name;
	private List<String> hobbyList;
	
	public JoinPerson() {}
		
	public JoinPerson(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public JoinPerson(String id, String name, List<String> hobby) {
		super();
		this.id = id;
		this.name = name;
		this.hobbyList = hobby;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getHobbyList() {
		return hobbyList;
	}

	public void setHobbyList(List<String> hobby) {
		this.hobbyList = hobby;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[id=");
		builder.append(id);
		builder.append(", 이름=");
		builder.append(name);
		builder.append(", 취미들=");
		builder.append(hobbyList);
		builder.append("]");
		return builder.toString();
	}	
}