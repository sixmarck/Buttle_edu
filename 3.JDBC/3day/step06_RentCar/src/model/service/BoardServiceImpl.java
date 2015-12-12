package model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import model.dao.BoardDAO;
import model.dto.BoardDTO;
import model.dto.AccidentDTO;

public class BoardServiceImpl implements BoardServiceIF {
	private static BoardServiceImpl instance = new BoardServiceImpl();
	private BoardServiceImpl(){}
	public static BoardServiceImpl getInstance(){
		return instance;
	}
	private BoardDAO dao = BoardDAO.getInstance();
	
	@Override
	public ArrayList<BoardDTO> allInfoDesk() throws SQLException {
		return dao.allInfoDesk();
	}

	@Override
	public boolean registerInfoDesk(BoardDTO b) throws SQLException {
		return dao.registerInfoDesk(b);
	}

	@Override
	public boolean updateInfoDesk(int index, String boaTitle, String boaContent) throws SQLException {
		return dao.updateInfoDesk(index,boaTitle,boaContent);
	}

	@Override
	public boolean deleteInfoDesk(int index) throws SQLException {
		return dao.deleteInfoDesk(index);
	}

	@Override
	public ArrayList<AccidentDTO> allAccident() throws SQLException {
		return dao.allAccident();
	}

	@Override
	public boolean registerAccident(AccidentDTO a) throws SQLException {
		return dao.registerAccident(a);
	}

	@Override
	public boolean deleteAccident(int accNo) throws SQLException {
		return dao.accidentDelete(accNo);
	}
}