<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/nav.css" media="screen">
<style type="text/css">
html, body {
	margin: 0;
	padding: 0;
}
</style>
</head>
<body>
	<div style="padding-bottom: 20px">
		<ul class='menu'>
			<li><a href="noticeBoardList.notice" target="mainfr">공지사항</a></li>
			<li><a href="calendarForm.schedul" target="mainfr">스케쥴러</a></li>
			<li><a href="listProject.project" target="mainfr">프로젝트관리</a></li>
			<li><a href="listdocument.doc" target="mainfr">결재서류</a></li>
			<li><a href="departmentList.dept" target="mainfr">부서게시판</a>
				<ul>
					<li><a href="departmentList.dept?departmentnumber=10"
						target="mainfr">경리부</a></li>
					<li><a href="departmentList.dept?departmentnumber=20"
						target="mainfr">인사부</a></li>
					<li><a href="departmentList.dept?departmentnumber=30"
						target="mainfr">영업부</a></li>
					<li><a href="departmentList.dept?departmentnumber=40"
						target="mainfr">전산부</a></li>
					<li><a href="departmentList.dept?departmentnumber=50"
						target="mainfr">프로젝트1팀</a></li>
					<li><a href="departmentList.dept?departmentnumber=60"
						target="mainfr">프로젝트2팀</a></li>
					<li><a href="departmentList.dept?departmentnumber=70"
						target="mainfr">프로젝트3팀</a></li>
					<li><a href="departmentList.dept?departmentnumber=80"
						target="mainfr">프로젝트4팀</a></li>
				</ul></li>
			<li><a href="groupChartList.member?departmentnumber=10"
				target="mainfr">조직도</a>
				<ul>
					<li><a href="groupChartList.member?departmentnumber=10"
						target="mainfr">경리부</a></li>
					<li><a href="groupChartList.member?departmentnumber=20"
						target="mainfr">인사부</a></li>
					<li><a href="groupChartList.member?departmentnumber=30"
						target="mainfr">영업부</a></li>
					<li><a href="groupChartList.member?departmentnumber=40"
						target="mainfr">전산부</a></li>
					<li><a href="groupChartList.member?departmentnumber=50"
						target="mainfr">프로젝트1팀</a></li>
					<li><a href="groupChartList.member?departmentnumber=60"
						target="mainfr">프로젝트2팀</a></li>
					<li><a href="groupChartList.member?departmentnumber=70"
						target="mainfr">프로젝트3팀</a></li>
					<li><a href="groupChartList.member?departmentnumber=80"
						target="mainfr">프로젝트4팀</a></li>
				</ul></li>
			<li><a href="./visitant/newVisitant.jsp" target="mainfr">출입관리</a>
				<ul id="ul1">
					<li><a href="./visitant/newVisitant.jsp" target="mainfr">정문출입등록</a></li>
					<li><a href="./visitant/outVisitant.jsp" target="mainfr">정문퇴행등록</a></li>
					<li><a href="./visitant/AllListVisitant.jsp" target="mainfr">정문출입현황</a></li>
					<li><a href="./visitant/listVisitant.jsp" target="mainfr">정문미퇴행현황</a></li>
					<li><a href="./visitant/newSecurityVisitant.jsp" target="mainfr">보안구역출입등록</a></li>
					<li><a href="./visitant/outSecurityVisitant.jsp" target="mainfr">보안구역퇴행등록</a></li>
					<li><a href="./visitant/AllListSecuryty.jsp" target="mainfr">보안구역출입현황</a></li>
					<li><a href="./visitant/listSecurityVisitant.jsp" target="mainfr">보안구역미퇴행현황</a></li>
				</ul></li>
		</ul>
	</div>
	<nav>
		<div>
			<iframe src="main.jsp" width="100%" height="1500" name="mainfr"
				frameborder="0" scrolling="no"></iframe>
		</div>
	</nav>
</body>
</html>