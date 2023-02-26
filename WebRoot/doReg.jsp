<%@ page language="java" import="java.util.*,dao.*,entity.*,dao.impl.*" pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("GBK");
	String userName = request.getParameter("userName");
	String userPass = request.getParameter("userPass");
	UserDao userDao = new UserDaoImpl();
	User user = new User();
	user.setUserName(userName);
	user.setUserPass(userPass);
	int num = userDao.addUser(user);
	if(num == 1){
		response.sendRedirect("index.jsp");
	}else{
		response.sendRedirect("reg.jsp");
	}
%>