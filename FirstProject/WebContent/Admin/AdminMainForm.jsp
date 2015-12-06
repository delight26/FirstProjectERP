<%@page import="org.apache.catalina.connector.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<link rel="stylesheet" href="css/nav.css" media="screen">
<style type="text/css">
html, body { margin: 0; padding: 0; }
</style>
</head>
<body>
<div style="padding-bottom: 10px">
			<ul class='menu'>
		<li><a href="./Admin/AdminMemberRegistrationForm.jsp" target="adminframe">사원등록</a></li>
		<li><a href="memberDeleteList.member" target="adminframe">사원삭제</a></li>
		<li><a href="NoticeList.admin?pageName=notice" target="adminframe">게시판관리</a>
		<ul>
		<li><a href="NoticeList.admin?pageName=notice" target="adminframe">공지사항</a></li>
		<li><a href="DepartmentList.admin?pageName=departmentboard" target="adminframe">부서게시판</a></li>
	</ul></li>
	</ul><br/><br/>
	</div>
<nav>
	<div>
	<iframe width="100%" height="1000" scrolling="no" name="adminframe" frameborder="0"></iframe>
</div>
</nav>
</body>
</html>