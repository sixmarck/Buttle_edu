import java.util.*;

public class EmployeeList implements Aggregate {
	private List<Employee> emp;
	
	public EmployeeList() {
		this.emp = new ArrayList<Employee>();
	}

	public Employee getEmpAt(int index) {
		return emp.get(index);
	}

	public void appendEmp(Employee emp) {
		this.emp.add(emp);
	}

	public int getLength() {
		return emp.size();
	}

	public Iterator iterator() {
		return new EmployeeListIterator(this);
	}
}