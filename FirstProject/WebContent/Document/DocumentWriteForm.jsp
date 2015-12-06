<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.*, com.firstproject.bean.*, java.util.*"%>
<%
	if (session.getAttribute("loginUser") == null) {
		%>
		<script type="text/javascript">
			alert('세션이 종료 되었습니다.');
			parent.location = "./LoginMain/LoginForm.jsp";
		</script>
	<%
	} else {
		Member member = (Member) session.getAttribute("loginUser");
		String name = member.getName();
		int memberNumber = member.getMembernumber();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서류작성</title>
<link type="text/css" href="css/table.css" rel="stylesheet" />
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
#t_doc th {
	width: 100px;
}
</style>
</head>
<body>
	<form action="writedocumentresult.doc" enctype="multipart/form-data" method="post">
		<table id="t_doc">
			<tr>
				<th>작성자</th>
				<td><input type="text" name="creater" value="<%=name %>" /></td>
				<th>결재자</th>
				<td><input type="hidden" name="membernum" value="<%=memberNumber %>"/>
					<input type="text" name="manager" required="required"/></td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3"><input name="doctitle" type="text" style="width: 550px;" required="required"/></td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3"><textarea rows="10" cols="80" name="content" required="required"></textarea></td>
			</tr>
			<tr>
				<th>파일등록</th>
				<td colspan="3" style="text-align: left"><input type="file" name="filepath"></td>
			</tr>
			<tr>
			<th>비밀번호</th>
				<td colspan="3" style="text-align: left"><input type="password" name = "pass" required="required"></td>
			</tr>
		</table>
		<div style="margin-left: 650px">
			<input type="button" value="취소" class="css3button" onclick="history.back();"/>
			<input type="submit" value="등록" class="css3button"/>
		</div>
	</form>
	<%
	}
	%>
</body>
</html>