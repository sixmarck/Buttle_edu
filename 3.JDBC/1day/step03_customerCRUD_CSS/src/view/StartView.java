package view;

import java.text.SimpleDateFormat;
import java.util.Date;

import model.domain.Member01DTO;
import controller.Controller;

public class StartView {
	private static Date date = new Date();
	private static SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	public static void main(String[] args) {
		System.out.println("--- ��� ȸ�� ���� �˻� ---");
		Controller.allMember();
		System.out.println("\n--- ȸ������ ---");
		System.out.println(date);
		Controller.registerMember(new Member01DTO("ddd", "ddd", "������",  date));
		System.out.println("\n--- ��� ȸ�� ���� �˻� ---");
		Controller.allMember();
		System.out.println("\n--- ȸ������ ---");
		Controller.registerMember(new Member01DTO("aaa", "ddd", "������",  date));
		System.out.println("\n--- ��� ȸ�� ���� �˻� ---");
		Controller.allMember();
		System.out.println("\n--- ȸ���������� ---");
		Controller.updateMember(new Member01DTO("aaa", "ddd", "������",  date));
		System.out.println("\n--- ��� ȸ�� ���� �˻� ---");
		Controller.allMember();
		System.out.println("\n--- ȸ���������� ---");
		Controller.deleteMember("ddd");
		System.out.println("\n--- ��� ȸ�� ���� �˻� ---");
		Controller.allMember();

	}
}
