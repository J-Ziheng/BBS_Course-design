<%@ page language="java"  import="java.util.*,dao.*,entity.*,dao.impl.*" pageEncoding="GBK"%>
<% 
	request.setCharacterEncoding("GBK");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	TopicDao topicDao = new TopicDaoImpl();
	User user = (User)session.getAttribute("user");
	int boardId = Integer.parseInt(request.getParameter("boardId"));
	if(user!=null){
		Topic topic = new Topic();
		topic.setTitle(title);
		topic.setContent(content);
		topic.setBoardId(boardId);
		topic.setUserId(user.getUserId());
		topicDao.addTopic(topic);
		response.sendRedirect("list.jsp?page=1&boardId="+boardId);
	}else{
		response.sendRedirect("login.jsp");
	}
%>