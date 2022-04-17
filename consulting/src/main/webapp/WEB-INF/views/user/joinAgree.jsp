<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="/resources/js/user/join.js" ></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#btn_agree").bind('click', agreeChk);
	});
</script>
</head>
<body>
	<div class="container">
			<div class="join-title">약관동의</div>
			<pre class="join-agree">

탁틴내일 회원 이용약관 안내

제 1 장 총 칙

제 1조 (목적)

<pre class="join-indent">
이 약관은 탁틴내일 사이트에서 제공하는 회원 서비스(이하 "서비스"라 합니다)를 이용함에 있어 이용자와 탁틴내일사이트간의 권리·의무 및 책임사항과 기타 필요한 사항을 규정함을 목적으로 합니다
</pre>
제 2 조 (약관의 효력 및 변경)

<pre class="join-indent">
① 이 약관은 서비스 화면에 게시하거나 기타의 방법으로 공지함으로써 이용자에게 공시하고, 이에 동의한 이용자가 서비스에 가입함으로써 효력이 발생합니다.

② 탁틴내일 사이트는 필요하다고 인정되는 경우 이 약관의 내용을 변경할 수 있으며, 변경된 약관은 서비스 화면에 공지함으로써 이용자가 직접 확인할 수 있도록 할 것입니다.

③ 이용자는 변경된 약관에 동의하지 않으실 경우 서비스 이용을 중단하고 본인의 회원등록을 취소할 수 있으며, 계속 사용하시는 경우에는 약관 변경에 동의한 것으로 간주되며 변경된 약관은 전항과 같은 방법으로 효력이 발생합니다.

④ 이용자가 이 약관의 내용에 동의하는 경우 탁틴내일 사이트의 서비스 제공행위 및 이용자의 서비스 이용행위에는 이 약관이 우선적으로 적용될 것입니다. 이 약관에 명시되지 않은 사항에 대해서는 전기통신기본법, 전기통신사업법, 정보통신망이용촉진및정보보호등에관한법률, 정보통신윤리위원회 심의규정, 정보통신 윤리강령, 프로그램 보호법 등 기타 대한민국의 관련법령과 상관습에 의합니다.
</pre>
			</pre>
			<div class="form-check">
  				<input class="form-check-input" type="checkbox" id="agreeCheck1">
  				<label class="form-check-label" for="agreeCheck1">
    				이용약관에 동의 합니다.
  				</label>
			</div>
			<pre class="join-agree">

탁틴내일 회원 이용약관 안내

제 1 장 총 칙

제 1조 (목적)

<pre class="join-indent">
이 약관은 탁틴내일 사이트에서 제공하는 회원 서비스(이하 "서비스"라 합니다)를 이용함에 있어 이용자와 탁틴내일사이트간의 권리·의무 및 책임사항과 기타 필요한 사항을 규정함을 목적으로 합니다
</pre>
제 2 조 (약관의 효력 및 변경)

<pre class="join-indent">
① 이 약관은 서비스 화면에 게시하거나 기타의 방법으로 공지함으로써 이용자에게 공시하고, 이에 동의한 이용자가 서비스에 가입함으로써 효력이 발생합니다.

② 탁틴내일 사이트는 필요하다고 인정되는 경우 이 약관의 내용을 변경할 수 있으며, 변경된 약관은 서비스 화면에 공지함으로써 이용자가 직접 확인할 수 있도록 할 것입니다.

③ 이용자는 변경된 약관에 동의하지 않으실 경우 서비스 이용을 중단하고 본인의 회원등록을 취소할 수 있으며, 계속 사용하시는 경우에는 약관 변경에 동의한 것으로 간주되며 변경된 약관은 전항과 같은 방법으로 효력이 발생합니다.

④ 이용자가 이 약관의 내용에 동의하는 경우 탁틴내일 사이트의 서비스 제공행위 및 이용자의 서비스 이용행위에는 이 약관이 우선적으로 적용될 것입니다. 이 약관에 명시되지 않은 사항에 대해서는 전기통신기본법, 전기통신사업법, 정보통신망이용촉진및정보보호등에관한법률, 정보통신윤리위원회 심의규정, 정보통신 윤리강령, 프로그램 보호법 등 기타 대한민국의 관련법령과 상관습에 의합니다.
</pre>
			</pre>
			<div class="form-check">
  				<input class="form-check-input" type="checkbox" id="agreeCheck2">
  				<label class="form-check-label" for="agreeCheck2">
					개인정보 수집 및 이용에 동의합니다.
  				</label>
			</div>
			<div class="text-center">
				<button type="button" class="btn btn-outline-secondary" id="btn_agree">동의</button>
			</div>
	</div>
</body>
</html>
