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
					<div class="panel-heading">Create Product Types</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-6">
								<h3>Product Types:</h3>
								<c:url value="admin-product_types/create" var="edit"></c:url>
								<%-- <form role="form" action="${edit}" method="post" --%>
								<form role="form" action="${update}" method="post"
									enctype="multipart/form-data">
									
									<div class="form-group">
										<label>Type ID:</label> <input type="text"
											class="form-control" name="typeID" />
									</div>
									
									<div class="form-group">
										<label>Type Name:</label> <input type="text"
											class="form-control" name="typeName" />
									</div>
									
									<div class="form-group">
										 <label>Image</label> <input type="file"
											name="typeImageURL" value="" />
									</div>
									
									<button type="submit" class="btn btn-default">Insert</button>
									<button type="reset" class="btn btn-primary">Exit</button>
								</form>
							</div>
						</div>
					</div>
				</div>
				<!-- End Form Elements -->
			</div>
		</div>
		<!-- /. ROW  -->
</div>
</div>