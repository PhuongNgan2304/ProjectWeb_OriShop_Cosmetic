<%@include file="/commons/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url value="/templates/web/static" var="url"></c:url>
<div class="topbar-v3">
	<div class="search-open">
		<div class="container">
			<input type="text" class="form-control" placeholder="Search">
			<div class="search-close">
				<i class="icon-close"></i>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				<!-- Topbar Navigation -->
				<ul class="left-topbar">
					
					<li><a>Giao diện</a>
						<ul class="language">
									<li class="active"><a href="#">Việt Nam (VI)<i class="fa fa-check"></i></a></li>
									<li class="active"><a href="#">English (EN)</a></li>
						</ul></li>
				</ul>
				<!--/end left-topbar-->
			</div>
			<c:choose>
				<c:when test="${sessionScope.acc != null}">
				<%-- ${sessionScope.acc != null} --%>
					<div class="col-sm-6">
							<ul class="list-inline left-topbar pull-right">
							<li><a>
							<img alt="" class="img-circle" width="22px" src="<c:url value="/${sessionScope.acc.images}"/>"/>
							${sessionScope.acc.fullname}</a>
								<ul class="language-right">
									<li><a href="${pageContext.request.contextPath }/member-myaccount">Hồ sơ tài khoản</a>
									<a href="${pageContext.request.contextPath }/logout">Đăng Xuất</a>
									<c:if test="${sessionScope.acc.admin ==true}">
									<a href="${pageContext.request.contextPath }/admin-cart">Trang quản trị</a>
									
									</c:if>
									</li>
								</ul>
							</li>
							<li><i class="search fa fa-search search-button"></i></li>
					
						</ul>
					</div>
				</c:when>
				<c:otherwise>
					<div class="col-sm-6">
						<ul class="list-inline right-topbar pull-right">
									<li><a href="${pageContext.request.contextPath }/login">Đăng nhập </a>|
									<a href="${pageContext.request.contextPath }/signup">Đăng ký</a></li>
									<li><i class="search fa fa-search search-button"></i></li>
						
							
								</ul>
					</div>
				</c:otherwise>
			</c:choose>



		</div>
	</div>
	<!--/container-->
</div>
