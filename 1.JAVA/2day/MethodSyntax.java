/*
	1.java/MethodSyntax.java
	학습내용
	1. method 개발문법
	  - 반환타입 메소드 ( [..] ){ [..] }
	  - 반환타입의 용도
	    : 메소드 실행을 요청한 곳으로 제공해주는 반환 데이터가 존재할 경우 필수
		  반환되는 데이터 타입에 맞게 선언
	  - 반환 타입 = return 타입
	  - * 반환값이 없는 메소드인 경우 : void

	2. method 호출 문법
      - 1단계 : 사용하고자 하는 메소드를 보유한 객체 생성
	  - 2단계 : 객체를 관리하는 참조변수로 메소드 호출
	    참조변수명.메소드( [..] );
	용어 정리
	 - () 의 표현 : parameter = argument = 매개변수 = 매개인자 = 인자 = 인수
*/

class MethodSyntax {
	int no1 = 10;
	int no2 = 20;

	// 멤버 변수들값 + (더하기) 한 결과값 반환
	int m1(){
		return no1 + no2;
	}
	// no1 변수값과 메소드 호출시 제공하는 값 *(곱하기) 해서 반환
	int m2(int i) {
		return no1 * i;
	}

	// no2 값 단순 출력
	void m3() {
		System.out.println(no2);
	}

	// ? client가 두개의 정수 데이터 제공하면서 * 연산을 요청 하는 로직
	/* 개발자 관점
		 - 두개의 데이터 받야아함
		 - 연산 진행
		 - 연산 결과값은 호출한 곳으로 반환
	*/
	int m4(int no1, int no2) {
		return no1 * no2;
	}

	public static void main(String[] args) {
		MethodSyntax m = new MethodSyntax();
		
		m.m3();
		System.out.println(m.m1());
		int i = m.m2(11);
		System.out.println(i);
		int j = m.m4(11, 20);
		System.out.println(j);
	}
}