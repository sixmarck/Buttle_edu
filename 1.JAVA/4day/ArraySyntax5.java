/*
	1.basic/ArraySyntax5.java
	�н�����
	1. �޸� ������ �帧 �����ϱ�
	2. ��� Ÿ�� : �迭, People
	3. ����
	  - ���ú���, �������
	4. ��� �޸� : class area(method area), stack, heap
*/

public class ArraySyntax5 {
	public People[] p = {new People(), new People()};

	public void m1(String name, int age, String job) {
		p[0].name = name;
		p[0].age = age;
		p[0].job = job;
	}

	public void m2(People p) {
		System.out.println(p.name + " " + p.age);
	}

	public static void main(String[] args) {
		ArraySyntax5 as = new ArraySyntax5();
		as.m1("���缮", 25, "IT����");
		as.m2(as.p[0]);

	}
}