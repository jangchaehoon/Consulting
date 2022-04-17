function agreeChk(){
	var agreeCheck1 = $('#agreeCheck1').is(":checked");
	var agreeCheck2 = $('#agreeCheck2').is(":checked");
	
	if(agreeCheck1 && agreeCheck2){
		window.location.href = "/user/join.go";
	} else {
		ypcustom.alert('약관동의', '약관에 동의해주세요.');
	}
}

function beforeRedirect(){
	ypcustom.confirm('주의', '변경사항이 저장되지 않을 수 있습니다.<br>뒤로가시겠습니까?', function(){
		window.location.href = "/user/joinAgree.go";
	});
}

function idCheckInit(){
	$('#idCheck').val('false');
}

function userIdCheck(){
	var flag = true;
	var user_id = $('#user_id').val();
	
	if(!user_id){
		ypcustom.alert("중복확인", "아이디를 입력해주세요.");
		flag = false;
	}
	if(flag){
		$.ajax({
			url: "/user/userIdCheck.ajax",
			type: "POST",
			data: {
				user_id: user_id
			},
			async: false,
			success: function(results) {
				var result = results.result;
				if(result == 0){
					ypcustom.alert("중복확인", "등록가능한 아이디입니다.");
					$('#idCheck').val('true');
				} else {
					ypcustom.alert("중복확인", "중복된 아이디가 존재합니다.");
					$('#idCheck').val('false');
				}
			},
			error : function(request, status, error) {
				ypcustom.alert("중복확인", "처리 중 에러가 발생하였습니다.");
				$('#idCheck').val('false');
			}
		});
	}
}

function pwCheck(){
	var user_pw = $('#user_pw').val();
	var user_pw_confirm = $('#user_pw_confirm').val();
				  
	if(user_pw != user_pw_confirm){
		$('#pwCheckSpan').text('비밀번호 다름');
	} else {
		$('#pwCheckSpan').text('비밀번호 일치');
	}
}

function formSubmit(){
	var flag = true;
	var idCheck = $('#idCheck').val();
	
	if(flag && idCheck != 'true'){
		ypcustom.alert("중복확인", "아이디 중복확인을 해주세요.");
		flag = false;
	}
	
	var user_pw = $('#user_pw').val();
	var user_pw_confirm = $('#user_pw_confirm').val();
	
	if(flag && (user_pw == '' || user_pw != user_pw_confirm)){
		ypcustom.alert("비밀번호 확인", "비밀번호를 확인해주세요.");
		flag = false;
	}
	
	var user_name = $('#user_name').val();
	
	if(flag && user_name == ''){
		ypcustom.alert("중복확인", "이름을 입력해주세요.");
		flag = false;
	}
	
	if(flag){
		$('#joinform').attr('action', "/user/insertUser.ajax");
		$('#joinform').submit();
	}
}