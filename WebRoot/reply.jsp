<%@ page language="java" import="java.util.*,dao.*,entity.*,dao.impl.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int topicId = Integer.parseInt(request.getParameter("topicId"));
int boardId = Integer.parseInt(request.getParameter("boardId"));
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>回帖</title>
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
		<a href="index.jsp">>>论坛首页</a><a href="login.jsp">>>c#语言</a><br><br>
		回复帖子
		<form name = "postForm" onsubmit = "return check()" action = "doReply.jsp" method = "POST">
			<input type="hidden" name="topicId" value="<%=topicId %>">
			<input type="hidden" name="boardId" value="<%=boardId %>">
			<table align="center" width="80%">
				<tr>
					<td width="20%" align="right">标题</td>
					<td width="80%"><input name = "title"></input></td>
				</tr>
				<tr>
					<td align="right">内容</td>
					<td><input name = "content" ></input><br>
				<input type = "submit" name = "submit" value = "tijiao"></td>
				</tr>
			</table>
		</form>
	</body>
</html>
