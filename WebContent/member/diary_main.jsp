<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href ="../CSS/diary.css">
<script src="../jquery/jquery-3.6.0.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="diarybody">
	<a href="DLS?command=paging">페이징보기</a> / 
	<a href="DLS?command=scroll">무한스크롤보기</a>
</div>
<div class="banner"></div>




<c:if test="${totalCnt == null}">
	<div class="scrollbody">
		<div class="diarybody">
			<input type="button" value="일기작성" onclick="go_create()">
		</div>
		<table>
			<thead>
				<tr>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody id="scrolltbody">

			</tbody>
		</table>
	</div>
</c:if>




<c:if test="${totalCnt != null}">
<table>
	<tr>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
	</tr>
	<c:forEach items="${dList}" var="d">
	<tr>
		<td><a href="RDS?diaryCode=${d.diaryCode }">${d.title }</a></td>
		<td>${d.userid }</td>
		<td>${d.diaryDate }</td>
	</tr>
	</c:forEach>
</table>
<div class="diarybody">
	<input type="button" value="일기작성" onclick="go_create()">
</div>

<div class="pagingbody">


	<c:choose>
		<c:when test="${totalCnt>100}">
			<c:if test="${(section)*100<totalCnt}"> <!--   >>(다음 섹션이 존재한다.)    -->
				<c:forEach var="page" begin="1" end="10" step="1" >
					<c:if test="${section >1 && page==1}"> <!--  이전 섹션 표시 << -->
						<a href="DLS?section=${section-1}&pageNum=10"> << </a>
					</c:if>
						<a href="DLS?section=${section}&pageNum=${page}">${(section-1)*10+page}</a>
					<c:if test="${page==10}"> <!--  다음 섹션 표시 >> -->
						<a href="DLS?section=${section+1}&pageNum=1"> >> </a>
					</c:if>
				</c:forEach>
			</c:if>
			<c:if test="${(section)*100>totalCnt}"> <!--   (다음 섹션이 없다!!) -->
				<c:forEach  var="page" begin="1" end="${((totalCnt+9)-(section-1)*100)/10}" step="1" >
					<c:if test="${section >1 && page==1}"> <!--  이전 섹션 표시 << -->
						<a href="DLS?section=${section-1}&pageNum=10"> << </a>
					</c:if>
						<a href="DLS?section=${section}&pageNum=${page}">${(section-1)*10+page}</a>
				</c:forEach>
			</c:if>
		</c:when>	
		<c:when test="${totalCnt==100}">
			<c:forEach var="page" begin="1" end="10" step="1">
				<a href="DLS?section=${section}&pageNum=${page}">${page}</a>
			</c:forEach>
		</c:when>	
		<c:when test="${totalCnt<100}">
			<c:forEach var="page" begin="1" end="${(totalCnt+9)/10}" step="1">
				<a href="DLS?section=${section}&pageNum=${page}">${page}</a>
			</c:forEach>
		</c:when>	
	</c:choose>
</div>
</c:if>



<script>
function go_create(){
	location.href="create_diary.jsp";
}

$(document).ready(function(){

	let tbody = document.getElementById('scrolltbody');
	var dList = JSON.parse('${dList}');

	var count = 50;
	var tdBackColor = ['td_color1','td_color2','td_color3','td_color4','td_color5','td_color6','td_color7'];
	var bgColorIndex = 1;
	
	for(let i=0; i<count; i++){
		let tr = document.createElement('tr');
		
				
		let td = document.createElement('td');
		td.setAttribute("class","td_color1");
		td.innerHTML = dList[i].title;
		tr.appendChild(td);

		td = document.createElement('td');
		td.setAttribute("class","td_color1");
		td.innerHTML = dList[i].userid;
		tr.appendChild(td);

		td = document.createElement('td');
		td.setAttribute("class","td_color1");
		td.innerHTML = dList[i].diaryDate;
		tr.appendChild(td);

		tbody.appendChild(tr);
	}

    $(window).scroll(function(){ // 스크롤 이벤트가 발생했을때 작동되는 함수(움직이는중일떄)
        let viewSize = $(window).height(); // 화면의 높이
        let scrollDistance = $(window).scrollTop(); // 스크롤된 거리
        let documentSize = $(document).height(); // 문서의 높이 

        if((viewSize+scrollDistance) == documentSize){ // 화면이 문서의 끝에 도달했다면

			count = count + 50;
			bgColorIndex = (bgColorIndex%7) + 1;

            for(let i=count-50; i<count; i++){
				let tr = document.createElement('tr');
				
				let td = document.createElement('td');
				td.setAttribute("class","td_color"+bgColorIndex);
				td.innerHTML = dList[i].title;
				tr.appendChild(td);

				td = document.createElement('td');
				td.setAttribute("class","td_color"+bgColorIndex);
				td.innerHTML = dList[i].userid;
				tr.appendChild(td);

				td = document.createElement('td');
				td.setAttribute("class","td_color"+bgColorIndex);
				td.innerHTML = dList[i].diaryDate;
				tr.appendChild(td);

				tbody.appendChild(tr);
            }
        }
    })
})

</script>
</body>
</html>