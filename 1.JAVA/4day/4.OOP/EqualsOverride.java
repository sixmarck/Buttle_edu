/*
	4.OOP/EqualsOverride.java
	�н�����
	1. java.lang.Object�� equals() ������ �ϱ�
	2. �߰� �н�����
	  - instanceof ������ : ��üŸ�� �� ������
	  - ���ǻ���
	    1) �⺻Ÿ�԰� �� �Ұ� : ������ ����
		2) ����(��ü=class) Ÿ�԰��� �񱳽� ��Ӱ��迡 ���ؼ��� �񱳰���
		  - ���� ������ ������ ���� ��ü Ÿ�� �� �Ұ� : ������ ����

*/

public class EqualsOverride {
	String msg;
	int data;
	/* ? java.lan.Object�� ��ü �ּҰ� �� �޼ҵ带 
		������ ��ü�� ���ؼ��� ��������� ���ؼ� ���� ������ ��츸 true
		��üŸ�Ե� �ٸ��� ��üŸ���� Ȥ �����ϴٰ� �ص� ����������� �ٸ��� false�� ��ȯ�ϴ�
		�޼ҵ� ������ �ϱ�
		
	*/
	EqualsOverride(String msg, int data) {
		this.msg = msg;
		this.data = data;
	}

	/*	���Ư¡
	1. java.lang.Object �ֻ� root
	2. ���� �θ�� �� �ϳ�
	3. ��� ����� ������ ����
	  - ������ : 
	4. ������ �����
	  - �θ�Ÿ�Ժ����� �ڽİ�ü ����
	    ������ �ڽĸ��� ��� ���� ȣ�� �Ұ���
		�ذ�å ��üŸ�԰��� ����ȯ
	5. ��Ӱ��迡�� ��ӵǴ� �������
	  - ����, �޼ҵ�
	  - �����ڴ� �ڽ� ��ü ������ ���������� �θ� ������ �ڵ� ȣ��
	    : super( [..] )
		  �������� ù���ο� ���� ����, ������ �����Ϸ��� �ڵ� ����
	  - ��ӹ޾����� �޼ҵ� ���� ����(������) - override or overriding
	    (tip : ��������(overloading) - ������ class������ �Ȱ��� �̸��� �ټ� �޼ҵ� �����ϴ� ���� rule : parameter�� �ݵ�� �޶����)
	  - �����ǽÿ� �θ� �޼ҵ��� ��� ������ �ѹ������� ���밡��
	    super.�޼ҵ��( [..] );
	6. 

	*/
	public boolean equals(Object o) {
		if(o instanceof EqualsOverride) {
			EqualsOverride eo = (EqualsOverride)o;
			if(this.msg.equals(eo.msg) && this.data == eo.data) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		EqualsOverride e1 = new EqualsOverride("ȣ��", 25);
		EqualsOverride e2 = new EqualsOverride("����", 25);
		System.out.println(e1.equals(e2));  //true

		System.out.println("������");


		System.out.println(3 == 3); //�� ��
		String s = "��";
		String s2 = "��a";
		System.out.println(s==s2); // �ּҰ� ��

		String s3 = new String("��");
		String s4 = new String("��");
		System.out.println(s3==s4); // false �ּҰ� ��
		System.out.println(s3.equals(s4)); // true ��ü�� ���밪 �񱳷� ������ �Ǿ� ����
	}
	/*
	// step1 - instanceof ������ �ǽ�
	public static void main(String[] args) {
		String s = "���ڿ�";
		boolean b = false;
		Integer i = null;


		if(s instanceof String) {
			System.out.println("true");
		}

		if(s instanceof Object) {
			System.out.println("true");
		}
		
		/*
		if(i instanceof String) { // ���� �ڵ� : ���� �������� ��üŸ�� �� �Ұ�, ������ ����
			System.out.println("true");
		}*/

		/*
		if(b instanceof String) { // ���� �ڵ� - boolean(�⺻)�� String(����) �� �񱳺Ұ�
			System.out.println("true");
		}*/
		
	//}
}