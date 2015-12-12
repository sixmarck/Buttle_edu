package model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.AccidentDTO;
import model.dto.BoardDTO;

public interface BoardServiceIF {
	public ArrayList<BoardDTO> allInfoDesk() throws SQLException;
	public boolean registerInfoDesk(BoardDTO b) throws SQLException;
	public boolean updateInfoDesk(int index, String boaTitle, String boaContent) throws SQLException;
	public boolean deleteInfoDesk(int index) throws SQLException;
	public ArrayList<AccidentDTO> allAccident() throws SQLException;
	public boolean registerAccident(AccidentDTO a) throws SQLException;
	public boolean deleteAccident(int accNo) throws SQLException;
}