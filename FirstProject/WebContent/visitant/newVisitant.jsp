<%@page import="com.firstproject.visitant.*"%>
<%@page import="com.firstproject.bean.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link type="text/css" href="../css/table.css" rel="stylesheet"/>
<link type="text/css" href="../css/pageBtn.css" rel="stylesheet"/>
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
<script type="text/javascript" src="./js/formcheck.js"></script>
<%
	AdminList adminList = new AdminList();
	ArrayList<Integer> admin = adminList.adminList();
	Member member = (Member) request.getSession().getAttribute("loginUser");
	if(member == null || !(admin.contains(member.getMembernumber()))){
%>
<script type="text/javascript">
	alert("사용권한이 없습니다.");
	history.back();
</script>
<%} %>
<body>
<form name="writeForm" action="newVisitantProcess.jsp" method="post" onsubmit="return formCheck()">
<table id="t1">
	<tr>
		<td colspan="2" class="boardTitle">
			<h3>출입 등록</h3>
		</td>
	</tr>
	<tr>
		<td class="readTh">출입증&nbsp;번호</td>
		<td class="readTd">
			<input type="text" name="passNum" size="50" maxlength="5">
		</td>
	</tr>
	<tr>
		<td class="readTh">출입자</td>
		<td class="readTd">
			<input type="text" name="name" size="50" maxlength="20">
		</td>
	</tr>
	<tr>
		<td class="readTh">소&nbsp;&nbsp;속</td>
		<td class="readTd">
			<input type="text" name="company" size="50" maxlength="50">
		</td>
	</tr>
	<tr>
		<td class="readTh">전화번호</td>
		<td class="readTd">
		 	<select  name="phone1">
				<option>010</option>
				<option>011</option>
				<option>016</option>
				<option>017</option>
				<option>018</option>
				<option>019</option>
				</select>-<input  type="text"  name="phone2"  size="10" maxlength="4"/>
				-<input  type="text"  name="phone3"  size="10"  />
		</td>
	</tr>		
	<tr>
			<td colspan="2" class="tdSpan">
				<input type="reset" value="다시쓰기" class="css3button"/>&nbsp;&nbsp;
				<input type="submit" value="등록하기" class="css3button"/>&nbsp;&nbsp;
			</td>				
	</tr>
<tr>
		<td colspan="2" class="boardTitle">
			<h3>공지 사항</h3>
			<h3>출입 요청서 미참시 출입불가(긴급사유시 후보고 가능)</h3>
			<h3>저장매체 일체 소지불가(휴대폰,노트북,usb등)</h3>
			<h3>담당직원 미동행시 출입불가</h3>
		</td>
	</tr> 
</table>	
	
	
</form>
</body>
</html>