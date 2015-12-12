/*
	4.OOP/ChildPolymorphism.java
	학습내용
	1. 상속기반의 다형성 학습하기
	2. 이미 존재하는 Parent 클래스를 상속받는 클래스
	3. 형변환
	  1) 명시적인 형변환
	    (1) 기본타입 : 작은 사이즈의 변수에 큰사이즈의 변수값 대입시
		    int i = 10;
			byte b = (byte) i;
	    (2) 참조타입 : 레벨을 기준으로 자식타입의 변수에 부모타입의 변수값 대입시
		  부모타입 변수 = new 자식생성자();
		  자식타입 변수 = (자식타입)부모타입변수;
	  2) 자동 형변환
	    1. 기본타입
		  byte b = 3;
		  int i = b;
		2. 참조타입
		  부모타입 변수 = 자식객체;
*/

public class ChildPolymorphism extends Parent {
	public String job;
	
	void printAll() {		// 메소드 재정의 
		super.printAll();
		System.out.println(job);
	}

	public static void main(String[] args) {
		Parent p = new ChildPolymorphism(); // 다형성 객체 생성, 부모타입으로 자식객체 생성
		p.printAll();
		/*	

		*/
		p.name = "명대한";
		/* 다형성이 적용된 부모타입의 변수로는 자식만의 멤버변수, 메소드 호출 불가
		해결책 - 객체간의 형변환(명시적인 형변환)
		자식타입 변수 = (자식타입)부모타입변수;

		*/
		//p.job = "IT맨";
		ChildPolymorphism c = (ChildPolymorphism)p;
		c.job = "IT맨";
		p.printAll();

		//다형성이 적용된 배열
		Parent[] p2 = new Parent[3];
		p2[0] = new Parent();
		p2[1] = new Child();
		p2[2] = new ChildPolymorphism();
	}
}