package buttle.view;

import java.util.HashMap;
import java.util.Iterator;

import buttle.model.dto.Board;

public class SuccessView {
	/**
	 * ��� �Խù� ���
	 * */
  public static void printBoard(HashMap<String, HashMap<String, Board>> board){
	  Iterator it = board.keySet().iterator();
	  Iterator it2 = null;
	  String keyValue = null;
	  String keyValue2 = null;
	  while(it.hasNext()) {
		  keyValue = (String) it.next();
		  System.out.println("----- " + keyValue + " Board�� ��� �Խù�  List -----");
		  it2 = board.get(keyValue).keySet().iterator();
		  while(it2.hasNext()) {
			  keyValue2 = (String) it2.next();
			  System.out.println(board.get(keyValue).get(keyValue2));
		  }
		  
	  }
  }
  
  /**
   *  �Խ��� ������ ���� ���
   * */
   public static void printBoardBykind(String kind, HashMap<String, Board> board){
	   System.out.println("------archive ���� �Խù� List -------");
	   Iterator it = board.keySet().iterator();
	   String keyValue = null;
	   while(it.hasNext()) {
		   keyValue = (String) it.next();
		   System.out.println(board.get(keyValue));
	   }
   }
  
    /**
     * �Խù� ���/����/���� ���� �� �޽��� ���
     * */ 
    public static void successMessage(String message) {
		System.out.println(message);
	}
    

    public static void printBoardByno(Board board){
 		System.out.println(" �Խù� ���� - " + board);
 	}
  
  
}
