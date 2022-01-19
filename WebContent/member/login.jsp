<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href ="./CSS/style.css">
<title>LOGIN</title>
</head>
<body>
<h2>My diary LOGIN</h2>
<form action="login.do" method="post">
	<table>
		<tr>
			<td>아이디</td>
			<td> <input type="text" name="userid" required> </td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td> <input type="password" name="userpwd" required> </td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="로그인" >
				<input type="reset" value="입력취소">
			</td>
		</tr>
		<tr>
			<td colspan="2">${message}</td>
		</tr>
	</table>
</form>
</body>
</html>