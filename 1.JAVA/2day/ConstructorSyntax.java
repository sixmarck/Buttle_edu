/*
	1.java/ConstructorSyntax.java
	�н�����
	1. ������ ���� �� ȣ�� ����
	  1) ���� ����
	    Ŭ������([..]){[..]}
	  2) ȣ�� ����
	    Ŭ������();

	2. �������� �پ��� ���� ���
	
	3. ������ �뵵
	  1) ��ü ����
	  2) ��ü ���� & ��� ������ �ʱ�ȭ

	4. ������ ��������(overloading)
	  - �ϳ��� class���ο� parameter�� ���� �ٸ� �ټ��� ������ ���� ����

	5. ���� ���� ��ġ�� ���� ����
	  1) ��� ���� = member
	    - �����Ǵ� ���� : heap

	  2) ���� ����  = local = stack = automatic = temporary �̶��  ��
	    - �����Ǵ� ���� : stack

	6. �뵵�� ���� ���� ����
	  1) ��� ���� - ��ü�� ���� ��� ������
	  2) ���� ���� - ��ü�� �����ϴ� ����, �����ϴ� �����ʹ� ��ü�� ��ġ��

	* ��� ����
	������ = Constructor
	�������� = overloading
*/

class ConstructorSyntax {
	String msg;
	ConstructorSyntax(){  // �⺻ ������
		System.out.println("�⺻ ������");
	} 

	// ��ü ������ ��� ������ �ʱ�ȭ(������) �뵵�� �ַ� ���
	ConstructorSyntax(String msg) {
		this.msg = msg;
		System.out.println(msg);
	}

	public static void main(String[] args) {
		ConstructorSyntax cs = new ConstructorSyntax();
		ConstructorSyntax cs2 = new ConstructorSyntax("data");
	}

}

/* ����
	1. ������� msg�� �޸𸮿� ���� �����Ǵ� ����?
	  - ��ü ���� ����
	2. �������� parameter�� String msg��� ������ �޸𸮿� ���� �����Ǵ� ����?
	  - �� ������ ������ �����ڰ� ȣ��Ǿ� ���� �ɶ�
	3. ��� ���� ��� ����
	  - ��ü �����Ǿ� ��ü�� �޸𸮿� �Ҹ�(����)�ɶ�����
	4. �������� parameter�� String msg ���� ��� ����
	  - �����ڰ� ȣ��Ǿ� ����ɶ� �ڵ� �����ǰ� �������� {} ���� ����� �ڵ� �Ҹ�
*/