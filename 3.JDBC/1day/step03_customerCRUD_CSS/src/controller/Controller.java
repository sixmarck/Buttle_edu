package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Member01DAO;
import model.domain.Member01DTO;
import view.EndView;

public class Controller {

	public static void allMember() {
		try {
			List<Member01DTO> list = Member01DAO.getInstance().allMember();
			if(list.size() != 0) {
				EndView.successMemberAll(list);
			} else {
				EndView.msg("ȸ�������� �����ϴ�.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.errorMsg("ȸ������ �˻� ����! ��õ� �ϼ���.");
		}
	}

	public static void registerMember(Member01DTO m) {
		try {
			if(Member01DAO.getInstance().registerMember(m) != 0) {
				EndView.msg("ȸ������ ����");
			} else {
				EndView.msg("�߸� �ԷµǾ����ϴ�. �ٽ� �Է����ּ���.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.errorMsg("ȸ������ ����! ��õ� �ϼ���.");
		}
	}

	public static void updateMember(Member01DTO m) {
		try {
			if(Member01DAO.getInstance().updateMember(m) != 0) {
				EndView.msg("ȸ������ ���� ����");
			} else {
				EndView.msg("�߸� �ԷµǾ����ϴ�. �ٽ� �Է����ּ���.");
			}
		} catch (SQLException e) {
			EndView.errorMsg("ȸ���������� ����! ��õ� �ϼ���.");
		}
	}

	public static void deleteMember(String id) {
		try {
			if(Member01DAO.getInstance().deleteMember(id) != 0) {
				EndView.msg("ȸ��Ż�� ����");
			} else {
				EndView.msg("�߸� �ԷµǾ����ϴ�. �ٽ� �Է����ּ���.");
			}
		} catch (SQLException e) {
			EndView.errorMsg("ȸ��Ż�� ����! ��õ� �ϼ���.");
		}
	}

}
