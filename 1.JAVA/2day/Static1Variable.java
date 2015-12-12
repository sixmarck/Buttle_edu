/*
	1. java/Static1Variable.java
	학습내용
	1. static 특징
	  - 객체 생성하지 않고도 변수, 메소드 호출가능하게 해주는 유일한 키워드
	2. 적용 범위
	  1) 변수
	    - 변수에 적용시 특징
		  (1) 객체 생성없이도 클래스 이름만으로 호출 가능
		  (2) 생성되는 모든 객체가 공유하는 메모리
		  (3) 사용 권장 시점 : 모든 객체들이 공유해야 하는 자원이 있을 경우 초기화 로직으로 적합
	  2) 메서드
	    - 객체 생성없이도 호출 가능
	  3) static{}
	3. 객체 생성시 메모리 변환
	  1) 멤버변수 공간 확보
	  2) 멤버변수 공간에 기본값 저장 (int 타입 = 0값)
	  3) 코드에 설정한 명시적인 데이터로 치환
	
*/

class Static1Variable {
	int no1;
	static int no2;

	Static1Variable() {
		no1++; // ++ 1씩 증가하는 연산자(증가연산자)
		no2++;
	}
	
	public static void main(String[] args) {
		System.out.println(Static1Variable.no2);
		Static1Variable s1 = new Static1Variable();
		System.out.println(s1.no1 + " " + Static1Variable.no2);

		Static1Variable s2 = new Static1Variable();
		System.out.println(s2.no1 + " " + Static1Variable.no2);
	}

	static{
		System.out.println("언제 실행?");
	}

}