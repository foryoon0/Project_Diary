<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../CSS/join.css">
<script src="../script/member.js"></script>
<title>회원가입</title>
</head>
<body>
	<header></header>
	<div id="join_line"></div>


	<form action="join.do" method="POST" name="frm">

		<table>

			<tr>
				<td>아이디</td>
				
			</tr>
			<tr>
				<td><input type="text" name="userid" required> <input
					type="hidden" name="reid">
				<!-- 중복확인했는지 여부 --> <input type="button" value="중복체크"
					onclick="idCheck()"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				
			</tr>
			<tr>
				<td><input type="password" name="userpwd" required>*</td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				
			</tr>
			<tr>
				<td><input type="password" name="pwd_check" required> *</td>
			</tr>

			<tr>
				<td>닉네임</td>
				
			</tr>
			<tr>
				<td><input type="tel" name="nickname"></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="회원 가입"
					onclick="return joinCheck()" class="button_base b2_butoon second">

				
			</tr>
		</table>
	</form>
</body>
</html>