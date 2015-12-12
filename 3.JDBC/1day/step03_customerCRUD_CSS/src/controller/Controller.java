package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Member01DAO;
import model.domain.Member01DTO;
import view.EndView;

public class Controller {

	public static void allMember() {
		try {
			List<Member01DTO> list = Member01DAO.getInstance().allMember();
			if(list.size() != 0) {
				EndView.successMemberAll(list);
			} else {
				EndView.msg("회원정보가 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.errorMsg("회원정보 검색 실패! 재시도 하세요.");
		}
	}

	public static void registerMember(Member01DTO m) {
		try {
			if(Member01DAO.getInstance().registerMember(m) != 0) {
				EndView.msg("회원가입 성공");
			} else {
				EndView.msg("잘못 입력되었습니다. 다시 입력해주세요.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.errorMsg("회원가입 실패! 재시도 하세요.");
		}
	}

	public static void updateMember(Member01DTO m) {
		try {
			if(Member01DAO.getInstance().updateMember(m) != 0) {
				EndView.msg("회원정보 수정 성공");
			} else {
				EndView.msg("잘못 입력되었습니다. 다시 입력해주세요.");
			}
		} catch (SQLException e) {
			EndView.errorMsg("회원정보수정 실패! 재시도 하세요.");
		}
	}

	public static void deleteMember(String id) {
		try {
			if(Member01DAO.getInstance().deleteMember(id) != 0) {
				EndView.msg("회원탈퇴 성공");
			} else {
				EndView.msg("잘못 입력되었습니다. 다시 입력해주세요.");
			}
		} catch (SQLException e) {
			EndView.errorMsg("회원탈퇴 실패! 재시도 하세요.");
		}
	}

}
