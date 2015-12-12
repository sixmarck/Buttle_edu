/*
	MethodSyntax2API.java
	�н�����
	1. method syntax review
	2. api Ȱ�� ����
	3. method & api ȥ���ؼ� ����
	4. ��Ʈ : java.lang.String Ŭ������ �޼ҵ带 Ȱ��

	* ����
	  1. ��ü���� ����
	    - Ÿ�� ������ = new ������( [..] );
	  2. ��ü �ӿ��� ���������� �ΰ��� Ÿ���� new ���̵� jvm������ �ڵ� ��üȭ
	    - ǥ������� ���������� �޸𸮿� �����Ǵ� ������ ��ü�� ����
	    - String(" "), �迭({��1, ...})
	   
*/

class MethodSyntax2API {
	// ? �̸�, ���̰� �޾Ƽ� "�� ����� �̸��� XXX�̰�, ���̴� XX�Դϴ�." ��ȯ
	String getInfo(String name, int age) {
		return "�� ����� �̸��� " + name + "�̰�, ���̴� " + age + "�Դϴ�.";
	}

	// ? ������ ������ ���ϱ�
	/* �� String Ŭ������ �޼ҵ� ��� Ȱ���ϱ�
	
	*/
	String m(String value) {
		return "    " + value;
	}

	public static void main(String[] args) {
		MethodSyntax2API m = new MethodSyntax2API();
		String value = m.getInfo("ȫ�浿", 22);
		System.out.println(value);
		//? value�� �����ϴ� ��ü�� ù��° �������� �����ؼ� ���
		/* String Ŭ���� ���ο� char�� ��ȯ �޼ҵ� ����

		*/
		char v = value.charAt(0);
		System.out.println(v);

		String value2 = value.substring(0,5);
		System.out.println(value2);

		//? value������ �����ϴ� ���ڿ� ��ý�� ��ü ���̰� ���
		int length = value.length();
		System.out.println(length);

		System.out.println(m.m(value));
		System.out.println(m.m(value).trim());
		
	}
}