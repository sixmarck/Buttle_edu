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
			System.out.println("운송장 번호" + no + " 변경되었습니다.");
		} else {
			System.out.println(no + " 해당 운송장 번호가 없거나 배송이 완료된 상태입니다.");
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
			System.out.println("조회하신 운송장 번호의 택배가 없습니다.");
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
			System.out.println("등록된 택배가 없습니다.");
		}

	}

	public static void transportInsert(Map<String, Transport> list, String no,
			String transportInfo) {

		System.out.println(list);

	}

	public static void transportDelete(Boolean b) {
		if (b) {
			System.out.println("해당 택배 정보를 삭제하였습니다.");
		} else {
			System.out.println("해당 택배가 전송중이므로 주소를 바꿀 수 없습니다..");
		}
	
	}

	public static void productRegister(String id, String lines, boolean b) {
		if (b)
			System.out.println(id + "님이" + lines + "에게 택배를 보냈습니다.");
		else
			System.out.println("받는 사람의 아이디 " + lines + " 가 존재하지 않습니다.");
	}

	public static void RegisterForm(boolean b) {
		if (b) {
			System.out.println("id가 중복되었습니다.");
		} else {
			System.out.println("회원가입이 완료되었습니다.");
		}
	}
}
