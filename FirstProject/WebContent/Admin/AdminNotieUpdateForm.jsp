<%@page import="java.util.ArrayList"%>
<%@page import="com.firstproject.bean.NoticeBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<NoticeBoard> noticeList = (ArrayList<NoticeBoard>)request.getAttribute("noticeList");
    NoticeBoard notice = noticeList.get(0);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<link type="text/css" href="./css/table.css" rel="stylesheet" />
<link type="text/css" href="css/pageBtn.css" rel="stylesheet" />
<style>
	#t1 {
		width: 820px;
	}
	#t1 th {
		width: 100px;
	}
	#t1 td {
		text-align: left;
	}
	#btn_div {
		margin-left: 700px;
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
	<form action="NoticeUpdateResult.admin">
		<table id="t1">
			<tr>
				<th>제 목</th>
				<td colspan="3"><input type="text" name="noticeName" size="80" value="<%=notice.getNoticeName()%>"/></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td colspan="3"><%=notice.getNoticeCreater()%></td>
			</tr>
			<tr>
				<th>글내용</th>
				<td colspan="4"><textarea name="noticeContent" cols="95" rows="30"><%=notice.getNoticeContent()%></textarea></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td colspan="3" align='left' ><input type="password" name="noticePassword" size="20" /></td>
			</tr>
		</table>
		<div id="btn_div">
			<input type="hidden" name="noticeNumber" value="<%=notice.getNoticeNumber()%>"/>
			<input type="submit" value="수정하기" class="css3button"/>&nbsp;&nbsp;&nbsp;
			<input type="button" value="취소" class="css3button" onclick="history.back()"/>
		</div>
	</form>
</body>
</html>