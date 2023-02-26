<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>登陆</title>
	</head>
	<body>
		请登录
		<form name = "postForm" onsubmit = "return check()" action = "doLogin.jsp" method = "POST">
			<table>
				<tr>
					<td>用户名：</td>
					<td><input type="text" name = "userName"></td>
				</tr>
				<tr>
					<td>密&nbsp;&nbsp;码：</td>
					<td><input type="text" name = "userPass"></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><input type = "submit" name = "submit" value = "登录"/>&nbsp;
						<input type="reset" value="重置"/>
					</td>
					<td><a href="reg.jsp">注册</a></td>
				</tr>
			</table>
		</form>
	</body>
</html>

