<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>添加客户</title>
	</head>
	<body>
	<div align="center">
	<a style="float: right;" href="/customer/index.jsp">返回首页</a>
		<h3>添加客户</h3>
		<hr/>
		<form action="/customer/AddCustomer" method="post">
		<table>
			<tr>
				<td>姓名</td><td><input name="name" type="text" /></td>
			</tr>
			<tr>
			<td>性别</td>
			<td>
						<input type="radio" name="gender" value="male">男
						<input type="radio" name="gender" value="female">女
			</td>
			</tr>
			<tr><td>出生日期</td><td><input name="birthday" type="text" /></td>
			</tr>
			<tr>
				<td>客户类型</td>
				<td>
					<input type="radio" name="type" value="普通客户" />普通客户
					<input type="radio" name="type" value="vip" />vip
					<input type="radio" name="type" value="高级vip" />高级vip
				</td>
			</tr>
			<tr>
				<td>电话</td><td><input name="phone" type="text" /></td>
			</tr>
			<tr>
				<td>邮箱</td><td><input name="email"  type="text" /></td>
			</tr>
			<tr>
				<td>地址</td><td><input name="address" type="text" /></td>
			</tr>
			<tr>
				<td>爱好</td>
				<td>
					<input type="checkbox" name="hobbies" value="音乐" />音乐
					<input type="checkbox" name="hobbies" value="旅行" />旅行
					<input type="checkbox" name="hobbies" value="读书" />读书
				</td>
			</tr>
			<tr>
				<td>描述</td><td><textarea name="description" rows="5" cols="20"></textarea></td>
			</tr>
			<tr>
				<td></td><td><input type="submit" value="添加客户" /></td>
			</tr>
		</table>
		</form>
		</div>
	</body>
</html>