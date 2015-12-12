package view;

import model.domain.Person;

public class EndView {

	public static void printAll(Person[] v) {
		for (int i = 0; i < v.length; i++) {
			System.out.println(v[i]);
		}
	}
	
	public static void printOne(Person v) {
		System.out.println(v);
	}
	
	public static void errorMsg(String s) {
		System.out.println(s);
	}

	public static void successMsg(String s) {
		// TODO Auto-generated method stub
		System.out.println(s);
	}

}
