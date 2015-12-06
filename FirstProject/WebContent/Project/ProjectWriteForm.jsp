<%@page import="com.firstproject.bean.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" href="css/table.css" rel="stylesheet"/>
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
	margin-left: 450px;
}
#btn_div {
	margin-left: 650px;
}
#t_write td {
	text-align: left;
}
#t_write td > input {
	width: 300px;
}
</style>
</head>
<body>
	<%
    if(session.getAttribute("loginUser")==null) {
    	%>
    		<script type="text/javascript">
    			parent.location = "./LoginMain/LoginForm.jsp";
    			alert("세션이 종료 되었습니다.");
    		</script>
    	<%
    }else{
    Member member = (Member)session.getAttribute("loginUser");
	String name = member.getName();
	int membernum = member.getMembernumber();
	%>
	<form action="ProjectWriteResult.project">
			<table id="t_write">
				<tr>
					<th>프로젝트명</th>
					<td><input type="text" name="projectName"
						placeholder="프로젝트 명을 입력하세요" required /></td>
				</tr>
				<tr>
					<th>담당자</th>
					<td><input type="text" name="managername" value="<%=name%>" readonly="readonly" />
						<input type="hidden" name="managernum" value="<%=membernum%>" />
					</td>
				</tr>
				<tr>
					<th>프로젝트 시작 날짜</th>
					<td><input type="date" name="startdate" required /></td>
				</tr>
				<tr>
					<th>프로젝트 종료 날짜</th>
					<td><input type="date" name="enddate" required /></td>
				</tr>
				<tr>
					<th>프로젝트 설명</th>
					<td><textarea name="comment" cols="50" rows="10" required></textarea></td>
				</tr>
			</table>
			<div id="btn_div">
				<input type="button" value="취소" class="css3button" onclick="history.back();"/>
				<input type="submit" value="등록" class="css3button"/>
			</div>
	</form>
	<%
	}
	%>
</body>
</html>