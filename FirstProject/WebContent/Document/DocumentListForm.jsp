<%@ page import="com.firstproject.bean.*, java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결재서류</title>
<link type="text/css" href="css/table.css" rel="stylesheet" />
<link type="text/css" href="css/pageBtn.css" rel="stylesheet" />
<script>
	function readDocument(documentNumber) {
		location.href = "DocumentRead.doc?documentNumber=" + documentNumber;
	}
	function WriteDocument() {
		location.href = "writedocument.doc";
	}
</script>
<style>
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
	<form action="departmentList.dept">
		<fieldset>
			<table>
				<thead style="font-size: 12px">
					<tr>
						<th width="70px">글번호</th>
						<th width="300px">제목</th>
						<th width="70px">글쓴이</th>
						<th width="110px">작성일</th>
						<th width="50px">결재상태</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="doc" items="${docList}">
						<tr>
							<td>${doc.documentNumber}</td>
							<td style="text-align: left;"><a
								href="javascript:readDocument('${doc.documentNumber}')">
									${doc.documentName}</a></td>
							<td>${doc.documentCreater}</td>
							<td>${doc.createDate}</td>
							<td>${doc.state==0?"결재대기":"결재완료"}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div style="margin-left: 1000px;">
					<input type="button" value=" 글쓰기 " name="btnWrite" onclick="WriteDocument()" class="css3button" /><br/></div>
			<div class="btn_div">
			<c:if test="${ listCount > 0 }">
				<c:if test="${ startPage > pageGroup }">
					<a
						href="listdocument.doc?
						pageNum=${ startPage - pageGroup }"
						class="page">이전</a>
				</c:if>
				<c:forEach var="i" begin="${ startPage }" end="${ endPage }">
					<c:if test="${ i == currentPage }">
						<a href="listdocument.doc?pageNum=${ i }" class="page active" style="text-align: center;">${ i }</a>
					</c:if>
					<c:if test="${ i != currentPage }">
						<a href="listdocument.doc?pageNum=${ i }" class="page">${ i }</a>
					</c:if>
				</c:forEach>

				<c:if test="${ endPage < pageCount }">
					<a
						href="listdocument.doc?
						pageNum=${ startPage + pageGroup }"
						class="page">다음</a>
				</c:if>
			</c:if>
			</div>
		</fieldset>
	</form>
</body>
</html>