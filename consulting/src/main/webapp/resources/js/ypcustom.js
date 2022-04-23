(function($) {

var window = this,
    ypcustom = gx = $.gx = $.ypcustom = window.ypcustom = function() {
    	return new ypcustom.fn.init();
    };

ypcustom.fn =
	ypcustom.prototype =  {
		init:function() {
			return this;
		},
		about:"ypcustom javascript library",
		version: "1.0.0"
	};

})(jQuery);

ypcustom.fn.init.prototype = ypcustom.fn;

var _csrf = $("meta[name='_csrf']").attr("name") + "=" + $("meta[name='_csrf']").attr("content");

/* 해상도 */
var screenWidth = screen.width;
var screenHeight = screen.height;

/* 창크기 */
var windowWidth = window.innerWidth;
var windowHeight = window.innerHeight;

/* 페이지 스크롤높이 */
var pageWidth  = document.documentElement.scrollWidth;
var pageHeight = document.documentElement.scrollHeight;

ypcustom.init = function(){
	ypcustom.scrollSizeInit();

	window.addEventListener("resize", ypcustom.scrollSizeInit);
}

/* 페이지 사이즈 초기화 */
ypcustom.pageSizeInit = function(){
	/* 해상도 */
	screenWidth = screen.width;
	screenHeight = screen.height;

	/* 창크기 */
	windowWidth = window.innerWidth;
	windowHeight = window.innerHeight;

	/* 페이지 스크롤높이 */
	pageWidth  = document.documentElement.scrollWidth;
	pageHeight = document.documentElement.scrollHeight;
}

/* 창크기에 따른 높이 설정 */
ypcustom.scrollSizeInit = function(){
	ypcustom.pageSizeInit();
	
	/* 상단 네비바 높이 */
	var navHeight = $("#header_navbar").height();
	
	/* 바디 높이 설정 */
	$('.body_contents').css("height", windowHeight - navHeight);
	$('.body_contents').css("margin-top", navHeight);
};

/* 이미지 에러 처리 */
ypcustom.imgError =  function(image){
	image.onerror = "";
	image.src = "/resources/images/common/alt_image.gif";
	return true;
}

ypcustom.modalRemove = function(){
	$('.custom-modal').remove();
}

ypcustom.alert = function(title, msg){
	
	ypcustom.modalRemove();
	
	var html  = '<div class="custom-modal">';
		html += '	<div class="custom-modal-items">';
		html += '		<div class="custom-modal-title">';
		html += title;
		html += '		</div>';
		html += '		<div class="custom-modal-contents">';
		html += msg;
		html += '		</div>';
		html += '		<div class="custom-modal-bottom">';
		html += '			<button type="button" class="btn btn-outline-secondary" id="modal_cancel">확인</button>';
		html += '		</div>';
		html += '	</div>';
		html += '</div>';
		
	$('#topBody').append(html);
	
	$('#modal_cancel').bind('click', function(){
		ypcustom.modalRemove();
	});
}

ypcustom.confirm = function(title, msg, callbackFn){
	
	ypcustom.modalRemove();
	
	var html  = '<div class="custom-modal">';
		html += '	<div class="custom-modal-items">';
		html += '		<div class="custom-modal-title">';
		html += title;
		html += '		</div>';
		html += '		<div class="custom-modal-contents">';
		html += msg;
		html += '		</div>';
		html += '		<div class="custom-modal-bottom">';
		html += '			<button type="button" class="btn btn-outline-secondary" id="modal_cancel">취소</button>';
		html += '			<button type="button" class="btn btn-outline-secondary" id="modal_success">확인</button>';
		html += '		</div>';
		html += '	</div>';
		html += '</div>';
		
	$('#topBody').append(html);
		
	$('#modal_cancel').bind('click', function(){
		ypcustom.modalRemove();
	});
		
	if(callbackFn != undefined){
		$('#modal_success').bind('click', function(){
			callbackFn();
			ypcustom.modalRemove();	
		});
	} else{
		$('#modal_success').bind('click', function(){
			ypcustom.modalRemove();
		});
	}
}

ypcustom.popOpen = function(options){
	
	var pid = options.pid;
	var url = options.url;
	var data = options.data;
	var height = options.height;
	var width = options.width;
	var callbackFn = options.callbackFn;
	
	$.ajax({
		url: url + "?" + _csrf,
		type: "POST",
		dataType: "text",
		data: data,
		success: function(results) {
			var html  = '<div class="pop" id="' + pid + '">';
				html += '	<div class="pop-items" style="height:' + height + 'px; width:' + width + 'px;">';
				html += '		<div class="pop-title">';
				html += options.title;
				html += '			<i class="bi bi-x-square pop-close" id="pop_close' + pid + '" onclick=""></i>';
				html += '		</div>';
				html += '		<div class="overflow-y" style="height:' + (height - 42) + 'px;">';
				html += '			<div class="pop-contents">';
				html += results;
				html += '			</div>';
				html += '		</div>';
				html += '		<div class="pop-bottom">';
				html += '		</div>';
				html += '	</div>';
				html += '</div>';
				html += '<input type="hidden" id="pid" name="pid" value="' + pid + '">';
		
			$('#topBody').append(html);
			
			if(callbackFn != undefined){
				$('#pop_close'+pid).bind('click', function(){
					callbackFn();
					$('#' + pid + '').remove();
				});
			} else{
				$('#pop_close'+pid).bind('click', function(){
					$('#' + pid + '').remove();
				});
			}
	
		},
		error : function(request, status, error) {
			ypcustom.alert("에러", "알수 없는 에러 발생")
		}
	});

}

ypcustom.srch = function(options){
	var url = options.url;
	var target = options.target;
	var data = options.date;
	
	_csrf = $("meta[name='_csrf']").attr("name") + "=" + $("meta[name='_csrf']").attr("content");
	$.ajax({
		url: url + "?" + _csrf,
		type: "POST",
		dataType: "html",
		data: data,
		async: false,
		success: function(results) {
			$('#' + target).html(results)
		},
		error : function(request, status, error) {
			ypcustom.alert("에러", "알수 없는 에러 발생")
		}
	});
}