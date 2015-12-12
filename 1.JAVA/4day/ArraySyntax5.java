/*
	1.basic/ArraySyntax5.java
	학습내용
	1. 메모리 구조의 흐름 정리하기
	2. 사용 타입 : 배열, People
	3. 변수
	  - 로컬변수, 멤버변수
	4. 사용 메모리 : class area(method area), stack, heap
*/

public class ArraySyntax5 {
	public People[] p = {new People(), new People()};

	public void m1(String name, int age, String job) {
		p[0].name = name;
		p[0].age = age;
		p[0].job = job;
	}

	public void m2(People p) {
		System.out.println(p.name + " " + p.age);
	}

	public static void main(String[] args) {
		ArraySyntax5 as = new ArraySyntax5();
		as.m1("강재석", 25, "IT직군");
		as.m2(as.p[0]);

	}
}