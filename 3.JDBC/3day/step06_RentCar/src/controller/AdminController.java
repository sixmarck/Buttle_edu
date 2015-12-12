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
				EndView.msg("해당 대리점에 예약 정보가 없습니다.");
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
				EndView.msg("모든 회원 정보가 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.errorMsg("모든 회원 정보 검색 실패, 재시도 하세요");
		}
	}
	
	public static void allGradeMemberList(String grade) {
		try {
			if (service.allGradeMemberList(grade).size() != 0) {
				EndView.successMsgAll(service.allGradeMemberList(grade));
			} else {
				EndView.msg("등급별 회원 정보가 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.errorMsg("등급별 회원 정보 검색 실패, 재시도 하세요");
		}
	}

	public static ArrayList<MemberUpdateGradeDTO> adminGradeSelectMember() {
		ArrayList<MemberUpdateGradeDTO> list = null;
		
		try {
			list = service.adminGradeSelectMember();
			if (list.size() != 0) {
				EndView.upgradeGradePrint(list);
			} else {
				EndView.errorMsg("등업 대상자가 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public static void adminGradeUpdateMember(ArrayList<MemberUpdateGradeDTO> list) {
		try {
			if(service.adminGradeUpdateMember(list)){
				EndView.msg(list.size() + "명의 등급이 업데이트 되었습니다."); 
			} else {
				EndView.msg("등업을 실패하였습니다. 다시 해주세요.");
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
				EndView.msg("반납 되지 않은 차량이 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public static void updateStateCar(int resNo) {
		try {
			if(service.updateStateCar(resNo)) {
				EndView.msg("반납 완료 되었습니다.");
			}else {
				EndView.msg("반납할 대상이없습니다. 다시확인해주세요.");
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
				EndView.msg("차량을 반납할 회원이 없습니다.");
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
				EndView.msg("예약 정보가 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}