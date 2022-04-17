<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="/resources/js/user/join.js" ></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#user_id").bind('keyup', idCheckInit);
		$("#btn_cancel").bind('click', beforeRedirect);
		$("#btn_confirm").bind('click', userIdCheck);
		$('#user_pw_confirm').bind('blur keyup', pwCheck);
		$('#btn_join').bind('click', formSubmit);
	});
</script>
</head>
<body>
	<form id="joinform" name="joinform" method="post" action="">
	<input type="hidden" id="idCheck" value="false">
	<%-- <form name="downform" id="downform" method="post" action="/files/getFile.do?${_csrf.parameterName}=${_csrf.token}"> --%>
		<div class="container">
			<div class="join-form">
				<div class="join-title">회원가입</div>
				<div class="inline-block join-item-title mt-5">아이디</div>
				<div class="inline-block join-item width60">
					<input class="form-control" type="text" id="user_id" name="user_id" placeholder="아이디">
				</div>
				<div class="inline-block join-item-footer">
					<button type="button" class="btn btn-outline-secondary" id="btn_confirm">중복확인</button>
				</div>
				<div class="inline-block join-item-title mt-3">비밀번호</div>
				<div class="inline-block join-item width60">
					<input class="form-control" type="password" id="user_pw" name="user_pw" placeholder="비밀번호">
				</div>
				<div class="inline-block join-item-title mt-3">비밀번호 확인</div>
				<div class="inline-block join-item width60">
					<input class="form-control" type="password" id="user_pw_confirm" name="user_pw_confirm" placeholder="비밀번호 확인">
				</div>
				<div class="inline-block join-item-title mt-3"></div>
				<div class="inline-block join-item width60" id="pwCheckSpan"></div>
				
				<div class="inline-block join-item-title mt-3">이름</div>
				<div class="inline-block join-item width60">
					<input class="form-control" type="text" id="user_name" name="user_name" placeholder="이름">
				</div>
				
				<div class="text-center mt-5">
					<button type="button" class="btn btn-outline-secondary" id="btn_cancel">이전</button>
					<button type="button" class="btn btn-outline-secondary" id="btn_join">회원가입</button>
				</div>
			</div>
		</div>
	</form>
</body>
</html>
