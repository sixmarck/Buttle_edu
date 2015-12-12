package model;

import java.sql.SQLException;

import model.domain.JoinPerson;

import org.apache.ibatis.session.SqlSession;

import util.DBUtil;

public class JoinTest {

	public static JoinPerson selectAccountById  (String id) throws SQLException {		
		SqlSession session = DBUtil.getSqlSession();
		JoinPerson person = null;
		try {
			person = session.selectOne("people.getJoinTestAll", id);
		}finally {
			session.close();
		}
		return person;
	}
	
	public static void main(String [] a){
		try {
			System.out.println(selectAccountById("javaman"));
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}

}



