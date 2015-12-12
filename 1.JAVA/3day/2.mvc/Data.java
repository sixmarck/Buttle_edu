/*
	2.mvc/Data.java
	데이터 제공 클래스
*/

public class Data {
	static Employee[] getEmps() {
		Employee[] emps = {new Employee("명대한", 24, "송파"), new Employee("권미정", 21, "안동")};
		return emps;
	}
}