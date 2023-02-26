package dao;

import java.util.Map;

import entity.Board;

public interface BoardDao {
	public Map findBoard();
	public Board findBoard(int boardId);

}
