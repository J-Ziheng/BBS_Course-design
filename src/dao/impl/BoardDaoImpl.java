package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dao.BoardDao;
import entity.Board;
import entity.Topic;

public class BoardDaoImpl extends BaseDao implements BoardDao {
	
	@Override
	public Map findBoard() {
		String sql = "select * from TBL_BOARD order by parentId,boardId";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int parentId = 0;
		HashMap map = new HashMap();
		/* 处理SQL,执行SQL */
		try {
			conn = getConn();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList sonList = new ArrayList();
			while(rs.next()){
				if(parentId != rs.getInt("parentId")){
					map.put(new Integer(parentId),sonList);
					sonList = new ArrayList();
					parentId = rs.getInt("parentId");
				}
				Board Map = new Board();
				Map.setBoardId(rs.getInt("BoardId"));
				Map.setBoardName(rs.getString("BoardName"));
				Map.setParentId(rs.getInt("parentId"));
				sonList.add(Map);
			}
			map.put(new Integer(parentId),sonList);
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // 处理ClassNotFoundException异常
		} catch (SQLException e) {
			e.printStackTrace(); // 处理SQLException异常
		} finally {
			closeAll(conn, pstmt, null); // 释放资源
		}
		return map;
	}

	@Override
	public Board findBoard(int boardId) {
	Connection conn = null;
		PreparedStatement pstmt = null;

		/* 处理SQL,执行SQL */
		try {
			conn = getConn();
			String sql = "select * from TBL_BOARD where boardId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, boardId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				Board Board = new Board();
				Board.setBoardId(rs.getInt("BoardId"));
				Board.setParentId(rs.getInt("parentId"));
				Board.setBoardName(rs.getString("boardName"));
				return Board;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // 处理ClassNotFoundException异常
		} catch (SQLException e) {
			e.printStackTrace(); // 处理SQLException异常
		} finally {
			closeAll(conn, pstmt, null); // 释放资源
		}
		return null;
	}

}
