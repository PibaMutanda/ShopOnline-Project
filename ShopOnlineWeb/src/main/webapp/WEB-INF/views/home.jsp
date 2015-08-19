<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link href="resources/css/style.css" rel="stylesheet" type="text/css">

<style>
.carousel-inner>.item>img, .carousel-inner>.item>a>img {
	width: 70%;
	margin: auto;
}
</style>
<head>
</head>
<body>
	<div class="container">
		<br>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img src="img_chania.jpg" alt="Chania" width="460" height="345">
				</div>

				<div class="item">
					<img src="img_chania2.jpg" alt="Chania" width="460" height="345">
				</div>

				<div class="item">
					<img src="img_flower.jpg" alt="Flower" width="460" height="345">
				</div>

				<div class="item">
					<img src="img_flower2.jpg" alt="Flower" width="460" height="345">
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" role="button"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel" role="button"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
	</div>
	<p>${message }</p>
	<br>
	<div>
		<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
			Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque
			penatibus et magnis dis parturient montes, nascetur ridiculus mus.
			Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem.
			Nulla consequat massa quis enim. Donec pede justo, fringilla vel,
			aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut,
			imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede
			mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum
			semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula,
			porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante,
			dapibus in, viverra quis</p>
	</div>
</body>
</html>