<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.xbf.domain.PageCustomer"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分页查看管理客户</title>
</head>
<body>
<div align="center">
	<a style="float: right;" href="index.jsp">返回首页</a>
<h3>查看管理客户</h3>
<hr/>
<table border="1" cellpadding="5">
<tr>
<td>客户姓名</td><td>性别</td><td>出生日期</td><td>电话</td><td>邮箱</td><td>客户类型</td><td>操作</td>
</tr>
<c:forEach items="${customerList}" var="customer">
<tr>
<td>${customer.name }</td><td>${customer.gender }</td><td>${customer.birthday }</td><td>${customer.phone }</td><td>${customer.email }</td><td>${customer.type }</td><td><a href="DeleteCustomerServlet?id=${customer.id }">删除</a> <a href="DetailCustomerServlet?id=${customer.id }">查看或修改</a></td>
</tr>
</c:forEach>
</table>
<div>
<a href="PageCustomerServlet?pageIndex=1&pageSize=10">首页</a>
<c:if test="${pageCustomer.pageIndex!=1}">
<a href="PageCustomerServlet?pageIndex=${pageCustomer.pageIndex-1 }&pageSize=10">上一页</a>
</c:if>
<%	
	PageCustomer pageCustomer = (PageCustomer)request.getAttribute("pageCustomer");
	int pageIndex = pageCustomer.getPageIndex();
	
	int begin =pageIndex-5; 
	if(begin <1){
		begin = 1;
	}
	int end = pageIndex+4;
	if(end >pageCustomer.getTotalPage()){
		end = pageCustomer.getTotalPage();
	}
	
	for(int i = begin;i<=end; i++){
		if(i==pageIndex){
			out.print(i);
		}else{
		%>
		<a href="PageCustomerServlet?pageIndex=<%=i %>&pageSize=10"><%=i %></a>
		<%}
	}
%>
<c:if test="${pageCustomer.pageIndex!=pageCustomer.totalPage}">
<a href="PageCustomerServlet?pageIndex=${pageCustomer.pageIndex+1 }&pageSize=10">下一页</a>
</c:if>
<a href="PageCustomerServlet?pageIndex=${pageCustomer.totalPage }&pageSize=10">尾页</a>
</div>
</div>
</body>
</html>