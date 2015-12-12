package buttle.view;

import buttle.controller.BoardController;
import buttle.model.dto.ArchiveBoard;
import buttle.model.dto.PhotoBoard;

public class MainView {

	public static void main(String[] args) {
		//1.archive와 photo 모든 게시물 검색
		System.out.println("========== 1. 모든 게시물 검색 ==============");
		BoardController.getAllBoard();
		
		System.out.println("\n");
		
		//2. archive 또는 photo  게시판에 있는 모든 게시물 검색
		System.out.println("========== 2. 게시판 유형에 따른 검색 ==============");  
		BoardController.getBoardByKind("archive");
		
		System.out.println("\n");
		
		//3.글번호에 해당하는 자료실검색
		/* 존재하는 게시물 검색할 경우와 없는 게시물 검색 각각 test 결과 출력하기
		 */
		System.out.println("==========3.Archive Board에서 글번호에 해당하는 게시물 검색 ==============");
		System.out.println("-----게시물이 존재하는 경우 검색 test----- ");
		BoardController.getBoardByno("archive", 10); //존재하는 게시물
		
		System.out.println();
		
		System.out.println("-----게시물이 없는 경우  검색 test-----");
		BoardController.getBoardByno("archive", 30);// 없는 게시물
		
		System.out.println("\n");
		
		//4. 게시물 등록하기(TreeMap에 저장- 저장하기 전에 글번호 중복여부 체크)
		System.out.println("========== 4. 게시물 등록 ==============");
		System.out.println("-----새로운 게시물 등록인  경우 test----- ");
		BoardController.insertBoard("photo", new PhotoBoard(20, "Java", "이나영", "안녕", "2013-10-20", "a.gif"));//글번호 없는 게시물등록
		
		System.out.println("-----새로운 게시물 등록인  경우 test----- ");
		BoardController.insertBoard("archive", new ArchiveBoard(12, "Java", "이나영", "안녕", "2013-10-20", "jdbc.xls", 200));//글번호 없는 게시물등록
		
		System.out.println();
		System.out.println("-----이미 존재하는 게시물 등록 하려는 경우 test----- ");
		BoardController.insertBoard("photo", new PhotoBoard(10, "Java", "이나영", "안녕", "2013-10-20", "a.gif"));//글번호 이미 있는 게시물등록

		System.out.println("\n");
		
		//5. 게시물 수정(제목과내용만 수정가능함. 글번호 존재여부 체크)
		System.out.println("========== 5. 게시물 수정 ==============");
		System.out.println("-----게시물이 존재하는 경우 수정 test----- ");
		BoardController.updateBoard("archive", "myBatis","myBatis수업자료",10);//글번호 있는 게시물 수정
		
		System.out.println();
		System.out.println("-----게시물이 존재하지 않는 경우 수정 test----- ");
		BoardController.updateBoard("archive", "myBatis","myBatis수업자료",20);//글번호 없는 게시물 수정
		//BoardController.getAllBoard();
		
		System.out.println("\n");
		
		//6. 게시물 삭제
		System.out.println("========== 6. 게시물 삭제 ==============");
		System.out.println("-----게시물이 존재하는 경우 삭제 test----- ");
		BoardController.deleteBoard("archive", 10);
		
		System.out.println();
		System.out.println("-----게시물이 존재하지 않는 경우삭제  test----- ");
		BoardController.deleteBoard("archive", 15);
	}
}
