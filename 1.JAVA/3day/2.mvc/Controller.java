/*
	2.mvc/Controller.java
*/

public class Controller {
	//step2 : client�� 1�Է��ϸ� ����� �����Ͱ� ���, 2 �Է��ϸ� �ǹ��� �����Ͱ� ���
	// ����üũ Ŭ������ Controller, ��û ���� class�� StartView.java, ��� ��� EndView.java
	/* 1 �Ǵ� 2�� �ش��ϴ� ���� - ���ǽ�, if��
	*/

	public static void request(int value) {
		Employee[] emps = Data.getEmps();
		if(value==1) {			
			EndView.print((Data.getEmps())[0]);
		} else if(value==2) {
			EndView.print((Data.getEmps())[1]);
		}else {
			System.out.println("��û ����");
		}
	}
}

/* step1
	static void empInfoPrint(Employee[] all) {
		// ? for + length + �� ������ �̸��鸸 ���
		for (int i = 0; i<all.length ; i++){
			System.out.println(all[i].getName());
		}
	}

	public static void main(String[] args) {
		Employee[] all = Data.getEmps();
		empInfoPrint(all);
		
	}
}*/