var _csrf = $("meta[name='_csrf']").attr("name") + "=" + $("meta[name='_csrf']").attr("content");

function srch(){
	
	var obj = Object();
	$('#searchDiv').find("input").each(function(){
		obj[$(this).attr("id")] = $(this).attr("value");
	});
	
	ypcustom.srch({
		url: '/system/menu/getMenuTableHtml.ajax',
		target: 'menuTable',
		date: obj
	});
}

function menuRegi(seq){
	
	if(seq == undefined || seq == ''){
		ypcustom.popOpen({
			pid: "menuRegiHtml",
			title: '메뉴 등록',
			url: "/system/menu/menuRegiHtml.pop",
			height: 650,
			width: 500,
			callbackFn: srch
		})
	} else {
		ypcustom.popOpen({
			pid: "menuRegiHtml",
			title: '메뉴 추가',
			url: "/system/menu/menuRegiHtml.pop",
			data: {
				seq: seq
			},
			height: 650,
			width: 500,
			callbackFn: srch
		})
	}
}

function menuDelete(seq){
	ypcustom.confirm('메뉴 삭제', '삭제하시겠습니까?', function(){
		$.ajax({
			url: "/system/menu/deleteMenu.ajax?" + _csrf,
			type: "POST",
			data: {
				seq: seq
			},
			async: false,
			success: function(results) {
				ypcustom.alert("중복확인", "등록가능한 아이디입니다.");
				srch();
			},
			error : function(request, status, error) {
				ypcustom.alert("중복확인", "처리 중 에러가 발생하였습니다.");
				srch();
			}
		});
	});
}

function beforeCheck(){
	var flag = true;
	/*
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
	*/
	return flag;
}

function formSubmit(){
	var flag = beforeCheck();
	if(flag){
		var seq = $('#seq').val();
		var url = "";
		if(seq != ''){
			url = "/system/menu/updateMenu.ajax?" + _csrf;
		} else {
			url = "/system/menu/insertMenu.ajax?" + _csrf;
		}
		
		$('#menuRegiform')
			.ajaxForm({
				url: url,
				dataType: 'json',
				success: function(results){
					$('#pop_close' + $('#pid').val()).click();
				},
				error: function(err){
					console.log(err)
				}
			});
		$('#menuRegiform').submit();
	}
}