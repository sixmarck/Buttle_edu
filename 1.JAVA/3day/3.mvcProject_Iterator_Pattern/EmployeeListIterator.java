public class EmployeeListIterator implements Iterator {
	private EmployeeList empList;
	private int index;

	public EmployeeListIterator(EmployeeList empList) {
		this.empList = empList;
		this.index = 0;
	}

	public boolean hasNext() {
		if(index < empList.getLength()) {
			return true;
		}else{
			return false;
		}
	}

	public Object next() {
		Employee e = empList.getEmpAt(index);
		index++;
		return e;
	}
}