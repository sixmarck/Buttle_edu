package view;

import model.domain.Dept01DTO;
import controller.Dept01Controller;

public class StartView {

	public static void main(String[] args) {
		// 모든 부서 정보 검색
		System.out.println("--- 모든 부서 정보 검색 ---");
		Dept01Controller.getAllDept();
		
		System.out.println("\n--- 새로운 부서 정보 등록 ---");
		Dept01Controller.insertDept(new Dept01DTO(50, "교육부", "구로"));
		
		System.out.println("\n--- 등록후 모든부서 정보 검색 ---");
		Dept01Controller.getAllDept();
		
		System.out.println("\n--- 50번 부서 정보 수정 ---");
		Dept01Controller.updateDept(50, "서울");
		
		System.out.println("\n--- 수정후 모든부서 정보 검색 ---");
		Dept01Controller.getAllDept();
		
		System.out.println("\n--- 50번 부서 정보 삭제 ---");
		Dept01Controller.deleteDept(50);
		
		System.out.println("\n--- 삭제후 모든부서 정보 검색 ---");
		Dept01Controller.getAllDept();
		
		System.out.println("\n--- 특정 부서정보 검색 ---");
		Dept01Controller.getDept(10);
		
		System.out.println("\n--- 사원번호 관련 부서 정보 검색 ---");
		Dept01Controller.getDeptEmp(7369);
	}

}
