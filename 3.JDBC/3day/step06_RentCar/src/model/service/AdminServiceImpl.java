package model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import model.dao.AdminDAO;
import model.dto.AgentByResDTO;
import model.dto.AgentBySalseDTO;
import model.dto.MemberDTO;
import model.dto.MemberUpdateGradeDTO;
import model.dto.ReturnCarDTO;

public class AdminServiceImpl implements AdminServiceIF {
	private static AdminServiceImpl instance = new AdminServiceImpl();
	private static AdminDAO dao = AdminDAO.getInstance();
	public static AdminServiceImpl getInstance(){
		return instance;
	}
	private AdminServiceImpl(){}
	
	@Override
	public ArrayList<AgentBySalseDTO> agentByOneSalsesList(int agtNo) throws SQLException {
		return dao.agentByOneSalsesList(agtNo);
	}

	@Override
	public ArrayList<AgentBySalseDTO> allAgentBySalseList() throws SQLException {
		return dao.allAgentBySalseList();
	}

	@Override
	public ArrayList<MemberDTO> allMemberList() throws SQLException {
		return dao.allMemberList();
	}

	@Override
	public ArrayList<MemberDTO> allGradeMemberList(String grade) throws SQLException {
		return dao.allGradeMemberList(grade);
	}

	@Override
	public ArrayList<MemberUpdateGradeDTO> adminGradeSelectMember() throws SQLException {
		return dao.adminGradeSelectMember();
	}

	@Override
	public ArrayList<AgentByResDTO> agentReservationList(int agtNo) throws SQLException {
		return dao.agentReservationList(agtNo);
	}

	@Override
	public boolean adminGradeUpdateMember(ArrayList<MemberUpdateGradeDTO> list) throws SQLException {
		return dao.adminGradeUpdateMember(list);
	}
	
	@Override
	public ArrayList<ReturnCarDTO> returnCar(int agtNo) throws SQLException {
		return dao.returnCar(agtNo);
	}

	@Override
	public boolean updateStateCar(int resNo) throws SQLException {
		return dao.updateStateCar(resNo);
	}
	
	@Override
	public ReturnCarDTO returnCar(String memID) throws SQLException {
		return dao.returnCar(memID);
	}

	@Override
	public ArrayList<AgentByResDTO> allReservationList() throws SQLException {
		return dao.allReservationList();
	}
}