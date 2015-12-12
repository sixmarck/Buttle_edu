package account.model;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import account.model.domain.AccountDTO;
import account.util.DBUtil;

public class AccountDAO {

	public static List selectAllAccounts() throws SQLException {
		SqlSession session = DBUtil.getSqlSession();
		List selectAll = null;
		try {
			selectAll = session.selectList("selectAllAccounts");
		} finally {
			session.close();
		}
		return selectAll;
	}

	public static AccountDTO selectAccountById(int id) throws SQLException {
		SqlSession session = DBUtil.getSqlSession();
		AccountDTO account = null;
		try {
			account = (AccountDTO)session.selectOne("selectAccountById", new Integer(id));
		} finally {
			session.close();
		}
		return account;
	}

	/*  point
	 * 1. getSqlSession() - session의 commit() and rollback() 호출 필수
	 * 2. getSqlSession(true) - "					호출 불필요 */
	 public static void insertAccount (AccountDTO account) throws SQLException {
		 SqlSession session = DBUtil.getSqlSession(true);
		// SqlSession session = OracleConfig.getSqlSession();
		 try{
			 session.insert("insertAccount", account);			 
		 } finally{
			session.close();
			//OracleConfig.closeSqlSession(true, session);
		 }
	 }
	 
	
	 public static void updateAccount (int id, String email) throws SQLException {
		 SqlSession session = DBUtil.getSqlSession(true);
		 try{
			 AccountDTO account = (AccountDTO)session.selectOne("selectAccountById", new Integer(id));
			 account.setEmailAddress(email);
			 session.update("updateAccount", account);
		 }finally{
			 session.close();
		 }
	 }
	 
	
	 public static void deleteAccount (int id) throws SQLException {
		 SqlSession session = DBUtil.getSqlSession(true);
		 try{
			 session.delete("deleteAccountById", new Integer(id)); 
		 }finally{
			 session.close();
		 }
	 }
	
}
