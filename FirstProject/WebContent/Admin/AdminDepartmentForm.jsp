<%@ page import="com.firstproject.bean.*, java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테이블관리_게시판</title>
<link type="text/css" href="./css/table.css" rel="stylesheet"/>
<link type="text/css" href="./css/pageBtn.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="./css/jquery.selectlist.css">
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="./js/jquery.selectlist.js"></script>
<script type="text/javascript">
	$(function(){
		$('select').selectlist({
			zIndex: 10,
			width: 200,
			height: 30
		});		
	});
</script>
<script>
	function deleteDepartment(postNumber) {
		location.href = "DepartmentDelete.admin?postNumber=" + postNumber;
	}
	function readDepartment(postNumber) {
		location.href = "DepartmentRead.admin?postNumber=" + postNumber;
	}
	function SerachDepartment() {
		var Name = document.getElementById('searchName').value;
		location.href = "DepartmentSearch.admin?searchName=" + Name;
	}
	function submit() {
		document.sendForm.submit();
	}
</script>
</head>
<style type="text/css">
#t_dept {
	margin-left: 220px;
}
#d_btn {
	margin-left: 600px;
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
<body>
	<form id="post" action="DepartmentList.admin">
		<div class="dept_select">
			<select name="departmentnumber" id="salary">
					<option value="0" selected="selected">부서명</option>
					<option value="10">경리부</option>
					<option value="20">인사부</option>
					<option value="30">영업부</option>
					<option value="40">전산부</option>
					<option value="50">프로젝트1팀</option>
					<option value="60">프로젝트2팀</option>
					<option value="70">프로젝트3팀</option>
					<option value="80">프로젝트4팀</option>
				</select>
				<input type="submit" value="바로가기" class="css3button"/>
				</div><br/>
			<table id="t_dept">
				<thead style="font-size: 12px">
					<tr>
						<th width="70px">글번호</th>
						<th width="90px">부서</th>
						<th width="300px">제목</th>
						<th width="70px">글쓴이</th>
						<th width="110px">작성일</th>
						<th width="50px">조회수</th>
						<th width="50px">삭제</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${listCount == 0 }">
						<tr>
							<td colspan="6">게시 글이 존재 하지 않습니다.</td>
						</tr>
					</c:if>
					<c:if test="${listCount != 0}">
						<c:forEach var="department" items="${departmentList}">
							<tr>
								<td>${department.postNumber}</td>
								<td>${department.departmentName}</td>
								<td style="text-align: left;"><a
									href="javascript:readDepartment('${department.postNumber}')">
										${department.postName}</a></td>
								<td>${department.postCreater}</td>
								<td>${department.postDate}</td>
								<td>${department.postLookup}</td>
								<td><input type="button" name="btnDelete" value="삭제"
									onclick="deleteDepartment('${department.postNumber}')" class="css3button"/>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</form>
		<form action="DepartmentSearch.admin">
		<div id="d_btn">
		<input type="text" id="searchName" name="searchName" style="width: 200px; height:20px;" /> 
		<input
			type="button" value="검색하기" name="btnSerach"
			onclick="SerachDepartment()" class="css3button" /><br />
		<c:if test="${ listCount > 0 }">
			<c:if test="${ startPage > pageGroup }">
				<a
					href="DepartmentList.admin?
					pageNum=${ startPage - pageGroup }" class="page">이전</a>
			</c:if>
			<c:forEach var="i" begin="${ startPage }" end="${ endPage }">
				<c:if test="${ i == currentPage }">
					<a href="DepartmentList.admin?pageNum=${ i }" class="page active">${ i }</a>
				</c:if>
				<c:if test="${ i != currentPage }">
					<a href="DepartmentList.admin?pageNum=${ i }" class="page">${ i }</a>
				</c:if>
			</c:forEach>
			<c:if test="${ endPage < pageCount }">
				<a
					href="DepartmentList.admin?
					pageNum=${ startPage + pageGroup }" class="page">다음</a>
			</c:if>
		</c:if>
		</div>
	</form>
</body>
</html>