<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	$(document).ready(function(){
		
		if('${MenuVO.seq}' != ''){
			$('.non-edit').attr('readonly', 'readonly');
		}
		
		$("#btn_close").bind('click', function(){
			$('#pop_close' + $('#pid').val()).click();
		})
		
		$('#btn_regi').bind('click', formSubmit)
	});
</script>
	<form id="menuRegiform" name="menuRegiform" method="post" action="">
		<input type="hidden" id="seq" name="seq" value="${MenuVO.seq }">
		<table class="table table-hover" style="width:100%">
			<colgroup>
				<col width="30%">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th class="center" scope="col">ID</th>
					<td>
						<input type="text" class="form-control non-edit" id="menu_id" name="menu_id" value="${MenuVO.menu_id }">
					</td>
				</tr>
				<tr>
					<th class="center" scope="col">메뉴명</th>
					<td>
						<input type="text" class="form-control" id="menu_name" name="menu_name" value="${MenuVO.menu_name }">
					</td>
				</tr>
				<tr>
					<th class="center" scope="col">타입</th>
					<td class="center">
						<input type="text" class="form-control" id="menu_type" name="menu_type" value="${MenuVO.menu_type }">
					</td>
				</tr>
				<tr>
					<th class="center" scope="col">패턴</th>
					<td>
						<input type="text" class="form-control" id="menu_pattren" name="menu_pattren" value="${MenuVO.menu_pattren }">
					</td>
				</tr>
				<tr>
					<th class="center" scope="col">URL</th>
					<td>
						<input type="text" class="form-control" id="menu_url" name="menu_url" value="${MenuVO.menu_url }">
					</td>
				</tr>
				<tr>
					<th class="center" scope="col">상위메뉴</th>
					<td class="center">
						<input type="text" class="form-control" id="parents_menu_id" name="parents_menu_id" value="${MenuVO.parents_menu_id }">
					</td>
				</tr>
				<tr>
					<th class="center" scope="col">이미지파일</th>
					<td>
						<input type="text" class="form-control" id="menu_img_file_seq" name="menu_img_file_seq" value="${MenuVO.menu_img_file_seq }">
					</td>
				</tr>
				<tr>
					<th class="center" scope="col">정렬순서</th>
					<td class="center">
						<input type="text" class="form-control" id="sort_no" name="sort_no" value="${MenuVO.sort_no }">
					</td>
				</tr>
				<tr>
					<th class="center" scope="col">사용여부</th>
					<td class="center">
						<input type="text" class="form-control" id="use_yn" name="use_yn" value="${MenuVO.use_yn }">
					</td>
				</tr>
			</tbody>
		</table>
	</form>
<div class="center">
	<button type="button" class="btn btn-light btn-sm" id="btn_close">취소</button>
	<button type="button" class="btn btn-light btn-sm" id="btn_regi">저장</button>
</div>