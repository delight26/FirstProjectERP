<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.*, com.firstproject.bean.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function readNotice(noticeNumber){
	location.href = "noticeRead.notice?noticeNumber="+noticeNumber;
}
</script>
<link rel="stylesheet" href="css/mainfr.css">
<style>
	a { text-decoration: none; }
</style>
</head>
<body>
<div id="dark" class="container">
    <div id="indented" class="box">
        <h2>Notice</h2>
        <ul>
	<c:forEach var="MainNotice" items="${ MainNoticeList }">
		<li><a href="noticeRead.notice?noticeNumber=${ MainNotice.noticeNumber }" target="mainfr"> ${MainNotice.noticeName}</a></li>
	</c:forEach>
		</ul>
		<a href="noticeBoardList.notice" target="mainfr" style="float: right; color:white;">더보기</a><br/>
	</div>
	</div>
</body>
</html>