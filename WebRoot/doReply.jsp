<%@ page language="java" import="java.util.*,dao.*,entity.*,dao.impl.*" pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("GBK");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	int boardId = Integer.parseInt(request.getParameter("boardId"));
	int topicId = Integer.parseInt(request.getParameter("topicId"));
	User user = (User)session.getAttribute("user");
	ReplyDao replyDao = new ReplyDaoImpl();
	if(user!=null){
		Reply Reply = new Reply();
		Reply.setTitle(title);
		Reply.setContent(content);
		Reply.setTopicId(topicId);
		Reply.setUserId(user.getUserId());
		replyDao.addReply(Reply);
		response.sendRedirect("detail.jsp?page=1&boardId="+boardId+"&topicId=" + topicId);
		return;
	}else{
		response.sendRedirect("login.jsp");
	}
%>