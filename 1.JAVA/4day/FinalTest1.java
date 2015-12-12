/*
	1.basic/FinalTest1.java
	학습내용
	1. final 키워드 학습
	  1. 기타제어자
	2. 적용 문법
	  1. 변수 - 값 변경 불가인 상수화 되는 선언
	  2. 메소드 - 상속 관계상에서 상속되는 메소드{} 수정(재정의) 불가
	  3. 클래스 - 상속관계에서 자식은 절대 있을수 없다 즉 상속 불가인 클래스
*/
public class FinalTest1{
	static int no1 = 3;
	public static final int no2 = 10;

	public static void main(String[] args) {
		FinalTest1 ft = new FinalTest1();
		ft.no1 = 10;
		//ft.no2 = 20;

		FinalTest1.no1 = 100;
		System.out.println(FinalTest1.no2);
	}
		
}