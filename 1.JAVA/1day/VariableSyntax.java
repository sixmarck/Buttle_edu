/*
	1.java/1.basic/VariableSyntax.java
	학습내용
	1. 자바 변수에 대한 학습
	2. 반장 부반장 정보 확인 프로그램
		- 데이터 : 최성식, 27, 권미정, 21
	3. 출력하는 서비스 로직
		- 반장과 부반장 정보 동시에 출력해 보기
	4. 마구잡이 분석, 설계
		- 분석.. 이름과 나이로 개발
		- 설계
			1. 클래스 이름?
			2. 이름과 나이를 표현하는 데이터 타입?
			3. "							  데이터 타입?
			4. 두사람의 데이터...
				4-1. 4개의 변수 선언해서 하나의 객체 생성?
				4-2. 2개의 변수 선언 후 두개의 객체 생성?
	5. 문법
		1) class 선언 - class class이름 {}
		2) 변수 선언 - 타입 변수명 [=데이터];
		3) 객체 생성 문법
		 - 타입 변수명  = new 생성자();
		4) 변수에 값 대입 문법
		 - 변수 = 값;
*/

class VariableSyntax {
	// 이름값 저장 가능한 변수 선언
	public String name;		// 멤버변수 = instance 변수
	// 나이값 저장 가능한 변수 선언
	public int age;

	// 실행을 위한 특화된 특별한 기능의 메소드 : sun에서 제시
	public static void main(String[]  args) {
		// 두사람의 정보 저장 및 활용가능한 시스템 메모리 점유 문법
		// 객체 생성 - 사용 가능한 메모리 확보
		// v = 객체참조변수, reference variable
		VariableSyntax v = new VariableSyntax();
		v.name = "최성식";
		v.age = 27;

		VariableSyntax v2 = new VariableSyntax();
		v2.name = "권미정";
		v2.age = 21;
		v2.age = 40;

		System.out.println(v.name + "과 " + v2.age);

	}
}
//http://learn.code.org