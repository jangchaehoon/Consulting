<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <body>
    <section>
		<div id="main_slide" class="carousel slide carousel-fade" data-bs-ride="carousel">
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
    </section>
  
    <!-- Map Section Start -->
    <section id="google-map-area">
        <div class="mx-6 mb-6">
            <div class="flex">
                <div class="w-full">
                    <object style="border:0; height: 450px; width: 100%;" data="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3102.7887109309127!2d-77.44196278417968!3d38.95165507956235!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x0!2zMzjCsDU3JzA2LjAiTiA3N8KwMjYnMjMuMiJX!5e0!3m2!1sen!2sbd!4v1545420879707"></object>
                </div>
            </div>
        </div>
    </section>
    <!-- Map Section End -->

  </body>
</html>
