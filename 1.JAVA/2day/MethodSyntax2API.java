/*
	MethodSyntax2API.java
	학습내용
	1. method syntax review
	2. api 활용 시작
	3. method & api 혼용해서 개발
	4. 힌트 : java.lang.String 클래스의 메소드를 활용

	* 참고
	  1. 객체생성 문법
	    - 타입 변수명 = new 생성자( [..] );
	  2. 객체 임에도 예외적으로 두개의 타입은 new 없이도 jvm내에서 자동 객체화
	    - 표기법으로 내부적으로 메모리에 생성되는 시점에 객체로 생성
	    - String(" "), 배열({값1, ...})
	   
*/

class MethodSyntax2API {
	// ? 이름, 나이값 받아서 "이 사람의 이름은 XXX이고, 나이는 XX입니다." 반환
	String getInfo(String name, int age) {
		return "이 사람의 이름은 " + name + "이고, 나이는 " + age + "입니다.";
	}

	// ? 로직을 본인이 정하기
	/* 단 String 클래스의 메소드 기능 활용하기
	
	*/
	String m(String value) {
		return "    " + value;
	}

	public static void main(String[] args) {
		MethodSyntax2API m = new MethodSyntax2API();
		String value = m.getInfo("홍길동", 22);
		System.out.println(value);
		//? value가 참조하는 객체의 첫번째 음절값만 착출해서 출력
		/* String 클래스 내부에 char값 반환 메소드 존재

		*/
		char v = value.charAt(0);
		System.out.println(v);

		String value2 = value.substring(0,5);
		System.out.println(value2);

		//? value변수가 참조하는 문자열 객첵의 전체 길이값 출력
		int length = value.length();
		System.out.println(length);

		System.out.println(m.m(value));
		System.out.println(m.m(value).trim());
		
	}
}