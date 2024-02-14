<html>
<body>
<h2>Hello World!</h2>
</body>

<% String message = (String)request.getAttribute("message"); %>

<% if(message!=null){ %>
<h1> <%= message %></h1>
<% } %>

<a href = "login.jsp">  LOGIN </a> <br>
<a href = "signup.jsp"> SIGNUP </a>


</html>
