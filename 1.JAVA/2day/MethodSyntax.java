/*
	1.java/MethodSyntax.java
	�н�����
	1. method ���߹���
	  - ��ȯŸ�� �޼ҵ� ( [..] ){ [..] }
	  - ��ȯŸ���� �뵵
	    : �޼ҵ� ������ ��û�� ������ �������ִ� ��ȯ �����Ͱ� ������ ��� �ʼ�
		  ��ȯ�Ǵ� ������ Ÿ�Կ� �°� ����
	  - ��ȯ Ÿ�� = return Ÿ��
	  - * ��ȯ���� ���� �޼ҵ��� ��� : void

	2. method ȣ�� ����
      - 1�ܰ� : ����ϰ��� �ϴ� �޼ҵ带 ������ ��ü ����
	  - 2�ܰ� : ��ü�� �����ϴ� ���������� �޼ҵ� ȣ��
	    ����������.�޼ҵ�( [..] );
	��� ����
	 - () �� ǥ�� : parameter = argument = �Ű����� = �Ű����� = ���� = �μ�
*/

class MethodSyntax {
	int no1 = 10;
	int no2 = 20;

	// ��� �����鰪 + (���ϱ�) �� ����� ��ȯ
	int m1(){
		return no1 + no2;
	}
	// no1 �������� �޼ҵ� ȣ��� �����ϴ� �� *(���ϱ�) �ؼ� ��ȯ
	int m2(int i) {
		return no1 * i;
	}

	// no2 �� �ܼ� ���
	void m3() {
		System.out.println(no2);
	}

	// ? client�� �ΰ��� ���� ������ �����ϸ鼭 * ������ ��û �ϴ� ����
	/* ������ ����
		 - �ΰ��� ������ �޾߾���
		 - ���� ����
		 - ���� ������� ȣ���� ������ ��ȯ
	*/
	int m4(int no1, int no2) {
		return no1 * no2;
	}

	public static void main(String[] args) {
		MethodSyntax m = new MethodSyntax();
		
		m.m3();
		System.out.println(m.m1());
		int i = m.m2(11);
		System.out.println(i);
		int j = m.m4(11, 20);
		System.out.println(j);
	}
}