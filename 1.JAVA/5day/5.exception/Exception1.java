/*
	1.java/5.exception/Exception1.java
	학습내용
	* 예외[exception] - 처리 가능한 경미한 에러

	1. 예외 발생 후 경험, 처리 문법 및 필요성 학습
	2. 예외 발생 시점에 따른 종류 구분하기
	  1) 컴파일 시점 발생
		- 서비스 로직의 문법을 완벽하게 코딩했다 하더라도 컴파일 예외 발생시에는 반드시 try~catch 필수
	  2) 런타임 시점 발생
	    - 컴파일은 정상, 실행시 발생되는 예외는 try~catch 처리 옵션
		왜냐하면 값 수정만으로 정상 실행 가능
	3. 예외 처리 문장
	  1) 발생가능한 영역에서 바로 처리하는 문법
	  try{
		서비스 필수로직 개발 단, 예외가 발생 가능한 로직들 개발
	  } catch(발생가능한예외타입 변수) {
		예외발생시 처리 블록
		변수.printStackTrace(); // 예외 발생에 대한 모든 내용 확인
		변수.getMessage(); // 발생된 예외 객체가 보유한 예외 메시지를 String 타입으로 반환
	  }
	  2) 호출한 곳으로 처리 위임하는 문법
		throws 해당 Exception
	
*/
class A {
	static{
		System.out.println("난 A 야");
	}
}

public class Exception1 {
	// 발생 가능한 exeception을 해당 로직에서 처리하지 않고 호출한 곳으로 처리 위임하는 코드
	public static void m() throws ClassNotFoundException{
		Class.forName("A");
	}

	public static void main(String[] args) {
		int[] i = {1, 2};
		System.out.println(i[1]);

		// java.lang.Class의 forName(String name) - parameter로 지정한 클래스의 byte code 메모리에 로딩기능의 메소드
		try{
			//Class.forName("A");
			m();
		} catch (ClassNotFoundException e){
			System.out.println("미존재하는 클래스명");
		}
		System.out.println("마지막 라인 실행");		
	}
}