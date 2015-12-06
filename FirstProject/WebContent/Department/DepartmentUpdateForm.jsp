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
<title>글쓰기</title>
<link type="text/css" href="css/table.css" rel="stylesheet"/>
<link type="text/css" href="css/pageBtn.css" rel="stylesheet"/>
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
#t_write {
	width: 800px;
}
#t_write th {
	width: 100px;
}
.btn_div {
	margin-left: 680px;
}
</style>
<script>
	function clearmessage(frm) {
		frm.value = "";
	}
</script>
</head>
<body>
	<form action="DepartmentUpdateForm.dept">
		<table id="t_write">
			<tbody>
				<c:forEach var="department" items="${departmentList}">
					<tr>
						<th>글번호</th>
						<td><input type="hidden" name="postNumber"value="${department.postNumber}">${department.postNumber}
						<input type="hidden" name="deptno" value="${department.departmentnum}"></td>
						<th>작성일</th>
						<td colspan="3">${department.postDate}</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>${department.postCreater}</td>
						<th>부서명</th>
						<td>${department.departmentName}</td>
						<th>조회수</th>
						<td>${department.postLookup}</td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="5" style="text-align: left;"><input type="text" value="${department.postName}" name="postName" size="100%"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="5"><textarea rows="20" cols="100" name="content">${department.content}</textarea></td>
					</tr>
					<tr>
					<th>비밀번호</th>
						<td colspan="5" style="text-align: left;"><input type="text" name="postPassword" value="${department.postPassword}"></td>
					</tr>
		</c:forEach>
			</tbody>
		</table>
		<div class="btn_div">
			<input type="button" value="취소" class="css3button" onclick="history.back();"/>
			<input type="submit" value="수정하기" class="css3button"/>
		</div>		 
	</form>
	<%
		}
	%>
</body>
</html>