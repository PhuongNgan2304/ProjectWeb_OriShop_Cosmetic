<%@include file="/commons/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url value="/template/web/static" var="url"></c:url>

<!--=== Shop Product ===-->
<div class="shop-product">
	<!-- Breadcrumbs v5 -->
	<div class="container">
		<ul class="breadcrumb-v5">
			<li><a href="${pageContext.request.contextPath }"><i
					class="fa fa-home"></i></a></li>
			<li><a href="${pageContext.request.contextPath }/product-grid">Sản
					phẩm</a></li>
			<li class="active">Chi tiết sản phẩm</li>
		</ul>
	</div>

	<b style="color: green">${ thongbao}</b>

	<!-- End Breadcrumbs v5 -->

	<div class="container">
		<div class="row">
			<div class="col-md-6 md-margin-bottom-50">
				<div class="ms-showcase2-template">
					<!-- Master Slider -->
					<div class="master-slider ms-skin-default"
						id="masterslider${product.productid}">
						<div class="ms-slide">
							<%-- <c:url value="/uploads/products?fname=${product.images}" var="imgUrl"></c:url> --%>
							<c:url value="/image?fname=products/${product.images}"
								var="imgUrl"></c:url>
							<img class="ms-brd" src="${imgUrl}" width="100%"
								data-src="${url}/img/blank.gif" alt="${product.productname }">

						</div>


					</div>
					<!-- End Master Slider -->
				</div>
			</div>

			<div class="col-md-6">
				<div class="shop-product-heading">
					<h2>${product.productname }</h2>
					<ul class="list-inline shop-product-social">
						<li><a href="#"><i class="fa fa-facebook"></i></a></li>
						<li><a href="#"><i class="fa fa-twitter"></i></a></li>
						<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
						<li><a href="#"><i class="fa fa-pinterest"></i></a></li>
					</ul>
				</div>
				<!--/end shop product social-->

				<ul class="list-inline product-ratings margin-bottom-30">
					<li><i class="rating-selected fa fa-star"></i></li>
					<li><i class="rating-selected fa fa-star"></i></li>
					<li><i class="rating-selected fa fa-star"></i></li>
					<li><i class="rating fa fa-star"></i></li>
					<li><i class="rating fa fa-star"></i></li>
					<li class="product-review-list"><span>(1) <a href="#">Đã
								đánh giá</a> | <a href="#"> Thêm đánh giá</a></span></li>
					<li class=""><span>| (${product.amount }) Đã bán </span></li>
				</ul>
				<!--/end shop product ratings-->
				<%-- ${product.des } <br> --%>
				<ul class="list-inline shop-product-prices margin-bottom-30">
					<li class="shop-red">$ ${product.price }.0</li>
					<li class="line-through">${product.price * 1.25 }</li>
					<li><small class="shop-bg-red time-day-left"> Best
							Sale </small></li>
				</ul>
				<!--/end shop product prices-->
				<h3 style = "font-weight:bold;  color: green" class="shop-product-title">Product Type: ${product.product_types.typename }</h3>
				<h3 style = "font-weight:bold;  color: green" class="shop-product-title">Skin: ${product.skins.skinname }</h3>
				<h3 style = "font-weight:bold;  color: green" class="shop-product-title">Supplier: ${product.suppliers.suppliername }</h3>
				<h3 style = "font-weight:bold;  color: purple" class="shop-product-title">Description: ${product.description }</h3>
					
				

				<!--/end product size-->

				<h3 class="shop-product-title">Giỏ hàng</h3>
				<%-- <select style="width: 200px; height: 30px">
					<c:forEach var="item" items="${listcartuser}">
						<option value=${item.cartid }>${item.cartcode}</option>
					</c:forEach>
				</select> <a href='<c:url value="/cart"/>'>Tạo giỏ hàng mới</a> --%>

				<!--/end product color-->


				<div class="margin-bottom-40">

					<form name="f1" class="product-quantity sm-margin-bottom-20"
						method="post"
						action="<c:url value="/Cart_Product/insert?productid=${product.productid }"></c:url>">

						<select name="giohang" style="width: 200px; height: 30px">

							<c:forEach var="item" items="${listcartuser}">
								<c:if test="${item.active==true}">
									<option value=${item.cartid }>${item.cartcode}</option>
								</c:if>
								
							</c:forEach>
						</select> <a href='<c:url value="/cart"/>'>Tạo giỏ hàng mới</a> <br></br>
						<h3 class="shop-product-title">Số lượng</h3>


						<input type="text" value="${product.productid}" name="pId"
							hidden="">
						<button type='button' class="quantity-button" name='subtract'
							onclick='javascript: subtractQty();' value='-'>-</button>
						<input type='text' class="quantity-field" name='quantity'
							value="1" id='qty' />
						<button type='button' class="quantity-button" name='add'
							onclick='javascript: document.getElementById("qty").value++;'
							value='+'>+</button>
						<button type="submit" class="btn-u btn-u-sea-shop btn-u-lg">Thêm
							vào giỏ hàng</button>
					</form>


				</div>
				<br /> <br />
				<!--/end product quantity-->

				<ul class="list-inline add-to-wishlist add-to-wishlist-brd">
					<li class="wishlist-in"><i class="fa fa-heart"></i> <a
						href="#">Add to Wishlist</a></li>
					<li class="compare-in"><i class="fa fa-exchange"></i> <a
						href="#">Add to Compare</a></li>
				</ul>
				<%-- <p class="wishlist-category">
							<strong>Danh mục:</strong> <a href="#">
							${product.category.name }</a> - Cửa hàng: <a href="#">${product.isseller.sell_name}</a>
						</p> --%>
			</div>
		</div>
		<!--/end row-->
	</div>
</div>
<!--=== End Shop Product ===-->

<%-- <!--=== Content Medium ===-->
<div class="container">
	<div class="tab-v5">
		<ul class="nav nav-tabs" role="tablist">
			<li class="active"><a href="#description" role="tab"
				data-toggle="tab">Mô tả</a></li>
			<li><a href="#reviews" role="tab" data-toggle="tab">Đánh giá
					(1)</a></li>
		</ul>

		<div class="tab-content">
			<!-- Description -->
			<div class="tab-pane fade in active" id="description">
				<div class="row">
					<div class="col-md-7">
						<p>${product.des }</p>
					</div>

				</div>
			</div>
			<!-- End Description -->

			<!-- Reviews -->
			<div class="tab-pane fade" id="reviews">
				<div class="product-comment margin-bottom-40">
					<div class="product-comment-in">
						<img class="product-comment-img rounded-x"
							src="${url}/img/team/01.jpg" alt="">
						<div class="product-comment-dtl">
							<h4>
								Mickel <small>22 days ago</small>
							</h4>
							<p>I like the green colour, it's very likeable and reminds me
								of Hollister. A little loose though but I am very skinny</p>
							<ul class="list-inline product-ratings">
								<li class="reply"><a href="#">Reply</a></li>
								<li class="pull-right">
									<ul class="list-inline">
										<li><i class="rating-selected fa fa-star"></i></li>
										<li><i class="rating-selected fa fa-star"></i></li>
										<li><i class="rating-selected fa fa-star"></i></li>
										<li><i class="rating fa fa-star"></i></li>
										<li><i class="rating fa fa-star"></i></li>
									</ul>
								</li>
							</ul>
						</div>
					</div>
				</div>
				<h3 class="heading-md margin-bottom-30">Add a review</h3>
				<form action="${url}/php/demo-contacts-process.php" method="post"
					id="sky-form3" class="sky-form sky-changes-4">
					<fieldset>
						<div class="margin-bottom-30">
							<label class="label-v2">Name</label> <label class="input">
								<input type="text" name="name" id="name">
							</label>
						</div>

						<div class="margin-bottom-30">
							<label class="label-v2">Email</label> <label class="input">
								<input type="email" name="email" id="email">
							</label>
						</div>

						<div class="margin-bottom-30">
							<label class="label-v2">Review</label> <label class="textarea">
								<textarea rows="7" name="message" id="message"></textarea>
							</label>
						</div>
					</fieldset>

					<footer class="review-submit">
						<label class="label-v2">Review</label>
						<div class="stars-ratings">
							<input type="radio" name="stars-rating" id="stars-rating-5">
							<label for="stars-rating-5"><i class="fa fa-star"></i></label> <input
								type="radio" name="stars-rating" id="stars-rating-4"> <label
								for="stars-rating-4"><i class="fa fa-star"></i></label> <input
								type="radio" name="stars-rating" id="stars-rating-3"> <label
								for="stars-rating-3"><i class="fa fa-star"></i></label> <input
								type="radio" name="stars-rating" id="stars-rating-2"> <label
								for="stars-rating-2"><i class="fa fa-star"></i></label> <input
								type="radio" name="stars-rating" id="stars-rating-1"> <label
								for="stars-rating-1"><i class="fa fa-star"></i></label>
						</div>
						<button type="button"
							class="btn-u btn-u-sea-shop btn-u-sm pull-right">Submit</button>
					</footer>
				</form>
			</div>
			<!-- End Reviews -->
		</div>
	</div>
</div>
<!--/end container-->
<!--=== End Content Medium ===-->

<!--=== Illustration v2 ===-->
<div class="container">
	<div class="heading heading-v1 margin-bottom-20">
		<h2>Product you may like</h2>
		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed
			odio elit, ultrices vel cursus sed, placerat ut leo. Phasellus in
			magna erat. Etiam gravida convallis augue non tincidunt. Nunc
			lobortis dapibus neque quis lacinia. Nam dapibus tellus sit amet odio
			venenatis</p>
	</div>

	<div class="illustration-v2 margin-bottom-60">
		<div class="customNavigation margin-bottom-25">
			<a class="owl-btn prev rounded-x"><i class="fa fa-angle-left"></i></a>
			<a class="owl-btn next rounded-x"><i class="fa fa-angle-right"></i></a>
		</div>

		<ul class="list-inline owl-slider-v4">
			<li class="item"><a href="#"><img class="img-responsive"
					src="${url}/img/thumb/09.jpg" alt=""></a>
				<div class="product-description-v2">
					<div class="margin-bottom-5">
						<h4 class="title-price">
							<a href="#">Double-breasted</a>
						</h4>
						<span class="title-price">$95.00</span>
					</div>
					<ul class="list-inline product-ratings">
						<li><i class="rating-selected fa fa-star"></i></li>
						<li><i class="rating-selected fa fa-star"></i></li>
						<li><i class="rating-selected fa fa-star"></i></li>
						<li><i class="rating fa fa-star"></i></li>
						<li><i class="rating fa fa-star"></i></li>
					</ul>
				</div></li>
			<li class="item"><a href="#"><img class="img-responsive"
					src="${url}/img/thumb/07.jpg" alt=""></a>
				<div class="product-description-v2">
					<div class="margin-bottom-5">
						<h4 class="title-price">
							<a href="#">Double-breasted</a>
						</h4>
						<span class="title-price">$60.00</span> <span
							class="title-price line-through">$95.00</span>
					</div>
					<ul class="list-inline product-ratings">
						<li><i class="rating-selected fa fa-star"></i></li>
						<li><i class="rating-selected fa fa-star"></i></li>
						<li><i class="rating-selected fa fa-star"></i></li>
						<li><i class="rating fa fa-star"></i></li>
						<li><i class="rating fa fa-star"></i></li>
					</ul>
				</div></li>
			<li class="item"><a href="#"><img class="img-responsive"
					src="${url}/img/thumb/08.jpg" alt=""></a>
				<div class="product-description-v2">
					<div class="margin-bottom-5">
						<h4 class="title-price">
							<a href="#">Double-breasted</a>
						</h4>
						<span class="title-price">$95.00</span>
					</div>
					<ul class="list-inline product-ratings">
						<li><i class="rating-selected fa fa-star"></i></li>
						<li><i class="rating-selected fa fa-star"></i></li>
						<li><i class="rating-selected fa fa-star"></i></li>
						<li><i class="rating fa fa-star"></i></li>
						<li><i class="rating fa fa-star"></i></li>
					</ul>
				</div></li>
			<li class="item"><a href="#"><img class="img-responsive"
					src="${url}/img/thumb/06.jpg" alt=""></a>
				<div class="product-description-v2">
					<div class="margin-bottom-5">
						<h4 class="title-price">
							<a href="#">Double-breasted</a>
						</h4>
						<span class="title-price">$95.00</span>
					</div>
					<ul class="list-inline product-ratings">
						<li><i class="rating-selected fa fa-star"></i></li>
						<li><i class="rating-selected fa fa-star"></i></li>
						<li><i class="rating-selected fa fa-star"></i></li>
						<li><i class="rating fa fa-star"></i></li>
						<li><i class="rating fa fa-star"></i></li>
					</ul>
				</div></li>
			<li class="item"><a href="#"><img class="img-responsive"
					src="${url}/img/thumb/04.jpg" alt=""></a>
				<div class="product-description-v2">
					<div class="margin-bottom-5">
						<h4 class="title-price">
							<a href="#">Double-breasted</a>
						</h4>
						<span class="title-price">$95.00</span>
					</div>
					<ul class="list-inline product-ratings">
						<li><i class="rating-selected fa fa-star"></i></li>
						<li><i class="rating-selected fa fa-star"></i></li>
						<li><i class="rating-selected fa fa-star"></i></li>
						<li><i class="rating fa fa-star"></i></li>
						<li><i class="rating fa fa-star"></i></li>
					</ul>
				</div></li>
			<li class="item"><a href="#"><img class="img-responsive"
					src="${url}/img/thumb/03.jpg" alt=""></a>
				<div class="product-description-v2">
					<div class="margin-bottom-5">
						<h4 class="title-price">
							<a href="#">Double-breasted</a>
						</h4>
						<span class="title-price">$95.00</span>
					</div>
					<ul class="list-inline product-ratings">
						<li><i class="rating-selected fa fa-star"></i></li>
						<li><i class="rating-selected fa fa-star"></i></li>
						<li><i class="rating-selected fa fa-star"></i></li>
						<li><i class="rating fa fa-star"></i></li>
						<li><i class="rating fa fa-star"></i></li>
					</ul>
				</div></li>
		</ul>
	</div>
</div> --%>
<!--=== End Illustration v2 ===-->

<script src="${url}/js/plugins/master-slider.js"></script>
<script src="${url}/js/forms/product-quantity.js"></script>
