/*
	4.OOP/Child.java
*/

public class Child extends Parent{  //상속문법
	String job;

	public Child() {
		System.out.println("자식");
	}

	public Child(String n, int a, String job) {
		super(n, a); // 부모 클래스의 String, int 의 parameter인 생성자 자동 호출
		this.job = job;
	}

	void printAll() {		// 메소드 재정의 
		super.printAll();
		System.out.println(job);
	}

	//Object의 toString() 로직을 개인이름값 반환으로 재정의
	public String toString() {
		return "이태경";
	}

	public static void main(String[] args) {
		Child c = new Child("전종일", 25, "IT맨");
		c.printAll();
		System.out.println(c.toString());
		String msg = "data";
		System.out.println(msg.toString());
	}
}