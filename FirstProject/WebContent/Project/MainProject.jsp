<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.firstproject.bean.*, java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/mainfr.css">
<script>
	function readProject(projectnum) {
		location.href = "ProjectRead.project?projectnum=" + projectnum;
	}
</script>
<style>
.graph {
	position: relative;
	width: 400px;
	border: 1px solid #E2E2E2;
	font-size: 11px;
	font-family: tahoma;
	margin-bottom: 3px;
}

.graph .bar {
	display: block;
	position: relative;
	background: #B1D632;
	text-align: center;
	color: #333;
	height: 2em;
	line-height: 2em;
}

.graph .bar span {
	position: absolute;
	left: 1em;
}
</style>
</head>
<body>
<div id="dark" class="container" style="padding: 20px 70px;">
<h2>Project</h2><Br/><Br/>
		<table>
					<%
	ArrayList<ProjectManager> project = (ArrayList<ProjectManager>) request.getAttribute("projectList");
	ProjectManager pm = null;
	for (int i = 0; i < project.size(); i++) {
		pm = project.get(i);
%>
			<tr>
				<td><%=pm.getProjectName()%></td>
				<td>
					<div class="graph">
						<strong class="bar" style="width: <%=pm.getPercent()%>%;"><%=pm.getPercent()%>%</strong>
					</div>
				</td>
			</tr>
									<%
			}
		%>
		</table>
		</div>
</body>
</html>