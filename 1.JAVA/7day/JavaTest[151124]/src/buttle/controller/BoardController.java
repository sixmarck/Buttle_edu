package buttle.controller;

import java.util.HashMap;

import buttle.exception.DuplicateException;
import buttle.exception.InexistentException;
import buttle.model.BoardServiceImpl;
import buttle.model.dto.Board;
import buttle.view.FailView;
import buttle.view.SuccessView;

public class BoardController {
	private static BoardServiceImpl boardService = BoardServiceImpl	.getInstance();

	/**
	 * ��� �Խù� �˻�
	 * */
	public static void getAllBoard() {
		HashMap<String, HashMap<String, Board>> allBoard = boardService	.getBoardList();
		SuccessView.printBoard(allBoard);
	}

	/**
	 * �ڷ�� �Ǵ� ���� �Խù� ��� �˻�
	 * */
	public static void getBoardByKind(String kind) {
		HashMap<String, Board> allboard = boardService.getBoardByKind(kind);
		SuccessView.printBoardBykind(kind, allboard);
	}

	/**
	 * �۹�ȣ�� �ش��ϴ� �Խù� �˻�
	 * */
	public static void getBoardByno(String kind, int no) {
		try {
			Board board = boardService.getBoardByNo(kind, no);
			if(board != null) {				
				SuccessView.printBoardByno(board);
			} else {
				throw new InexistentException(Integer.toString(no));
			}
		} catch (InexistentException e) {
			System.out.println(e.getMessage());
			FailView.errorMessage("�Խù��� �˻� �� �� �����ϴ�");
		}
	}

	/**
	 * �Խù� ����
	 * */
	public static void insertBoard(String kind, Board board) {
		try {
			boardService.insertBoard(kind, board);
			SuccessView.successMessage("�Խù��� ����Ǿ����ϴ�.");
		} catch (DuplicateException e) {
			System.out.println(e.getMessage());
			FailView.errorMessage("�Խù��� ���� �Ҽ� �����ϴ�.");
		}
	}

	/**
	 * �۹�ȣ�� �ش��ϴ� �Խù� ����
	 */
	public static void updateBoard(String kind, String subject, String content,	int no) {
		try {
			boardService.updateBoard(kind, subject, content, no);
			SuccessView.successMessage("�Խù��� �����Ǿ����ϴ�.");
		} catch (InexistentException e) {
			System.out.println(e.getMessage());
			FailView.errorMessage("�Խù��� ���� �Ҽ� �����ϴ�.");
		}
	}

	/**
	 * �۹�ȣ�� �ش��ϴ� �Խù� ����
	 * */

	public static void deleteBoard(String kind, int no) {
		try {
			boardService.deleteBoard(kind, no);
			SuccessView.successMessage("�Խù��� �����Ǿ����ϴ�.");
		} catch (InexistentException e) {
			System.out.println(e.getMessage());
			FailView.errorMessage("�Խù��� ���� �� �� �����ϴ�.");
		}
	}

}