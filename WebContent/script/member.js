/**
 * 
 */

function updateCheck(){
	//
	//암호 일치 여부
	if(document.frm.userpwd.value!=document.frm.pwd_check.value){
		alert('비밀번호가 일치하지 않습니다.');
		document.frm.userpwd.value="";
		document.frm.pwd_check.value="";
		
		document.frm.userpwd.focus();
		return false;
	}
	
	return true;
}

function joinCheck(){
	//암호 일치 여부
	if(document.frm.userpwd.value!=document.frm.pwd_check.value){
		alert('비밀번호가 일치하지 않습니다.');
		document.frm.userpwd.value="";
		document.frm.pwd_check.value="";
		
		document.frm.userpwd.focus();
		return false;
	}
	
	//아이디 중복 체크 여부 확인
	if(document.frm.reid.value.length == 0){
		alert('중복 체크를 하지 않았습니다.');
		frm.userid.focus();
		return false;
	}
	
	
	return true;
}

function idCheck(){
	// 체크할 아이디가 있는지 확인
	if(document.frm.userid.value.length==0){
		alert('아이디를 입력해주세요.');
		frm.userid.focus();
		return false;
	}
	
	let url = "idCheck.do?userid="+document.frm.userid.value;
	
	console.log(url);
	
	window.open(url,"_blank1","toolbar=no,menubar=no,scrollbars=yes,resizable=no,width=450,height=200");
	
	
}

function idOk(){
	opener.frm.userid.value = document.frm.userid.value;
	opener.frm.reid.value = document.frm.userid.value;
	
	self.close(); //현재 새로 열린 창 닫기
}

function go_create(){
	location.href="member/create_diary.jsp";
}












