<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, com.firstproject.bean.*, java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>부서별 사원 조직도</title>
<style>
tr>td {
	border: 1px solid black;
	padding: 5px 10px;
	font-size: 16px;
	width: 120px;
	font-weight: bold;
}

table {
	border-collapse: collapse;
	margin: 30px;
	float: left;
}
</style>
</head>
<body style="margin-left: 300px;">
	<div style="width: 1000px;">
	<%
	ArrayList<Member> memberlist = (ArrayList<Member>)request.getAttribute("memberList");
	String dname = memberlist.get(0).getDname();
	%>
		<strong style="font-size: 43px;"><%=dname %></strong><br/><br/>

		<c:forEach var="member" items="${ memberList }">
			<table>
				<tr>
					<th class="image">
					<c:if test="${empty member.photo }">이미지<br/>파일 없음</c:if>
					<c:if test="${!empty member.photo }"><img src="${member.photo}" width="200px" height="200px"/></c:if>
						</th>
				</tr>
				<tr>
					<td>${ member.jobname }</td>
				</tr>
				<tr>
					<td>${ member.name }</td>
				</tr>
				<tr>
					<td>${ member.phonenumber }</td>
				</tr>
			</table>
		</c:forEach>
	</div>
</body>
</html>