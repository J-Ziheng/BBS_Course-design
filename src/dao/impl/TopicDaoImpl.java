package dao.impl;

import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import dao.TopicDao;
import entity.Topic;
import entity.User;

public class TopicDaoImpl extends BaseDao implements TopicDao {

	private Connection conn;
	private PreparedStatement ps;

	public Topic findTopic(int topicId) {
		Connection conn = null;

		/* ����SQL,ִ��SQL */
		try {
			conn = getConn();
			String sql = "select * from TBL_TOPIC where topicId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, topicId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				Topic Topic = new Topic();
				Topic.setTopicId(rs.getInt("topicId"));
				Topic.setTitle(rs.getString("title"));
				Topic.setContent(rs.getString("content"));
				Topic.setPublishTime(rs.getDate("publishTime"));
				Topic.setModifTime(rs.getDate("modifyTime"));
				Topic.setUserId(rs.getInt("uId"));
				Topic.setBoardId(rs.getInt("boardId"));
				return Topic;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // ����ClassNotFoundException�쳣
		} catch (SQLException e) {
			e.printStackTrace(); // ����SQLException�쳣
		} finally {
			closeAll(conn, ps, null); // �ͷ���Դ
		}
		return null;
	}

	@Override
	public List findListTopic(int page, int boardId) {
		Connection conn = null;
		List list = new ArrayList();
		int rowBegin = 1;
		if(page>1){
			rowBegin = 20*(page-1);
		}
		try {
			String sql = "select top 20 * from TBL_TOPIC where boardId = " + boardId 
					+ " and topicId not in (select top 0 topicId from TBL_TOPIC where boardId = " + 
					boardId +")";
			//" order by publishTime desc) order by publishTime desc";
			conn = getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Topic topic = new Topic();
                topic.setTopicId(rs.getInt("topicId"));
                topic.setTitle(rs.getString("title"));
                topic.setPublishTime(rs.getDate("PublishTime"));
                topic.setUserId(rs.getInt("uId"));
                list.add(topic);
			}
		} catch (Exception e) {
			e.printStackTrace(); // ����SQLException�쳣
		} finally {
			closeAll(conn, ps, null); // �ͷ���Դ
		}
		return list;
	}

	@Override
	public int addTopic(Topic topic) {
		String sql ="insert into TBL_TOPIC(title,content,publishTime,modifyTime,uId,boardId) values(?,?,?,?," + topic.getUserId()+ "," + topic.getBoardId() + ")";
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
		String[] parm = {topic.getTitle(),topic.getContent(),time,time};
		return this.executeSQL(sql,parm);
	}

	@Override
	public int deleteTopic(int topicID) {
		String sql = "selete from TBL_TOPIC where topicId=?";
		try {
			Connection conn=getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,topicID);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				Topic topic = new Topic();
				topic.setTopicId(rs.getInt("topicId"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // ����ClassNotFoundException�쳣
		} catch (SQLException e) {
			e.printStackTrace(); // ����SQLException�쳣
		} finally {
			PreparedStatement ps = null;
			closeAll(conn, ps, null); // �ͷ���Դ
		}
		return 1;
	}

	@Override
	public int updateTopic(Topic topic) {
		return 0;
	}

	@Override
	public int findCountTopic(int boardId) {
		Connection conn = null;
		int i = 0;

		/* ����SQL,ִ��SQL */
		try {
			conn = getConn();
			String sql = "select * from TBL_USER where boaedId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, boardId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Topic Topic = new Topic();
				Topic.setTopicId(rs.getInt("topicId"));
				i=i+1;
				return i;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // ����ClassNotFoundException�쳣
		} catch (SQLException e) {
			e.printStackTrace(); // ����SQLException�쳣
		} finally {
			closeAll(conn, ps, null); // �ͷ���Դ
		}
		return 0;
	}
}

