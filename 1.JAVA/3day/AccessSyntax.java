/*
	//1.java/1.basic/AccessSyntax.java
	학습내용
	1. '.' 라는 접근자로 변수, 메소드 호출하는 문법 익숙해지기
	2. API 활용 익숙해지기

*/

class B {
	int noB = 100;
	String msgB = "B내에 존재하는 변수";
}

class A {
	int no = 10;
	B b = new B();
	String msg = "A내에 존재하는 변수";
}

public class AccessSyntax {
	A a = new A();

	//? m1이라는 메소드 구현 : A의 msg라는 변수값 반환 로직
	public String m1() {
		return a.msg;
	}

	//? m2 : B의 msgB 변수값 반환
	public String m2() {
		return a.b.msgB;
	}

	public static void main(String[]  args) {
		// ? 멤버 변수가 참조하는 A객체의 no값 출력해보기
		//System.out.println(a.no);
		AccessSyntax as = new AccessSyntax();
		System.out.println(as.a.no);
		// ? 더이상의 객체 생성없이 B의 noB값 출력하기
		System.out.println(as.a.b.noB);
		//? m1 메소드 호출하기
		System.out.println(as.m1());
		//? m2 메소드 호출하기
		System.out.println(as.m2());
		//? m2 메소드에서 반환된 결과값을 문자열 길이 출력하기
		System.out.println(as.m2().length());
		System.out.println(Integer.toString(as.m2().length()).charAt(1));
		
	}
} 