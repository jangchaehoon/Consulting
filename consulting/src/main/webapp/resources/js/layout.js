var _csrf = $("meta[name='_csrf']").attr("name") + "=" + $("meta[name='_csrf']").attr("content");

function menuInit(){
	$.ajax({
		url: '/system/menu/getMenuList.ajax?' + _csrf,
		type: "POST",
		dataType: "json",
		async: false,
		success: function(results) {
			menuDraw(results.results);
		},
		error : function(request, status, error) {
			ypcustom.alert("에러", "알수 없는 에러 발생")
		}
	});	
}
	
function menuDraw(menuList){
	for(var i=0; i<menuList.length ; i++){
		var menu = menuList[i];
		var html = "";
		
		if(menu.menu_url == 'NONE'){
			menu.menu_url = '#';
		}
		
		if(menu.lv == 1){
			if(menu.child_cnt == 0){
				html += '<li class="nav-item">';
				html += '	<a href="' + menu.menu_url + '" class="nav-link px-4 disabled link-dark" role="button">' + menu.menu_name + '</a>';
				html += '</li>';
			} else {
				html += '<li class="nav-item dropdown dropdown-hover">';
				html += '	<a href="#" id="' + menu.menu_id + '" class="nav-link dropdown-toggle disabled px-4 link-dark" role="button" data-bs-toggle="dropdown" >' + menu.menu_name + '</a>';
				html += '	<ul class="dropdown-menu dropdown-menu-hover" aria-labelledby="' + menu.menu_id + '">';
				html += '	</ul>';
				html += '</li>';
			}
			$('#topMenu').append(html);
			html = "";
		} else if(menu.lv == 2) {
			if(menu.child_cnt == 0){
				html += '<li><a class="dropdown-item" id="' + menu.menu_id + '" href="' + menu.menu_url + '">' + menu.menu_name + '</a></li>';
				$('ul[aria-labelledby='+ menu.parents_menu_id + ']').append(html);
				html = "";
			} else {
				/* 기능없음 */
			}
			var parents_menu_id = $('#parents_menu_id').val();
			var menu_id = $('#menu_id').val();
			
			if(menu_id == menu.menu_id){
				$('#leftmenu_title').text(menu.parents_menu_name);
			}
			
			if(parents_menu_id == menu.parents_menu_id){
				if(menu_id == menu.menu_id){
					html += '<li class="nav-item">';
					html += '	<a class="nav-link active" aria-current="page" href="' + menu.menu_url + '">' + menu.menu_name + '</a>';
					html += '</li>';
				} else {
					html += '<li class="nav-item">';
					html += '	<a class="nav-link" aria-current="page" href="' + menu.menu_url + '">' + menu.menu_name + '</a>';
					html += '</li>';
				}
				
				$('#leftmenu-contents').append(html);
			}
		} else {
			/* 기능없음 */
		}
		
	}
}
