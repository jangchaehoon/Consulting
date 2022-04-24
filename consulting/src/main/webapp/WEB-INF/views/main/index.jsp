<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <body>
	<div id="main_slide" class="carousel slide carousel-fade row" data-bs-ride="carousel">
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#main_slide" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
			<button type="button" data-bs-target="#main_slide" data-bs-slide-to="1" aria-label="Slide 2"></button>
			<button type="button" data-bs-target="#main_slide" data-bs-slide-to="2" aria-label="Slide 3"></button>
		</div>
		<div class="carousel-inner" style="height:400px;">
			<div class="carousel-item h-100 active">
				<img src="/resources/images/common/main.jpg" class="d-block w-100 h-100" onerror="ypcustom.imgError(this)">
			</div>
			<div class="carousel-item h-100">
				<img src="/resources/images/common/main2.jpg" class="d-block w-100 h-100" onerror="ypcustom.imgError(this)">
			</div>
			<div class="carousel-item h-100">
				<img src="/resources/images/common/main3.jpg" class="d-block w-100 h-100" onerror="ypcustom.imgError(this)">
			</div>
		</div>
		<button class="carousel-control-prev" type="button" data-bs-target="#main_slide" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span>
			<span class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button" data-bs-target="#main_slide" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span>
			<span class="visually-hidden">Next</span>
		</button>
	</div>
	
	<div class="row" style="margin-top: 30px;">
		<div class="col-1">
		</div>
		<div class="col-3">
			<nav>
				<div class="nav nav-tabs" id="board1" role="tablist">
					<button class="nav-link active" id="board1_tab1" data-bs-toggle="tab" data-bs-target="#board1_list1" type="button" role="tab" aria-controls="board1_list1" aria-selected="true">게시판1</button>
					<button class="nav-link" id="board1_tab2" data-bs-toggle="tab" data-bs-target="#board1_list2" type="button" role="tab" aria-controls="board1_list2" aria-selected="false">게시판2</button>
					<button class="nav-link" id="board1_tab3" data-bs-toggle="tab" data-bs-target="#board1_list3" type="button" role="tab" aria-controls="board1_list3" aria-selected="false">게시판3</button>
				</div>
			</nav>
			<div class="tab-content" id="nav-tabContent">
				<div class="tab-pane fade show active" id="board1_list1" role="tabpanel" aria-labelledby="board1_tab1">
					<table class="table table-borderless" style="width:100%; table-layout:fixed">
						<colgroup>
							<col width="*">
							<col width="100px">
						</colgroup>
						<tbody>
							<tr>
								<td>게시판1의 게시물 1번입니다</td>
								<td>2022.04.24</td>
							</tr>
							<tr>
								<td>게시판1의 게시물 2번입니다</td>
								<td>2022.04.24</td>
							</tr>
							<tr>
								<td>게시판1의 게시물 3번입니다 이건 길이테스트를 위해 길게 작성합니다 전체가 보이지 않고 ...으로 나오면 성공입니다.</td>
								<td>2022.04.24</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="tab-pane fade" id="board1_list2" role="tabpanel" aria-labelledby="board1_tab2">
					<table class="table table-borderless" style="width:100%; table-layout:fixed">
						<colgroup>
							<col width="*">
							<col width="100px">
						</colgroup>
						<tbody>
							<tr>
								<td>게시판2의 게시물 1번입니다</td>
								<td>2022.04.24</td>
							</tr>
							<tr>
								<td>게시판2의 게시물 2번입니다</td>
								<td>2022.04.24</td>
							</tr>
							<tr>
								<td>게시판2의 게시물 3번입니다 이건 길이테스트를 위해 길게 작성합니다 전체가 보이지 않고 ...으로 나오면 성공입니다.</td>
								<td>2022.04.24</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="tab-pane fade" id="board1_list3" role="tabpanel" aria-labelledby="board1_tab3">
					<table class="table table-borderless" style="width:100%; table-layout:fixed">
						<colgroup>
							<col width="*">
							<col width="100px">
						</colgroup>
						<tbody>
							<tr>
								<td>게시판3의 게시물 1번입니다</td>
								<td>2022.04.24</td>
							</tr>
							<tr>
								<td>게시판3의 게시물 2번입니다</td>
								<td>2022.04.24</td>
							</tr>
							<tr>
								<td>게시판3의 게시물 3번입니다 이건 길이테스트를 위해 길게 작성합니다 전체가 보이지 않고 ...으로 나오면 성공입니다.</td>
								<td>2022.04.24</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="col-4">
			<nav>
				<div class="nav nav-tabs" id="board2" role="tablist">
					<button class="nav-link active" id="board2_tab1" data-bs-toggle="tab" data-bs-target="#board2_list1" type="button" role="tab" aria-controls="board2_list1" aria-selected="true">이미지형</button>
					<button class="nav-link" id="board2_tab2" data-bs-toggle="tab" data-bs-target="#board2_list2" type="button" role="tab" aria-controls="board2_list2" aria-selected="false">게시판2</button>
				</div>
			</nav>
			<div class="tab-content">
				<div class="tab-pane fade show active main-board-image-area" id="board2_list1" role="tabpanel" aria-labelledby="board2_tab1">
				
					<div id="board2_list1_carousel" class="carousel slide carousel-dark row" data-bs-ride="carousel" data-bs-interval="false">
						<div class="carousel-inner center">
							<div class="carousel-item h-100 active">
								<div class="main-board-imgae">
									<img src="/resources/images/common/main.jpg" class="d-block" onerror="ypcustom.imgError(this)">
									<span>제목1</span>
								</div>
								<div class="main-board-imgae">
									<img src="/resources/images/common/main.jpg" class="d-block" onerror="ypcustom.imgError(this)">
									<span>제목2- 길이테스트 진행합니다.</span>
								</div>
								<div class="main-board-imgae">
									<img src="/resources/images/common/main.jpg" class="d-block" onerror="ypcustom.imgError(this)">
									<span>제목3</span>
								</div>
							</div>
							<div class="carousel-item h-100">
								<div class="main-board-imgae">
									<img src="/resources/images/common/main2.jpg" class="d-block" onerror="ypcustom.imgError(this)">
								</div>
								<div class="main-board-imgae">
									<img src="/resources/images/common/main2.jpg" class="d-block" onerror="ypcustom.imgError(this)">
								</div>
								<div class="main-board-imgae">
									<img src="/resources/images/common/main.jpg" class="d-block" onerror="ypcustom.imgError(this)">
								</div>
							</div>
						</div>
						<button class="carousel-control-prev main-board-carousel-prev" type="button" data-bs-target="#board2_list1_carousel" data-bs-slide="prev">
							<span class="carousel-control-prev-icon" aria-hidden="true"></span>
							<span class="visually-hidden">Previous</span>
						</button>
						<button class="carousel-control-next main-board-carousel-next" type="button" data-bs-target="#board2_list1_carousel" data-bs-slide="next">
							<span class="carousel-control-next-icon" aria-hidden="true"></span>
							<span class="visually-hidden">Next</span>
						</button>
					</div>
				</div>
				<div class="tab-pane fade" id="board2_list2" role="tabpanel" aria-labelledby="board2_tab2">
					<table class="table table-borderless" style="width:100%; table-layout:fixed">
						<colgroup>
							<col width="*">
							<col width="100px">
						</colgroup>
						<tbody>
							<tr>
								<td>게시판2의 게시물 1번입니다</td>
								<td>2022.04.24</td>
							</tr>
							<tr>
								<td>게시판2의 게시물 2번입니다</td>
								<td>2022.04.24</td>
							</tr>
							<tr>
								<td>게시판2의 게시물 3번입니다 이건 길이테스트를 위해 길게 작성합니다 전체가 보이지 않고 ...으로 나오면 성공입니다.</td>
								<td>2022.04.24</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="col-3">
			<nav>
				<div class="nav nav-tabs" id="board3" role="tablist">
					<button class="nav-link active" id="board3_tab1" data-bs-toggle="tab" data-bs-target="#board3_list1" type="button" role="tab" aria-controls="board3_list1" aria-selected="true">게시판1</button>
				</div>
			</nav>
			<div class="tab-content" id="nav-tabContent">
				<div class="tab-pane fade show active" id="board3_list1" role="tabpanel" aria-labelledby="board3_tab1">
					<table class="table table-borderless" style="width:100%; table-layout:fixed">
						<colgroup>
							<col width="*">
							<col width="100px">
						</colgroup>
						<tbody>
							<tr>
								<td>게시판1의 게시물 1번입니다</td>
								<td>2022.04.24</td>
							</tr>
							<tr>
								<td>게시판1의 게시물 2번입니다</td>
								<td>2022.04.24</td>
							</tr>
							<tr>
								<td>게시판1의 게시물 3번입니다 이건 길이테스트를 위해 길게 작성합니다 전체가 보이지 않고 ...으로 나오면 성공입니다.</td>
								<td>2022.04.24</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="col-1">
		</div>
	</div>
  </body>
</html>
