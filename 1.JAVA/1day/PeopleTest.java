/*
	1.basic/PeopleTest.java
	����
	1. �ϼ� ���� : �� ����� ������ ���� �� ���
	2. ���� ����
	 1) �Ϻ��� People Ŭ������ ���
		(People.java�� ���� �Ұ�)
	 2) �� Ŭ�������� People ��ü�� ���� �� Ȱ��
	3. Ȯ��(�ɼ�)
	 - �⺻�� main �޼ҵ忡�� ��� ���� �� ����
	  ���������� �� �ڵ��ϰ� �ʹ� ���� ģ���鸸 ���� ���� �ϼ�
	 - �ΰ��� People ��� �����ε� ���� �� Ȱ��
*/

class PeopleTest {
	public static void main(String[] args) {
		People p1 = new People();
		People p2 = new People();

		p1.name = "aaa";
		p1.age = 11;
		p1.job = "aaa";

		p2.name = "bbb";
		p2.age = 12;
		p2.job = "bbb";

		System.out.printf("name : %s, age : %d, job : %s\n", p1.name, p1.age, p1.job);
		System.out.println("name : " + p2.name + ", age : " + p2.age + ", job : " + p2.job);
		
	}
}