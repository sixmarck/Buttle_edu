package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.domain.Member01DTO;
import util.DBUtil;

public class Member01DAO {
	private static Member01DAO instance = new Member01DAO();
	
	public static Member01DAO getInstance() {
		return instance;
	}
	
	private Member01DAO() {}
	
	public List<Member01DTO> allMember() throws SQLException {
		List<Member01DTO> list = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			con = DBUtil.getConnection();
			stmt = con.createStatement();
			
			rs = stmt.executeQuery("select * from member01");
			list = new ArrayList<Member01DTO>();
			
			while(rs.next()) {
				list.add(new Member01DTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4)));
			}
			
		} finally {
			DBUtil.close(con, stmt, rs);
		}
		
		return list;
	}

	public int registerMember(Member01DTO m) throws SQLException {
		int result = 0;
		Connection con = null;
		Statement stmt = null;
		
		try{
			con = DBUtil.getConnection();
			stmt = con.createStatement();
			String sql = "insert into Member01 values('" + m.getId() + "','" 
					+ m.getPw() + "','" + m.getName() + "',"+ m.getMemDate() +")";
			System.out.println(sql);
			result = stmt.executeUpdate(sql);
		} finally {
			DBUtil.close(con, stmt);
		}
		
		return result; 
	}
	
	public int updateMember(Member01DTO m) throws SQLException {
		int result = 0;
		Connection con = null;
		Statement stmt = null;
		
		try{
			con = DBUtil.getConnection();
			stmt = con.createStatement();
			
			result = stmt.executeUpdate("update Member01 set pw = '" + m.getPw() + "', name = '" 
														+ m.getName() + "' where id = '" + m.getId() + "'");
		} finally {
			DBUtil.close(con, stmt);
		}
		
		return result; 
	}
	
	public int deleteMember(String id) throws SQLException {
		int result = 0;
		Connection con = null;
		Statement stmt = null;
		
		try{
			con = DBUtil.getConnection();
			stmt = con.createStatement();
			
			result = stmt.executeUpdate("delete from Member01 where id = '" + id + "'");
		} finally {
			DBUtil.close(con, stmt);
		}
		
		return result; 
	}

}
