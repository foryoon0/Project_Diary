<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../CSS/creatediary.css">
<title>Insert title here</title>
</head>
<body>
<header></header>
<form action="CDS" method="GET">
	<fieldset>
		<legend>오늘의 일기 작성</legend>
		작성자 : <input type="text" name="userid"><br>
		제목 :<input type="text" name="title"> <br>
		내용 :<textarea name="content"></textarea> <br>
		${message }
		<input type="submit" value="저장">
		
	</fieldset>
</form>



</body>
</html>