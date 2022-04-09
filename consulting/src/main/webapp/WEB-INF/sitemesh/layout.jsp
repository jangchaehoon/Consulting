<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/resources/common/jstl.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상담센터</title>
<!-- Required meta tags -->
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!--====== Favicon Icon ======-->
<link rel="shortcut icon" href="/resources/assets/img/favicon.png" type="image/png">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<script src="/resources/js/jquery/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
<script src="/resources/js/layout.js" ></script>
<%@ include file="../sitemesh/layoutStyle.jsp" %>

<sitemesh:write property='head'/>
</head>
<script type="text/javascript">
$(document).ready(function(){
	init();
	scrollSizeInit();
});

window.addEventListener("resize", scrollSizeInit);

</script>
<body class="overflow-hidden">
	<!-- Header Area wrapper Starts -->
	<div id="header_navbar" class="container fixed-top bg-white" style="height:86px;">
		<nav class="navbar navbar-expand navbar-light pb-0" >
			<div id="header_navbar_list" class="collapse navbar-collapse d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 border-bottom">
				<a href="/" class="d-flex align-items-center col-md-3 mb-md-0 text-dark text-decoration-none">
					<img src="/resources/images/common/logo.png" >
				</a>
				<ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
					<li class="nav-item dropdown">
						<a href="#" id="header_navbar_dropdown_1" class="nav-link dropdown-toggle px-4 link-dark" role="button" data-bs-toggle="dropdown" >매일봄미디어</a>
						<ul class="dropdown-menu" aria-labelledby="header_navbar_dropdown_1">
							<li><a class="dropdown-item" href="#">걸어온길</a></li>
							<li><a class="dropdown-item" href="#">설립취지문</a></li>
							<li><a class="dropdown-item" href="#">조직도</a></li>
							<li><a class="dropdown-item" href="#">오시는길</a></li>
							<li><a class="dropdown-item" href="#">재정보고</a></li>
							<li><a class="dropdown-item" href="#">문의하기</a></li>
						</ul>
					</li>
					<li class="nav-item dropdown">
						<a href="#" id="header_navbar_dropdown_2" class="nav-link dropdown-toggle px-4 link-dark" role="button" data-bs-toggle="dropdown" aria-expanded="false">소식</a>
						<ul class="dropdown-menu" aria-labelledby="header_navbar_dropdown_2">
							<li><a class="dropdown-item" href="#">공지사항</a></li>
							<li><a class="dropdown-item" href="#">뉴스레터</a></li>
							<li><a class="dropdown-item" href="#">자료실</a></li>
						</ul>
					</li>
					<li class="nav-item dropdown">
						<a href="#" id="header_navbar_dropdown_3" class="nav-link dropdown-toggle px-4 link-dark" role="button" data-bs-toggle="dropdown" aria-expanded="false">활동영역</a>
						<ul class="dropdown-menu" aria-labelledby="header_navbar_dropdown_3">
							<li><a class="dropdown-item" href="#">캠페인</a></li>
							<li><a class="dropdown-item" href="#">미디어리터러시 교육</a></li>
							<li><a class="dropdown-item" href="#">인터넷중독상담</a></li>
							<li><a class="dropdown-item" href="#">미디어모니터링</a></li>
							<li><a class="dropdown-item" href="#">소외계층정보격차해소</a></li>
						</ul>
					</li>
					<li class="nav-item dropdown">
						<a href="#" id="header_navbar_dropdown_4" class="nav-link dropdown-toggle px-4 link-dark" role="button" data-bs-toggle="dropdown" aria-expanded="false">부설기구</a>
						<ul class="dropdown-menu" aria-labelledby="header_navbar_dropdown_4">
							<li><a class="dropdown-item" href="#">청소년가족상담센터</a></li>
						</ul>
					</li>
					<li class="nav-item dropdown">
						<a href="#" id="header_navbar_dropdown_5" class="nav-link dropdown-toggle px-4 link-dark" role="button" data-bs-toggle="dropdown" aria-expanded="false">참여</a>
						<ul class="dropdown-menu" aria-labelledby="header_navbar_dropdown_5">
							<li><a class="dropdown-item" href="#">후원</a></li>
							<li><a class="dropdown-item" href="#">회원활동</a></li>
						</ul>
					</li>
				</ul>
				<div class="col-md-3 text-end">
					<button type="button" class="btn btn-outline-primary me-2">로그인</button>
					<button type="button" class="btn btn-primary">회원가입</button>
				</div>
			</div>
		</nav>
	</div>
    <!-- Header Area wrapper End -->
    <div id="body_contents" style="margin-top:86px; height:800px; overflow:auto;">
		<sitemesh:write property='body'/>
	</div>
	  <!-- Footer Section Start -->
    <footer id="footer" class="bg-gray-800 py-16">
           
    </footer> 
    <!-- Footer Section End -->

</body>
</html>