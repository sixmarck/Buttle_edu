package model.service;

import java.sql.SQLException;

import model.dao.MemberDAO;
import model.dto.MemberDTO;
import model.dto.SessionDTO;

public class MemberServiceImpl implements MemberServiceIF {
	private static MemberServiceImpl instance = new MemberServiceImpl();
	private static MemberDAO dao = MemberDAO.getInstance();
	public static MemberServiceImpl getInstance(){
		return instance;
	}
	
	@Override
	public boolean registerMember(MemberDTO m) throws SQLException {
		return dao.insertMember(m);
	}

	@Override
	public SessionDTO memberLogin(String memID, String memPW) throws SQLException {
		return dao.memberLogin(memID, memPW);
	}

	public boolean insertMember(MemberDTO m) throws SQLException {
		return dao.insertMember(m);
	}

	public int getMileage(String memID) throws SQLException {
		return dao.getMileage(memID);
	}
}