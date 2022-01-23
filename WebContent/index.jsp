<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./CSS/index.css">
<script
	src="https://www.jqueryscript.net/demo/jQuery-Plugin-For-Water-Ripple-Animation-ripples/js/jquery.ripples.js"></script>
<script src="jquery/jquery-3.6.0.js"></script>
<title>main</title>
</head>
<body>

	<div class="main">
		<div class="logo"></div>
		<div id="info">
			<div class="text_box" trigger("typing")>
				<span class="text"></span>
			</div>
		</div>
		<div class="parent">
			<div class="button_base b1_butoon first"
				onclick="location.href='member/login.jsp';">LOGIN</div>
			<div class="button_base b2_butoon second"
				onclick="location.href='member/join.jsp';">JOIN</div>
			<div class="button_base b3_butoon third" onclick="">ABOUT</div>
		</div>
	</div>


	<script>
		const content = "Share your true self.";
		const text = document.querySelector(".text");
		let i = 0;

		function typing() {
			let txt = content[i++];
			text.innerHTML += txt;
			if (i > content.length) {
				text.textContent = "";
				i = 0;
			}
		}
		setInterval(typing, 200)
	</script>

</body>
</html>