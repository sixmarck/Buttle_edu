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
		System.out.println("=====�ù����  �ý���=====");
		System.out.println("==================");
		System.out.println("1. ȸ������");
		System.out.println("2. �α���");
		System.out.println("3. ����");
		System.out.print("���� : ");
		return Integer.parseInt(reader.readLine());
	}

	public static int startDetail(int index) throws IOException,
			InputCheckException {
		switch (index) {
		case Utils.NO1:
			// ȸ������
			memberRegisterForm();
			break;
		case Utils.NO2:
			// �α���
			loginForm();
			break;
		case Utils.NO3:
			// ����
			break;
		default:
			throw new InputCheckException("�߸��� �Է°��Դϴ�.");
		}
		return index;
	}

	public static void memberRegisterForm() throws IOException {
		String id = null;
		String pw = null;
		String name = null;
		String addr = null;
		String ph = null;
		System.out.print("���̵� : ");
		id = reader.readLine();
		System.out.print("��й�ȣ : ");
		pw = reader.readLine();
		System.out.print("�̸� : ");
		name = reader.readLine();
		System.out.print("�ּ� : ");
		addr = reader.readLine();
		System.out.print("�ڵ��� : ");
		ph = reader.readLine();

		Controller.register(new Member(id,pw,name,addr,ph));
	}

	public static void loginForm() throws IOException {
		String id = null;
		String pw = null;
		System.out.print("ID �Է� : ");
		id = reader.readLine();
		System.out.print("PW �Է� : ");
		pw = reader.readLine();

		if (Controller.login(id, pw)) {
			if (id.equals("admin")) {
				adminForm(id);
			} else {
				mainForm(id);
			}
		} else {
			System.out.println("id �Ǵ� pw�� �����ϴ�.");
		}
	}

	public static void comment(String id) {
		System.out.println("==== " + id + "�� ȯ���մϴ�! ====");
	}

	public static void mainForm(String id) throws IOException {
		comment(id);
		while (true) {
			System.out.println("1. �ù���ȸ");
			System.out.println("2. ������ȣ��ȸ");
			System.out.println("3. �ù���");
			System.out.println("4. �α׾ƿ�");
			System.out.print("���� : ");
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
			// System.out.println("1. ������ �ּҼ���");
			System.out.println("1. �ù����");
			System.out.println("2. ���ư���");
			System.out.print("���� : ");
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
		// // �ּҼ���
		// System.out.println("������ �ּ����� �Է����ּ���. : ");
		// Controller.userUpdateTransport(no, reader.readLine());//id�� ��� no�� �ù�
		// index = 3; // ���ư���
		// break;
		// case Utils.NO2:
		// Controller.deleteBoard(no);
		// index = 3; // ���ư���
		// // �ù����
		// break;
		// case Utils.NO3:
		// // ���ư���
		// break;
		// default:
		// throw new InputCheckException("�߸��� �Է°��Դϴ�.");
		// }
		case Utils.NO1:

			// �ù����
			Controller.deleteBoard(no);
			index = Utils.NO2; // ���ư���
			break;
		case Utils.NO2:

			break;
		default:
			throw new InputCheckException("�߸��� �Է°��Դϴ�.");
		}
		return index;
	}

	public static int mainDetail(int index, String id)
			throws InputCheckException {
		switch (index) {
		case Utils.NO1:
			// �ù���ȸ
			Controller.userTransportSearch(id);
			break;
		case Utils.NO2:
			// �ù���
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
			// �ù���
			try {
				transportInsertForm(id);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			break;
		case Utils.NO4:
			// �α׾ƿ�
			break;
		default:
			throw new InputCheckException("�߸��� �Է°��Դϴ�.");
		}
		return index;
	}

	public static void adminForm(String id) throws IOException {
		while (true) {
			comment(id);
			System.out.println("1. ��ü ȸ�� ��� ���");
			System.out.println("2. ����� ��� ���");
			System.out.println("3. ����� ���� ����");
			System.out.println("4. �ù� ��û�� ���");
			System.out.println("5. �α׾ƿ�");
			System.out.print("���� : ");
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
			// ��ü ȸ�� ��� ���
			Controller.allMemberList();
			break;
		case Utils.NO2:
			// ����� ��� ���
			Controller.allTransportList();
			break;
		case Utils.NO3:
			// ����� ���� ����
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
			// �ù��û�� ���
			Controller.oneDayParcelStatistics();
			break;
		case Utils.NO5:
			// �α׾ƿ�
			break;
		default:
			throw new InputCheckException("�߸��� �Է°��Դϴ�.");
		}
		return index;
	}

	public static void checkTransportNo(String id)
			throws NumberFormatException, IOException {
		System.out.print("��ȸ�� ����� ��ȣ �Է� : ");
		String no = reader.readLine();
		if (Controller.transportNo(no, id))
			transportNoForm(id, no);
	}

	public static void changeStateForm() throws NumberFormatException,
			IOException {
		System.out.print("���¸� ������ ����� ��ȣ �Է� [ex)no] : ");
		String no = reader.readLine();
		System.out.print("���¸� �Է� [ex)1:��� �غ���, 2:�����, 3: ��ۿϷ�] : ");
		int value = Integer.parseInt(reader.readLine());
		Controller.changeState(no, value);
	}

	public static void transportInsertForm(String id) throws IOException {
		//
		// System.out.println("����� �ù� ��ȣ �Է� [ex)no] : ");
		// String no = reader.readLine();
		// if (Data.checkTransport(no)) {
		// // throw new DuplicateException(no);
		// System.out.println("�����ϴ� �ù蹰�Դϴ�.");
		// } else {
		// String transportInfo = no;
		// System.out
		// .print("�ù� ������ �Է� [ex)1:������ ���, 2:������ �ּ�, 3: �޴»��, 4:������ ��ȣ, 5:�޴� �ּ�, 6:�޴� ��ȣ, 7: state, 8:��¥");
		// transportInfo = transportInfo + "," + reader.readLine();
		//
		// Controller.insertBoard(no, transportInfo.trim());
		// }
		System.out.print("���� ����� ���̵� �Է��ϼ��� >�� < : ");
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
