<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/commons/taglib.jsp"%>
<div class="page-content-wrapper">
			<div class="page-content">
<!-- /. ROW  -->
		
		<div class="row">
			<div class="col-md-12">
				<!-- Form Elements -->
				<div class="panel panel-default">
					<div class="panel-heading">Create User</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-6">
								<h3>User</h3>
								<c:url value="admin-users/create" var="edit"></c:url>
								<%-- <form role="form" action="${edit}" method="post" --%>
								<form method="post" action="<c:url value='/register'/>">
                        <!-- Các trường thông tin của người dùng -->
                        <div class="form-group">
                            <label for="username">User Name:</label>
                            <input type="text" class="form-control" name="username" id="username" required/>
                        </div>
                        <div class="form-group">
                            <label for="password">Password:</label>
                            <input type="password" class="form-control" name="password" id="password" required/>
                        </div>
                        <div class="form-group">
                            <label for="repass">Re-enter Password:</label>
                            <input type="password" class="form-control" name="repass" id="repass" required/>
                        </div>
                        <div class="form-group">
                            <label for="phone">Phone:</label>
                            <input type="text" class="form-control" name="phone" id="phone"/>
                        </div>
                        <div class="form-group">
                            <label for="fullname">Full Name:</label>
                            <input type="text" class="form-control" name="fullname" id="fullname"/>
                        </div>
                        <div class="form-group">
                            <label for="email">Email:</label>
                            <input type="email" class="form-control" name="email" id="email"/>
                        </div>
                        <div class="form-group">
                            <label for="images">Images:</label>
                            <input type="file" onchange="chooseFile(this)" class="form-control" name="images"/>
                        </div>
                        <div class="form-check form-check-inline">
                            <label for="role">Role:</label>
                            <input id="adminRole" class="form-check-input" type="radio" name="role" value="admin" checked>
                            <label for="adminRole" class="form-check-label">Admin</label>
                            <input id="userRole" class="form-check-input" type="radio" name="role" value="user">
                            <label for="userRole" class="form-check-label">User</label>
                        </div>
                        <br/>
                        <hr>
                        <div class="form-group">
                            <button type="submit" class="btn green">Create <i class="fa fa-plus"></i></button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- ... (các phần khác của trang) ... -->
    </div>
</div>
</div>