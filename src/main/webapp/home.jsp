<%@page import="java.util.ArrayList"%>
<%@page import="dao.ProductDao"%>
<%@page import="java.util.Base64"%>
<%@page import="java.util.List"%>
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
<% String name = (String)request.getAttribute("message"); %>
<% String welcome = "hello"+ " "+name; %>
<h1><%= welcome %>  </h1>

<a   href = "addproduct.jsp"> Add products</a><br>

<table>
<tr>
<th>Id</th>
<th>Name</th>
<th>Price</th>
<th>Brand</th>			
<th>Discount</th>
<th>Image</th>
<th>Delete</th>
<th>Edit</th>
</tr>
<% dao.ProductDao pdao = new dao.ProductDao(); 
  List<dto.ProductDto> product = pdao.getAll();
%>
<% List<ProductDto> products = (List)pdao.getAll(); %>
<%for(ProductDto p : products) {%>

<tr>
<td><%= p.getId() %></td>
<td><%= p.getName()  %></td>
<td><%= p.getPrice() %></td>
<td><%= p.getBrand() %></td>
<td><%= p.getDiscount() %></td>
<% String base64image = new String(Base64.getEncoder().encode(p.getImage())); %>
<td><img src= "data:image/jpeg;base64, <%= base64image %>" height="100px" width = "100px" src = ""> </td>


<td><a href = "delete?id=<%= p.getId()%>">Delete</a></td>
<td><a href = "edit?id= <%= p.getId() %>">Edit</a></td>

</tr>
<% } %>
</table>
<a  href = "logout"> </a>
</body>
</html>