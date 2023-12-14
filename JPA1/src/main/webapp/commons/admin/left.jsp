<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/commons/taglib.jsp"%>
 <!-- BEGIN SIDEBAR -->
		<div class="page-sidebar-wrapper">
			<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
			<!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
			<div class="page-sidebar navbar-collapse collapse">
				<!-- BEGIN SIDEBAR MENU -->
				<!-- DOC: Apply "page-sidebar-menu-light" class right after "page-sidebar-menu" to enable light sidebar menu style(without borders) -->
				<!-- DOC: Apply "page-sidebar-menu-hover-submenu" class right after "page-sidebar-menu" to enable hoverable(hover vs accordion) sub menu mode -->
				<!-- DOC: Apply "page-sidebar-menu-closed" class right after "page-sidebar-menu" to collapse("page-sidebar-closed" class must be applied to the body element) the sidebar sub menu mode -->
				<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
				<!-- DOC: Set data-keep-expand="true" to keep the submenues expanded -->
				<!-- DOC: Set data-auto-speed="200" to adjust the sub menu slide up/down speed -->
				<ul class="page-sidebar-menu page-sidebar-menu-hover-submenu " data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200">
					<%-- <li class="${tag=='adminhome'?'active':''} start ">
						<a href="<c:url value="/admin-home"></c:url>">
						<i class="icon-home"></i>
						<span class="title">Dashboard</span>
						<span class="${tag=='adminhome'?'selected':''}"></span>
						<span class="arrow ${tag=='adminhome'?'open':''}"></span>
						</a>
					</li> --%>
					<li class="${tag=='type'?'active':''}">
						<a href="<c:url value="/admin-product_types"></c:url>">
						<span class="icon-grid"></span>
						<span class="title">Manage Product Types</span>
						<span class="${tag=='type'?'selected':''}"></span>
						<span class="arrow ${tag=='type'?'open':''}"></span>
						</a>
						
					</li>
					<li class="${tag=='skin'?'active':''}">
						<a href="<c:url value="/admin-skins"></c:url>">
						<span class="icon-diamond"></span>
						<span class="title">Manage Skins</span>
						<span class="${tag=='skin'?'selected':''}"></span>
						<span class="arrow ${tag=='skin'?'open':''}"></span>
						</a>
						
					</li>
					<li class="${tag=='supplier'?'active open':''}">
						<a href="<c:url value="/admin-suppliers"></c:url>">
						<span class="icon-support"></span>
						<span class="title">Manage Suppliers</span>
						<span class="${tag=='supplier'?'selected':''}"></span>
						<span class="arrow ${tag=='supplier'?'open':''}"></span>
						</a>
						
					</li>
					<li class="${tag=='product'?'active open':''}">
						<a href="<c:url value="/admin-products"></c:url>">
						<span class="icon-present"></span>
						<span class="title">Manage Products</span>
						<span class="${tag=='product'?'selected':''}"></span>
						<span class="arrow ${tag=='product'?'open':''}"></span>
						</a>
						
					</li>
					<li class="${tag=='user'?'active open':''}">
						<a href="<c:url value="/admin-users"></c:url>">
						<span class="icon-user"></span>
						<span class="title">Manage Users</span>
						<span class="${tag=='user'?'selected':''}"></span>
						<span class="arrow ${tag=='user'?'open':''}"></span>
						</a>
						
					</li>
					
					<li class="${tag=='order_user'?'active open':''}">
						<a href="<c:url value="/admin-order_user"></c:url>">
						<span class="icon-credit-card"></span>
						<span class="title">Manage Order_Users</span>
						<span class="${tag=='order_user'?'selected':''}"></span>
						<span class="arrow ${tag=='order_user'?'open':''}"></span>
						</a>
						
					</li>
					
					<li class="${tag=='cart'?'active open':''}">
						<a href="<c:url value="/admin-cart"></c:url>">
						<span class="icon-handbag"></span>
						<span class="title">Manage Carts</span>
						<span class="${tag=='cart'?'selected':''}"></span>
						<span class="arrow ${tag=='cart'?'open':''}"></span>
						</a>
						
					</li>
					
					<li class="${tag=='cart_product'?'active open':''}">
						<a href="<c:url value="/admin-cart_product"></c:url>">
						<i class="icon-basket"></i>
						<span class="title">Manage Cart_Products</span>
						<span class="${tag=='cart_product'?'selected':''}"></span>
						<span class="arrow ${tag=='cart_product'?'open':''}"></span>
						</a>
						
					</li>
					
				</ul>
				<!-- END SIDEBAR MENU -->
			</div>
		</div>
		<!-- END SIDEBAR -->