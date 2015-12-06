<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery-1.11.3.min.js"></script>
<link type="text/css" href="css/table.css" rel="stylesheet"/>
<script>
	function clearmessage(frm) {
		frm.value = "";
	}
	$(function() {
		$("#btnsubmit")
				.on(
						"click",
						function() {

							if ($("#scheduleTitle").val()==""
									|| $("#scheduleContent").val()=="") {
								alert("스케줄의 제목과 내용을 입력해 주세요 ");
								window.close();
							} else {
								var scheduleTitle = $("#scheduleTitle").val();
								var scheduleContent = $("#scheduleContent")
										.val();
								var scheduleDate = $("#scheduleDate").val();
								opener.location.href = "addScheculeService.schedul?scheduleTitle="
										+ scheduleTitle
										+ "&scheduleContent="
										+ scheduleContent
										+ "&scheduleDate="
										+ scheduleDate;
								window.close();
							}
						});
	});
</script>
<style type="text/css">
.content {
	font-family: "맑은 고딕";
	font-size: 9px;
	color: #666666;
	border: 1px #c9c9c9 solid;
	background-image: url(image/textline.gif);
	line-height: 15pt;
	scrollbar-face-color: #FFFFFF;
	scrollbar-shadow-color: #C9C9C9;
	scrollbar-highlight-color: #C9C9C9;
	scrollbar-3dlight-color: #FFFFFF;
	scrollbar-darkshadow-color: #FFFFFF;
	scrollbar-track-color: #FFFFFF;
	scrollbar-arrow-color: #666666;
	overflow: hidden;
}
</style>
<style type="text/css">
body{
background: lightcyan;
}
.css3button {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 13px;
	color: #ffffff;
	padding: 6px 20px;
	background: -moz-linear-gradient(
		top,
		#c9c9c9 0%,
		#000000 55%,
		#050505);
	background: -webkit-gradient(
		linear, left top, left bottom,
		from(#c9c9c9),
		color-stop(0.55, #000000),
		to(#050505));
	-moz-border-radius: 87px;
	-webkit-border-radius: 87px;
	border-radius: 87px;
	border: 2px solid #fcfcfc;
	-moz-box-shadow:
		0px 3px 11px rgba(000,000,000,0.5),
		inset 0px 0px 1px rgba(000,000,000,1);
	-webkit-box-shadow:
		0px 3px 11px rgba(000,000,000,0.5),
		inset 0px 0px 1px rgba(000,000,000,1);
	box-shadow:
		0px 3px 11px rgba(000,000,000,0.5),
		inset 0px 0px 1px rgba(000,000,000,1);
	text-shadow:
		0px -1px 0px rgba(000,000,000,0),
		0px 1px 0px rgba(255,255,255,0.3);
}
</style>
</head>
<body>
<%
	String date = request.getParameter("date");
%>
	<form id="form1" name="form" action="#">
	<table id="t1" style="margin: 0; width: 400px;">
			<tr>
				<th>Title</th>
				<td><input id="scheduleTitle" type="text" name="scheduleTitle" 
			onfocus="clearmessage(this.form.scheduleTitle);" placeholder="제목" size="40px;" required /></td>
			</tr>
			<tr>
				<th style="height: 200px;">Content</th>
				<td><textarea id="scheduleContent" class="content" rows="12" cols="47"
			name="scheduleContent" placeholder="스케줄 내용" required></textarea></td>
			</tr>
		</table><br/>
		<div style="margin-left: 150px;">
			<input id="btnsubmit" type="button" value="등록" class="css3button"/> <input type="button" value="취소" onclick="self.close();" 
				class="css3button"/> <input type="hidden" id="scheduleDate"
				name=scheduleDate value="<%=date%>" />
		</div>
	</form>
</body>
</html>