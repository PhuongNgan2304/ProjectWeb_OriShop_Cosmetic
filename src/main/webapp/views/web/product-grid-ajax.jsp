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
							href="${pageContext.request.contextPath }/product-list"><i
								class="fa fa-th-list"></i></a> <a
							href="${pageContext.request.contextPath }/product-grid"><i
								class="fa fa-th"></i></a></li>
						<li class="sort-list-btn">
							<h3>Sắp xếp :</h3>
							<div class="btn-group">
								<button type="button" class="btn btn-default dropdown-toggle"
									data-toggle="dropdown">
									Điều kiện <span class="caret"></span>
								</button>
								<ul class="dropdown-menu" role="menu">
									<li><a href="#">Tất cả</a></li>
									<li><a href="#">Bán chạy nhất</a></li>
									<li><a href="#">Bán chạy nhất theo tuần</a></li>
									<li><a href="#">Sản phẩm mới</a></li>
								</ul>
							</div>
						</li>
						<li class="sort-list-btn">
							<h3>Hiển thị :</h3>
							<div class="btn-group">
								<button type="button" class="btn btn-default dropdown-toggle"
									data-toggle="dropdown">
									<c:if test="${tag1==-1}">
												Tất cả
											</c:if>
									<c:if test="${tag1!=-1}">
											${tag1+2} 
											</c:if>
									<span class="caret"></span>
								</button>
								<ul class="dropdown-menu" role="menu">
									<li><a
										href="${pageContext.request.contextPath }/findAll?index=${tag}&index1=-1">Tất
											cả</a></li>
									<li><a
										href="${pageContext.request.contextPath }/findAll?index=${tag}&index1=8">10</a></li>
									<li><a
										href="${pageContext.request.contextPath }/findAll?index=${tag}&index1=3">5</a></li>
									<li><a
										href="${pageContext.request.contextPath }/findAllindex=${tag}&index1=1">3</a></li>
								</ul>
							</div>
						</li>
					</ul>
				</div>
			</div>
			<!--/end result category-->

			<div id = "content"class="filter-results">
				<div class="row illustration-v2 margin-bottom-30">

					<c:forEach items="${products}" var="p">
						<c:url value="/image?fname=products/${p.images}" var="imgUrl"></c:url>

						<div class= " product col-md-4">
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
					</c:forEach>
				</div>


				<!--/end filter resilts-->


			</div>
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
			
			<script>
				$(window).scroll(function(){
					if($(window).scrollTop() + $(window).height() >= $(document).height()){
						loadAjax();
					}
				});
				
				function loadAjax() {
                    var amount = document.getElementsByClassName("product").length;
                    $.ajax({
                        url: "/JPA1/product/loadAjax",
                        type: "get", //send it through get method
                        data: {
                            exits: amount
                        },
                        success: function (data) {
                            $("#content").append(data);
                        },
                        error: function (xhr) {
                            //Do Something to handle error
                        }
                    });
                }
				
				
			
			</script>
			
		</div>
		<!--/end row-->
	</div>
</div>
<!--/end container-->
<!--=== End Content Part ===-->
