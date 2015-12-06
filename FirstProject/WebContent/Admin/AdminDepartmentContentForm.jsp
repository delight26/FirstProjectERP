<%@ page import="com.firstproject.bean.*, java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서별 게시판</title>
<link type="text/css" href="css/table.css" rel="stylesheet" />
<link type="text/css" href="../css/pageBtn.css" rel="stylesheet" />
<script>
	function deleteDepartment(postNumber) {
		location.href = "DepartmentDelete.admin?postNumber=" + postNumber;
	}
	function nextDepartment(postNumber, departmentnum) {
		location.href = "nextDepartment.admin?postNumber=" + postNumber
				+ "&departmentNum=" + departmentnum;
	}
	function preDepartment(postNumber, departmentnum) {
		location.href = "preDepartment.admin?postNumber=" + postNumber
				+ "&departmentNum=" + departmentnum;
	}
</script>
<style>
#t1 {
	width: 800px;
}
td{
text-align: left;
}
</style>
<style type="text/css">
.css3button {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 13px;
	color: #ffffff;
	padding: 6px 20px;
	background: -moz-linear-gradient(top, #c9c9c9 0%, #000000 55%, #050505);
	background: -webkit-gradient(linear, left top, left bottom, from(#c9c9c9),
		color-stop(0.55, #000000), to(#050505));
	-moz-border-radius: 87px;
	-webkit-border-radius: 87px;
	border-radius: 87px;
	border: 2px solid #fcfcfc;
	-moz-box-shadow: 0px 3px 11px rgba(000, 000, 000, 0.5), inset 0px 0px
		1px rgba(000, 000, 000, 1);
	-webkit-box-shadow: 0px 3px 11px rgba(000, 000, 000, 0.5), inset 0px 0px
		1px rgba(000, 000, 000, 1);
	box-shadow: 0px 3px 11px rgba(000, 000, 000, 0.5), inset 0px 0px 1px
		rgba(000, 000, 000, 1);
	text-shadow: 0px -1px 0px rgba(000, 000, 000, 0), 0px 1px 0px
		rgba(255, 255, 255, 0.3);
}
</style>
</head>
<body>
<c:forEach var="department" items="${departmentList}">
	<form>
		<table id='t1'>
			<tbody>
					<tr>
						<th>글번호</th>
						<td>${department.postNumber}</td>
						<th>작성일</th>
						<td colspan="3">${department.postDate}</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td >${department.postCreater}</td>						
						<th>부서명</th>
						<td >${department.departmentName}</td>
						<th>조회수</th>
						<td>${department.postLookup}</td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="5">${department.postName}</td>
					</tr>
					<tr>
						<th style="height: 200px;">내용</th>
						<td colspan="5">${department.content}</td>
					</tr>
					<tr>
						<th>비밀번호 확인</th>
						<td colspan="5"><input type="hidden" name="postPassword"
							id="postPassword" value="${department.postPassword }"> <input
							type="text" name="checkPassword" id="checkPassword"></td>
					</tr>
			</tbody>
		</table>
		<div class="btn_div" style="margin-left:600px">
			<input type="button" value="이전 글"
				onclick="preDepartment('${department.postNumber}' , '${department.departmentnum }')"
				class="css3button" /> <input type="button" value="다음 글"
				onclick="nextDepartment('${department.postNumber}', '${department.departmentnum }')"
				class="css3button" /> <input type="button" name="btnDelete"
				value="삭제" onclick="deleteDepartment('${department.postNumber}')"
				class="css3button" />
		</div>
	</form>
	</c:forEach>
</body>
</html>


















