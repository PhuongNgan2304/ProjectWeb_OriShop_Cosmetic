<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="update" method="post">
		<label>CartId:</label>
		<input type="text" value="${cart.cartid}" name="cart_id"></br>
		<label>Nhập code giỏ hàng:</label>
		<input type="text" value="${cart.cartcode}" name="cart_code"></br>
		<input type="submit" value="Update cart"> 
	</form>
</body>
</html>