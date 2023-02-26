<%@ page language="java" import="java.util.*,dao.*,entity.*,dao.impl.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
BoardDao boardDao = new BoardDaoImpl();
TopicDao topicDao = new TopicDaoImpl();
Map mapBoard = boardDao.findBoard();
UserDao userDao = new UserDaoImpl();
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>首页</title>
	</head>
	<body>
		<h1 style="text-align:center">校园BBS系统</h1><br>
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
		<form method='post'>
			<table border='1' cellspacing='0' align='center' width="100%"  style="table-layout:fixed">
				<tr height='50px'>
					<td style="width: 90px;">论坛</td>
					<td style="width: 400px;"></td>
					<td style="width: 90px;">主题</td>
					<td >最后发表</td>
				</tr>
				<%
					List listMainBoard = (List)mapBoard.get(0);
					for(int i=0;i < listMainBoard.size();i++){
						Board mainBoard = ((Board)listMainBoard.get(i));
				 %>
				<tr height='50px'>
					<td><%=mainBoard.getBoardName() %></td>
				</tr>
				<% 
					List listSonBoard = (List)mapBoard.get(new Integer(mainBoard.getBoardId()));
					for(int j=0;j<listSonBoard.size();j++){
						Board sonBoard = (Board)listSonBoard.get(j);
						int boardId = sonBoard.getBoardId();
						/*Topic topic = new Topic();
						User user = new User();
						int boardId = sonBoard.getBoardId();
						List listTopic = (List)topicDao.findListTopic(1,boardId);
						if(listTopic != null && listTopic.size()>0){
							topic = (Topic)listTopic.get(0);
							user = userDao.findUser(topic.getUserId());
						}*/
				 %>
				<tr height='50px'>
					<td></td>
					<td><A href="list.jsp?page=1&boardId=<%=boardId%>"><%=sonBoard.getBoardName() %></A></td>
					<td></td>
					<td></td>
				</tr>
				<%
						}
					} 
				%>
			</table>
		</form>
	</body>
</html>