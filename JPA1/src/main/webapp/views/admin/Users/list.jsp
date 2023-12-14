<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/commons/taglib.jsp"%>

<div class="page-content-wrapper">
	<div class="page-content">
		<div class="row">
			<div class="col-md-12">
				<!-- BEGIN EXAMPLE TABLE PORTLET-->
				<div class="portlet box grey-cascade">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-globe"></i>Manage Users
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
											<form action="admin-users" method="post" enctype="multipart/form-data">
											<div class="form-group">
													<div class="form-group">
                                                    <label for="UserID">User ID:</label>
                                                    <input type="text" name="userID" value="${user.userID}" id="userID" class="form-control" readonly/>
                                                </div>

												</div>
												<div class="form-group">
													<label for="Username">User Name:</label> <input type="text"
														name="username" id="username" class="form-control" value="${user.username }" />
												</div>
												<div class="form-group">
													<label for="Password">Password:</label> <input
														type="password" class="form-control" name="password"
														id="password" value="${user.password }" />
												</div>
												<div class="form-group">
													<label for="Fullname">Full Name:</label> <input type="text"
														class="form-control" name="fullname" id="fullname" value="${user.fullname }" />
												</div>
												<div class="form-group">
													<label for="Phone">Phone:</label> <input type="text"
														class="form-control" name="phone" id="phone" value="${user.phone }" />
												</div>
												<div class="form-group">
													<label for="Email">Email Address:</label> <input
														type="text" class="form-control" name="email" id="Email" value="${user.email }"/>
												</div>
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
													<label for="Images">Images:</label> 
													<c:url value="/image?fname=users/${user.images!=null?user.images:'uploads/abc.jpg'}"
																var="imgUrl"></c:url> <img width="50px" height="50px"
															src="${imgUrl}">
													<input type="file"
														class="form-control" name="images" id="images" value="${user.images}"/>
												</div>
												<div class="form-check form-check-inline">
													<label for="Admin">Role:</label> 
													<input id="admin" class="form-check-input" type="radio" name="admin" ${user.admin?'checked':''} value="true">
													<label for="Admin" class="form-check-label">Admin</label> 
													<input	id="user" class="form-check-input" type="radio"	name="admin" ${!user.admin?'checked':''} value="false"> 
													<label for="Admin" class="form-check-label">User</label>
												</div>
												<br/>
												<div class="form-check form-check-inline">
                        							<label for="Active">Status:</label>
                        							<input id="activeon" class="form-check-input" type="radio" name="active" ${user.active?'checked':''} value="true">
                        							<label for="Active" class="form-check-label">Hoạt động</label>
                       								<input id="activeoff" class="form-check-input" type="radio" name="active" ${!user.active?'checked':''} value="false">
                        							<label for="Active" class="form-check-label">Khóa</label>
                    							</div>
                    							<br/>
                    							<hr>
												<div class="form-group">
													<button class="btn green"
														formaction="<c:url value="/admin-users/create"/>">
														Create <i class="fa fa-plus"></i>
													</button>
													<button class="btn btn-warning"
														formaction="<c:url value="/admin-users/update"/>">
														Update <i class="fa fa-edit"></i>
													</button>
													<br /> <br />
													<button class="btn btn-danger"
														formaction="<c:url value="/admin-users/delete"/>">
														Delete <i class="fa fa-trash"></i>
													</button>
													<button class="btn btn-success"
														formaction="${pageContext.request.contextPath }/admin-users/reset">
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
													<td>UserID</td>
													<td>UserName</td>
													<td>Images
													<td>FullName</td>													
													<td>Email</td>
													<td>Phone</td>												
													<td>Status</td>
													<td>Role</td>
													<td>Action</td>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${users}" varStatus="stt">
													<tr>
														<td>${item.userID}</td>
														<td>${item.username}</td>
														<td><c:url value="/image?fname=users/${item.images!=null?item.images:'uploads/abc.jpg'}"
																var="imgUrl"></c:url> <img width="50px" height="50px"
															src="${imgUrl}"></td>
														<td>${item.fullname}</td>
														
														<td>${item.email}</td>
														<td>${item.phone}</td>
														<td><c:if test="${item.admin == true}">
																<span class="label label-sm label-success"> Admin
																 </span>
															</c:if> 
															<c:if test="${item.admin ==false}">
																<span class="label label-sm label-warning"> User
																</span>
															</c:if></td>	
														<td><c:if test="${item.active == true}">
																<span class="label label-sm label-success"> Hoạt
																	động </span>
															</c:if> <c:if test="${item.active ==false}">
																<span class="label label-sm label-warning"> Khóa
																</span>
															</c:if></td>
															
															<td><a href="<c:url value='/admin-users/edit?userID=${item.userID}'/>">Edit</a> | 
															<a href="<c:url value='/admin-users/delete?userID=${item.userID}'/>">Delete</a>
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
				</div>
				<!-- END EXAMPLE TABLE PORTLET-->
			</div>
		</div>
	</div>
</div>


