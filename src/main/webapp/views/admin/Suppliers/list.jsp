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
							<i class="fa fa-globe"></i>Manage Suppliers
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

									<div class="row">
										<div class="col-md-9">
											<form action="#" method="post" enctype="multipart/form-data">
												<br />
												<div class="form-group">
													<label for="supplierid">Supplier ID:</label> <input
														type="text" name="supplierid"
														value="${supplier.supplierid}" id="supplierid"
														class="form-control" readonly />
												</div>
												<div class="form-group">
													<label for="suppliername">Supplier Name:</label> <input
														type="text" class="form-control" name="suppliername"
														id="suppliername" value="${supplier.suppliername}" />
												</div>

												<div class="form-group">
													<label for="suppliername">Supplier Country:</label> <input
														type="text" class="form-control" name="country"
														id="country" value="${supplier.country}" />
												</div>
												<%-- <div class="form-group">
													<label for="categorycode">Type code:</label> <input
														type="text" class="form-control" name="typecode" value="${type.typecode}"
														id="typecode" />
												</div> --%>

												<script>
													function chooseFile(
															fileInput) {
														if (fileInput.files
																&& fileInput.files[0]) {
															var reader = new FileReader();

															reader.onload = function(
																	e) {
																$('#images')
																		.attr(
																				'src',
																				e.target.result);
															}
															reader
																	.readAsDataURL(fileInput.files[0]);
														}
													}
												</script>

												<div class="form-group">
													<label for="images">Images:</label>
													<c:if test="${supplier.images!=null}">
														<img width="50px" height="50px" id="images"
															src="<c:url value='/image?fname=suppliers/${supplier.images}'/>">
													</c:if>
													<c:if test="${supplier.images==null}">
														<img width="50px" height="50px" id="images"
															src="<c:url value='/uploads/cate.png'/>">
													</c:if>


													<input type="file" onchange="chooseFile(this)"
														class="form-control" name="images"
														value="${supplier.images}" />
												</div>

												<%-- <div class="form-group">
													<label for="images">Images:</label> <input type="file"
														class="form-control" name="images" id="images" value="${type.images}"/>
												</div> --%>
												<div class="form-check form-check-inline">
													<label for="status">Status:</label> <input id="statuson"
														class="form-check-input" type="radio" name="status"
														${supplier.status?'checked':''} value="true"> <label
														for="statuson" class="form-check-label">Active</label> <input
														id="statusoff" class="form-check-input" type="radio"
														name="status" ${!supplier.status?'checked':''} value="false">
													<label for="statusoff" class="form-check-label">Block</label>
												</div>
												<br />
												<hr>
												<div class="form-group">
													<button class="btn green"
														formaction="<c:url value="/admin-suppliers/create"/>">
														Create <i class="fa fa-plus"></i>
													</button>
													<button class="btn btn-warning"
														formaction="<c:url value="/admin-suppliers/update"/>">
														Update <i class="fa fa-edit"></i>
													</button>
													<br /> <br />
													<button class="btn btn-danger"
														formaction="<c:url value="/admin-suppliers/delete"/>">
														Delete <i class="fa fa-trash"></i>
													</button>
													<button class="btn btn-success"
														formaction="${pageContext.request.contextPath }/admin-suppliers/reset">
														Reset <i class="fa fa-undo"></i>
													</button>
												</div>

											</form>
										</div>

									</div>
								</div>
								<div class="col-md-9" style="padding-right: 25px">
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
													<th>Image</th>
													<th>Supplier Name</th>
													<th>Supplier Country</th>


													<th>Status</th>
													<th>Action</th>
												</tr>
											</thead>
											<tbody>

												<c:forEach var="item" items="${suppliers}">

													<tr class="odd gradeX">

														<td><c:if test="${item.images!=null}">
																<img width="50px" height="50px"
																	src="<c:url value='/image?fname=suppliers/${item.images}'/>">
															</c:if> <c:if test="${item.images==null}">
																<img width="50px" height="50px" id="images"
																	src="<c:url value='/uploads/cate.png'/>">
															</c:if></td>

														<%-- <td>
														<c:url value="/image?fname=types/${item.images!=null?item.images:'uploads1/cate.png'}" var="imgUrl"></c:url>
														<img width="50px" height="50px"
															src="${imgUrl}"></td> --%>

														<td>${item.suppliername}</td>
														<td>${item.country}</td>
														<td><c:if test="${item.status == true}">
																<span class="label label-sm label-success">
																	Active </span>
															</c:if> <c:if test="${item.status ==false}">
																<span class="label label-sm label-warning"> Block
																</span>
															</c:if></td>

														<td><a
															href="<c:url value='/admin-suppliers/edit?supplierid=${item.supplierid}'/>"
															class="center">Edit</a> | <a
															href="<c:url value='/admin-suppliers/delete?supplierid=${item.supplierid}'/>"
															class="center">Delete</a></td>
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