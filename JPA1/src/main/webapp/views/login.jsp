<%@include file="/commons/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

		<!--=== Breadcrumbs v4 ===-->
		<div class="breadcrumbs-v4">
			<div class="container">
				<span class="page-name">Đăng nhập</span>
				<h1>
					Xin vui lòng <span class="shop-green">đăng nhập</span> để sử dụng hệ thống
				</h1>
				<ul class="breadcrumb-v4-in">
					<li><a href="home">Trang chủ</a></li>
					<li><a href="${pageContext.request.contextPath }/product-grid">Sản phẩm</a></li>
					<li class="active">Đăng nhập</li>
				</ul>
			</div>
			<!--/end container-->
		</div>
		<!--=== End Breadcrumbs v4 ===-->

		<!--=== Login ===-->
		<div class="log-reg-v3 content-md">
			<div class="container">
				<div class="row">
					<div class="col-md-2 ">
						
					</div>

					<div class="col-md-6 md-margin-bottom-50">
						<form id="sky-form1" class="log-reg-block sky-form" action="login" method="post">
							<h2>Đăng nhập vào hệ thống</h2>
							<c:if test="${error !=null}">
								<h3 class="alert alert-danger">${error}</h3>
							</c:if>

							<section>
								<label class="input login-input">
								<div class="input-group">
								
										<span class="input-group-addon"><i class="fa fa-user"></i></span>
										<input type="text" placeholder="User name" name="user"
											class="form-control">
									</div>
									</label>
									
								
							</section>
							<section>
								
									
									<label class="input login-input no-border-top">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-lock"></i></span>
										<input type="password" placeholder="Password" name="pass"
											class="form-control">
									</div>
									</label>
									
								
							</section>
							<div class="row margin-bottom-5">
								<div class="col-xs-6">
									<label class="checkbox"> <input type="checkbox"
										name="remember" /> <i></i> Nhớ tôi
									</label>
								</div>
								<div class="col-xs-6 text-right">
									<a href="${pageContext.request.contextPath }/forgotPassword">Quên mật khẩu?</a>
								</div>
							</div>
							<button class="btn-u btn-u-sea-shop btn-block margin-bottom-20"
								type="submit">Đăng nhập</button>

							
						</form>

						<div class="margin-bottom-20"></div>
						<p class="text-center">
							Nếu bạn chưa có tài khoản trên hệ thống, thì hãy <a
								href="${pageContext.request.contextPath }/signup">Đăng ký</a>
						</p>
					</div>
				</div>
				<!--/end row-->
			</div>
			<!--/end container-->
		</div>
		<!--=== End Login ===-->

		
		