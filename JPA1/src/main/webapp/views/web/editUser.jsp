<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/commons/taglib.jsp"%>
<div class="page-content-wrapper">
			<div class="page-content">
<!-- /. ROW  -->
	<c:url value="/templates/web/static" var="url"></c:url>
		<!--=== Breadcrumbs v4 ===-->
		<div class="breadcrumbs-v4">
			<div class="container">
				<span class="page-name">Đăng ký</span>
				<h1>
					Bạn <span class="shop-green">Hồ sơ tài khoản</span> để hưởng nhiều ưu đãi nhé
				</h1>
				<ul class="breadcrumb-v4-in">
					<li><a href="home">Trang chủ</a></li>
					<li><a href="${pageContext.request.contextPath }/product/grid">Sản phẩm</a></li>
					<li class="active">Hồ sơ tài khoản</li>
				</ul>
			</div>
			<!--/end container-->
		</div>
		<!--=== End Breadcrumbs v4 ===-->

		<!--=== Registre ===-->
	
		<div class="row">
			<div class="col-md-12">
				<!-- Form Elements -->
				<div class="panel panel-default">
					<div class="panel-heading">Update User</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-6">
								<h3>User</h3>
								<c:url value="/member-myaccount" var="edit"></c:url>
								<%-- <form role="form" action="${edit}" method="post" --%>
								<form role="form" method="post" action="${edit}"
								id="registrationForm" enctype="multipart/form-data">
						
                        <!-- Các trường thông tin của người dùng -->
                         <section>
                        <div class="form-group">
											
                             <label for="UserID">User ID:</label>
                             <input name="userID" value="${sessionScope.acc.userID}" type="text"  id= "userID" class="form-control" readonly/>
                           
                         </div>
                         </section>
                                     <section>
                        <div class="form-group">
                            <label for="username">User Name:</label>
                            <input type="text" class="form-control" name="username" value="${sessionScope.acc.username}" id="username" readonly/>
                            
                        </div></section>
                        <section>
                        <div class="form-group">
                            <label for="password">Password:</label>
                            <input type="password" class="form-control" name="password" value="${sessionScope.acc.password}" id="password" readonly/>
                        </div></section>
                        <!--  <div class="form-group">
                            <label for="repass">Re-enter Password:</label>
                            <input type="password" class="form-control" name="repass" id="repass" required/>
                        </div>-->
                        <section>
                        <div class="form-group">
                            <label for="phone">Phone:</label>
                            <input type="text" class="form-control" name="phone" value="${sessionScope.acc.phone}" id="phone" readonly/>
                        </div></section>
                        <section>
                        <div class="form-group">
                            <label for="fullname">Full Name:</label>
                            <input type="text" class="form-control" name="fullname" value="${sessionScope.acc.fullname}" id="fullname" readonly/>
                        </div></section>
                        <section>
                        <div class="form-group">
                            <label for="email">Email:</label>
                            <input type="email" class="form-control" name="email" value="${sessionScope.acc.email}" id="email" readonly/>
                        </div></section>
                        <section>
                        <div class="form-group">
                            <label for="images">Images:</label>
                            <input type="file" onchange="chooseFile(this)" class="form-control" value="${sessionScope.acc.images}" id="images" readonly/>
                        </div></section>
                        
                        
                        <br/>
                        <hr>
                        
                    </form>
                </div>
            </div>
        </div>

        <!-- ... (các phần khác của trang) ... -->
    </div>
</div>
</div>