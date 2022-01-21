<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../CSS/diary.css">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script src="../jquery/jquery-3.6.0.js"></script>
<title>Insert title here</title>
</head>
<body>
	<header></header>
	<input type="button" value="일기작성" onclick="go_create()">

	<div id="box_container">

		<c:forEach items="${dList}" var="d">
			<div class="diary_list">
				<table>
					<tr>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
					</tr>
					<tr>
						<td><a href="RDS?diaryCode=${d.diaryCode}">${d.title}</a></td>
						<td>${d.userid }</td>
						<td>${d.diaryDate}</td>
					</tr>

				</table>
			</div>
		</c:forEach>



	</div>





	<script>
		function go_create(){
			location.href="create_diary.jsp";
		}
		</script>





</body>
</html>