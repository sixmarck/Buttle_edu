/*
	1. java/Static1Variable.java
	�н�����
	1. static Ư¡
	  - ��ü �������� �ʰ� ����, �޼ҵ� ȣ�Ⱑ���ϰ� ���ִ� ������ Ű����
	2. ���� ����
	  1) ����
	    - ������ ����� Ư¡
		  (1) ��ü �������̵� Ŭ���� �̸������� ȣ�� ����
		  (2) �����Ǵ� ��� ��ü�� �����ϴ� �޸�
		  (3) ��� ���� ���� : ��� ��ü���� �����ؾ� �ϴ� �ڿ��� ���� ��� �ʱ�ȭ �������� ����
	  2) �޼���
	    - ��ü �������̵� ȣ�� ����
	  3) static{}
	3. ��ü ������ �޸� ��ȯ
	  1) ������� ���� Ȯ��
	  2) ������� ������ �⺻�� ���� (int Ÿ�� = 0��)
	  3) �ڵ忡 ������ ������� �����ͷ� ġȯ
	
*/

class Static1Variable {
	int no1;
	static int no2;

	Static1Variable() {
		no1++; // ++ 1�� �����ϴ� ������(����������)
		no2++;
	}
	
	public static void main(String[] args) {
		System.out.println(Static1Variable.no2);
		Static1Variable s1 = new Static1Variable();
		System.out.println(s1.no1 + " " + Static1Variable.no2);

		Static1Variable s2 = new Static1Variable();
		System.out.println(s2.no1 + " " + Static1Variable.no2);
	}

	static{
		System.out.println("���� ����?");
	}

}