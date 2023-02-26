<%@ page language="java" import="java.util.*,dao.*,entity.*,dao.impl.*" pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("GBK");
	String userName = request.getParameter("userName");
	String userPass = request.getParameter("userPass");
	UserDao userDao = new UserDaoImpl();
	User user = userDao.findUser(userName);
	if(user!=null&&user.getUserPass().equals(userPass)){
		session.setAttribute("user",user);//建立一个session内置对象参数,参数值为user
		out.println("登录成功");
	}else{
		out.println("登录失败");
	}
%>
<br> <a href="index.jsp">进入主页</a>