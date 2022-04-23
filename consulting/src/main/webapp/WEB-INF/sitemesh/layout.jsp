<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/resources/common/jstl.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상담센터</title>
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<!-- Required meta tags -->
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!--====== Favicon Icon ======-->
<link rel="shortcut icon" href="/resources/assets/img/favicon.png" type="image/png">

<!-- css -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">

<!-- js -->
<script src="/resources/js/jquery/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/resources/js/jquery/jquery.form-3.51.0.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
<script src="/resources/js/ypcustom.js"></script>
<script src="/resources/js/layout.js"></script>
<link rel="stylesheet" href="/resources/css/layoutStyle.css">

<sitemesh:write property='head'/>
</head>
<script type="text/javascript">
$(document).ready(function(){
	ypcustom.init();
	menuInit();
});

</script>
<input type="hidden" id="menu_id" name="menu_id" value="${menuRole.menu_id }">
<input type="hidden" id="parents_menu_id" name="parents_menu_id" value="${menuRole.parents_menu_id }">
<input type="hidden" id="menu_url" name="menu_url" value="${menuRole.menu_url }">
<input type="hidden" id="leftmenu" name="leftmenu" value="${menuRole.leftmenu }">
<body id="topBody" class="overflow-hidden">
	<!-- Header Area wrapper Starts -->
	<div id="header_navbar" class="container fixed-top bg-white" style="height:122px;">
		<nav class="navbar navbar-expand navbar-light pb-0" >
			<div id="header_navbar_list" class="collapse navbar-collapse d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 border-bottom">
				<a href="/" class="d-flex align-items-center col-md-3 mb-md-0 text-dark text-decoration-none">
					<img src="/resources/images/common/logo.png" >
				</a>
				<ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0" id="topMenu"></ul>
			</div>
		</nav>
		<nav class="navbar navbar-expand-sm border-bottom" style="padding: 0.4rem 0" >
			<div id="header_navbar_list" class="container-fluid collapse navbar-collapse d-flex flex-wrap align-items-center justify-content-center justify-content-md-between" style="height:1rem;">
				<ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
					<c:if test="${empty User.user_id }">
						<li class="nav-item">
							<a href="/user/login.go" class="nav-link px-4 link-dark" style="font-size:0.7rem; padding:0 1rem;">로그인</a>
						</li>
						<li class="nav-item">
							<a href="/user/joinAgree.go" class="nav-link px-4 link-dark" style="font-size:0.7rem; padding:0 1rem;">회원가입</a>
						</li>
					</c:if>
					<c:if test="${not empty User.user_id }">
						<li class="nav-item">
							<a href="/logout.do" class="nav-link px-4 link-dark" style="font-size:0.7rem; padding:0 1rem;">로그아웃</a>
						</li>
					</c:if>
				</ul>
			</div>
			<div class="container-fluid input-group input-group-sm" style="width:20rem;">
				<input type="text" class="form-control pt-0 pb-0" aria-label="Recipient's username" aria-describedby="button-addon2">
				<button class="btn btn-outline-secondary pt-0 pb-0" type="button" id="button-addon2"><i class="bi bi-search"></i></button>
			</div>
		</nav>
	</div>
	
    <div class="body_contents overflow-auto">
		<div class="container">
			<div class="row">
				<c:if test="${menuRole.leftmenu ne 'N' }">
				<div class="col-2">
					<div class="leftmenu-title" id="leftmenu_title"></div>
					<div class="leftmenu-contents">
						<ul class="nav flex-column nav-pills" id="leftmenu-contents">
						</ul>
					</div>
				</div>
				</c:if>
				<div class="col">
					<sitemesh:write property='body'/>
				</div>
			</div>
		</div>
	</div>
	
    <footer id="footer" class="bg-gray-800 py-16">
           
    </footer>
    <!-- Footer Section End -->

</body>
</html>