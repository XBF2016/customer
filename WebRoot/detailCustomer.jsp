<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看或修改</title>
</head>
<body>
<div align="center">
<a style="float: right;" href="index.jsp">返回首页</a>
		<h3>客户详细信息</h3>
		<hr/>
		<form action="/customer/UpdateCustomerServlet" method="post">
		<table>
			<tr>
				<td>编号</td><td>${customer.id }<input type="hidden"  name="id" value="${customer.id }"/></td>
			</tr>
			<tr>
				<td>姓名</td><td><input name="name" type="text" value="${customer.name }"/></td>
			</tr>
			<tr>
			<td>性别</td>
			<td>
						<input type="radio" name="gender" value="male" 
						<c:if test="${customer.gender == 'male' }">
						  checked="checked" 
						</c:if>						  
						  />男
						
						<input type="radio" name="gender" value="female"  
						<c:if test="${customer.gender == 'female' }">
						  checked="checked" 
						</c:if>				
						/>女
			</td>
			</tr>
			<tr><td>出生日期</td><td><input name="birthday" type="text"  value="${customer.birthday }"/></td>
			</tr>
			<tr>
				<td>类型</td>
				<td>
					<input type="radio" name="type" value="普通客户" 
					<c:if test="${customer.type == '普通客户' }">
						  checked="checked" 
						</c:if>				 
					/>普通客户
					<input type="radio" name="type" value="vip"  
					<c:if test="${customer.type == 'vip' }">
						  checked="checked" 
						</c:if>				
					 />vip
					<input type="radio" name="type" value="高级vip" 
						<c:if test="${customer.type == '高级vip' }">
						  checked="checked" 
						</c:if>				
					  />高级vip
				</td>
			</tr>
			<tr>
				<td>电话</td><td><input name="phone" type="text" value="${customer.phone }"/></td>
			</tr>
			<tr>
				<td>邮箱</td><td><input name="email" type="text" value="${customer.email }"/></td>
			</tr>
			<tr>
				<td>地址</td><td><input name="address" type="text"  value="${customer.address }"/></td>
			</tr>
			<tr>
				<td>爱好</td>
				<td>
					<input type="checkbox" name="hobbies" value="音乐"  
					<c:if test="${customer.hobbies == '音乐' }">
						  checked="checked" 
						</c:if>				
					  />音乐
					<input type="checkbox" name="hobbies" value="旅行"   	
					<c:if test="${customer.hobbies == '旅行' }">
						  checked="checked" 
						</c:if>	
					  	/>旅行
					<input type="checkbox" name="hobbies" value="读书" 
						<c:if test="${customer.hobbies == '读书' }">
						  checked="checked" 
						</c:if>	
					 />读书
				</td>
			</tr>
			<tr>
				<td>描述</td><td><textarea name="description" rows="5" cols="20" >${ customer.description}</textarea></td>
			</tr>
			<tr>
				<td></td><td><input type="submit" value="保存修改"></td>
			</tr>
		</table>
		</form>
		</div>
</body>
</html>