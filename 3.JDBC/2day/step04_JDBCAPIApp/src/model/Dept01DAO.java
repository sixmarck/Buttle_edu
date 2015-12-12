package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.domain.Dept01DTO;
import util.DBUtil;

public class Dept01DAO {
	public static String dept01One(int deptno) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String dname = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select dname from dept01 where deptno=?");
			pstmt.setInt(1, deptno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dname = rs.getString("dname");
			}
			
		} finally {
			DBUtil.close(con, pstmt, rs);
		}
		return dname;
	}
	
	public static Dept01DTO getDeptEmp(int empno) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Dept01DTO dept01 = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from dept01 where deptno = (select deptno from emp where empno = ?)");
			pstmt.setInt(1, empno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dept01 = new Dept01DTO(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			
		} finally {
			DBUtil.close(con, pstmt, rs);
		}
		return dept01;
	}
	
	public static List<Dept01DTO> dept01All() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Dept01DTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from dept01");
			
			rs = pstmt.executeQuery();
			list = new ArrayList<Dept01DTO>();
			
			while(rs.next()){
				list.add(new Dept01DTO(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc")));
			}
			
		} finally {
			DBUtil.close(con, pstmt, rs);
		}
		return list;
	}
	
	public static boolean insertDept01(Dept01DTO dept) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into dept01 values(?,?,?)");
			pstmt.setInt(1, dept.getDeptno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());
			
			int i = pstmt.executeUpdate();
			if(i == 1) {
				result = true;
			}
			
		} finally {
			DBUtil.close(con, pstmt);
		}
		
		return result;
	}
	
	public static void updateDept01(int deptno, String newLoc) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("update dept01 set loc=? where deptno=?");
			pstmt.setString(1, newLoc);
			pstmt.setInt(2, deptno);
			
			pstmt.executeUpdate();
			
		} finally {
			DBUtil.close(con, pstmt);
		}
	}
	
	public static int deleteDept01(int deptno) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		int value = 0;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from dept01 where deptno = ?");
			pstmt.setInt(1, deptno);
			value = pstmt.executeUpdate();
			
		} finally {
			DBUtil.close(con, pstmt);
		}
		
		return value;
	}
}
/*
1. select * from dept;
	- HashMap<Integer, Dept01DTO> dept01All(){..}
	- ArrayList<Dept01DTO> dept01All(){..}
	- Dept01DTO[] dept01All(){} 
2. insert into dept01 values( , , )
	- int insertDept01(Dept01DTO dept){}
	- boolean insertDept01(Dept01DTO dept){}
	- void insertDept01(Dept01DTO dept) throws~Exception{}
3. delete from dept01 where deptno = ?
4. update dept01 set loc=? where deptno=?
5. select dname from dept01 where deptno=?
6. 해당 사원의 사원번호로 어떤 부서에 근무하는지에 대한 부서정보
	- select * from dept01
		where deptno = (select deptno from emp where empno=?)

*/