package model;

import java.util.List;

import model.domain.DeptVO;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import util.DBUtil;

public class DeptDAO {
	public static DeptVO getDept(int deptno) {
		SqlSession session = DBUtil.getSqlSession();
		DeptVO dept = null;
		try{
			dept = (DeptVO)session.selectOne("selectDeptOne", deptno);
		} finally {
			session.close();
		}
		return dept;
	}
	
	public static List<DeptVO> getDeptAll() {
		SqlSession session = DBUtil.getSqlSession();
		List<DeptVO> list = null;
		try{
			list = session.selectList("selectDeptAll");
		} finally {
			session.close();
		}
		return list;
	}
	
	public static int insertDept(DeptVO dept) throws PersistenceException {
		SqlSession session = DBUtil.getSqlSession(true);
		int result = 0;
		try{
			result = session.insert("insertDept", dept);
		} finally {
			session.close();
		}
		return result;
	}
	
	public static int updateDept(DeptVO dept) throws PersistenceException {
		SqlSession session = DBUtil.getSqlSession(true);
		int result = 0;
		try{
			result = session.insert("updateDept", dept);
		} finally {
			session.close();
		}
		return result;
	}
	
	public static int deleteDept(int deptno) throws PersistenceException {
		SqlSession session = DBUtil.getSqlSession(true);
		int result = 0;
		try{
			result = session.insert("deleteDept", deptno);
		} finally {
			session.close();
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(getDept(10));
		System.out.println(DeptDAO.getDeptAll());
		try {
			System.out.println(DeptDAO.insertDept(new DeptVO(12, "kk", "kk")));
		} catch (Exception e) {
			System.out.println("아이디 중복되었거나 잘못 입력 하셨습니다.");
		}
		System.out.println(DeptDAO.getDeptAll());
		System.out.println(DeptDAO.updateDept(new DeptVO(15, "구로"))!=0?"수정성공":"수정실패");
		System.out.println(DeptDAO.deleteDept(15)!=0 ? "삭제성공" : "삭제실패");
		System.out.println(DeptDAO.getDeptAll());
	}
}
