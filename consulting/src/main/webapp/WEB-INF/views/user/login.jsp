<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<script src="/resources/js/user/login.js" ></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#btn_login").bind('click', formSubmit);
		
		var EXCEPTION = '${SPRING_SECURITY_LAST_EXCEPTION}';
		if(EXCEPTION != ''){
			ypcustom.alert("로그인 실패", EXCEPTION);
		}
	});
</script>
</head>
<body>
	<form id="loginform" name="loginform" method="post" action="">
		<div class="container">
			<div class="login-form">
				<div class="login-title">로그인</div>
				<div class="login-item">
					<input class="form-control" type="text" id="user_id" name="user_id" placeholder="아이디">
				</div>
				<div class="login-item">
					<input class="form-control" type="password" id="user_pw" name="user_pw" placeholder="비밀번호">
				</div>
				<div class="login-checkbox">
					<div class="form-check">
						<input class="form-check-input" type="checkbox" value="" id="keep_login">
						<label class="form-check-label" for="keep_login">
							로그인 유지
						</label>
					</div>
				</div>
				<div class="d-grid gap-2 login-footer">
					<button type="button" class="btn btn-outline-secondary" id="btn_login">로그인</button>
				</div>
			</div>
		</div>
	</form>
</body>
</html>
