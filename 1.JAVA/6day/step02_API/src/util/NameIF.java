package util;

public class NameIF implements NameInterface {

	@Override
	public String getName() {
		return "�ּ���";
	}

	@Override
	public String getName2() {
		return "�ǳ� ��¾�";
	}

	public static void main(String[] args) {
		NameInterface n = new NameIF();
		System.out.println(n.getName());
		System.out.println(n.getName2());
	}

}
