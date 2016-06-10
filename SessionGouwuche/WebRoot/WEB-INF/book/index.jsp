<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书首页</title>
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
  		<table border="1px" width="800px" align="center">
  			<tr>
		    	<c:forEach var="book" items="${sessionScope.booklist}" varStatus="status">
		    		<td>
		    			${book.title}<br>
		    			<a href="BookAction?action=one&isbn=${book.isbn}">
		    				<img src="images/${book.imageFile}" title="${book.title}"/>
		    			</a>
		    		</td>
		    		<c:if test="${(status.index+1)%3==0}">
		    			</tr>
		    				
		    			<tr>
		    		</c:if>
		    	</c:forEach>
  			</tr>
  		</table>
  </body>
</html>
