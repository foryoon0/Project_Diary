<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../jquery/jquery-3.6.0.js"></script>
</head>
<body>

<form action="UDS" method="GET">
	<fieldset>
		<legend>오늘의 일기 작성</legend>
		작성자 : <input type="text" id="userid" name="userid" value="${dVo.userid }"readonly><br>
		작성일시 : <input type="text" id="diaryDate" name="diaryDate" value="${dVo.diaryDate }" readonly> <br>
		제목 :<input type="text" id="title" name="title" value="${dVo.title }" readonly> <br>
		내용 :<textarea id="content" name="content" readonly>${dVo.content }</textarea> <br>
		<input type="hidden" id="diaryCode" name="diaryCode" value="${dVo.diaryCode }">
		<input type="button" id="updateBtn" name="updateBtn" value="수정" onclick="updateDiary('${dVo.diaryCode}')">
		<input type="hidden" id="goUpdate" name="goUpdate" value="확인">
		<input type="button" id="deleBtn" name="deleBtn" value="삭제" onclick="deleteDiary('${dVo.diaryCode}')">
		
		
	</fieldset>
</form>

<script>
	function updateDiary(code){
		console.log(code);
		
		$('#title').attr('readonly',false);
		$('#content').attr('readonly',false);
		
		$('#updateBtn').attr('type','hidden');
		$('#goUpdate').attr('type','submit');
	}
	function deleteDiary(code){
		alert("삭제");
		location.href="DDS?code="+code;
	}
</script>

</body>
</html>