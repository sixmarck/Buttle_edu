package view;

import model.domain.Person;
import controller.Controller;

public class StartView {

	public static void main(String[] args) {
		//1 : 모두 보기
		
		//2 : one or two 등 보기
		
		//3 : 가입(Person 객체 생성해서 저장 요청)
		/* 고려사항	- id중복 체크가 우선
		 * 				- 가입 성공시 출력 메시지?
		 * 				- 가입 실패시 출력 메시지?
		 * */
		System.out.println("******* 가입 *******");
		Controller.saveRequest(new Person("master", "용선", 24));
		System.out.println("******* 모두보기 *******");
		Controller.request("all");
		System.out.println("******* one에 해당하는 첫번째 Person 보기 *******");
		Controller.request("one");
		System.out.println("******* two에 해당하는 두번째 Person 보기 *******");
		Controller.request("two");
		System.out.println("******* three에 해당하는 세번째 Person 보기 *******");
		Controller.request("three");
	}

}
