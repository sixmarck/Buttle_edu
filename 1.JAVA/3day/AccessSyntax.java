/*
	//1.java/1.basic/AccessSyntax.java
	�н�����
	1. '.' ��� �����ڷ� ����, �޼ҵ� ȣ���ϴ� ���� �ͼ�������
	2. API Ȱ�� �ͼ�������

*/

class B {
	int noB = 100;
	String msgB = "B���� �����ϴ� ����";
}

class A {
	int no = 10;
	B b = new B();
	String msg = "A���� �����ϴ� ����";
}

public class AccessSyntax {
	A a = new A();

	//? m1�̶�� �޼ҵ� ���� : A�� msg��� ������ ��ȯ ����
	public String m1() {
		return a.msg;
	}

	//? m2 : B�� msgB ������ ��ȯ
	public String m2() {
		return a.b.msgB;
	}

	public static void main(String[]  args) {
		// ? ��� ������ �����ϴ� A��ü�� no�� ����غ���
		//System.out.println(a.no);
		AccessSyntax as = new AccessSyntax();
		System.out.println(as.a.no);
		// ? ���̻��� ��ü �������� B�� noB�� ����ϱ�
		System.out.println(as.a.b.noB);
		//? m1 �޼ҵ� ȣ���ϱ�
		System.out.println(as.m1());
		//? m2 �޼ҵ� ȣ���ϱ�
		System.out.println(as.m2());
		//? m2 �޼ҵ忡�� ��ȯ�� ������� ���ڿ� ���� ����ϱ�
		System.out.println(as.m2().length());
		System.out.println(Integer.toString(as.m2().length()).charAt(1));
		
	}
} 