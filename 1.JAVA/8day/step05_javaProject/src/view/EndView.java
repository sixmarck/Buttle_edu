package view;

import java.util.Iterator;
import java.util.Map;

import model.dto.Member;
import model.dto.Transport;
import util.Utils;

public class EndView {
	public static void allTransportList(Map<String, Transport> list) {
		Iterator<String> it = list.keySet().iterator();
		String key = null;
		while (it.hasNext()) {
			key = it.next();
			System.out.println(list.get(key));
		}
	}

	public static void allMemberList(Map<String, Member> list) {
		Iterator<String> it = list.keySet().iterator();
		String key = null;
		while (it.hasNext()) {
			key = it.next();
			System.out.println(list.get(key));
		}
	}

	public static void errMsg(String s) {
		System.out.println(s);
	}

	public static void changeState(boolean changeState, String no) {
		if (changeState) {
			System.out.println("����� ��ȣ" + no + " ����Ǿ����ϴ�.");
		} else {
			System.out.println(no + " �ش� ����� ��ȣ�� ���ų� ����� �Ϸ�� �����Դϴ�.");
		}

	}

	public static boolean transportNoList(String no, String id,
			Map<String, Transport> list) {
		Iterator<String> it = list.keySet().iterator();
		String key = null;
		boolean check = false;
		while (it.hasNext()) {
			key = it.next();
			if (list.get(key).getNo().equals(no)
					&& list.get(key).getId().equals(id)) {
				check = true;
				System.out.println(list.get(key));
			}
		}
		if (!check) {
			System.out.println("��ȸ�Ͻ� ����� ��ȣ�� �ù谡 �����ϴ�.");
			return check;
		}
		return check;
	}

	public static void userTransportList(String id, Map<String, Transport> list) {
		Iterator<String> it = list.keySet().iterator();
		String key = null;
		boolean flag = false;
		while (it.hasNext()) {
			key = it.next();
			if (list.get(key).getId().equals(id)) {
				System.out.println(list.get(key));
				flag = true;
			} 
		}
		if(!flag) {
			System.out.println("��ϵ� �ù谡 �����ϴ�.");
		}

	}

	public static void transportInsert(Map<String, Transport> list, String no,
			String transportInfo) {

		System.out.println(list);

	}

	public static void transportDelete(Boolean b) {
		if (b) {
			System.out.println("�ش� �ù� ������ �����Ͽ����ϴ�.");
		} else {
			System.out.println("�ش� �ù谡 �������̹Ƿ� �ּҸ� �ٲ� �� �����ϴ�..");
		}
	
	}

	public static void productRegister(String id, String lines, boolean b) {
		if (b)
			System.out.println(id + "����" + lines + "���� �ù踦 ���½��ϴ�.");
		else
			System.out.println("�޴� ����� ���̵� " + lines + " �� �������� �ʽ��ϴ�.");
	}

	public static void RegisterForm(boolean b) {
		if (b) {
			System.out.println("id�� �ߺ��Ǿ����ϴ�.");
		} else {
			System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�.");
		}
	}
}
