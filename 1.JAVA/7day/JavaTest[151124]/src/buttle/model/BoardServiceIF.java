package buttle.model;

import java.util.HashMap;

import buttle.exception.DuplicateException;
import buttle.exception.InexistentException;
import buttle.model.dto.Board;

public interface BoardServiceIF {
  /**
   * ��� �Խù� �˻�(�ڷ��, ����)
   * */
	public HashMap<String, HashMap<String, Board>> getBoardList();
	
	/**
	 *  �Խ��� ������ ���� �˻�
	 *  ��� �ڷ��  or ��� �����ڷ�� �˻�
	 * */
	public HashMap<String, Board> getBoardByKind(String kind);
	
	/**
	 * �۹�ȣ�� �ش��ϴ� �Խù� �˻�
	 * */
	public Board getBoardByNo(String kind, int no ) throws InexistentException;
	
	/**
	 *  �۹�ȣ�� �ش��ϴ� �Խù� ����
	 * */
	public void insertBoard(String kind, Board board)throws DuplicateException;
	
	/**
	 * �۹�ȣ�� �ش��ϴ� �Խù� ����
	 * (����� ���� �� ����������.)
	 * */
	public void updateBoard(String kind, String subject, String content, int no)throws InexistentException;
	
	/**
	 * �۹�ȣ�� �ش��ϴ� �Խù� ����
	 * */
	public void deleteBoard(String kind, int no)throws InexistentException;
	
	/**
	 * �Խù� ���� ���翩�� üũ
	 * return =>  true : �Խù� ���� , false :  �Խù� ����
	 * */
	public boolean existBoardBykind(String kind, int no);
}
