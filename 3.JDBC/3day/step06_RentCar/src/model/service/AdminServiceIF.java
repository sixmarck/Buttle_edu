package model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.AgentByResDTO;
import model.dto.AgentBySalseDTO;
import model.dto.MemberDTO;
import model.dto.MemberUpdateGradeDTO;
import model.dto.ReturnCarDTO;

public interface AdminServiceIF {
	public ArrayList<AgentBySalseDTO> agentByOneSalsesList(int agtNo) throws SQLException;
	public ArrayList<AgentBySalseDTO> allAgentBySalseList() throws SQLException;
	public ArrayList<AgentByResDTO> agentReservationList(int agtNo) throws SQLException;
	public ArrayList<MemberDTO> allMemberList() throws SQLException;
	public ArrayList<MemberDTO> allGradeMemberList(String grade) throws SQLException;
	public ArrayList<MemberUpdateGradeDTO> adminGradeSelectMember() throws SQLException;
	public boolean updateStateCar(int resNo) throws SQLException;
	public boolean adminGradeUpdateMember(ArrayList<MemberUpdateGradeDTO> list) throws SQLException;
	public ArrayList<ReturnCarDTO> returnCar(int agtNo) throws SQLException;
	public ReturnCarDTO returnCar(String memID) throws SQLException;
	public ArrayList<AgentByResDTO> allReservationList() throws SQLException;
}