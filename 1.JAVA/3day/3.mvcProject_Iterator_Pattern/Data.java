public class Data {
	static EmployeeList getEmp() {
		EmployeeList empList = new EmployeeList();
		empList.appendEmp(new Employee("명대한", 24, "송파"));
		empList.appendEmp(new Employee("하하", 24, "송파"));
		empList.appendEmp(new Employee("다나와", 24, "송파"));
		empList.appendEmp(new Employee("룰루랄라", 24, "송파"));
		return empList;
	}
}