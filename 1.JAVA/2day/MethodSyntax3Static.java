/*
	1.java/MethodSyntax3Static.java
	�н�����
	1. static Ű���忡 ���� �н� ����
	  - Ŭ���� ���ο� static Ű����� ����� �޼ҵ�� ����
	  - ȣ���� : class��, �޼ҵ��([..]);

	2. �������
	  - ��ü ������ �ʿ伺?
	    : ��� ������ �� �����ϴ� Ŭ�������� ��ü ���� ����� �� �ʿ�
		  * ��ü �������� ������ �ּ�ȭ ��? ���� �ý��� ���� ����
	  - ??? Math Ŭ������ ������ ���� ������?
	    - ���� �� Math Ŭ���� ���ο����� ��� ������ �����ڷ� ����
		  ��� - ���б�� ����(private Ű���尡 �ٽ�)

	* static Ű���� �� �н� ���Ŀ�...
*/

class MethodSyntax3Static {
	void m(){
		System.out.println(1);
	}
	static void m2(){
		System.out.println(2);
	}

	public static void main(String[] args) {
		MethodSyntax3Static m = new MethodSyntax3Static();
		m.m();
		m.m2();
		MethodSyntax3Static.m2();

		// 0.0 ~ 1.0 ���������� �Ǽ�(double) ���� ����� ���� ���������� ���
		// ���� = random [ double random(){} ]

	}
}