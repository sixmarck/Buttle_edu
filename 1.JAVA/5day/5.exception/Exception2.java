/*
	1.java/5.exception/Exception2.java
	학습내용
	1. java.lang.RuntimeException 하위 클래스들은 예외처리 문장 불필요
	2. 사용자 정의 예외 클래스 개발 및 활용 방법
	  1) test 로직 : id가 master가 아닌 모든 사람에게 "무효한 id입니다"라는 메세지 발생시키는 사용자 정의 예외 클래스 개발 처리하기
	  2) 문법
	    (1) java.lang.Exception 상속
		(2) parameter가 있는 생성자 개발

*/ 
public class Exception2 {
	//id 체크하는 메소드
	public static void idCheck(String id) throws UserIDCheckException{
		if(id.equals("master")) {
			System.out.println("안녕하세요~");
		}else{
			throw new UserIDCheckException("무효한 id입니다.");
		}
	}

	public static void main(String[] args) {
		try{
			idCheck("kk");
		}catch(UserIDCheckException e) {
			System.out.println(e.getMessage());
		}
		
		//java.lang.Thread의 sleep()
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace(); // 예외 발생시 연계된 모든 소스의 line 정보를 제공
		}
		System.out.println(1);
	}
}