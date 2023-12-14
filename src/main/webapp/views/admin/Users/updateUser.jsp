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
					<div class="panel-heading">Update User</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-6">
								<h3>User</h3>
								<c:url value="admin-users/update" var="edit"></c:url>
								<%-- <form role="form" action="${edit}" method="post" --%>
								<form role="form" method="post" action="${update}">
                        <!-- Các trường thông tin của người dùng -->
                        <input name="userID" value="${user.userID}" type="hidden">
                        <div class="form-group">
                            <label for="username">User Name:</label>
                            <input type="text" class="form-control" name="username" id="username" required/>
                        </div>
                        <div class="form-group">
                            <label for="password">Password:</label>
                            <input type="password" class="form-control" name="password" id="password" required/>
                        </div>
                        <!--  <div class="form-group">
                            <label for="repass">Re-enter Password:</label>
                            <input type="password" class="form-control" name="repass" id="repass" required/>
                        </div>-->
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
                        <div class="form-group">
                                        <label>Quản trị:</label>
                                        <input type="radio" name="admin" value="1" ${user.admin == 1 ? 'checked' : ''}> Có
                                        <input type="radio" name="admin" value="0" ${user.admin == 0 ? 'checked' : ''}> Không
                        </div>

                        <div class="form-group">
                                        <label>Trạng thái:</label>
                                        <input type="radio" name="active" value="1" ${user.active == 1 ? 'checked' : ''}> Hoạt động
                                        <input type="radio" name="active" value="0" ${user.active == 0 ? 'checked' : ''}> Khóa
                       </div>
                        
                        <br/>
                        <hr>
                        <div class="form-group">
                            <button type="submit" class="btn green">Update <i class="fa fa-plus"></i></button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- ... (các phần khác của trang) ... -->
    </div>
</div>
</div>