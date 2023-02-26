package entity;

import java.util.Date;

public class Topic {
	private int topicId;
	private String title;
	private String content;
	private Date publishTime;
	private Date modifTime;
	private int userId;
	private int boardId;
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public Date getModifTime() {
		return modifTime;
	}
	public void setModifTime(Date modifTime) {
		this.modifTime = modifTime;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public void setPublishTime(java.sql.Date date) {
		// TODO Auto-generated method stub
		
	}

}
