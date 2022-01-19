<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 체크</title>
<script src="../script/member.js"></script>
</head>
<body>
<h2>아이디 중복 체크</h2>
<form action="idCheck.do" method="GET" name="frm">
	아이디 : <input type="text" name="userid" value="${userid}">
	<input type="submit" value="중복 체크"><br>

	<c:if test="${result==1}"> <!-- 중복된 아이디가 있다면 -->
		<script>
			opener.document.frm.userid.value="";
		</script>
		${userid}는 이미 사용중인 아이디 입니다.
	</c:if>
	
	<c:if test="${result==-1}"> <!-- 중복된 아이디가 없다면 -->
		${userid}는 사용 가능한 아이디 입니다.
		<input type="button" value="사용" onclick="idOk()">
	
	</c:if>

</form>
</body>
</html>