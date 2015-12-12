/*
	2.mvc/StartView.java
	�� Ŭ������ �뵵
	1. StartView.java			: client ��û�� �޴� ���� Ŭ����
	2. Controller.java		: � ��û���� ����, �����ؼ� ��û�� ó��(Data�κ��� ������ ȹ��, ��� ��� Ŭ������ ���� ���� ���)
	3. Data.java				: �ٽ� ������ ���� Ŭ����
	4. Employee.java			: �ٽɵ����͸� ���� �� �������ִ� �����Ϳ� Ŭ����
	5. EndView.java			: ������ �޾Ƽ� �����ؼ� ���

	web application
	�������� ����Ǵ� Ŭ������ : StartView & EndView
	�������� ���� ���۵� client ��û �ް� �ش� ��û�� ó�� ���� �����ϴ� Ŭ���� : Controller
	���� ���ο��� �ٽ� ������ ���� �� ���� Ŭ������ : Data, Employee

	�������̳� ��� Ŭ����[Presentation=View] : StartView & EndView
	����Ͻ�����[Business] = Biz = Model = Core ���� : ����Ͻ� �Ǵ� �ٽ� ������ : Data & Employee
	���� �� ���� ����[Controller] = Controller
	* MVC pattern
*/

public class StartView {
	public static void main(String[] args) {
		Controller.request(1);
		Controller.request(2);
		
	}
}