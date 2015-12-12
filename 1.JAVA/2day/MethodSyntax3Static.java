/*
	1.java/MethodSyntax3Static.java
	학습내용
	1. static 키워드에 대한 학습 시작
	  - 클래스 내부에 static 키워드로 선언된 메소드들 개발
	  - 호출방법 : class명, 메소드명([..]);

	2. 고려사항
	  - 객체 생성의 필요성?
	    : 멤버 변수가 미 존재하는 클래스들은 객체 생성 고려해 볼 필요
		  * 객체 생성수는 가급적 최소화 왜? 서버 시스템 부하 감소
	  - ??? Math 클래스의 생성자 정말 미존재?
	    - 존재 단 Math 클래스 내부에서만 사용 가능한 생성자로 구현
		  방식 - 은닉기법 적용(private 키워드가 핵심)

	* static 키워드 상세 학습 차후에...
*/

class MethodSyntax3Static {
	void m(){
		System.out.println(1);
	}
	static void m2(){
		System.out.println(2);
	}

	public static void main(String[] args) {
		MethodSyntax3Static m = new MethodSyntax3Static();
		m.m();
		m.m2();
		MethodSyntax3Static.m2();

		// 0.0 ~ 1.0 이전까지의 실수(double) 값을 실행시 마다 가변적으로 출력
		// 난수 = random [ double random(){} ]

	}
}