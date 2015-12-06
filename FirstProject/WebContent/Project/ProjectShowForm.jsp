<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.firstproject.bean.*, java.util.*"%>
<%
	ArrayList<ProjectManager> project = (ArrayList<ProjectManager>) request.getAttribute("projectList");
	ProjectManager pm = null;
	
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function readProject(projectnum) {
		location.href = "ProjectRead.project?projectnum=" + projectnum;
	}
	function WriteProject() {
		location.href = "ProjectWrite.project";
	}
</script>
<style>
.graph {
	position: relative;
	width: 800px;
	font-size: 13px;
	font-family: tahoma;
	margin-bottom: 3px;
	border: 1px solid black;
	background: white;
}

.graph .bar {
	display: block;
	position: relative;
	background: #4D48E1;
	text-align: center;
	color: #EAEAEA;
	height: 2em;
	line-height: 2em;
}

.graph .bar span {
	position: absolute;
	left: 1em;
}
#project th{
	border-top: 2px solid #666;
	border-bottom: 2px solid #666;
	font-size: 18px;
	background: #EAEAEA;
	border-left: none;
	border-right: none;
}
#project td {
	font-size: 17px;
	text-align: center;
}
#project a { text-decoration: none; }
#project a:link {
	color: black;
}
#project a:hover {
	color: blue;
	text-decoration: underline;
}
#project a:visited {
	color: black;
}
#project th, td {
	padding: 10px 30px;
	border-collapse: collapse;
}
#project {
	border-bottom: 2px solid #666;
	border-top: 2px solid #666;
	border-collapse: collapse;
}
#p_div {
	margin-left: 100px;
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
	<div id="p_div">
		<table id="project">
			<tr>
				<th>프로젝트 명</th>
				<th>책임자</th>
				<th>시작일</th>
				<th>종료일</th>
				<th>설명</th>
				<th>진행률</th>
			</tr>
			<%
			for (int i = 0; i < project.size(); i++) {
				pm = project.get(i);
				 %>
			<tr>
				<td><a href="javascript:readProject(<%=pm.getProjectNumber()%>)"><%=pm.getProjectName()%></a></td>
				<td><%=pm.getManager()%></td>
				<td><%=pm.getStartDate().substring(0, 10)%></td>
				<td><%=pm.getEndDate().substring(0, 10)%></td>
				<td><%=pm.getComment() %></td>
				<td><%=pm.getPercent()%>%</td>
			</tr>
			<%
			}
		%>
		</table><br/>
			<input type="button" value="새 프로젝트 등록" onclick="WriteProject()" class="css3button" style="margin-left: 1000px;"/><br/><br/><br/><br/>
<%
	for (int i = 0; i < project.size(); i++) {
		pm = project.get(i);
%>
		<table>
			<tr>
				<td style="font-weight: bold; font-size:20px; color: black" width="200px;"><%=pm.getProjectName()%></td>
				<td>
					<div class="graph">
						<strong class="bar" style="width: <%=pm.getPercent()%>%;"><%=pm.getPercent()%>%</strong>
					</div>
				</td>
			</tr>
		</table>
		<%
			}
		%>
	</div>
</body>
</html>