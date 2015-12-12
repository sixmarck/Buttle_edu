package buttle.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import buttle.exception.DuplicateException;
import buttle.exception.InexistentException;
import buttle.model.dto.ArchiveBoard;
import buttle.model.dto.Board;
import buttle.model.dto.PhotoBoard;

public class BoardServiceImpl implements BoardServiceIF {
	
	HashMap<String, HashMap<String, Board>> allBoardList =new HashMap<String, HashMap<String, Board>>();
	HashMap<String, Board> archiveList =new HashMap<String, Board>();
	HashMap<String, Board> photoList =new HashMap<String, Board>();
	
	private static BoardServiceImpl instance = new BoardServiceImpl();
	
	
	/**
	 * BoardServiceImpl 객체 생성
	 * */
	public static BoardServiceImpl getInstance(){
		return instance;
	}
	
	/**
	 * 파일로 부터 데이터를 로딩해서 Map에 저장하는 생성자
	 * */
	private BoardServiceImpl(){
		String [] boardValue = null;
		String key=null;
		Iterator<String> allKey =null;
		try {
			
			//자료실 정보
			Properties archiveInfo = new Properties();
			//properties 파일 2byte씩 read해서 메모리에 저장(로딩, 적재)
			archiveInfo.load(new FileReader("archiveInfo.properties"));	
			
			allKey= archiveInfo.stringPropertyNames().iterator();
			
			while(allKey.hasNext()){
				 key = allKey.next();
				 boardValue = archiveInfo.getProperty(key).split(",");
				
				archiveList.put(key, new ArchiveBoard(Integer.parseInt(boardValue[0]),boardValue[1],boardValue[2],
						boardValue[3],boardValue[4],boardValue[5], Integer.parseInt(boardValue[6])));
			
		   }
			
		// 사진 정보
			Properties photoInfo = new Properties();
			photoInfo.load(new FileReader("photoInfo.properties"));	
			allKey= photoInfo.stringPropertyNames().iterator();
			while(allKey.hasNext()){
				 key = allKey.next();
				 boardValue = photoInfo.getProperty(key).split(",");
				
				photoList.put(key, new PhotoBoard(Integer.parseInt(boardValue[0]),boardValue[1],boardValue[2],
						boardValue[3],boardValue[4],boardValue[5]));
			
		   }
			
			allBoardList.put("archive", archiveList);
			allBoardList.put("photo", photoList);
		
       } catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public void updateBoard(String kind, String subject, String content, int no)
			throws InexistentException {
            Board  board = allBoardList.get(kind).get(Integer.toString(no));		
            if(board==null){
            	throw new InexistentException(Integer.toString(no));
            }else{
            	board.setSubject(subject);
            	board.setContent(content);
            	
            	allBoardList.get(kind).put(Integer.toString(no), board);
            }
	}

	@Override
	public HashMap<String, HashMap<String, Board>> getBoardList() {
		return allBoardList;
	}

	@Override
	public HashMap<String, Board> getBoardByKind(String kind) {
		// TODO Auto-generated method stub
		return allBoardList.get(kind);
	}

	@Override
	public Board getBoardByNo(String kind, int no) throws InexistentException {
		// TODO Auto-generated method stub		
		return allBoardList.get(kind).get(Integer.toString(no));
	}

	@Override
	public void insertBoard(String kind, Board board) throws DuplicateException {
		// TODO Auto-generated method stub
		if(existBoardBykind(kind, board.getNo())){
			throw new DuplicateException(kind + "의 글번호 " + Integer.toString(board.getNo()));
		} else {
			allBoardList.get(kind).put(Integer.toString(board.getNo()), board);
			BufferedReader in = null;
			BufferedWriter out = null;
			if(kind.equals("photo")) {
				try {
					in = new BufferedReader(new FileReader("photoInfo.properties"));
					out = new BufferedWriter(new FileWriter("photoInfo.properties", true));
					PhotoBoard pb = (PhotoBoard)board;
					String s = board.getNo()+"="+board.getNo() +","+board.getSubject()+","+board.getWriter()+","+board.getContent()+","+board.getDate()+","+pb.getImgName();
					out.newLine();
					out.write(s);
					out.flush();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						in.close();
						in=null;
						out.close();
						out=null;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			} else if(kind.equals("archive")) {
				try {
					in = new BufferedReader(new FileReader("archiveInfo.properties"));
					out = new BufferedWriter(new FileWriter("archiveInfo.properties", true));
					ArchiveBoard ab = (ArchiveBoard)board;
					String s = board.getNo()+"="+board.getNo() +","+board.getSubject()+","+board.getWriter()+","+board.getContent()+","+board.getDate()+","+ab.getFileName()+","+ab.getFileSize();
					out.newLine();
					out.write(s);
					out.flush();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						in.close();
						in=null;
						out.close();
						out=null;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
			
			
			
		}		
	}

	@Override
	public void deleteBoard(String kind, int no) throws InexistentException {
		// TODO Auto-generated method stub
		if(existBoardBykind(kind, no)){
			allBoardList.get(kind).remove(Integer.toString(no));
		} else {
			throw new InexistentException(Integer.toString(no));
		}
	}

	@Override
	public boolean existBoardBykind(String kind, int no) {
		// TODO Auto-generated method stub
		boolean result = false;
		if(allBoardList.get(kind).get(Integer.toString(no)) != null) {
			result = true;
		}
		return result;
	}
}
