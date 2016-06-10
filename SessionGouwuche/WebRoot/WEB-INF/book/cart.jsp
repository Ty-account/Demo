<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>购物车</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
 <style type="text/css">
 	tr{
 		text-align:center;
 	}
 	table{
 	border-collapse:collapse;
 	}
 </style>
  </head>
  		<table border="1px" width="1000px" align="center">
  			<caption><b>书本的详细信息</b></caption>
  			<tr>
  				<td>书本的id</td>
  				<td>书本的标题</td>
  				<td>书本的版本</td>
  				<td>书本的版权</td>
  				<td>书本的出版商ID</td>
  				<td>书本的图片</td>
  				<td>书本的价格</td>
  				<td>数量</td>
  			</tr>
  			<c:forEach var="books" items="${cartItem}">
	  			<tr>
	  				<td>${books.value.bookBean.isbn}</td>
	  				<td>${books.value.bookBean.title}</td>
	  				<td>${books.value.bookBean.editionNumber}</td>
	  				<td>${books.value.bookBean.copyright}</td>
	  				<td>${books.value.bookBean.publisherID}</td>
	  				<td><img src="images/${books.value.bookBean.imageFile}"/></td>
	  				<td>${books.value.bookBean.price}</td>
	  				<td>${books.value.count}</td>
	  			</tr>
  			</c:forEach>
  		</table>
  		
  </body>
</html>
