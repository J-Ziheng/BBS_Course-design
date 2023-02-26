<%@ page language="java" import="java.util.*,dao.*,entity.*,dao.impl.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
TopicDao topicDao = new TopicDaoImpl();
ReplyDao replyDao = new ReplyDaoImpl();
UserDao userDao = new UserDaoImpl();
BoardDao boardDao = new BoardDaoImpl();
int boardId = Integer.parseInt(request.getParameter("boardId"));
int topicId = Integer.parseInt(request.getParameter("topicId"));
int p = Integer.parseInt(request.getParameter("page"));
Board board = boardDao.findBoard(boardId);
Topic topic = topicDao.findTopic(topicId);
User user = userDao.findUser(topic.getUserId());
List listReply = replyDao.findListReply(p,topicId);
int prep = p;
int nextp = p;
if(listReply.size() == 20){
	nextp = p+1;
}
if(p>1){
	prep = p-1;
}

%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>帖子信息</title>
	</head>
	<body>
		<h1 style="text-align:center">校园BBS</h1><br>
		<%
			if(session.getAttribute("user")==null){
		 %>
		您尚未<a href="login.jsp">登录</a>丨<a href="reg.jsp">注册</a><br>
		<%
			}else{
				User loginUser = (User)session.getAttribute("user");
		 %>
		 	您好：<%=loginUser.getUserName() %>|<a href="doLogout.jsp">登出</a>
		 <%
		 	}
		  %>
		<a href="index.jsp">>>论坛首页</a><a href="list.jsp?page=1&boardId=<%=boardId %>"><%=board.getBoardName() %></a><br><br>
		<a href="reply.jsp?boardId=<%=boardId %>&topicId=<%=topicId %>">回复帖子</a><br>
		<a href="post.jsp?boardId=<%=boardId %>">发表话题</a>
		<a href="detail.jsp?page=<%=prep %>&boardId=<%=boardId%>&topicId=<%=topicId %>">上一页</a>|<a href="detail.jsp?page=<%=nextp %>&boardId=<%=boardId%>&topicId=<%=topicId %>">下一页</a><br>
		本页主题：<%=topic.getTitle() %>
		<form>
		<%
		if(p==1){
		
		 %>			

			<table border='1' cellspacing='0' align='center' width="100%">

				<tr>
					<td width="20%"><%=user.getUserName() %><br>
					<%=user.getUserPass() %><br>
					注册：【2007-07-31-8：37】</td>
					<td width="80%">
					<%=topic.getTitle() %><br>
					<%=topic.getContent() %>
					
					</td>
				</tr>
				
			</table>
						<%
			for(int i = 0; i <listReply.size();i++){ 
				Reply reply = (Reply)listReply.get(i);
				User replyUser = (User)userDao.findUser(reply.getUserId());
			%>
			<table border='1' cellspacing='0' align='center' width="100%">
				<tr>
					<td width="20%"><%= replyUser.getUserName() %>
					<br>
					注册：【2007-07-31-10：32】</td>
					<td width="80%"><%=reply.getTitle() %><br>
					<%=reply.getContent() %><br>
					发表：【2007-07-31-10：32】最后修改：【2007-07-31-10：32】</td>
				</tr>
			</table><%} %>
			<a href="detail.jsp?page=<%=prep %>&boardId=<%=boardId%>&topicId=<%=topicId %>">上一页</a>|<a href="detail.jsp?page=<%=nextp %>&boardId=<%=boardId%>&topicId=<%=topicId %>">下一页</a><br>
		</form>
		<%} %>
	</body>
</html>
