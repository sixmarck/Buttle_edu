package view;

import model.domain.Person;
import controller.Controller;

public class StartView {

	public static void main(String[] args) {
		//1 : ��� ����
		
		//2 : one or two �� ����
		
		//3 : ����(Person ��ü �����ؼ� ���� ��û)
		/* �������	- id�ߺ� üũ�� �켱
		 * 				- ���� ������ ��� �޽���?
		 * 				- ���� ���н� ��� �޽���?
		 * */
		System.out.println("******* ���� *******");
		Controller.saveRequest(new Person("master", "�뼱", 24));
		System.out.println("******* ��κ��� *******");
		Controller.request("all");
		System.out.println("******* one�� �ش��ϴ� ù��° Person ���� *******");
		Controller.request("one");
		System.out.println("******* two�� �ش��ϴ� �ι�° Person ���� *******");
		Controller.request("two");
		System.out.println("******* three�� �ش��ϴ� ����° Person ���� *******");
		Controller.request("three");
	}

}
