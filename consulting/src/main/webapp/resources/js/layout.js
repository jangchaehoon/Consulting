function init(){
}

/* 창크기에 따른 높이 설정 */
function scrollSizeInit(){
	/* 해상도 */
	var screenWidth = screen.width;
	var screenHeight = screen.height;

	/* 창크기 */
	var windowWidth = window.innerWidth;
	var windowHeight = window.innerHeight;

	/* 페이지 스크롤높이 */
	var pageWidth  = document.documentElement.scrollWidth;
	var pageHeight = document.documentElement.scrollHeight;
	
	/* 상단 네비바 높이 */
	var navHeight = $("#header_navbar").height();
	
	/* 바디 높이 설정 */
	$('#body_contents').css("height", windowHeight - navHeight);	
};

/* 이미지 에러 처리 */
function imgError(image){
	image.onerror = "";
	image.src = "/resources/images/common/alt_image.gif";
	return true;
}