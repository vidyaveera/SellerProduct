<%@page import="java.util.Base64"%>
<%@page import="dto.ProductDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 
<% ProductDto p = (ProductDto)request.getAttribute("product"); %>

<form action = "edit" method = "post" enctype="multipart/form-data">
 Id: <input type = "text" name = "id" value= "<%= p.getId() %>"> <br>
 name: <input type = "text" name = "name" value ="">  <%= p.getName() %> <br>	
 price: <input type = "text" name = "price"> <%= p.getPrice() %><br>
 brand: <input type = "text" name = "brand"><%= p.getBrand()%> <br>
 discount: <input type = "text" name = "discount"> <%= p.getDiscount() %><br>
 image:<input type= "file" name ="image">
 
 <% String base64image = new String(Base64.getEncoder().encode(p.getImage())); %>
 <td><img src= "data:image/jpeg;base64, <%= base64image %>" height="100px" width = "100px" src = ""> </td>
 
<input type = "submit">
 </form>


</body>
</html>