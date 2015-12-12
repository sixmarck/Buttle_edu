/*
	2.mvc/Employee.java
*/

public class Employee {
	private String name;
	private int age;
	private String address;

	public Employee(){}
	public Employee(String name, int age, String address) {
		this.name = name;
		setAge(age);
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if( age > 0 ) {
			this.age = age;
		} else {
			System.out.println("age값 재 확인 하셔요");
		}
		
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}