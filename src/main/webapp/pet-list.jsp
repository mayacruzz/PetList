<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pet List Results</title>
</head>
<body>
	
		<H1>Pet List Results</H1>
		<form method = "post" action = "navigationServlet">
	<table>
		<c:forEach items="${requestScope.allItems}" var="currentitem">
		<tr>
		<td><input type="radio" name="id" value="${currentitem.id}"></td>
		<td>${currentitem.type}:</td>
		<td>${currentitem.name}:</td>
		<td>${currentitem.age}</td>
		</tr>
	</c:forEach>
	</table>
		<input type = "submit" value = "edit" name="doThisToItem">
		<input type = "submit" value = "delete" name="doThisToItem">
		<input type="submit" value = "add" name = "doThisToItem">
	</form>
</body>
</html>