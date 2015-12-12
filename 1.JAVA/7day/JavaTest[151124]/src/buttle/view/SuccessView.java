package buttle.view;

import java.util.HashMap;
import java.util.Iterator;

import buttle.model.dto.Board;

public class SuccessView {
	/**
	 * 모든 게시물 출력
	 * */
  public static void printBoard(HashMap<String, HashMap<String, Board>> board){
	  Iterator it = board.keySet().iterator();
	  Iterator it2 = null;
	  String keyValue = null;
	  String keyValue2 = null;
	  while(it.hasNext()) {
		  keyValue = (String) it.next();
		  System.out.println("----- " + keyValue + " Board의 모든 게시물  List -----");
		  it2 = board.get(keyValue).keySet().iterator();
		  while(it2.hasNext()) {
			  keyValue2 = (String) it2.next();
			  System.out.println(board.get(keyValue).get(keyValue2));
		  }
		  
	  }
  }
  
  /**
   *  게시판 유형에 따른 출력
   * */
   public static void printBoardBykind(String kind, HashMap<String, Board> board){
	   System.out.println("------archive 유형 게시물 List -------");
	   Iterator it = board.keySet().iterator();
	   String keyValue = null;
	   while(it.hasNext()) {
		   keyValue = (String) it.next();
		   System.out.println(board.get(keyValue));
	   }
   }
  
    /**
     * 게시물 등록/수정/삭제 성공 시 메시지 출력
     * */ 
    public static void successMessage(String message) {
		System.out.println(message);
	}
    

    public static void printBoardByno(Board board){
 		System.out.println(" 게시물 정보 - " + board);
 	}
  
  
}
