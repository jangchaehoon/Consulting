<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<script src="/resources/js/system/menu/menu.js" ></script>
<script type="text/javascript">
	$(document).ready(function(){
		srch();
		
		$('#btn_add').bind("click", function(){
			menuRegi();
		})
		
	});
</script>
</head>
<body>
	<div class="menu-body">
		<div id="searchDiv">
			<input type="hidden" id="sort_column" name="sort_column" value="parents_sort_no, lv, sort_no">
		</div>
		<button type="button" class="btn btn-light" id="btn_add">추가</button>
		
		<div class="menu-table" id="menuTable"></div>
	</div>
</body>
</html>
