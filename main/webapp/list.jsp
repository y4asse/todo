<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="constant.Parameters, java.util.List, java.util.ArrayList, model.dao.dto.TodoDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo List</title>
</head>
<body>
	<form action="insert-servlet" method="post">
	<label>Todo: </label><input type="text" name="<%=Parameters.TODO %>"><br>
	<label>Limit: </label><input type="date" name="<%=Parameters.TIME_LIMIT %>"> <br>
	<input type="submit" value="Todoを登録する">
	<form>	
	<%
		List<TodoDTO> todoList = (List) request.getAttribute("todoList");
	%>

	<% for(TodoDTO todo: todoList){  %>
		<%=todo.getTodo() %> 期限：<%=todo.getTimeLimit() %><br>
	<% } %>

</body>
</html>