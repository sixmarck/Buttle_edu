package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.Data;
import model.dto.Member;
import util.Utils;
import controller.Controller;
import exception.InputCheckException;

public class StartView {
	public static BufferedReader reader = new BufferedReader(
			new InputStreamReader(System.in));

	public static int startForm() throws IOException {
		System.out.println("==================");
		System.out.println("=====택배관리  시스템=====");
		System.out.println("==================");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 종료");
		System.out.print("선택 : ");
		return Integer.parseInt(reader.readLine());
	}

	public static int startDetail(int index) throws IOException,
			InputCheckException {
		switch (index) {
		case Utils.NO1:
			// 회원가입
			memberRegisterForm();
			break;
		case Utils.NO2:
			// 로그인
			loginForm();
			break;
		case Utils.NO3:
			// 종료
			break;
		default:
			throw new InputCheckException("잘못된 입력값입니다.");
		}
		return index;
	}

	public static void memberRegisterForm() throws IOException {
		String id = null;
		String pw = null;
		String name = null;
		String addr = null;
		String ph = null;
		System.out.print("아이디 : ");
		id = reader.readLine();
		System.out.print("비밀번호 : ");
		pw = reader.readLine();
		System.out.print("이름 : ");
		name = reader.readLine();
		System.out.print("주소 : ");
		addr = reader.readLine();
		System.out.print("핸드폰 : ");
		ph = reader.readLine();

		Controller.register(new Member(id,pw,name,addr,ph));
	}

	public static void loginForm() throws IOException {
		String id = null;
		String pw = null;
		System.out.print("ID 입력 : ");
		id = reader.readLine();
		System.out.print("PW 입력 : ");
		pw = reader.readLine();

		if (Controller.login(id, pw)) {
			if (id.equals("admin")) {
				adminForm(id);
			} else {
				mainForm(id);
			}
		} else {
			System.out.println("id 또는 pw가 없습니다.");
		}
	}

	public static void comment(String id) {
		System.out.println("==== " + id + "님 환영합니다! ====");
	}

	public static void mainForm(String id) throws IOException {
		comment(id);
		while (true) {
			System.out.println("1. 택배조회");
			System.out.println("2. 운송장번호조회");
			System.out.println("3. 택배등록");
			System.out.println("4. 로그아웃");
			System.out.print("선택 : ");
			try {
				if (mainDetail(Integer.parseInt(reader.readLine()), id) == Utils.NO4) {
					break;
				}
			} catch (InputCheckException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void transportNoForm(String id, String no) throws IOException {
		while (true) {
			// System.out.println("1. 보낸이 주소수정");
			System.out.println("1. 택배삭제");
			System.out.println("2. 돌아가기");
			System.out.print("선택 : ");
			try {
				if (transportDetail(Integer.parseInt(reader.readLine()), id, no) == Utils.NO2) {
					break;
				}
			} catch (InputCheckException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static int transportDetail(int index, String id, String no)
			throws InputCheckException, IOException {
		switch (index) {
		// case Utils.NO1:
		// // 주소수정
		// System.out.println("변경할 주소지를 입력해주세요. : ");
		// Controller.userUpdateTransport(no, reader.readLine());//id는 멤버 no는 택배
		// index = 3; // 돌아가기
		// break;
		// case Utils.NO2:
		// Controller.deleteBoard(no);
		// index = 3; // 돌아가기
		// // 택배삭제
		// break;
		// case Utils.NO3:
		// // 돌아가기
		// break;
		// default:
		// throw new InputCheckException("잘못된 입력값입니다.");
		// }
		case Utils.NO1:

			// 택배삭제
			Controller.deleteBoard(no);
			index = Utils.NO2; // 돌아가기
			break;
		case Utils.NO2:

			break;
		default:
			throw new InputCheckException("잘못된 입력값입니다.");
		}
		return index;
	}

	public static int mainDetail(int index, String id)
			throws InputCheckException {
		switch (index) {
		case Utils.NO1:
			// 택배조회
			Controller.userTransportSearch(id);
			break;
		case Utils.NO2:
			// 택배등록
			try {
				checkTransportNo(id);
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case Utils.NO3:
			// 택배등록
			try {
				transportInsertForm(id);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			break;
		case Utils.NO4:
			// 로그아웃
			break;
		default:
			throw new InputCheckException("잘못된 입력값입니다.");
		}
		return index;
	}

	public static void adminForm(String id) throws IOException {
		while (true) {
			comment(id);
			System.out.println("1. 전체 회원 목록 출력");
			System.out.println("2. 운송장 목록 출력");
			System.out.println("3. 운송장 상태 변경");
			System.out.println("4. 택배 신청수 통계");
			System.out.println("5. 로그아웃");
			System.out.print("선택 : ");
			try {
				if (adminDetail(Integer.parseInt(reader.readLine())) == Utils.NO5) {
					break;
				}
			} catch (InputCheckException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static int adminDetail(int index) throws InputCheckException {
		switch (index) {
		case Utils.NO1:
			// 전체 회원 목록 출력
			Controller.allMemberList();
			break;
		case Utils.NO2:
			// 운송장 목록 출력
			Controller.allTransportList();
			break;
		case Utils.NO3:
			// 운송장 상태 변경
			try {
				changeStateForm();
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case Utils.NO4:
			// 택배신청수 통계
			Controller.oneDayParcelStatistics();
			break;
		case Utils.NO5:
			// 로그아웃
			break;
		default:
			throw new InputCheckException("잘못된 입력값입니다.");
		}
		return index;
	}

	public static void checkTransportNo(String id)
			throws NumberFormatException, IOException {
		System.out.print("조회할 운송장 번호 입력 : ");
		String no = reader.readLine();
		if (Controller.transportNo(no, id))
			transportNoForm(id, no);
	}

	public static void changeStateForm() throws NumberFormatException,
			IOException {
		System.out.print("상태를 변경할 운송장 번호 입력 [ex)no] : ");
		String no = reader.readLine();
		System.out.print("상태를 입력 [ex)1:배송 준비중, 2:배송중, 3: 배송완료] : ");
		int value = Integer.parseInt(reader.readLine());
		Controller.changeState(no, value);
	}

	public static void transportInsertForm(String id) throws IOException {
		//
		// System.out.println("등록할 택배 번호 입력 [ex)no] : ");
		// String no = reader.readLine();
		// if (Data.checkTransport(no)) {
		// // throw new DuplicateException(no);
		// System.out.println("존재하는 택배물입니다.");
		// } else {
		// String transportInfo = no;
		// System.out
		// .print("택배 정보를 입력 [ex)1:보내는 사람, 2:보내는 주소, 3: 받는사람, 4:보내는 번호, 5:받는 주소, 6:받는 번호, 7: state, 8:날짜");
		// transportInfo = transportInfo + "," + reader.readLine();
		//
		// Controller.insertBoard(no, transportInfo.trim());
		// }
		System.out.print("받을 사람의 아이디를 입력하세요 >ㅁ < : ");
		Controller.productRegister(id, reader.readLine());
	}

	public static void main(String[] args) {
		while (true) {
			try {
				if (startDetail(startForm()) == Utils.NO3) {
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InputCheckException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
