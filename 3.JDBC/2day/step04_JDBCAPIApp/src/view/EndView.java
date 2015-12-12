package view;

import java.util.List;

import model.domain.Dept01DTO;

public class EndView {

	public static void msg(String msg) {
		System.out.println(msg);
	}

	public static void successMsgAll(List<Dept01DTO> list) {
		for(Dept01DTO value : list) {
			System.out.println(value);
		}
	}

	public static void errorMsg(String msg) {
		System.out.println(msg);
	}

	public static void successMsgOne(Dept01DTO d) {
		System.out.println(d);
	}
}
