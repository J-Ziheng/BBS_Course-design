package dao;

import entity.User;

public interface UserDao {
	public static final int FEMALE =1;//����Ů��
	public static final int MALE =2;//��������
	public User findUser(String userName);
	public User findUser(int userId);
	public int addUser(User user);
	public int updateUser(User user);
	
}
