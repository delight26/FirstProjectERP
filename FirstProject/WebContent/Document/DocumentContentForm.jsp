<%@ page import="com.firstproject.bean.*, java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	DocumentApproval da = (DocumentApproval) request.getAttribute("dac");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" href="css/table.css" rel="stylesheet" />
<script>
	function deleteDocument(documentNumber) {
		location.href = "DocumentDelete.doc?documentNumber=" + documentNumber;
	}
	function DocumentApproval(DocumentNumber) {
		location.href = "DocumentApproval.doc?DocumentNumber=" + DocumentNumber;
	}
	function back(){
		location.href = "listdocument.doc";
	}
</script>
<style type="text/css">

li {
	list-style: none;
	color: white;
	float: left;
	vertical-align: middle;
	text-align: center;
	width: 100px;
	border: 1px solid black;
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
	<form>
		<table>
			<tbody>
				<tr>
					<th>결재 문서 이름</th>
					<td colspan="7"><%=da.getDocumentName()%></td>
					</tr>
					<tr>
					<th>작성자</th>
					<td><%=da.getDocumentCreater()%></td>
					<th>결재자</th>
					<td><%=da.getManagerName()%></td>
					<th>결재 상태</th>
					<td><%=da.getState() == 0 ? "결재 대기" : "결재 완료"%></td>
					<th>날짜</th>
					<td colspan="7"><%=da.getCreateDate().subSequence(0, 10)%></td>
					</tr>					
					<tr>
					<th style="height:350px;">내용</th>
					<td colspan="7" style="width:600px;" ><%=da.getDocumentContent()%></td>
					</tr>
					<tr>
					<th>파일</th>
					<td colspan="4"><a href="<%=da.getFilePath()%>">파일 다운로드</a></td>
					<th>결재 하기</th>
					<td colspan="2"><input type="button" value="결재 하기"
						onclick="DocumentApproval('<%=da.getDocumentNumber()%>')"
						class="css3button" /></td>
						</tr>
			</tbody>
		</table>
		<div style="margin-left: 650px">
		<input type="button" name="btnDelete"
			value="삭제" onclick="deleteDocument('<%=da.getDocumentNumber()%>')"
			class="css3button" /> 
			<input type="button" value="목록보기" onclick="back()" class="css3button"/>
			</div>
	</form>
</body>
</html>


















