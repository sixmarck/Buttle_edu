/*
	4.OOP/EqualsOverride.java
	학습내용
	1. java.lang.Object의 equals() 재정의 하기
	2. 추가 학습내용
	  - instanceof 연산자 : 객체타입 비교 연산자
	  - 주의사항
	    1) 기본타입과 비교 불가 : 컴파일 에러
		2) 참조(객체=class) 타입간의 비교시 상속관계에 한해서만 비교가능
		  - 서로 상이한 연관성 없는 객체 타입 비교 불가 : 컴파일 에러

*/

public class EqualsOverride {
	String msg;
	int data;
	/* ? java.lan.Object의 객체 주소값 비교 메소드를 
		동일한 객체에 한해서만 멤버변수값 비교해서 값이 동일한 경우만 true
		객체타입도 다르고 객체타입이 혹 동일하다고 해도 멤버변수값이 다르면 false를 반환하는
		메소드 재정의 하기
		
	*/
	EqualsOverride(String msg, int data) {
		this.msg = msg;
		this.data = data;
	}

	/*	상속특징
	1. java.lang.Object 최상 root
	2. 직계 부모는 단 하나
	3. 상속 기반의 다형성 가능
	  - 다형성 : 
	4. 다형성 적용시
	  - 부모타입변수로 자식객체 생성
	    변수로 자식만의 멤버 변수 호출 불가능
		해결책 객체타입간의 형변환
	5. 상속관계에서 상속되는 구성요소
	  - 변수, 메소드
	  - 생성자는 자식 객체 생성시 내부적으로 부모 생성자 자동 호출
	    : super( [..] )
		  생성자의 첫라인에 개발 가능, 생략시 컴파일러가 자동 적용
	  - 상속받았으나 메소드 로직 수정(재정의) - override or overriding
	    (tip : 다중정의(overloading) - 동일한 class내에서 똑같은 이름의 다수 메소드 개발하는 구조 rule : parameter는 반드시 달라야함)
	  - 재정의시에 부모 메소드의 모든 로직을 한문장으로 적용가능
	    super.메소드명( [..] );
	6. 

	*/
	public boolean equals(Object o) {
		if(o instanceof EqualsOverride) {
			EqualsOverride eo = (EqualsOverride)o;
			if(this.msg.equals(eo.msg) && this.data == eo.data) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		EqualsOverride e1 = new EqualsOverride("호성", 25);
		EqualsOverride e2 = new EqualsOverride("ㅏㅏ", 25);
		System.out.println(e1.equals(e2));  //true

		System.out.println("과제끝");


		System.out.println(3 == 3); //값 비교
		String s = "문";
		String s2 = "문a";
		System.out.println(s==s2); // 주소값 비교

		String s3 = new String("문");
		String s4 = new String("문");
		System.out.println(s3==s4); // false 주소값 비교
		System.out.println(s3.equals(s4)); // true 객체의 내용값 비교로 재정의 되어 있음
	}
	/*
	// step1 - instanceof 연산자 실습
	public static void main(String[] args) {
		String s = "문자열";
		boolean b = false;
		Integer i = null;


		if(s instanceof String) {
			System.out.println("true");
		}

		if(s instanceof Object) {
			System.out.println("true");
		}
		
		/*
		if(i instanceof String) { // 오류 코드 : 서로 연관없는 객체타입 비교 불가, 컴파일 오류
			System.out.println("true");
		}*/

		/*
		if(b instanceof String) { // 오류 코드 - boolean(기본)과 String(참조) 은 비교불가
			System.out.println("true");
		}*/
		
	//}
}