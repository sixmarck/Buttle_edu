/*
	1.basic/PeopleTest.java
	과제
	1. 완성 로직 : 두 사람의 정보를 저장 및 출력
	2. 제약 조건
	 1) 완벽한 People 클래스를 사용
		(People.java는 수정 불가)
	 2) 이 클래스에서 People 객체들 생성 후 활용
	3. 확장(옵션)
	 - 기본은 main 메소드에서 모든 로직 다 구현
	  예외적으로 더 코딩하고 싶다 싶은 친구들만 다음 로직 완성
	 - 두개의 People 멤버 변수로도 선언 및 활용
*/

class PeopleTest {
	public static void main(String[] args) {
		People p1 = new People();
		People p2 = new People();

		p1.name = "aaa";
		p1.age = 11;
		p1.job = "aaa";

		p2.name = "bbb";
		p2.age = 12;
		p2.job = "bbb";

		System.out.printf("name : %s, age : %d, job : %s\n", p1.name, p1.age, p1.job);
		System.out.println("name : " + p2.name + ", age : " + p2.age + ", job : " + p2.job);
		
	}
}