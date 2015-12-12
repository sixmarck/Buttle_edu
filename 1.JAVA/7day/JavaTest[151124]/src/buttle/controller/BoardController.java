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
	 * 모든 게시물 검색
	 * */
	public static void getAllBoard() {
		HashMap<String, HashMap<String, Board>> allBoard = boardService	.getBoardList();
		SuccessView.printBoard(allBoard);
	}

	/**
	 * 자료실 또는 사진 게시물 모두 검색
	 * */
	public static void getBoardByKind(String kind) {
		HashMap<String, Board> allboard = boardService.getBoardByKind(kind);
		SuccessView.printBoardBykind(kind, allboard);
	}

	/**
	 * 글번호에 해당하는 게시물 검색
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
			FailView.errorMessage("게시물을 검색 할 수 없습니다");
		}
	}

	/**
	 * 게시물 저장
	 * */
	public static void insertBoard(String kind, Board board) {
		try {
			boardService.insertBoard(kind, board);
			SuccessView.successMessage("게시물이 저장되었습니다.");
		} catch (DuplicateException e) {
			System.out.println(e.getMessage());
			FailView.errorMessage("게시물을 저장 할수 없습니다.");
		}
	}

	/**
	 * 글번호에 해당하는 게시물 수정
	 */
	public static void updateBoard(String kind, String subject, String content,	int no) {
		try {
			boardService.updateBoard(kind, subject, content, no);
			SuccessView.successMessage("게시물이 수정되었습니다.");
		} catch (InexistentException e) {
			System.out.println(e.getMessage());
			FailView.errorMessage("게시물을 수정 할수 없습니다.");
		}
	}

	/**
	 * 글번호에 해당하는 게시물 삭제
	 * */

	public static void deleteBoard(String kind, int no) {
		try {
			boardService.deleteBoard(kind, no);
			SuccessView.successMessage("게시물이 삭제되었습니다.");
		} catch (InexistentException e) {
			System.out.println(e.getMessage());
			FailView.errorMessage("게시물을 삭제 할 수 없습니다.");
		}
	}

}