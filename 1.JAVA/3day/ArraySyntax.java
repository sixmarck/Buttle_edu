/*
	1.basic/ArraySyntax.java
	학습내용
	1. 배열이란?
	  - 동일한 타입의 다수의 데이터들을 하나의 변수로 관리하는 구조
	  - 단 개별 데이터의 구분은 고유한 index로 함
	    : index 시작은 0부터
	  - length : 배열 생성시 자동 생성되는 변수(속성)
	    배열의 전체 사이즈
	  - 모든 배열은 객체, 저장되는 실제 메모리 또한 heap
	  - * 로컬 변수임에도 유일하게 자동 초기화 진행
	2. 문법
	  1) 선언생성초기화 동시 진행 문법
		타입[] 변수 = { 값1, 값2, 값3... };
	  2) 선언, 생성, 초기화 별도의 문법
	    타입[] 변수;
		변수 = new 타입[생성시킬메모리개수];
		변수[0] = 값;
		변수[1] = 값;
	3. 고려사항
	  int i = 1;

*/

class ArraySyntax {
	public static void main(String[] args) {
		//배열선언, 생성, 값 초기화 동시에 진행
		// 1, 2, 3, 4, 5 저장 후 출력하기
		int[] i = {1, 2, 3, 4, 5};
		int i2 [] = {1, 2, 3, 4, 5};

		System.out.println(i[4]); //5
		System.out.println(i.length);

		//배열 선언 따로, 생성 따로, 값 초기화 따로 분리해서 개발하는 문법
		int[] i3 = null;		//선언
		i3 = new int[5];		//생성
		i3[0] = 1;				//초기화
		i3[1] = 2;
		i3[2] = 3;
		System.out.println(i3[0] + " " + i3[4] + " " + i3.length);

		int i4;
		System.out.println(i4);
	}
}