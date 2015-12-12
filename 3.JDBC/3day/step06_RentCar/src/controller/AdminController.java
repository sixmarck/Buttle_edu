package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.AgentByResDTO;
import model.dto.AgentBySalseDTO;
import model.dto.MemberUpdateGradeDTO;
import model.dto.ReturnCarDTO;
import model.service.AdminServiceImpl;
import view.EndView;

public class AdminController {
	private static AdminServiceImpl service = AdminServiceImpl.getInstance();
	
	public static void allAgentBySalseList() {
		try {
			ArrayList<AgentBySalseDTO> list = service.allAgentBySalseList();
			if(list.size() != 0) {
				EndView.agentBySalseList(list);
			} else {
				EndView.msg("");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void agentByOneSalsesList(int agtNo) {
		try {
			ArrayList<AgentBySalseDTO> list = service.agentByOneSalsesList(agtNo);
			if(list.size() != 0) {
				EndView.agentBySalseList(list);
			} else {
				EndView.msg("");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void agentReservationList(int agtNo) {
		try {
			ArrayList<AgentByResDTO> list = service.agentReservationList(agtNo);
			if(list.size() != 0) {
				EndView.agentReservationList(list);
			} else {
				EndView.msg("�ش� �븮���� ���� ������ �����ϴ�.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void allMemberList() {
		try {
			if (service.allMemberList().size() != 0) {
				EndView.successMsgAll(service.allMemberList());
			} else {
				EndView.msg("��� ȸ�� ������ �����ϴ�.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.errorMsg("��� ȸ�� ���� �˻� ����, ��õ� �ϼ���");
		}
	}
	
	public static void allGradeMemberList(String grade) {
		try {
			if (service.allGradeMemberList(grade).size() != 0) {
				EndView.successMsgAll(service.allGradeMemberList(grade));
			} else {
				EndView.msg("��޺� ȸ�� ������ �����ϴ�.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.errorMsg("��޺� ȸ�� ���� �˻� ����, ��õ� �ϼ���");
		}
	}

	public static ArrayList<MemberUpdateGradeDTO> adminGradeSelectMember() {
		ArrayList<MemberUpdateGradeDTO> list = null;
		
		try {
			list = service.adminGradeSelectMember();
			if (list.size() != 0) {
				EndView.upgradeGradePrint(list);
			} else {
				EndView.errorMsg("��� ����ڰ� �����ϴ�.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public static void adminGradeUpdateMember(ArrayList<MemberUpdateGradeDTO> list) {
		try {
			if(service.adminGradeUpdateMember(list)){
				EndView.msg(list.size() + "���� ����� ������Ʈ �Ǿ����ϴ�."); 
			} else {
				EndView.msg("����� �����Ͽ����ϴ�. �ٽ� ���ּ���.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean returnCar(int agtNo) {
		boolean result = false;
		
		try {
			ArrayList<ReturnCarDTO> list = service.returnCar(agtNo);
			if(list.size() != 0) {
				EndView.returnCarPrint(list);
				result = true;
			} else {
				EndView.msg("�ݳ� ���� ���� ������ �����ϴ�.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public static void updateStateCar(int resNo) {
		try {
			if(service.updateStateCar(resNo)) {
				EndView.msg("�ݳ� �Ϸ� �Ǿ����ϴ�.");
			}else {
				EndView.msg("�ݳ��� ����̾����ϴ�. �ٽ�Ȯ�����ּ���.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void returnCar(String memID) {
		try {
			ReturnCarDTO rc = service.returnCar(memID);
			if(rc!= null) {
				EndView.loginReturnCarPrint(rc);
			}else {
				EndView.msg("������ �ݳ��� ȸ���� �����ϴ�.");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public static void allReservationList() {
		try {
			ArrayList<AgentByResDTO> list =  service.allReservationList();
			if(list.size() != 0) {
				EndView.agentReservationList(list);
			}else {
				EndView.msg("���� ������ �����ϴ�.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}