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
				EndView.msg("�Խ��� ��� ����");
				BoardController.allBoardList();
			} else {
				EndView.msg("�Է��� �ȵǾ����ϴ�. ���� �Է����ּ���");
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
				EndView.msg("�Խ��� ���� ����");
				BoardController.allBoardList();
			} else {
				EndView.msg("�Է��� �ȵǾ����ϴ�. ���� �Է����ּ���");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void deleteBoard(int index) {
		try {
			if (BoardServiceImpl.getInstance().deleteInfoDesk(index)) {
				EndView.msg("�Խ��� ���� ����");
				BoardController.allBoardList();
			} else {
				EndView.msg("�Է��� �ȵǾ����ϴ�. ���� �Է����ּ���");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void accidentBoard(AccidentDTO a) {
		try {
			if (BoardServiceImpl.getInstance().registerAccident(a)) {
				EndView.msg("��� ��� ����");
				BoardController.allAccidentList();
			} else {
				EndView.msg("�Է��� �ȵǾ����ϴ�. ���� �Է����ּ���");
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
				EndView.msg("��� ���� ���� ����");
				BoardController.allAccidentList();
			} else {
				EndView.msg("������ ��������� �����ϴ�.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}