<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Page</title>
</head>
<body>
	<h1>Edit Page For Pet List</h1>
	<form action = "editItemServlet" method="post">
		Type: <input type ="text" name = "type" value= "${itemToEdit.type}">
		Name: <input type = "text" name = "name" value= "${itemToEdit.name}">
		Age: <input type ="number" name = "age" value= "${itemToEdit.age}">
		<input type = "hidden" name = "id" value="${itemToEdit.id}">
		<input type = "submit" value="Save Edited Item">
	</form>

</body>
</html>