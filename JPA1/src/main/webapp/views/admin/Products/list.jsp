<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp"%>

<br />
<div class="page-content-wrapper">
	<div class="page-content">
		<div class="row">
			<div class="col-md-12">
				<ul class="nav nav-tabs flex-column font-weight-bold">
					<li class="nav-item"><a class="nav-link btn-success"
						href="#details" data-toggle="tab">Add Products</a></li>
					<li class="nav-item"><a class="nav-link btn-primary"
						href="#mailform" data-toggle="tab">List Products</a></li>


				</ul>
				<div class="tab-content">
					<div role="tabpanel" class="tab-pane active" id="details">
						<br />
						<div class="container bootstrap snippet">
							<!-- Hiển thị thông báo -->
							<%@include file="/commons/info.jsp"%>
							<!-- Kết thúc hiển thị thông báo -->
							<form action="admin-video" method="post"
								enctype="multipart/form-data">
								<div class="row">
									<div class="col-sm-3">

										<%-- <c:url
											value="/image?fname=products/${product.images!=null?product.images:'/templates/images/video.png'}"
											var="imgUrl"></c:url>
										<img src="${imgUrl}" class="img-fluid" width="300px"> --%>
										
										
										<script>
						function chooseFile(fileInput){
							if(fileInput.files && fileInput.files[0]){
								var reader = new FileReader();
								
								reader.onload = function(e){
									$('#images').attr('src',e.target.result);
								}
								reader.readAsDataURL(fileInput.files[0]);
							}
						}
					
					</script>
												
												<div class="form-group">
													<label for="images">Images:</label> 
													<c:if test="${product.images!=null}">
														<img width="50px" height="50px" id="images"	src="<c:url value='/image?fname=products/${product.images}'/>">
													</c:if>	
													<c:if test="${product.images==null}">
														<img width="50px" height="50px" id="images"	src="<c:url value='/uploads/cate.png'/>">
													</c:if>			
																
																
													<input type="file" onchange="chooseFile(this)" 
														class="form-control" name="images" value="${product.images}"/>
												</div>
										
										
										
										
										<%-- <c:url
											value="/image?fname=products/${product.images!=null?product.images:'/uploads/products/simple_micellar.png'}"
											var="imgUrl"></c:url>
										<img src="${imgUrl}" class="img-fluid" width="300px">
										
										
										<hr>
										<div class="input-group mb-3 mt-3">
											<div class="input-group-prepend">
												<span class="input-group-text">Upload</span>
											</div>
											
											<div class="custom-file">
												<input type="file" class="custmo-file-input" name="images"
													id="images" value="${product.images}" /> <br />
											</div>
										</div> --%>


									</div>
									<div class="col-sm-9">
										<div class="tab-content">
											<div class="tab-pane active" id="home">


												<%-- <div class="form-group">
													<label for="videoId">Product ID:</label> <input type="text"
														name="productid" id="productid" class="form-control"
														value="${product.productid }" />
												</div> --%>

												<div class="form-group">
													<label for="videoTitle">Product Name:</label> <input
														type="text" class="form-control" name="productname" id="productname"
														value="${product.productname }" />
												</div>
												
												<div class="form-group">
													<label for="videoTitle">Description:</label> <input
														type="text" class="form-control" name="description" id="description"
														value="${product.description }" />
												</div>
												
												<div class="form-group">
													<label>Supplier</label>
													<div class="checkbox">
														<select name="supplierid">
															<option value="${product.suppliers.supplierid}">${product.suppliers.suppliername}</option>
															<c:forEach items="${suppliers}" var="c">
																<option value="${c.supplierid}">${c.suppliername}</option>
															</c:forEach>
														</select>
													</div>
												</div>
													
												<div class="form-group">
													<label>Product Type</label>
													<div class="checkbox">
														<select name="typeid">
															<option value="${product.product_types.typeid}">${product.product_types.typename}</option>
															<c:forEach items="${types}" var="c">
																<option value="${c.typeid}">${c.typename}</option>
															</c:forEach>
														</select>
													</div>
												</div>
													
												<div class="form-group">
													<label>Skin</label>
													<div class="checkbox">
														<select name="skinid">
															<option value="${product.skins.skinid}">${product.skins.skinname}</option>
															<c:forEach items="${skins}" var="c">
																<option value="${c.skinid}">${c.skinname}</option>
															</c:forEach>
														</select>
													</div>
												</div>
													
												<div class="form-group">
													<label for="videoTitle">Price:</label> <input
														type="text" class="form-control" name="price" id="price"
														value="${product.price }" />
												</div>
												
												<div class="form-group">
													<label for="videoTitle">Amount:</label> <input
														type="text" class="form-control" name="amount" id="amount"
														value="${product.amount }" />
												</div>
			
												<br />
												<div class="form-check form-check-inline">
													<label for="active">Status:</label> <input id="activeon"
														class="form-check-input" type="radio" name="status"
														${product.status?'checked':''} value="true"> <label
														for="activeon" class="form-check-label">Acitve</label>
													<input id="activeoff" class="form-check-input" type="radio"
														name="status" ${!product.status?'checked':''} value="false">
													<label for="activeoff" class="form-check-label">Block</label>
												</div>

												<hr>
												<div class="form-group">
													<button class="btn green"
														formaction="<c:url value="/admin-products/create"/>">
														Create <i class="fa fa-plus"></i>
													</button>
													<button class="btn btn-warning"
														formaction="<c:url value="/admin-products/update"/>">
														Update <i class="fa fa-edit"></i>
													</button>

													<button class="btn btn-danger"
														formaction="<c:url value="/admin-products/delete"/>">
														Delete <i class="fa fa-trash"></i>
													</button>
													<button class="btn btn-success"
														formaction="${pageContext.request.contextPath }/admin-products/reset">
														Reset <i class="fa fa-undo"></i>
													</button>
												</div>





											</div>

										</div>
									</div>

								</div>
							</form>
						</div>


						<br />
					</div>
					<div role="tabpanel" class="tab-pane fade" id="mailform">
						<div class="tab-content">
							<div class="tab-pane active" id="list">

								<div class="col-md-12" style="padding-right: 25px">
									<div class="row">
										<div class="col-md-6"></div>
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
													<td>Order</td>
													<td>Product ID</td>
													<td>Images</td>
													<td>Product Name</td>
													<td>Description</td>
													<td>Supplier</td>
													<td>Product Type</td>
													<td>Skin</td>
													<td>Price</td>
													<td>Amount</td>
													<td>Status</td>

													<td>Action</td>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${products}" varStatus="stt">
													<tr>
														<td>${stt.index+1}</td>
														<td>${item.productid}</td>
														
														<td><c:if test="${item.images!=null}">
																<img width="50px" height="50px"	src="<c:url value='/image?fname=products/${item.images}'/>">
															</c:if>	
															<c:if test="${item.images==null}">
																<img width="50px" height="50px" id="images"	src="<c:url value='/uploads/cate.png'/>">
															</c:if>		
														</td>
														
														<%-- <td><c:url
																value="/image?fname=products/${item.images!=null?item.images:'/templates/images/video.png'}"
																var="imgUrl"></c:url> <img width="50px" height="50px"
															src="${imgUrl}"></td> --%>
															
														<td>${item.productname}</td>
														<td>${item.description}</td>
														<td>${item.suppliers.suppliername}</td>
														<td>${item.product_types.typename}</td>
														<td>${item.skins.skinname}</td>
														<td>${item.price}</td>
														<td>${item.amount}</td>
													
														<td><c:if test="${item.status == true}">
																<span class="label label-sm label-success"> Hoạt
																	động </span>
															</c:if> <c:if test="${item.status ==false}">
																<span class="label label-sm label-warning"> Khóa
																</span>
															</c:if></td>


														<td><a
															href="<c:url value='/admin-products/edit?productid=${item.productid}'/>">Edit</a>
															| <a
															href="<c:url value='/admin-products/delete?productid=${item.productid}'/>">Delete</a>
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>

									</div>
								</div>
							</div>
						</div>
					</div>
					<br />
				</div>
				<br />
			</div>
		</div>
	</div>
</div>