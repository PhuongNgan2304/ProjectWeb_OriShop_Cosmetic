<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/commons/taglib.jsp"%>
<c:url value="/templates/web/static" var="url"></c:url>



<div class="col-md-3 filter-by-block md-margin-bottom-60">
	<h1>Lọc theo</h1>
	<div class="panel-group" id="accordion">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h2 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapseOne"> Tên sản phẩm <i class="fa fa-angle-down"></i>
					</a>
				</h2>
			</div>
			<div id="collapseOne" class="panel-collapse collapse in">
				<div class="panel-body">
					<ul class="list-unstyled checkbox-list">


						<form action="${pageContext.request.contextPath }/product/seach"
							method="get">
							<input type="text" name="name" /> <input type="submit"
								value="Tìm kiếm">
						</form>

					</ul>
				</div>
			</div>
		</div>
	</div>
	<c:set var="temp" value="0" />
	<div class="panel-group" id="accordion-v2">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h2 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion-v2"
						href="#collapseTwo"> Suppliers <i class="fa fa-angle-down"></i>
					</a>
				</h2>
			</div>


			<div id="collapseTwo" class="panel-collapse collapse in">
				<div class="panel-body">
					<ul class="list-unstyled checkbox-list">
						<c:forEach var="item" items="${suppliers}">
							<li><label class="checkbox"> <input type="checkbox"
									name="checkbox" /> <i></i> ${item.suppliername} <small><a
										href='<c:url value="/findBySupplierID?supplierid=${item.supplierid}"/>'>${listCountProductBySuppliers.get(temp)} product</a></small>
							</label> <c:set var="temp" value="${temp+1}" /></li>

						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!--/end panel group-->
	<!--/end panel group-->


	<div class="panel-group" id="accordion-v2">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h2 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion-v2"
						href="#collapseTwo"> Product Types <i class="fa fa-angle-down"></i>
					</a>
				</h2>
			</div>

			<c:set var="temp" value="0" />

			<div id="collapseTwo" class="panel-collapse collapse in">
				<div class="panel-body">
					<ul class="list-unstyled checkbox-list">
						<c:forEach var="item" items="${types}">
							<%-- <li><label class="checkbox"> <input type="checkbox"
									name="checkbox" /> <i></i> ${item.typename} <small><a
										href='<c:url value="findByTypeID?id=${item.typeid}"/>'>${listCountProduct.get(temp)}
											product</a></small>
							</label> <c:set var="temp" value="${temp+1}" /></li> --%>

							<c:url var="editURL" value="/product-grid">
								<c:param name="typeid" value="${item.typeid}" />
							</c:url>
							<li><label class="checkbox"> <input type="checkbox"
									name="checkbox" /> <i></i> ${item.typename} <small><a
										href='<c:url value="/findByTypeID?typeid=${item.typeid}"/>'>${listCountProduct.get(temp)}
											product</a></small>
							</label> <c:set var="temp" value="${temp+1}" /></li>

							<%-- <li class="${tag == item.id ? "active":""}">
							<c:forEach var="item1" items="${countcate}">
								<c:if test="${item1.catid == item.id&& item1.total !=0}">
							  <label class="checkbox"> 
								<input type="checkbox" name="checkbox" checked /> <i></i> 
								<a href="${editURL}&index=1&index1=-2">${item.name} 
									<small>
										 (${item1.total})
									</small>	 
								</a>
							</label>
							</c:if>
							</c:forEach>
							</li> --%>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!--/end panel group-->
	<c:set var="temp" value="0" />
	<div class="panel-group" id="accordion-v3">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h2 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion-v3"
						href="#collapseThree"> Skins <i class="fa fa-angle-down"></i>
					</a>
				</h2>
			</div>
			<div id="collapseThree" class="panel-collapse collapse in">
				<div class="panel-body">
					<ul class="list-unstyled checkbox-list">
						<c:forEach var="item" items="${skins}">
							<li><label class="checkbox"> <input type="checkbox"
									name="checkbox" /> <i></i> ${item.skinname} <small><a
										href='<c:url value="/findBySkinID?skinid=${item.skinid}"/>'>${listCountProductBySkins.get(temp)} product</a></small>
							</label> <c:set var="temp" value="${temp+1}" /></li>

						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!--/end panel group-->


	<div class="panel-group margin-bottom-30" id="accordion-v6">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h2 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion-v6"
						href="#collapseSix"> Rating <i class="fa fa-angle-down"></i>
					</a>
				</h2>
			</div>
			<div id="collapseSix" class="panel-collapse collapse in">
				<div class="panel-body">
					<div class="stars-ratings stars-ratings-label">
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
				</div>
			</div>
		</div>
	</div>
	<!--/end panel group-->
	<button type="button"
		class="btn-u btn-brd btn-brd-hover btn-u-lg btn-u-sea-shop btn-block"
		onclick="window.location.href='${pageContext.request.contextPath }/findAll';">Reset</button>

</div>