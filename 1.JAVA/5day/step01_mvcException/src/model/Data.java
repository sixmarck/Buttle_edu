package model;

import model.domain.Person;

public class Data {
	private static Person[] all = new Person[3];
	
	//데이터 생성해서 저장
	static {
		all[0] = new Person("master", "최성식", 27);
		all[1] = new Person("abc", "홍길동", 25);
		all[2] = new Person("aaa", "조지아", 30);	
	}
	
	//Person[] 반환 메소드
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
