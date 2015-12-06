<%@ page import="com.firstproject.bean.*, java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테이블관리_공지사항</title>
<link type="text/css" href="css/table.css" rel="stylesheet"/>
<link type="text/css" href="css/pageBtn.css" rel="stylesheet"/>
<script>
function readNotice(noticeNumber){
	location.href = "noticeRead.notice?noticeNumber="+noticeNumber;
}
function SerachNotice(){
	var Name = document.getElementById('searchName1').value;;
	location.href = "NoticeSearch.notice?searchName="+Name;
}
</script>
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
	<form>
		<fieldset>
			<table>
				<thead style="font-size: 12px">
					<tr>
						<th width="50px">글번호</th>
						<th width="330px">제목</th>
						<th width="70px">글쓴이</th>
						<th width="110px">작성일</th>
						<th width="50px">조회수</th>
					</tr>
				</thead>
				<tbody>
				<c:if test = "${listCount == 0 }">
				<tr>
				<td colspan="6">게시 글이 존재 하지 않습니다.</td>
				</tr>
				</c:if>
				<c:if test="${listCount != 0}">
					<c:forEach var="notice" items="${noticeList}">
						<tr>
							<td>${notice.noticeNumber}</td>
							<td style="text-align: left;"><a href="javascript:readNotice('${notice.noticeNumber}')"> ${notice.noticeName}</a></td>
							<td>${notice.noticeCreater}</td>
							<td>${notice.noticeDate}</td>
							<td>${notice.noticeLookup}</td>
						</tr>
					</c:forEach>
					</c:if>
				</tbody>
			</table>
			</form>
			<div class="btn_div">
				<form action="NoticeSearch.notice">
				<input type="text" id="searchName" name = "searchName" style="width: 200px; height:20px;"/>
				<input type="button" value="검색" name="btnSerach" onclick="SerachNotice()" class="css3button"/><br/>
				</form>
			<div class="pagination">
			<c:if test="${ listCount > 0 }" >
			<c:if test="${ startPage > pageGroup }">
				<a href="NoticeSearch.notice?
					pageNum=${ startPage - pageGroup }&searchName=${searchName}" class="page">이전</a>
			</c:if>
			<c:forEach var="i" begin="${ startPage }" end="${ endPage }">
				<c:if test="${ i == currentPage }">
					${ i }
				</c:if>
				<c:if test="${ i != currentPage }">
					<a href="NoticeSearch.notice?pageNum=${ i }&searchName=${searchName}" class="page">${ i }</a>
				</c:if>
			</c:forEach>
			<c:if test="${ endPage < pageCount }">
				<a href="NoticeSearch.notice?
					pageNum=${ startPage + pageGroup }&searchName=${searchName}" class="page">다음</a>
			</c:if>
			</c:if>
			</div>
		</fieldset>
</body>
</html>