/*
	1.java/4.OOP/Parent.java
	학습내용
	1. 클래스간의 재사용성을 위한 상속, 다형성 학습
	2. 상속과 다형성 장점
	  - 기업입장 : 비용 절감
	  - 코드의 재사용성 또는 유지보수시에 수정이 발생되도 일부만 수정해도되는 기능 제공
	3. 스펙
	  1) java.lang.Object라는 클래스가 모든 클래스의 최상위 root[단군할아버지 급]
	  2) 직계 부모는 단일 클래스 단, 조상 계층은 제한이 없음
      3) *** 상속 구성 요소
	    - 부모가 변수와 메소드만 자식 클래스에게 상속
		- 부모의 생성자는 자식 생성자 호출되어 실행시 우선적으로 실행됨
		  : 자식객체만 생성 요청한다 하더라도 내부적으로 부모 객체 우성 생성
	  4) 문법 & 키워드
	    (1) 상속 문법
		  class 자식클래스명 extends 부모클래스명 {
			변수, 메소드 상속, 추가로 멤버 개발가능
			메소드의 내용을 수정(재정의=overriding=override)
		  }
		(2) super
		  - super. : 부모의 멤버 변수 또는 메소드 지정 및 호출
		  - sper() : 생성자 내부에서 부모의 생성자 호출시 사용

		  참고 : this. - 해당 클래스의 멤버 변수 지정 및 호출
  5. 컴파일시에 자동 생성되는 코드
    1) 클래스 선언구 : extends가 미존재 할 경우만
	    extends Object
    2) 생성자별 첫 라인
	  - super()
	  - 참고 : 개발자가 parameter가 있는 생성자 호출문법 코딩 가능
	3) println()
	  - 기본타입의 데이터 출력과는 무관
        객체 타입 출력시 해당 객체가보유한 toString() 메소드 자동 호출
	* 가장 좋은 코드
	  - 가장 simple한 코드가 가장 좋은 코드
*/

public class Parent extends Object {
	String name;
	int age;

	public Parent() {
		super();
		System.out.println("부모");
	}

	public Parent(String n, int a) {
		super();
		name = n;
		age = a;
	}

	void printAll() {
		System.out.println(name);
		System.out.println(age);
	}
}