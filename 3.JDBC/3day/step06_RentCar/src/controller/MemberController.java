package controller;

import java.sql.SQLException;

import model.dao.MemberDAO;
import model.dto.MemberDTO;
import model.dto.SessionDTO;
import model.service.MemberServiceImpl;
import view.EndView;
import view.MainView;

public class MemberController {
	private static MemberServiceImpl service = MemberServiceImpl.getInstance();
	
	public static SessionDTO memberLogin(String memID, String memPW) {
		SessionDTO session = null;
		
		try {
			session = service.memberLogin(memID, memPW);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return session;
	}

	public static void insertMember(MemberDTO m) {
		try {
			if (service.insertMember(m)) {
				EndView.msg("ȸ������ ����");
			} else {
				EndView.msg("�Է��� �ȵǾ����ϴ�. ���� �Է����ּ���");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int getMileage(String memID) {
		int money = 0;
		try {
			money = service.getMileage(memID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return money;
	}
}