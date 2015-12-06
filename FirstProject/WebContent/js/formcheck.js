function formCheck() {	
	if(document.writeForm.writer.value == "") {
		alert("작성자가 입력되지않았습니다.\n작성자를 입력해 주세요");
		document.writeForm.writer.focus();
		return false;
	}	
	if(document.writeForm.title.value == "") {
		alert("글 제목이 입력되지 않았습니다..\n글 제목을 입력해 주세요");
		document.writeForm.title.focus();
		return false;
	}
	if(document.writeForm.content.value == "") {
		alert("글 내용이 입력되지 않았습니다..\n글 내용을 입력해 주세요");
		document.writeForm.content.focus();
		return false;
	}
	if(document.writeForm.pass.value == "") {
		alert("비밀번호가 입력되지 않았습니다.\n비밀번호를 입력해 주세요");
		document.writeForm.pass.focus();
		return false;
	}
}
function loginCheck() {
	if(document.loginForm.id.value == "") {
		alert("아이디가 입력되지 않았습니다.\n아이디를 입력해 주세요");
		document.loginForm.id.focus();
		return false;
	} else if (document.loginForm.pass.value == "") {
		alert("비밀번호가 입력되지 않았습니다.\n비밀번호를 입력해 주세요");
		document.loginForm.pass.focus();
		return false;
	} else {
		document.loginForm.currentURL.value = window.location.href;
		return true;
	}	
}