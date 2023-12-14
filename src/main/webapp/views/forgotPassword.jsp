<%@include file="/commons/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url value="/templates/web/static" var="url"></c:url>
		<!--=== Breadcrumbs v4 ===-->
		<div class="breadcrumbs-v4">
			<div class="container">
				<span class="page-name">Quên mật khẩu</span>
				
				<ul class="breadcrumb-v4-in">
					<li><a href="home">Trang chủ</a></li>
					<li><a href="${pageContext.request.contextPath }/product/grid">Sản phẩm</a></li>
					<li class="active">Quên mật khẩu</li>
				</ul>
			</div>
			<!--/end container-->
		</div>
		<!--=== End Breadcrumbs v4 ===-->

		<!--=== Registre ===-->
		<div class="log-reg-v3 content-md margin-bottom-30">
			<div class="container">
				<div class="row">
					<div class="col-md-2 ">
						
					</div>

					<div class="col-md-6  md-margin-bottom-50">
						<form id="sky-form4" class="log-reg-block sky-form"
							action="forgotPassword" method="post">
							<h2>Quên mật khẩu</h2>
							<c:if test="${error !=null}">
								<h3 class="alert alert-danger">${error}</h3>
							</c:if>
							
							<section>
							
								<label class="input login-input">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-envelope"></i></span>
										<input type="text" placeholder="Nhập Email" name="email" value="${user.email}"
											class="form-control">
									</div>
									</label>
									
								
							</section>
			
							
							<!-- <label>
							 <input
								type="checkbox" name="checkbox" /> <i></i> Tôi đồng ý với <a href="#">các điều &amp; khoản quy định</a>
							</label> -->
							<button class="btn-u btn-u-sea-shop btn-block margin-bottom-20"
								type="submit">Lấy lại mật khẩu</button>
						</form>

						<div class="margin-bottom-20"></div>
						<p class="text-center">
							Nếu bạn đã có tài khoản? <a
								href="${pageContext.request.contextPath }/login">Đăng nhập</a>
						</p>
					</div>
				</div>
				<!--/end row-->
			</div>
			<!--/end container-->
		</div>
		<!--=== End Registre ===-->
	
	

	