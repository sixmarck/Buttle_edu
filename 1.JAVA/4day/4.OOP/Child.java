/*
	4.OOP/Child.java
*/

public class Child extends Parent{  //��ӹ���
	String job;

	public Child() {
		System.out.println("�ڽ�");
	}

	public Child(String n, int a, String job) {
		super(n, a); // �θ� Ŭ������ String, int �� parameter�� ������ �ڵ� ȣ��
		this.job = job;
	}

	void printAll() {		// �޼ҵ� ������ 
		super.printAll();
		System.out.println(job);
	}

	//Object�� toString() ������ �����̸��� ��ȯ���� ������
	public String toString() {
		return "���°�";
	}

	public static void main(String[] args) {
		Child c = new Child("������", 25, "IT��");
		c.printAll();
		System.out.println(c.toString());
		String msg = "data";
		System.out.println(msg.toString());
	}
}