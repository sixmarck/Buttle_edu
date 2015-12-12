/*
	4.OOP/ChildPolymorphism.java
	�н�����
	1. ��ӱ���� ������ �н��ϱ�
	2. �̹� �����ϴ� Parent Ŭ������ ��ӹ޴� Ŭ����
	3. ����ȯ
	  1) ������� ����ȯ
	    (1) �⺻Ÿ�� : ���� �������� ������ ū�������� ������ ���Խ�
		    int i = 10;
			byte b = (byte) i;
	    (2) ����Ÿ�� : ������ �������� �ڽ�Ÿ���� ������ �θ�Ÿ���� ������ ���Խ�
		  �θ�Ÿ�� ���� = new �ڽĻ�����();
		  �ڽ�Ÿ�� ���� = (�ڽ�Ÿ��)�θ�Ÿ�Ժ���;
	  2) �ڵ� ����ȯ
	    1. �⺻Ÿ��
		  byte b = 3;
		  int i = b;
		2. ����Ÿ��
		  �θ�Ÿ�� ���� = �ڽİ�ü;
*/

public class ChildPolymorphism extends Parent {
	public String job;
	
	void printAll() {		// �޼ҵ� ������ 
		super.printAll();
		System.out.println(job);
	}

	public static void main(String[] args) {
		Parent p = new ChildPolymorphism(); // ������ ��ü ����, �θ�Ÿ������ �ڽİ�ü ����
		p.printAll();
		/*	

		*/
		p.name = "�����";
		/* �������� ����� �θ�Ÿ���� �����δ� �ڽĸ��� �������, �޼ҵ� ȣ�� �Ұ�
		�ذ�å - ��ü���� ����ȯ(������� ����ȯ)
		�ڽ�Ÿ�� ���� = (�ڽ�Ÿ��)�θ�Ÿ�Ժ���;

		*/
		//p.job = "IT��";
		ChildPolymorphism c = (ChildPolymorphism)p;
		c.job = "IT��";
		p.printAll();

		//�������� ����� �迭
		Parent[] p2 = new Parent[3];
		p2[0] = new Parent();
		p2[1] = new Child();
		p2[2] = new ChildPolymorphism();
	}
}