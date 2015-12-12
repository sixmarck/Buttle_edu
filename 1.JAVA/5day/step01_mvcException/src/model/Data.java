package model;

import model.domain.Person;

public class Data {
	private static Person[] all = new Person[3];
	
	//������ �����ؼ� ����
	static {
		all[0] = new Person("master", "�ּ���", 27);
		all[1] = new Person("abc", "ȫ�浿", 25);
		all[2] = new Person("aaa", "������", 30);	
	}
	
	//Person[] ��ȯ �޼ҵ�
	public static Person[] getAll() {
		return all;
	}
	
	public static Person getOne(int idx) {
		return all[idx];
		
	}

	public static void newSave(Person v) {
		all[0] = v;
	}
	
	
}
