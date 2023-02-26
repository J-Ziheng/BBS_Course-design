package dao;

import java.util.List;

import entity.Reply;

public interface ReplyDao {
	public Reply findReply(int replyId);
	public int addReply(Reply reply);
	public int deleteReply(int reply);
	public int updateReply(Reply reply);
	public List findListReply(int page,int topicId);
	public int findCountReply(int topicId);

}
