<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.firstproject.bean.*, java.util.*"%>
<%
	ProjectManager pm = (ProjectManager) request.getAttribute("pm");
%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function UpdateProject(projectNum) {
		location.href = "ProjectUpdate.project?projectNum="+projectNum;
	}
	function ListProject() {
		location.href = "listProject.project";
	}
</script>
<link type="text/css" href="css/table.css" rel="stylesheet"/>
<style>
.graph {
	position: relative;
	font-size: 13px;
	font-family: tahoma;
	margin-bottom: 3px;
}

.graph .bar {
	display: block;
	position: relative;
	background: #4D48E1;
	text-align: center;
	color: #eaeaea;
	height: 2.5em;
	line-height: 2.5em;
}

.graph .bar span {
	position: absolute;
	left: 1em;
}
</style>
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
	<div>
		<table style="width: 740px">
			<tr>
				<th style="width: 200px"><%=pm.getProjectName()%></th>
				<td>
					<div class="graph" style="width:100%">
						<p class="bar" style="width: <%=pm.getPercent()%>%;"><%=pm.getPercent()%>%</p>
					</div>
				</td>
			</tr>
		</table>
		<table style="width:740px">
			<tr>
				<th style="width: 200px">프로젝트 명</th>
				<td><%=pm.getProjectName()%></td>
			</tr>
			<tr>
				<th style="width: 200px">책임자</th>
				<td><%=pm.getManager()%></td>
			</tr>
			<tr>
				<th style="width: 200px">시작일</th>
				<td><%=pm.getStartDate().substring(0, 10)%></td>
			</tr>
			<tr>
				<th style="width: 200px">종료일</th>
				<td><%=pm.getEndDate().substring(0, 10)%></td>
			</tr>
			<tr>
				<th style="width: 200px">설명</th>
				<td><%=pm.getComment()%></td>
			</tr>
			<tr>
				<th style="width: 200px">진행률</th>
				<td><%=pm.getPercent()%>%</td>
			</tr>
		</table>
		<input type="button" value="목록보기" onclick="ListProject()" class="css3button" style="margin-left: 900px"/>
		<input type="button" value="수정하기" onclick="UpdateProject(<%= pm.getProjectNumber()%>)" class="css3button"/>
	</div>
</body>
</html>