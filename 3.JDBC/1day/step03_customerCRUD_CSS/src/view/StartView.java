package view;

import java.text.SimpleDateFormat;
import java.util.Date;

import model.domain.Member01DTO;
import controller.Controller;

public class StartView {
	private static Date date = new Date();
	private static SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	public static void main(String[] args) {
		System.out.println("--- 모든 회원 정보 검색 ---");
		Controller.allMember();
		System.out.println("\n--- 회원가입 ---");
		System.out.println(date);
		Controller.registerMember(new Member01DTO("ddd", "ddd", "디지몬",  date));
		System.out.println("\n--- 모든 회원 정보 검색 ---");
		Controller.allMember();
		System.out.println("\n--- 회원가입 ---");
		Controller.registerMember(new Member01DTO("aaa", "ddd", "디지몬",  date));
		System.out.println("\n--- 모든 회원 정보 검색 ---");
		Controller.allMember();
		System.out.println("\n--- 회원정보수정 ---");
		Controller.updateMember(new Member01DTO("aaa", "ddd", "디지몬",  date));
		System.out.println("\n--- 모든 회원 정보 검색 ---");
		Controller.allMember();
		System.out.println("\n--- 회원정보삭제 ---");
		Controller.deleteMember("ddd");
		System.out.println("\n--- 모든 회원 정보 검색 ---");
		Controller.allMember();

	}
}
