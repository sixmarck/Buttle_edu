/*
	2.mvc/Controller.java
*/

public class Controller {
	//step2 : client가 1입력하면 명대한 데이터가 출력, 2 입력하면 권미정 데이터가 출력
	// 조건체크 클래스는 Controller, 요청 시작 class는 StartView.java, 출력 담당 EndView.java
	/* 1 또는 2에 해당하는 조건 - 조건식, if문
	*/

	public static void request(int value) {
		Employee[] emps = Data.getEmps();
		if(value==1) {			
			EndView.print((Data.getEmps())[0]);
		} else if(value==2) {
			EndView.print((Data.getEmps())[1]);
		}else {
			System.out.println("요청 오류");
		}
	}
}

/* step1
	static void empInfoPrint(Employee[] all) {
		// ? for + length + 각 직원들 이름들만 출력
		for (int i = 0; i<all.length ; i++){
			System.out.println(all[i].getName());
		}
	}

	public static void main(String[] args) {
		Employee[] all = Data.getEmps();
		empInfoPrint(all);
		
	}
}*/