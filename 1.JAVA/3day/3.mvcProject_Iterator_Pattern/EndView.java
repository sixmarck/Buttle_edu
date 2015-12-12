public class EndView {
	public static void print(EmployeeList el){
		Iterator it = el.iterator();
		while(it.hasNext()) {
			Employee e = (Employee)it.next();
			System.out.println(e.getName() + e.getAge() + e.getAddress());
		}
	}
}