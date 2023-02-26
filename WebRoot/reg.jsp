<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>注册</title>
	</head>
	<body>
		<h1 style="text-align:center">用户注册</h1>
		<form name = "postForm" onsubmit = "return check()" action = "doReg.jsp" method = "POST">
			<center>
			<table>
				<tr>
					<td align="right">用户名：</td>
					<td><input type="text" name = "userName"></td>
				</tr>
				<tr>
					<td align="right" >密码：</td>
					<td><input type="text" name = "userPass"></td>
				</tr>
				<tr>
					<td align="right">性别：</td>
					<td>男<input type="radio" name="sex">
					女<input type="radio" name="sex">
					</td>
				</tr>
				<tr>
					<td align="right">爱好：</td>
					<td>吃<input type="checkbox" name="mo">
					喝<input type="checkbox" name="mo">
					玩<input type="checkbox" name="mo">
					乐<input type="checkbox" name="mo">
					</td>
				</tr>
				<tr>
					<td align="right">城市：</td>
					<td>北京<input type="radio" name="um">
					上海<input type="radio" name="um">
					天津<input type="radio" name="um">
					宝丰<input type="radio" name="um">
					</td>
				</tr>
				<tr>
				<td align="right">个人介绍：</td>
				<td><textarea style="resize:none" row=10 cole=10></textarea></td>
				</tr>
				<tr>
					<td><input type = "submit" name = "submit" value = "注册"></td>
					<td><a href="login.jsp">去登录>>></a></td>
				</tr>
			</table>
			</center>
		</form>
	</body>
</html>