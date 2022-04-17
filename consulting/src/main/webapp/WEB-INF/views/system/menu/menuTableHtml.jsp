<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
	<table class="table table-hover">
	<thead>
		<tr>
			<th scope="col">ID</th>
			<th scope="col">메뉴명</th>
			<th scope="col">타입</th>
			<th scope="col">패턴</th>
			<th scope="col">URL</th>
			<th scope="col">상위메뉴</th>
			<th scope="col">이미지 파일</th>
			<th scope="col">정렬순서</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${results }" var="MenuVO">
		<tr>
			<td>${MenuVO.menu_id }</td>
			<td>${MenuVO.menu_name }</td>
			<td>${MenuVO.menu_type }</td>
			<td>${MenuVO.menu_pattren }</td>
			<td>${MenuVO.menu_url }</td>
			<td>${MenuVO.parents_menu_id }</td>
			<td>${MenuVO.menu_img_file_seq }</td>
			<td>${MenuVO.sort_no }</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
