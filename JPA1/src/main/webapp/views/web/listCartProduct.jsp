<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" style="width:100%">
		<tr>
			<td>Tên sản phẩm</td>
			<td>Số lượng</td>
			<td>Tổng tiền sản phẩm</td>
		</tr>
		<tbody>
		
		<c:forEach var="i" items="${listCart_Products}">
			<tr>
				<td>${i.product.productname}</td>
				<td>${i.quantity}</td>
				<td>${i.totalPrice}</td>
			</tr>
		</c:forEach>
		</tbody>
		<tr>
			<td></td>
			<td>Tổng tiền</td>
			<td>200.000vnđ</td>
		</tr>
	</table>
</body>
</html>