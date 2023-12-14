<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp"%>    
 
<div class="page-content-wrapper">
	<div class="page-content">
		<div class="row">
			<div class="col-md-12">
				<!-- BEGIN EXAMPLE TABLE PORTLET-->
				<div class="portlet box grey-cascade">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-globe"></i>Manage Cart_Product
						</div>
						<div class="tools">
							<a href="javascript:;" class="collapse"> </a> <a
								href="#portlet-config" data-toggle="modal" class="config"> </a>
							<a href="javascript:;" class="reload"> </a> <a
								href="javascript:;" class="remove"> </a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="table-toolbar">
						<!-- Hiển thị thông báo -->
												<%@include file="/commons/info.jsp"%>
												<!-- Kết thúc hiển thị thông báo -->
							<div class="row">
								<div class="col-md-3">
									
								</div>
								<div class="col-md-9" style="padding-right: 25px">
									<div class="row">
										<div class="col-md-6">
											
										</div>
										<div class="col-md-6">
											<div class="btn-group pull-right">
												<button class="btn dropdown-toggle" data-toggle="dropdown">
													Tools <i class="fa fa-angle-down"></i>
												</button>
												<ul class="dropdown-menu pull-right">
													<li><a href="#"> Print </a></li>
													<li><a href="#"> Save as PDF </a></li>
													<li><a href="#"> Export to Excel </a></li>
												</ul>
											</div>
										</div>
									</div>
									<div class="row">
										<table class="table table-striped table-bordered table-hover"
											id="sample_2">
											<thead>
												<tr>
													<th>ID</th>
													<th>CartID</th>
													<th>Product Name</th>
													<th>Quantity</th>
													<th>Total Price</th>
												</tr>
											</thead>
											<tbody>

												<c:forEach var="item" items="${cart_products}">

													<tr class="odd gradeX">
														
										
														<td>${item.id}</td>
														<td>${item.cart.cartid}</td>
														<td>${item.product.productname}</td>
														<td>${item.quantity}</td>
														<td>${item.totalPrice}</td>
				
													</tr>
												</c:forEach>
											</tbody>
										</table>

									</div>
								</div>
							</div>
						</div>


					</div>
				</div>
				<!-- END EXAMPLE TABLE PORTLET-->
			</div>
		</div>
	</div>
</div>
</html>