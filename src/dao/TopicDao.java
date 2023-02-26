package dao;

import java.util.List;

import entity.Topic;

public interface TopicDao {
	public Topic findTopic(int topicId);
	public List findListTopic(int page,int boardId);
	public int addTopic(Topic topic);
	public int deleteTopic(int topicID);
	public int updateTopic(Topic topic);
	public int findCountTopic(int boardId);

}
