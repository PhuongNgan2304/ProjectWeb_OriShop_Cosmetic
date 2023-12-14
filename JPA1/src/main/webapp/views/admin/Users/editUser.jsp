<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/commons/taglib.jsp"%>
<div class="page-content-wrapper">
    <div class="page-content">
        <div class="row">
            <div class="col-md-12">
                <!-- Form Elements -->
                <div class="panel panel-default">
                    <div class="panel-heading">Chỉnh sửa người dùng</div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-6">
                                <h3>Thông tin người dùng:</h3>
                                <c:url value="/admin-users/edit" var="edit"></c:url>
                                <form role="form" action="${edit}" method="post"
                                      enctype="multipart/form-data">
                                   
                                      	<label>User ID:</label>
                               			<input name="userID" value="${user.userID}" type="hidden" readonly="readonly">                                    <div class="form-group">
                                        <label>User Name:</label>
                                        <input type="text" class="form-control" value="${user.username}" name="username" />
                                    </div>

                                    <div class="form-group">
                                        <label>Password:</label>
                                        <input type="password" class="form-control" value="${user.password}" name="password" />
                                    </div>

                                    <div class="form-group">
                                        <label>Phone:</label>
                                        <input type="text" class="form-control" value="${user.phone}" name="phone" />
                                    </div>

                                    <div class="form-group">
                                        <label>FullName:</label>
                                        <input type="text" class="form-control" value="${user.fullname}" name="fullname" />
                                    </div>

                                    <div class="form-group">
                                        <label>Email:</label>
                                        <input type="text" class="form-control" value="${user.email}" name="email" />
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

                                    <button type="submit" class="btn btn-default">Sửa</button>
                                    <button type="reset" class="btn btn-primary">Thoát</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- End Form Elements -->
            </div>
        </div>
    </div>
</div>
