<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href ="../CSS/diary.css">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script src="../jquery/jquery-3.6.0.js"></script>
<title>Insert title here</title>
</head>
<body>
<header></header>
${message }
<input type="button" value="일기작성" onclick="go_create()">

<div class="box_container">

<c:forEach items="${dList}" var="d">
	 <div class="diary_list">	
	<table>
  	<tr>
	  	<th>제목</th>
	  	<th>작성자</th>
	  	<th>작성일</th>
  	</tr>
  	<tr>
		<td><a href="RDS?diaryCode=${d.diaryCode }">${d.title }</a></td>
		<td>${d.userid }</td>
		<td>${d.diaryDate }</td>
	</tr>
	
	</table>
	</div>
 </c:forEach>



</div>



<script>

$(document).ready(function(){
    $(window).scroll(function(){ //스크롤 이벤트가 발생했을때 작동되는 함수
        let viewSize = $(window).height();  //화면의 높이
        let scrollDistance = $(window).scrollTop(); // 스크롤된 거리 : 스크롤바의 상단부가 움직인 거리
                let documentSize = $(document).height();   //문서의 높이

                if((viewSize+scrollDistance)==documentSize){// 화면이 문서의 끝에 도달했다면
                    for(let i=0;i<10;i++){
                        $("#scroll").html('무한 인사 - 안녕하세요').appendTo($('div'));
                    }
                }
            })


        });

function go_create(){
	location.href="create_diary.jsp";
}




    </script>





</body>
</html>