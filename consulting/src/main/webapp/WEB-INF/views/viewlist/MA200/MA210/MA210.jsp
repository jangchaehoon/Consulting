<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<script src="/resources/js/system/menu/menu.js" ></script>
<script type="text/javascript">
	$(document).ready(function(){
		//srch();
		
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
			<input type="hidden" id="page_size" name="page_size" value="10">
			<input type="hidden" id="page" name="page" value="1">
		</div>
		<button type="button" class="btn btn-light" id="btn_add">추가</button>
		
		<div class="menu-table" id="menuTable">
			<table class="table table-hover" style="width:100%; table-layout:fixed">
				<colgroup>
					<col width="8%">
					<col width="15%">
					<col width="8%">
					<col width="10%">
					<col width="*">
					<col width="10%">
					<col width="10%">
					<col width="8%">
					<col width="15%">
				</colgroup>
				<thead>
					<tr>
						<th class="center" scope="col">ID</th>
						<th class="center" scope="col">메뉴명</th>
						<th class="center" scope="col">타입</th>
						<th class="center" scope="col">패턴</th>
						<th class="center" scope="col">URL</th>
						<th class="center" scope="col">상위메뉴</th>
						<th class="center" scope="col">이미지 파일</th>
						<th class="center" scope="col">정렬순서</th>
						<th class="center" scope="col">변경</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="center" colspan="9">게시물이 없습니다.</td>
					</tr>
				</tbody>
			</table>
		</div>
		
		<div class="" id="page_area"></div>
	</div>
</body>
</html>
