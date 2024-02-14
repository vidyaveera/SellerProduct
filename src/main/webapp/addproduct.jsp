<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action = "addproduct" method = "post" enctype="multipart/form-data">
 Id: <input type = "text" name = "id"> <br>
 name: <input type = "text" name = "name"> <br>	
 price: <input type = "text" name = "price"> <br>
 brand: <input type = "text" name = "brand"> <br>
 discount: <input type = "text" name = "discount"> <br>
 image:<input type= "file" name ="image">
<input type = "submit">
</form>

</body>
</html>