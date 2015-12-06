<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, com.firstproject.bean.*, java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자페이지_사원 삭제</title>
<link type="text/css" href="/FirstProject/css/pageBtn.css"
	rel="stylesheet" />
<link type="text/css" href="/FirstProject/css/table.css"
	rel="stylesheet" />
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

#d_btn {
	margin-left: 600px;
}

#t_delete {
	margin-left: 200px;
}
</style>
<script>
	function deleteMember(membernumber) {
		var conf = confirm("정말 삭제하시겠습니까?");
		if (conf) {
			location.href = "memberDeleteResult.member?membernumber="
					+ membernumber;
		}
	}
</script>
</head>
<body>
	<form>
		<table id="t_delete">
			<thead style="font-size: 12px">
				<tr>
					<th width="100px">사원번호</th>
					<th width="100px">이름</th>
					<th width="100px">부서</th>
					<th width="75px">직급</th>
					<th width="130px">모바일</th>
					<th width="200px">주소</th>
					<th width="50px">삭제</th>
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
						<td><input type="button" name="btn_delete" value="삭제"
							onclick="deleteMember('${member.membernumber}')"
							class="css3button" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
	<form action=memberSearch.member>
		<div class="btn_div">
			<input type="text" id="searchName" name="searchName" /> <input
				type="submit" value="검색하기" name="btnSerach" onclick="SearchNotice()"
				class="css3button" />
		</div>
	</form><br/>
	<div id="d_btn">
		<c:if test="${ listCount > 0 }">
			<c:if test="${ startPage > pageGroup }">
				<a
					href="memberDeleteList.member?
						pageNum=${ startPage - pageGroup }"
					class="page">이전</a>
			</c:if>

			<c:forEach var="i" begin="${ startPage }" end="${ endPage }">
				<c:if test="${ i == currentPage }">
					<a href="memberDeleteList.member?pageNum=${ i }"
						class="page active">${ i }</a>
				</c:if>
				<c:if test="${ i != currentPage }">
					<a href="memberDeleteList.member?pageNum=${ i }" class="page">${ i }</a>
				</c:if>
			</c:forEach>

			<c:if test="${ endPage < pageCount }">
				<a
					href="memberDeleteList.member?
						pageNum=${ startPage + pageGroup }"
					class="page">다음</a>
			</c:if>
		</c:if>
	</div>
</body>
</html>