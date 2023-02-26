<%@ page language="java" import="java.util.*,dao.*,entity.*,dao.impl.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
TopicDao topicDao = new TopicDaoImpl();
ReplyDao replyDao = new ReplyDaoImpl();
UserDao userDao = new UserDaoImpl();
BoardDao boardDao = new BoardDaoImpl();
int boardId = Integer.parseInt(request.getParameter("boardId"));
int p = Integer.parseInt(request.getParameter("page"));
List listTopic = topicDao.findListTopic(p,boardId);
Board board = boardDao.findBoard(boardId);
int prep = p;
int nextp = p;
if(listTopic.size() == 20){
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
		<title>帖子列表</title>
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
		<a href="index.jsp">>>论坛首页</a><br><br>
		<a href="list.jsp?page=1&boardId=<%=boardId %>"><%=board.getBoardName() %></a><br>
		<a href="post.jsp?boardId=<%=boardId %>">发表话题</a><br>
		<a href="list.jsp?page=<%=prep %>&boardId=<%=boardId%>">上一页</a>|<a href="list.jsp?page=<%=nextp %>&boardId=<%=boardId%>">下一页</a>
		<form>
			<table border='1' cellspacing='0' align='center' width="100%"  >
				<tr height='50px' width="100%">
				</tr>
				<tr >
					<td width='3%'></td>
					<td width="80%" align='center'>文章</td>
					<td width="10%" align='center'>作者</td>
					<td width="7%" align='center'>回复</td>
				</tr>
				<% 
					for(int i = 0; i < listTopic.size();i++){
						Topic topic = (Topic)listTopic.get(i);
						User user = userDao.findUser(topic.getUserId());
				 %>
				<tr>
					<td></td>
					<td><a href = "detail.jsp?page=<%=prep %>&boardId=<%=boardId%>&topicId=<%=topic.getTopicId() %>"><%=topic.getTitle() %></a></td>
					<td><%=user.getUserName() %></td>
					<td><%=replyDao.findCountReply(topic.getTopicId()) %></td>
				</tr>
				<%
					}
				 %>
			</table>
		</form><br>
		<a href="list.jsp?page=<%=prep %>&boardId=<%=boardId%>">上一页</a>|<a href="list.jsp?page=<%=nextp %>&boardId=<%=boardId%>">下一页</a>
	</body>
</html>