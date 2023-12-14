<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/commons/taglib.jsp"%>
<c:url value="/template/web/static" var="url"></c:url>


<!--=== Breadcrumbs v4 ===-->
<div class="breadcrumbs-v4">
	<div class="container">
		<span class="page-name">Products Page</span>
		<h1>
			A lot of <span class="shop-green">hightlight</span> products are
			waiting for you
		</h1>
		<ul class="breadcrumb-v4-in">
			<li><a href="${pageContext.request.contextPath }">Home Page</a></li>
			<li><a href="${pageContext.request.contextPath }/findAll">Products</a></li>
			<li class="active">List products</li>
		</ul>
	</div>
	<!--/end container-->
</div>
<!--=== End Breadcrumbs v4 ===-->


<!--=== Content Part ===-->
<div class="content container-fluid">
	<div class="row">
		<c:set var="temp" value="0" />
		<jsp:include page="/commons/web/left.jsp"></jsp:include>

		<div class="col-md-9">
			<div class="row margin-bottom-5">
				<div class="col-sm-4 result-category">
					<h2>&nbsp;</h2>
					<%-- <small class="shop-bg-red badge-results"> ${countproductAll}
						10 Sản phẩm
					</small> --%>
				</div>
				<div class="col-sm-8">
					<ul class="list-inline clear-both">
						<li class="grid-list-icons"><a
							href="${pageContext.request.contextPath }/findAll"><i
								class="fa fa-th-list"></i></a> <a
							href="${pageContext.request.contextPath }/findAll"><i
								class="fa fa-th"></i></a></li>
					</ul>
				</div>
			</div>
			<!--/end result category-->

			<div class="filter-results">
				<div class="row illustration-v2 margin-bottom-30">

					<c:forEach items="${products}" var="p">
						<c:url value="/image?fname=products/${p.images}" var="imgUrl"></c:url>

						<div class="col-md-4">
							<div class="item">
								<div class="product-img product-img-brd">

									<a
										href='<c:url value="/product/detail?productid=${p.productid}"/>'><img
										width="300px" height="300px" class="full-width img-responsive"
										src="${imgUrl}" alt=""></a> <a class="product-review"
										href='<c:url value="/product/detail?productid=${p.productid}"/>'>Quick
										view</a> <a class="add-to-cart"
										href='<c:url value="/product/detail?productid=${p.productid}"/>'><i
										class="fa fa-shopping-cart"></i>Add to cart</a>

									<div class="shop-rgba-dark-green rgba-banner">New</div>
								</div>
								<div
									class="product-description product-description-brd margin-bottom-30">
									<div class="overflow-h margin-bottom-5">
										<div class="pull-left">
											<h4 class="title-price">
												<a
													href='<c:url value="/product/detail?productid=${p.productid}"/>'>${p.productname}</a>
											</h4>


											<span class="gender text-uppercase">${p.product_types.typename }
												- ${p.skins.skinname}</span> <span class="title-price">$${p.price
												}.0</span> <span class="line-through"><small>$${p.price
													*1.25 }</small></span>

										</div>

									</div>
									<ul class="list-inline product-ratings">
										<li><i class="rating-selected fa fa-star"></i></li>
										<li><i class="rating-selected fa fa-star"></i></li>
										<li><i class="rating-selected fa fa-star"></i></li>
										<li><i class="rating fa fa-star"></i></li>
										<li><i class="rating fa fa-star"></i></li>
										<li class="like-icon">Đã bán:${p.amount} | <a
											data-original-title="Add to wishlist" data-toggle="tooltip"
											data-placement="left" class="tooltips" href="#"><i
												class="fa fa-heart"></i> <%--  ${p.wish} --%></a></li>
									</ul>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>

				<ul class="listPage">
					<!-- <li class = "active">1</li>
					<li>2</li>
					<li>3</li> -->
				</ul>

				<script>
				let thisPage = 1;
				let limit = 6;
				let list = document.querySelectorAll('.col-md-4 .item');

				function loadItem() {
					let beginGet = limit * (thisPage - 1);
					let endGet = limit * thisPage - 1;
					list.forEach((item, key) => {
						if (key >= beginGet && key <= endGet) {
							item.style.display = 'block';
						} else {
							item.style.display = 'none';
						}
					})
					listPage();
				}
				loadItem();

				function listPage() {
					let count = Math.ceil(list.length / limit);
					document.querySelector('.listPage').innerHTML = '';

					if (thisPage != 1) {
						let prev = document.createElement('li');
						prev.innerText = 'PREV';
						prev.setAttribute('onclick', "changePage(" + (thisPage - 1) + ")");
						document.querySelector('.listPage').appendChild(prev);
					}

					for (i = 1; i <= count; i++) {
						let newPage = document.createElement('li');
						newPage.innerText = i;
						if (i == thisPage) {
							newPage.classList.add('active');
						}
						newPage.setAttribute('onclick', "changePage(" + i + ")");
						document.querySelector('.listPage').appendChild(newPage);
					}
			
					if (thisPage != 100) {
						let next = document.createElement('li');
						prev.innerText = 'NEXT';
						prev.setAttribute('onclick', "changePage(" + (thisPage + 1) + ")");
						document.querySelector('.listPage').appendChild(next);
					}
				}
				
				function changePage(i){
					thisPage = i;
					loadItem();
				}
				</script>

				<!--/end filter resilts-->

			</div>
		</div>
		<!--/end row-->
	</div>
</div>
<!--/end container-->
<!--=== End Content Part ===-->
