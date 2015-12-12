package view;

import model.domain.Dept01DTO;
import controller.Dept01Controller;

public class StartView {

	public static void main(String[] args) {
		// ��� �μ� ���� �˻�
		System.out.println("--- ��� �μ� ���� �˻� ---");
		Dept01Controller.getAllDept();
		
		System.out.println("\n--- ���ο� �μ� ���� ��� ---");
		Dept01Controller.insertDept(new Dept01DTO(50, "������", "����"));
		
		System.out.println("\n--- ����� ���μ� ���� �˻� ---");
		Dept01Controller.getAllDept();
		
		System.out.println("\n--- 50�� �μ� ���� ���� ---");
		Dept01Controller.updateDept(50, "����");
		
		System.out.println("\n--- ������ ���μ� ���� �˻� ---");
		Dept01Controller.getAllDept();
		
		System.out.println("\n--- 50�� �μ� ���� ���� ---");
		Dept01Controller.deleteDept(50);
		
		System.out.println("\n--- ������ ���μ� ���� �˻� ---");
		Dept01Controller.getAllDept();
		
		System.out.println("\n--- Ư�� �μ����� �˻� ---");
		Dept01Controller.getDept(10);
		
		System.out.println("\n--- �����ȣ ���� �μ� ���� �˻� ---");
		Dept01Controller.getDeptEmp(7369);
	}

}
