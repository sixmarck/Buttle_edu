package view;

import java.util.ArrayList;
import java.util.List;

import model.domain.Member01DTO;

public class EndView {

	public static void successMemberAll(List<Member01DTO> list) {
		for (Member01DTO member01dto : list) {
			System.out.println(member01dto);
		}
	}

	public static void msg(String msg) {
		System.out.println(msg);
	}

	public static void errorMsg(String msg) {
		System.out.println(msg);
	}
}
