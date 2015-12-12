/*
	4.OOP/ChildOverriding.java
	학습내용
	1. 다형성 review 및 응용
*/

public class ChildOverriding extends Object {
	public ChildOverriding() {
		super();
	}

	public String toString() {  // 재정의
		return "재정의학습";
	}

	static Object m() {
		return "난 문자열";
	}

	public static void main(String[] args) {
		String v = (String)m();
		System.out.print(v);
		//Integer i = (Integer)m(); 실행오류 - 메모리에 생성된 객체 타입으로만 형변환 가능
	}

}