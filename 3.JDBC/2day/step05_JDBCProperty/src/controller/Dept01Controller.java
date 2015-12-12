package controller;

import java.sql.SQLException;
import java.util.List;

import view.EndView;
import model.Dept01DAO;
import model.domain.Dept01DTO;

public class Dept01Controller {

	public static void getAllDept() {
		try {
			List<Dept01DTO> dept = Dept01DAO.dept01All();
			if(dept.size() == 0) {
				EndView.msg("�ش� ȸ���� �� �μ� ������ �����ϴ�.");
			} else {
				EndView.successMsgAll(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.errorMsg("��� �μ� ���� �˻� ����, ��õ��ϼ���.");
		}
	}
	
	public static void insertDept(Dept01DTO dept) {
		try {
			if(Dept01DAO.insertDept01(dept)) {
				EndView.msg("�μ� ���� ��� ����");
			} else {
				EndView.msg("�Է��� �ȵǾ����ϴ�. ���� �Է����ּ���.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.errorMsg("�ߺ��� deptno���� ������ �߻�, �ٽ� ���ο� �����ͷ� �Է½õ� �ϼſ�.");
		}
	}
	
	public static void updateDept(int deptno, String newLoc) {
		try {
			Dept01DAO.updateDept01(deptno, newLoc);
			EndView.msg("�μ� ���� ���� ����");
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.errorMsg("�ش� �μ���ȣ �������� ���� ���� ��õ� �ϼſ�");
		}
	}

	public static void deleteDept(int deptno) {
		try {
			if(Dept01DAO.deleteDept01(deptno) == 1) {
				EndView.msg("�μ� ���� ���� ����");
			} else {
				EndView.msg("�ش� �μ��� �����ϴ�.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.errorMsg("�ش� �μ���ȣ �������� ���� ���� ��õ� �ϼſ�");
		}
	}
	
	public static void getDept(int deptno) {
		try {
			String dname = Dept01DAO.dept01One(deptno);
			if(dname != null) {
				EndView.msg(deptno + "�� �μ����� " + dname);
			} else {
				EndView.msg("��û�Ͻ� �μ� ��ȣ�� �ش� ������ �������� �ʽ��ϴ�.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.errorMsg("�μ��� �˻� ���� ��õ� �ϼſ�");
		}
		
	}
	
	public static void getDeptEmp(int empno) {
		try {
			Dept01DTO d = Dept01DAO.getDeptEmp(empno);
			if(d != null) {
				EndView.successMsgOne(d);
			} else {
				EndView.msg("��û�Ͻ� �����ȣ�� �������� �ʽ��ϴ�.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.errorMsg("�����ȣ �˻� ���� ��õ� �ϼſ�");
		}
	}
	
}
