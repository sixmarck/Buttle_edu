public class Data {
	static EmployeeList getEmp() {
		EmployeeList empList = new EmployeeList();
		empList.appendEmp(new Employee("�����", 24, "����"));
		empList.appendEmp(new Employee("����", 24, "����"));
		empList.appendEmp(new Employee("�ٳ���", 24, "����"));
		empList.appendEmp(new Employee("������", 24, "����"));
		return empList;
	}
}