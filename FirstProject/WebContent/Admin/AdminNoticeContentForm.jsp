<%@ page import="com.firstproject.bean.*, java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항</title>
<link type="text/css" href="./css/table.css" rel="stylesheet"/>
<link type="text/css" href="./css/pageBtn.css" rel="stylesheet"/>
<script>
	function deleteNotice(noticeNumber) {
		location.href = "NoticeDelete.admin?noticeNumber=" + noticeNumber;
	}
	function updateNotice(noticeNumber) {
		location.href = "NoticeUpdate.admin?noticeNumber=" + noticeNumber;
	}
	function nextNotice(noticeNumber) {
		location.href = "nextNotice.admin?noticeNumber=" + noticeNumber;
	}
	function preNotice(noticeNumber) {
		location.href = "preNotice.admin?noticeNumber=" + noticeNumber;
	}
	function listNotice() {
		location.href="NoticeList.admin?pageName=notice";
	}
</script>
<style>
	#t1 {
		width: 820px;
	}
	#t1 th {
		width: 100px;
	}
	#btn_div {
		margin-left: 700px;
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
</style>
</head>
<body>
<c:forEach var="notice" items="${noticeList}" varStatus="status">
	<div>
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
					<td>${notice.noticeCreater}</td>
				</tr>
				<tr>
					<th height="200px">내용</th>
					<td colspan="5" style="text-align: left;"><textarea readonly="readonly" rows="30" cols="95">${notice.noticeContent}</textarea></td>
				</tr>
			</tbody>
		</table>
		<div id="btn_div">
			<input type="button" name="btnModify" value="수정"
							onclick="updateNotice('${notice.noticeNumber}')" class="css3button" />
			<input type="button" name="btnDelete" value="삭제"
							onclick="deleteNotice('${notice.noticeNumber}')" class="css3button" />
			<input type="button" name="btnList" value="목록보기"
							onclick="listNotice()" class="css3button" />
		</div>
	</div>
	</c:forEach>
</body>
</html>
