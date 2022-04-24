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
		<h4>오시는길</h4>
		<table class="table table-borderless" style="width:100%; table-layout:fixed">
			<colgroup>
				<col width="8%">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th class="center" scope="col">주소</th>
					<td>서울특별시 00구 00로 00빌딩</td>
				</tr>
				<tr>
					<th class="center" scope="col">전화</th>
					<td>02) 000-0000</td>
				</tr>
				<tr>
					<th class="center" scope="col">팩스</th>
					<td>02) 000-0000</td>
				</tr>
				<tr>
					<th class="center" scope="col">이메일</th>
					<td>aaa@gmail.com</td>
				</tr>
				<tr>
					<th class="center" scope="col">약도</th>
					<td></td>
				</tr>
				<tr>
					<td colspan="2">
						<section id="google-map-area">
		        			<div class="mx-6 mb-6">
					            <div class="flex">
					                <div class="w-full">
					                	<iframe style="border:1px solid gray; height: 450px; width: 100%;" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3163.487646688703!2d126.89752691558795!3d37.543573233200036!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357c9ece0f65a781%3A0xef5371f8485ba9bf!2z7ISg7Jyg64-E6rO17JuQ!5e0!3m2!1sko!2skr!4v1650776932691!5m2!1sko!2skr" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
					                </div>
					            </div>
					        </div>
					    </section>
				    </td>
				</tr>
			</tbody>
		</table>
    </div>
</body>
</html>
