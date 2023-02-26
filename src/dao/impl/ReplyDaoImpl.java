package dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import dao.ReplyDao;
import entity.Board;
import entity.Reply;
import entity.Topic;

public class ReplyDaoImpl extends BaseDao implements ReplyDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	@Override
	public Reply findReply(int replyId){
		
		Reply reply = new Reply();
		
		try {
			conn=getConn();
			//����Statement����
			String sql="select * from TBL_REPLY where replyId=?";
			pstmt = conn.prepareStatement(sql);
			//��ȫsql���
			pstmt.setInt(1, replyId);
			//ִ�в�ѯ
			rs=pstmt.executeQuery();
			if(rs.next()) {
				reply.setReplyId(rs.getInt("replyId"));
				reply.setTitle(rs.getString("title"));
				reply.setContent(rs.getString("content"));
				reply.setPublishTime(rs.getString("publishTime"));
				reply.setModifyTime(rs.getString("modifyTime"));
				reply.setUserId(rs.getInt("uId"));
				reply.setTopicId(rs.getInt("topicId"));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			this.closeAll(conn,pstmt,rs);
		}
		return reply;	
	}

	public int addReply(Reply reply) {
		String sql = "insert into TBL_REPLY(title,content,publishTime,modifyTime,uId,topicId) values(?,?,?,?,"+reply.getUserId()+ "," +reply.getTopicId() + ")";
		String time = new SimpleDateFormat("yyyy - MM - dd HH:mm:ss").format(new Date());
		String[] parm = {reply.getTitle(),reply.getContent(),time,time};
		return this.executeSQL(sql, parm);
	}

	public int deleteReply(int replyId) {
		String sql = "delete from TBL_REPLY where topicId = " + replyId;
		try {
			conn=getConn();
			//����Statement����
			pstmt = conn.prepareStatement(sql);
			//ִ��sql���
			rs=pstmt.executeQuery();
			if(rs.next()) {
				Reply reply = new Reply();
				reply.setReplyId(rs.getInt("replyId"));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			this.closeAll(conn,pstmt,rs);
		}
		return 1;
	}
	@Override
	public int updateReply(Reply reply) {
		String sql = "update TBL_TOPIC set content = ? wherer title = ?";
		String[] parm = {reply.getContent(),reply.getTitle()};
		try{
			conn=getConn();
			//����Statement����
			pstmt = conn.prepareStatement(sql);
			//ִ��sql���
			rs=pstmt.executeQuery();
			if(rs.next()) {
				reply.setContent(rs.getString("content"));
				reply.setTitle(rs.getString("title"));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			this.closeAll(conn,pstmt,rs);
		}
		return this.executeSQL(sql, parm);
	}
	public int findCountReply(int topicId) {
		String sql = "select count(*) from TBL_REPLY where topicId=?";
		int num = 0 ;

		/* ����SQL,ִ��SQL */
		try {
			conn = getConn(); // �õ����ݿ�����
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, topicId);
			rs = pstmt.executeQuery(); // ִ��SQL���
			if(rs.next()) {
				num = rs.getInt(1);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // ����ClassNotFoundException�쳣
		} catch (SQLException e) {
			e.printStackTrace(); // ����SQLException�쳣
		} finally {
			this.closeAll(conn, pstmt, null); // �ͷ���Դ
		}
		return num;
	}

	@Override
	public List findListReply(int page, int topicId) {
		Connection conn = null;
		List list = new ArrayList();
		int rowBegin = 1;
		if(page>1){
			rowBegin = 20*(page-1);
		}
		try {
			String sql = "select top 20 * from TBL_REPLY where topicId = " + topicId 
					+ " and replyId not in (select top 0 replyId from TBL_TOPIC where topicId = " + 
					topicId +")";
			//" order by publishTime desc) order by publishTime desc";
			conn = getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Reply reply = new Reply();
				reply.setReplyId(rs.getInt("replyId"));
				reply.setTitle(rs.getString("title"));
				reply.setPublishTime(rs.getString("PublishTime"));
				reply.setUserId(rs.getInt("uId"));
                list.add(reply);
			}
		} catch (Exception e) {
			e.printStackTrace(); // ����SQLException�쳣
		} finally {
			closeAll(conn, pstmt, null); // �ͷ���Դ
		}
		return list;
	}
	
}
