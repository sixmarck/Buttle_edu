package controller;

import java.sql.SQLException;
import java.util.List;

import view.EndView;
import model.Dept01DAO;
import model.domain.Dept01DTO;

public class Dept01Controller {

	public static void getAllDept() {
		try {
			List<Dept01DTO> dept = Dept01DAO.dept01All();
			if(dept.size() == 0) {
				EndView.msg("해당 회사의 현 부서 정보가 없습니다.");
			} else {
				EndView.successMsgAll(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.errorMsg("모든 부서 정보 검색 실패, 재시도하세요.");
		}
	}
	
	public static void insertDept(Dept01DTO dept) {
		try {
			if(Dept01DAO.insertDept01(dept)) {
				EndView.msg("부서 정보 등록 성공");
			} else {
				EndView.msg("입력이 안되었습니다. 새로 입력해주세요.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.errorMsg("중복된 deptno등의 문제가 발생, 다시 새로운 데이터로 입력시도 하셔요.");
		}
	}
	
	public static void updateDept(int deptno, String newLoc) {
		try {
			Dept01DAO.updateDept01(deptno, newLoc);
			EndView.msg("부서 정보 수정 성공");
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.errorMsg("해당 부서번호 지역정보 수정 실패 재시도 하셔요");
		}
	}

	public static void deleteDept(int deptno) {
		try {
			if(Dept01DAO.deleteDept01(deptno) == 1) {
				EndView.msg("부서 정보 삭제 성공");
			} else {
				EndView.msg("해당 부서가 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.errorMsg("해당 부서번호 지역정보 삭제 실패 재시도 하셔요");
		}
	}
	
	public static void getDept(int deptno) {
		try {
			String dname = Dept01DAO.dept01One(deptno);
			if(dname != null) {
				EndView.msg(deptno + "의 부서명은 " + dname);
			} else {
				EndView.msg("요청하신 부서 번호의 해당 정보가 존재하지 않습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.errorMsg("부서명 검색 실패 재시도 하셔요");
		}
		
	}
	
	public static void getDeptEmp(int empno) {
		try {
			Dept01DTO d = Dept01DAO.getDeptEmp(empno);
			if(d != null) {
				EndView.successMsgOne(d);
			} else {
				EndView.msg("요청하신 사원번호가 존재하지 않습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.errorMsg("사원번호 검색 실패 재시도 하셔요");
		}
	}
	
}
