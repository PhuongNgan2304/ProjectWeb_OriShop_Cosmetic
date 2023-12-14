<%@include file="/commons/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container mb-4">
	<form action="/JPA1/order/insert?cartid=${cart.cartid}" method="post"
		class="order_form">
		<div class="mb-3">
			<label for="exampleFormControlInput1" class="form-label">Họ
				và tên</label> <input type="text" class="form-control"
				id="exampleFormControlInput1" placeholder="Nhập họ và tên">
		</div>

		<div class="mb-3">
			<label for="exampleFormControlInput1" class="form-label">Địa
				chỉ</label> <input type="text" class="form-control" name="address"
				id="exampleFormControlInput1" placeholder="Nhập địa chỉ">
		</div>

		<div class="mb-3">
			<label for="exampleFormControlInput1" class="form-label">Số
				điện thoại</label> <input type="text" class="form-control"
				id="exampleFormControlInput1" placeholder="Nhập số điện thoại">
		</div>

		<h3>Sản phẩm đã đặt</h3>
		<table class="table table-striped">
			<thead>
				<tr>
					<!-- <th scope="col"></th> -->
					<th scope="col">Product</th>
					<th scope="col" class="text-center">Quantity</th>
					<th scope="col" class="text-right">Price</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${cart.cart_product}">
					<tr>
						<%-- <c:url value="/image?fname=products/${item.product.images}"
							var="imgUrl"></c:url>
						<td class="product-in-table"><img class="img-responsive"
							src="${imgUrl}" alt=""> --%>
						<td>${item.product.productname }</td>
						<td class="text-center">${item.quantity }</td>
						<td class="text-right">$ ${item.totalPrice }</td>
					</tr>
				</c:forEach>
		</table>
		<div class="col-sm-3 col-sm-offset-5">
			<ul class="list-inline total-result">


				<li class="divider"></li>
				<li class="total-price">
					<h4>
						Total:
						<div class="total-result-in">
							<span>$ ${totalPrice }</span>
						</div>
					</h4>

				</li>

			</ul>
		</div>

		<div class="col mb-2">
			<div class="row">
				<div class="col-sm-12 col-md-6 text-right">
					<button class="btn btn-lg btn-block btn-success text-uppercase"
						type="submit">Xác nhận</button>
				</div>
			</div>
		</div>

	</form>
	<form action="/JPA1/findAll" style="position: relative;">
		<button
			style="position: absolute; right: 0; bottom: 0px; width: 500px; height: 45px; background: pink"
			class="btn btn-block btn-light" type="submit">Continue
			Shopping</button>
	</form>


</div>