/*
	4.OOP/ChildOverriding.java
	�н�����
	1. ������ review �� ����
*/

public class ChildOverriding extends Object {
	public ChildOverriding() {
		super();
	}

	public String toString() {  // ������
		return "�������н�";
	}

	static Object m() {
		return "�� ���ڿ�";
	}

	public static void main(String[] args) {
		String v = (String)m();
		System.out.print(v);
		//Integer i = (Integer)m(); ������� - �޸𸮿� ������ ��ü Ÿ�����θ� ����ȯ ����
	}

}