package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import dao.UserDao;
import entity.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public User findUser(String userName) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		/* 处理SQL,执行SQL */
		try {
			conn = getConn();
			String sql = "select * from TBL_USER where uName=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				User user = new User();
				user.setUserId(rs.getInt("uID"));
				user.setUserName(rs.getString("uName"));
				user.setUserPass(rs.getString("uPass"));
				return user;
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

	@Override
	public User findUser(int userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		/* 处理SQL,执行SQL */
		try {
			conn = getConn();
			String sql = "select * from TBL_USER where uId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				User user = new User();
				user.setUserId(rs.getInt("uID"));
				user.setUserName(rs.getString("uName"));
				user.setUserPass(rs.getString("uPass"));
				return user;
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

	@Override
	public int addUser(User user) {
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
		String sql ="insert into TBL_USER(uName,uPass,head,regTime,gender) values(?,?," + 1 + "," + 2 + "," + 2 + ")";
		String[] parm = { user.getUserName(),user.getUserPass()};
		return this.executeSQL(sql,parm);
	}

	@Override
	public int updateUser(User user) {
		String sql = "update TBL_USER set upass=? where uname=?";
		String[] parm ={ user.getUserPass(),user.getUserName(), };
		return this.executeSQL(sql,parm);
	}

}
