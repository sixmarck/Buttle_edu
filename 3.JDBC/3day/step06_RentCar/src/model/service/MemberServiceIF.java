package model.service;

import java.sql.SQLException;

import model.dto.MemberDTO;
import model.dto.SessionDTO;

public interface MemberServiceIF {
	public boolean registerMember (MemberDTO m) throws SQLException;
	public SessionDTO memberLogin (String memID, String memPW) throws SQLException;
	public int getMileage(String memID) throws SQLException;
}