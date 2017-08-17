<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看管理客户</title>
</head>
<body>
<div align="center">
	<a style="float: right;" href="/customer/index.jsp">返回首页</a>
<h3>查看管理客户</h3>
<hr/>
<table border="1" cellpadding="5">
<tr>
<td>客户姓名</td><td>性别</td><td>出生日期</td><td>电话</td><td>邮箱</td><td>客户类型</td><td>操作</td>
</tr>
<c:forEach items="${customerList}" var="customer">
<tr>
<td>${customer.name }</td><td>${customer.gender }</td><td>${customer.birthday }</td><td>${customer.phone }</td><td>${customer.email }</td><td>${customer.type }</td><td><a href="/customer/DeleteCustomerServlet?id=${customer.id }">删除</a> <a href="/customer/DetailCustomerServlet?id=${customer.id }">查看或修改</a></td>
</tr>

</c:forEach>
</table>
</div>
</body>
</html>