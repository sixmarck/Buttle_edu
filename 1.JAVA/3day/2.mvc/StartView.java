/*
	2.mvc/StartView.java
	각 클래스의 용도
	1. StartView.java			: client 요청을 받는 시작 클래스
	2. Controller.java		: 어떤 요청인지 감별, 구분해서 요청별 처리(Data로부터 데이터 획득, 출력 담당 클래스의 로직 실행 명령)
	3. Data.java				: 핵심 데이터 제공 클래스
	4. Employee.java			: 핵심데이터를 저장 및 제공해주는 데이터용 클래스
	5. EndView.java			: 데이터 받아서 가공해서 출력

	web application
	브라우저로 실행되는 클래스들 : StartView & EndView
	브라우저로 부터 전송된 client 요청 받고 해당 요청별 처리 로직 진행하는 클래스 : Controller
	서버 내부에서 핵심 데이터 생성 및 제공 클래스들 : Data, Employee

	웹디자이너 담당 클래스[Presentation=View] : StartView & EndView
	비즈니스로직[Business] = Biz = Model = Core 로직 : 비즈니스 또는 핵심 개발자 : Data & Employee
	제어 및 조절 로직[Controller] = Controller
	* MVC pattern
*/

public class StartView {
	public static void main(String[] args) {
		Controller.request(1);
		Controller.request(2);
		
	}
}