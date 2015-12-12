/*
	d:/JavaSW/1.java/Test.java
	로직 : 짝궁 이름, 나이 소개하는 프로그램
	제약조건 : 
		1. getXxxx / setXxxxx 메소드 개발해보기
		2. 이름, 나이 값 저장 및 활용 가능한 변수 선언하기
*/

/*
class Person
{
	private String name;
	private int age;
	private String describe;

	public Person() {

	}

	public Person(String name, int age, String describe) {
		 this.name = name;
		 this.age = age;
		 this.describe = describe;

	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge(){
		return this.age;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getDescribe(){
		return this.describe;
	}

	public String toString(){
		return "이름 : " + this.name + ", 나이 : " + this.age + ", 설명 : " + this.describe;
	}

}

class Test {
	public static void main(String args[]) {
		Person p  = new Person();
		p.setName("kkk");
		p.setAge(25);
		p.setDescribe("안녕하세요");

		System.out.println("이름 : " + p.getName());
		System.out.println("나이 : " + p.getAge());
		System.out.println("설명 : " + p.getDescribe());

		Person p1 = new Person("kkkk", 25, "안녕하세요");
		System.out.println(p1.toString());
	}
}
*/

class Test {
	String name = "kkk";
	int age = 25;

	public static void main(String[] args) {
		// 실행시 시스템 메모리에 데이터들 저장 요청 및 생성
		Test t = new Test();
		// 메모리에 저장된 이름값만 출력
		System.out.println(t.name);
	}
}