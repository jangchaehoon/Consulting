<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<script src="/resources/js/user/login.js" ></script>
<script type="text/javascript">
	$(document).ready(function(){
		$.ajax({
			url: "/system/menu/getMenuTableHtml.ajax",
			type: "POST",
			dataType: "html",
			async: false,
			success: function(results) {
				$('#menuTable').append(results)
			},
			error : function(request, status, error) {
				ypcustom.alert("에러", "알수 없는 에러 발생")
			}
		});
	});
</script>
</head>
<body>
	<div class="container">
		<div class="menu-table" id="menuTable">
		</div>
	</div>
</body>
</html>
