/*
	1.java/ConstructorSyntax.java
	학습내용
	1. 생성자 구현 및 호출 문법
	  1) 구현 문법
	    클래스명([..]){[..]}
	  2) 호출 문법
	    클래스명();

	2. 생성자의 다양한 구현 방법
	
	3. 생성자 용도
	  1) 객체 생성
	  2) 객체 생성 & 멤버 변수값 초기화

	4. 생성자 다중정의(overloading)
	  - 하나의 class내부에 parameter가 서로 다른 다수의 생성자 개발 가능

	5. 변수 선언 위치에 따른 종류
	  1) 멤버 변수 = member
	    - 생성되는 공간 : heap

	  2) 지역 변수  = local = stack = automatic = temporary 이라고  함
	    - 생성되는 공간 : stack

	6. 용도에 따른 변수 종류
	  1) 멤버 변수 - 객체의 구성 요소 데이터
	  2) 참조 변수 - 객체를 관리하는 변수, 보유하는 데이터는 객체의 위치값

	* 용어 정리
	생성자 = Constructor
	다중정의 = overloading
*/

class ConstructorSyntax {
	String msg;
	ConstructorSyntax(){  // 기본 생성자
		System.out.println("기본 생성자");
	} 

	// 객체 생성시 멤버 변수값 초기화(값대입) 용도로 주로 사용
	ConstructorSyntax(String msg) {
		this.msg = msg;
		System.out.println(msg);
	}

	public static void main(String[] args) {
		ConstructorSyntax cs = new ConstructorSyntax();
		ConstructorSyntax cs2 = new ConstructorSyntax("data");
	}

}

/* 질문
	1. 멤버변수 msg가 메모리에 실제 생성되는 시점?
	  - 객체 생성 시점
	2. 생성자의 parameter인 String msg라는 변수가 메모리에 실제 생성되는 시점?
	  - 이 변수를 선언한 생성자가 호출되어 실행 될때
	3. 멤버 변수 사용 영역
	  - 객체 생성되어 객체가 메모리에 소멸(삭제)될때까지
	4. 생성자의 parameter인 String msg 변수 사용 영역
	  - 생성자가 호출되어 실행될때 자동 생성되고 생성자의 {} 로직 종료시 자동 소멸
*/