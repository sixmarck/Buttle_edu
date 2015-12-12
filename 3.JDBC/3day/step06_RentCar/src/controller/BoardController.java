package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.AccidentDTO;
import model.dto.BoardDTO;
import model.service.BoardServiceImpl;
import view.EndView;

public class BoardController {
	private static BoardServiceImpl service = BoardServiceImpl.getInstance();

	public static void insertBoard(BoardDTO b) {
		try {
			if (BoardServiceImpl.getInstance().registerInfoDesk(b)) {
				EndView.msg("게시판 등록 성공");
				BoardController.allBoardList();
			} else {
				EndView.msg("입력이 안되었습니다. 새로 입력해주세요");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void allBoardList() {
		try {
			ArrayList<BoardDTO> list = service.allInfoDesk();
			if (list.size() != 0) {
				EndView.boardList(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateBoard(int index, String boaTitle, String boaContent) {
		try {
			if (BoardServiceImpl.getInstance().updateInfoDesk(index, boaTitle, boaContent)) {
				EndView.msg("게시판 수정 성공");
				BoardController.allBoardList();
			} else {
				EndView.msg("입력이 안되었습니다. 새로 입력해주세요");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void deleteBoard(int index) {
		try {
			if (BoardServiceImpl.getInstance().deleteInfoDesk(index)) {
				EndView.msg("게시판 삭제 성공");
				BoardController.allBoardList();
			} else {
				EndView.msg("입력이 안되었습니다. 새로 입력해주세요");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void accidentBoard(AccidentDTO a) {
		try {
			if (BoardServiceImpl.getInstance().registerAccident(a)) {
				EndView.msg("사고 등록 성공");
				BoardController.allAccidentList();
			} else {
				EndView.msg("입력이 안되었습니다. 새로 입력해주세요");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void allAccidentList() {
		try {
			ArrayList<AccidentDTO> list = service.allAccident();
			if (list.size() != 0) {
				EndView.accidentList(list);
			} else {
				EndView.msg("");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void accidentDelete(int accNo) {
		try {
			if (BoardServiceImpl.getInstance().deleteAccident(accNo)) {
				EndView.msg("사고 접수 삭제 성공");
				BoardController.allAccidentList();
			} else {
				EndView.msg("삭제할 사고접수가 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}