<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ page import="java.lang.Math" %>



<!--=== Breadcrumbs v4 ===-->
<div class="breadcrumbs-v4">
	<div class="container">
		<span class="page-name">Thanh toán</span>
		<h1>
			Bạn còn <span class="shop-green">bước cuối cùng</span> để hoàn tất
		</h1>
		<b style="color: green">${ thongbao}</b>
		<ul class="breadcrumb-v4-in">
			<li><a href="${pageContext.request.contextPath}/home">Trang
					chủ</a></li>
			<li><a href="${pageContext.request.contextPath}/product-grid">Sản
					phẩm</a></li>
			<li class="active">Giỏ hàng của bạn</li>
		</ul>
	</div>
	<!--/end container-->
</div>
<!--=== End Breadcrumbs v4 ===-->

<!--=== Content Medium Part ===-->
<div class="content-md margin-bottom-30">
	<div class="container">
			<div>
				<div class="header-tags">
					<div class="overflow-h">
						<h2>Giỏ hàng của bạn</h2>
						<p>Xem &amp; kiểm tra sản phẩm của bạn đã chọn</p>
						<i class="rounded-x fa fa-check"></i>
					</div>
				</div>
				<section>
				<a href = '<c:url value = "/cart/insert"/>'>Thêm giỏ hàng</a>
					<div class="table-responsive">
						<table class="table table-striped">
							<thead>
								<tr>
									
									
									<td>CartCode</td>
									<td>Số lượng sản phẩm</td>
									<td>Chi tiết</td>

								</tr>
							</thead>
							<tbody>
								<c:set var="temp" value="0" />
								<c:forEach var="i" items="${listCarts}">
									
									<c:if test="${i.active==true}">
										<tr>
									
										<td>${i.cartcode}</td>
										<td>
											${number_of_cp.get(temp)}
											<c:set var="temp" value="${temp+1}" /> 
										</td>
										<td><a href="/JPA1/findAllCart_Product?CartId=${i.cartid}">Xem chi tiết</a></td>
										<td><a href="<c:url value="/cart/update?CartId=${i.cartid }"> </c:url>">Update</a> || <a href="/JPA1/cart/delete?CartId=${i.cartid }">Delete</a>||<a href="/JPA1/findAll">Mua sắm</a> </td>
										
									</tr>
									
									</c:if>

									
								</c:forEach>

							</tbody>
						</table>
					</div>
				</section>




			</div>	
				
	</div>
	<!--/end container-->
</div>
<!--=== End Content Medium Part ===-->





<!-- JS Page Level -->
<script src="${url}/js/shop.app.js"></script>
<script src="${url}/js/forms/page_login.js"></script>
<script src="${url}/js/plugins/stepWizard.js"></script>
<script src="${url}/js/forms/product-quantity.js"></script>
<script>
	jQuery(document).ready(function() {
		App.init();
		Login.initLogin();
		App.initScrollBar();
		StepWizard.initStepWizard();
		StyleSwitcher.initStyleSwitcher();
	});
</script>

