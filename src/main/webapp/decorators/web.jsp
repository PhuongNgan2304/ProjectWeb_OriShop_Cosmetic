<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/commons/taglib.jsp"%>
<c:url value="/templates/web/static" var="url"></c:url>
<c:url value="/templates/web/asset1" var="url1"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Orishop Cosmetic</title>
<link rel='stylesheet' type='text/css'
	href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600&amp;subset=cyrillic,latin'>
	
	

<link rel="stylesheet" href="${url1}/css/style.css">

<!-- CSS Global Compulsory -->
<link rel="stylesheet"
	href="${url}/plugins/bootstrap/css/bootstrap1.min.css">
<link rel="stylesheet" href="${url}/css/shop.style.css">

<!-- CSS Header and Footer -->
<link rel="stylesheet" href="${url}/css/headers/header-v5.css">
<link rel="stylesheet" href="${url}/css/footers/footer-v4.css">

<!-- CSS Implementing Plugins -->
<link rel="stylesheet" href="${url}/plugins/animate.css">
<link rel="stylesheet" href="${url}/plugins/line-icons/line-icons.css">
<link rel="stylesheet"
	href="${url}/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${url}/plugins/scrollbar/css/jquery.mCustomScrollbar.css">
<link rel="stylesheet"
	href="${url}/plugins/owl-carousel/owl-carousel/owl.carousel.css">
<link rel="stylesheet"
	href="${url}/plugins/revolution-slider/rs-plugin/css/settings.css">

<!-- CSS Theme -->
<link rel="stylesheet" href="${url}/css/theme-colors/blue.css"
	id="style_color">

<!-- CSS Customization -->
<link rel="stylesheet" href="${url}/css/custom.css">

<!-- Style Switcher -->
<link rel="stylesheet" href="${url}/css/plugins/style-switcher.css">

</head>

<body>

<body class="header-fixed">
	<div class="wrapper">
		<%@ include file="/commons/web/header.jsp"%>
		
		
	
			<!-- body -->
			<td><decorator:body></decorator:body></td>
				<!-- <dec:body /> -->
				<!-- body -->


		<!--=== Footer v4 ===-->
		<jsp:include page="/commons/web/footer.jsp"></jsp:include>
		<!--=== End Footer v4 ===-->
	</div>
	<!--/wrapper-->

	<!-- JS Global Compulsory -->
	<script src="${url}/plugins/jquery/jquery.min.js"></script>
	<script src="${url}/plugins/jquery/jquery-migrate.min.js"></script>
	<script src="${url}/plugins/bootstrap/js/bootstrap.min.js"></script>
	<!-- JS Implementing Plugins -->
	<script src="${url}/plugins/back-to-top.js"></script>
	<%-- <script src="${url}/plugins/smoothScroll.js"></script> --%>
	<%-- <script src="${url}/plugins/jquery.parallax.js"></script> --%>
	<script src="${url}/plugins/owl-carousel/owl-carousel/owl.carousel.js"></script>
	<script
		src="${url}/plugins/scrollbar/js/jquery.mCustomScrollbar.concat.min.js"></script>
	<script
		src="${url}/plugins/revolution-slider/rs-plugin/js/jquery.themepunch.tools.min.js"></script>
	<script
		src="${url}/plugins/revolution-slider/rs-plugin/js/jquery.themepunch.revolution.min.js"></script>
	<!-- JS Customization -->
	<script src="${url}/js/custom.js"></script>
	<!-- JS Page Level -->
	<script src="${url}/js/shop.app.js"></script>
	<script src="${url}/js/plugins/owl-carousel.js"></script>
	<script src="${url}/js/plugins/revolution-slider.js"></script>
	<!-- JS Page Level -->
	<script src="${url}/js/forms/jquery.validate.min.js"></script>
	<script src="${url}/js/forms/page_login.js"></script>
	<%-- <script src="${url}/js/plugins/stepWizard.js"></script> --%>
	<script src="${url}/js/forms/product-quantity.js"></script>
	 <script src="${url}/js/forms/page_registration.js"></script>
	 
	 <script>
		jQuery(document).ready(function() {
			App.init();
			Login.initLogin();
			Registration.initRegistration();
			App.initScrollBar();
			//App.initParallaxBg();
			OwlCarousel.initOwlCarousel();
			RevolutionSlider.initRSfullWidth();
			
		});
	</script>
	

</body>
</body>
</html>