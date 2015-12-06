<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, com.firstproject.bean.*, java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자페이지_사원 삭제</title>
<style>
	* {
		font: '맑은 고딕';
	}
	#delete > tr {
		font-weight: bold;
	}
	#t_delete {
		border: 1px solid black;
		border-collapse: collapse;
	}
	#t_delete th, #t_delete td {
		border: 1px solid black;
		border-collapse: collapse;
		height: 23px;
	} 
	#t_delete td:last-child {
		line-height: 23px;
		text-align: center;
		padding-bottom: 3px;
	}
	#delete fieldset {
		border: none;
	}
	#delete div {
		padding-left: 310px; 
	}
	#delete legend {
		font-size: 16px;
		font-weight: bold;
	}

</style>
</head>
<body>
	<form id="delete">
		<fieldset>
		<legend>사원 리스트</legend>
		<table id="t_delete">
			<thead style="font-size: 12px">
				<tr>
					<th width="100px">사원번호</th>
					<th width="100px">이름</th>
					<th width="100px">부서</th>
					<th width="75px">직급</th>
					<th width="130px">모바일</th>
					<th width="200px">주소</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="member" items="${ memberList }">
				<tr>
					<td>${ member.membernumber }</td>
					<td>${ member.name }</td>
					<td>${ member.dname }</td>
					<td>${ member.jobname}</td>
					<td>${ member.phonenumber }</td>
					<td>${ member.adress}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		</fieldset>
	</form>

</body>
</html>