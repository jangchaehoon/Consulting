<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<c:forEach items="${results }" var="MenuVO">
			<tr>
				<td class="center">${MenuVO.menu_id }</td>
				<td class="center">${MenuVO.menu_name }</td>
				<td class="center">${MenuVO.menu_type }</td>
				<td>${MenuVO.menu_pattren }</td>
				<td>${MenuVO.menu_url }</td>
				<td class="center">${MenuVO.parents_menu_id }</td>
				<td>${MenuVO.menu_img_file_seq }</td>
				<td class="center">${MenuVO.sort_no }</td>
				<td class="center">
					<button type="button" class="btn btn-light btn-sm" onclick="menuRegi('${MenuVO.seq }')">수정</button>
					<button type="button" class="btn btn-light btn-sm" onclick="menuDelete('${MenuVO.seq }')">삭제</button>
				</td>
			</tr>
			</c:forEach>
		</tbody>
</table>
