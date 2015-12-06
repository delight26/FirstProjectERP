<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" href="../css/table.css" rel="stylesheet"/>
<link type="text/css" href="../css/pageBtn.css" rel="stylesheet"/>
<script type="text/javascript" src="./js/formcheck.js"></script>
<style type="text/css">
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
<form name="writeForm" action="outVisitantProcess.jsp" method="post" onsubmit="return formCheck()">
<table class="readTable">
	<tr>
		<td colspan="2" class="boardTitle">
			<h3>퇴행 등록</h3>
		</td>
	</tr>
	<tr>
		<td class="readTh">출입증&nbsp;번호</td>
		<td class="readTd">
			<input type="text" name="passNum" size="5" maxlength="5">
		</td>
	</tr>
	<tr>
		<td colspan="2" class="tdSpan">
			<input type="reset" value="다시쓰기" class="css3button"/>&nbsp;&nbsp;
			<input type="submit" value="등록하기" class="css3button"/>&nbsp;&nbsp;
		</td>				
	</tr>
</table>
</form>
</body>
</html>