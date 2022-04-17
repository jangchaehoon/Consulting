function formSubmit(){
	var flag = true;
	var user_id = $('#user_id').val();
	
	if(flag && user_id == ''){
		ypcustom.alert("아이디확인", "아이디를 입력해주세요.");
		flag = false;
	}
	
	var user_pw = $('#user_pw').val();
	
	if(flag && user_pw == ''){
		ypcustom.alert("비밀번호확인", "비밀번호를 입력해주세요.");
		flag = false;
	}
	
	if(flag){
		$('#loginform').attr('action', "/login.do");
		$('#loginform').submit();
	}
}