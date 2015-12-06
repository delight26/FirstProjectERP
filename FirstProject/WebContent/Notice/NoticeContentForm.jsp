<%@ page import="com.firstproject.bean.*, java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html	>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" href="css/table.css" rel="stylesheet"/>
<script>
	function nextNotice(noticeNumber) {
		location.href = "nextNotice.notice?noticeNumber=" + noticeNumber;
	}
	function preNotice(noticeNumber) {
		location.href = "preNotice.notice?noticeNumber=" + noticeNumber;
	}
	function listNotice() {
		location.href = "noticeBoardList.notice";
	}
</script>
<style>
	#t1 {
		width: 750px;
	}
</style>
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
.btn_div {
	margin-left: 850px;
}
</style>
</head>
<body>
	<div>
		<c:forEach var="notice" items="${noticeList}" varStatus="status">
		<table id="t1">
			<tbody>
					<tr>
						<th>글번호</th>
						<td>${notice.noticeNumber}</td>
						<th>작성일</th>
						<td>${notice.noticeDate}</td>
						<th>조회수</th>
						<td>${notice.noticeLookup}</td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="3" style="text-align: left;">${notice.noticeName}</td>
						<th>작성자</th>
						<td>관리자</td>
					</tr>
					<tr>
						<th style="height: 200px;">내용</th>
						<td colspan="5" style="text-align: left;"><textarea readonly="readonly" rows="30" cols="95">${notice.noticeContent}</textarea></td>
					</tr>
			</tbody>
		</table>
		<div style="margin-left: 900px;">
			<img src="images/btn_pre.gif"
							onclick="preNotice('${notice.noticeNumber}')" />
			<img src="images/btn_next.gif"
							onclick="nextNotice('${notice.noticeNumber}')" /></div><br/>
			<input type="button" value="목록보기"
							onclick="listNotice()" class="css3button" style="margin-left:650px"/>
		
		</c:forEach>
	</div>
</body>
</html>
