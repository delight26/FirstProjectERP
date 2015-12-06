<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" href="../css/table.css" rel="stylesheet"/>
<title>공지사항</title>
<style type="text/css">
#t1{
	width: 820px;
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
	
	<form name="form1" action="NoticeWrite.admin">
		<table id='t1'>
			<tr>
				<th colspan='2'>
					<h2 >공지사항</h2>
				</th>
			</tr>
			<tr>
				<th>제 목</th>
				<td colspan="3" align='left' ><input type="text" name="title" size="78" /></td>
			</tr>
			<tr>
			<tr>
				<th>글내용</th>
				<td colspan="4" align='left' ><textarea name="content" cols="95" rows="30"></textarea></td>
			</tr>
			<tr>
			<th>비밀번호</th>
				<td colspan="3" align='left' ><input type="password" name="pass" size="20" /></td>
			</tr>
			<tr>
				<td colspan="4" id="buttons"><input type="submit" value="완료" class="css3button" />&nbsp;&nbsp;&nbsp;
					<input type="button" value="취소"  class="css3button" onclick="history.back()"/></td>
			</tr>
		</table>
	</form>
</body>
</html>