<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<% String msg = (String)request.getAttribute("message"); %>
<% if(msg!=null) {%>
<%= msg %>
<% } %>
<form action = "login" method = "post">

Email: <input type = "text" name = "email"> <br>
password <input type = "text" name = "password"> <br>

<input type = "submit">
</form>
</body>
</html>