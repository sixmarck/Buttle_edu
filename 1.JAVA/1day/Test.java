/*
	d:/JavaSW/1.java/Test.java
	���� : ¦�� �̸�, ���� �Ұ��ϴ� ���α׷�
	�������� : 
		1. getXxxx / setXxxxx �޼ҵ� �����غ���
		2. �̸�, ���� �� ���� �� Ȱ�� ������ ���� �����ϱ�
*/

/*
class Person
{
	private String name;
	private int age;
	private String describe;

	public Person() {

	}

	public Person(String name, int age, String describe) {
		 this.name = name;
		 this.age = age;
		 this.describe = describe;

	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge(){
		return this.age;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getDescribe(){
		return this.describe;
	}

	public String toString(){
		return "�̸� : " + this.name + ", ���� : " + this.age + ", ���� : " + this.describe;
	}

}

class Test {
	public static void main(String args[]) {
		Person p  = new Person();
		p.setName("kkk");
		p.setAge(25);
		p.setDescribe("�ȳ��ϼ���");

		System.out.println("�̸� : " + p.getName());
		System.out.println("���� : " + p.getAge());
		System.out.println("���� : " + p.getDescribe());

		Person p1 = new Person("kkkk", 25, "�ȳ��ϼ���");
		System.out.println(p1.toString());
	}
}
*/

class Test {
	String name = "kkk";
	int age = 25;

	public static void main(String[] args) {
		// ����� �ý��� �޸𸮿� �����͵� ���� ��û �� ����
		Test t = new Test();
		// �޸𸮿� ����� �̸����� ���
		System.out.println(t.name);
	}
}