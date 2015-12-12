/*
	1.basic/ArraySyntax4.java
*/

class Person {
	private int no;
	private String name;
	private int age;

	public Person() {}

	public Person(int no, String name, int age) {
		this.no = no;
		this.name = name;
		this.age = age;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public String toString() {
		return "사번 : " + no + ", 이름 : " + name + ", 나이 : " + age;
	}

}

public class ArraySyntax4 {
	Person[] p = {new Person(3, "명대한", 24), new Person(2, "권미정", 21), new Person(1, "곽호성", 25)};

	public Person searchNo(int index) {
		int result = 0;
		for(int i=0; i<p.length; i++) {
			if(index == p[i].getNo()) {
				result = i;
				break;
			}
		}
		return p[result];
	}

	public static void main(String[] args) {
		

		ArraySyntax4 as = new ArraySyntax4();

		System.out.println(as.searchNo(1));
		System.out.println(as.searchNo(2));
		System.out.println(as.searchNo(3));
	}
}