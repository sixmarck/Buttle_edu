package util;

public class NameIF implements NameInterface {

	@Override
	public String getName() {
		return "최성식";
	}

	@Override
	public String getName2() {
		return "맨날 노는애";
	}

	public static void main(String[] args) {
		NameInterface n = new NameIF();
		System.out.println(n.getName());
		System.out.println(n.getName2());
	}

}
