package controller;

import java.util.stream.Stream;

import model.Data;
import model.dto.Member;
import view.EndView;

public class Controller {
	private static Data dataService = Data.getInstance();

	public static void userTransportSearch(String id) {
		EndView.userTransportList(id, dataService.allSearch());
	}

	public static boolean transportNo(String no, String id) {
		return EndView.transportNoList(no, id, dataService.allSearch());
	}

	/*
	 * public static void userUpdateTransport(String no, String updateValue) {
	 * //EndView.UpdateTransport(dataService.allMemberList(), no, updateValue);
	 * EndView.UpdateTransport(dataService.allSearch(), no, updateValue); }
	 */

	public static void insertBoard(String no, String transportInfo) {
		EndView.transportInsert(dataService.allSearch(), no, transportInfo);
	}

	public static void deleteBoard(String no) {
		EndView.transportDelete(dataService.deleteBoard(no));
	}

	public static boolean login(String id, String pw) {
		return dataService.login(id, pw);
	}

	public static void allMemberList() {
		EndView.allMemberList(dataService.allMemberList());
	}

	public static void allTransportList() {
		EndView.allTransportList(dataService.allTransportList());
	}

	public static void changeState(String no, int value) {
		EndView.changeState(dataService.changeState(no, value), no);
	}

	public static void oneDayParcelStatistics() {
		dataService.oneDayParcelStatistics();
	}

	public static void productRegister(String id, String lines) {
		boolean b = dataService.productRegistr(id, lines);
		EndView.productRegister(id, lines, b);
	}

	public static void register(Member m) {
		boolean b = dataService.registerForm(m);

		EndView.RegisterForm(b);

	}
}
