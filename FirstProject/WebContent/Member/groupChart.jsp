<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사원 조직도</title>
<style>
	* { font: 12px '맑은 고딕'; }
	li {
		list-style: none;
		border: 1px solid black;
		padding: 5px 10px;
		width: 80px;
		float:left;
	}
	li:nth-child(n+2) { border-top: none; }
	a { text-decoration: none; }
	a:link { color: black; }
	li:hover { background: yellow; }
	a:visited { color: black; }
	section {
		text-align: center;
	}
	ul{

	}
</style>
</head>
<body>
	<ul id="chart">
		<li><a href="groupChartList.member?departmentnumber=10" target="mainframe">경리부</a></li>
		<li><a href="groupChartList.member?departmentnumber=20" target="mainframe">인사부</a></li>
		<li><a href="groupChartList.member?departmentnumber=30" target="mainframe">영업부</a></li>
		<li><a href="groupChartList.member?departmentnumber=40" target="mainframe">전산부</a></li>
		<li><a href="groupChartList.member?departmentnumber=50" target="mainframe">프로젝트1팀</a></li>
		<li><a href="groupChartList.member?departmentnumber=60" target="mainframe">프로젝트2팀</a></li>
		<li><a href="groupChartList.member?departmentnumber=70" target="mainframe">프로젝트3팀</a></li>
		<li><a href="groupChartList.member?departmentnumber=80" target="mainframe">프로젝트4팀</a></li>
	</ul>
	<section>
		<iframe width="100%" height="2000" name="mainframe" frameborder="0"></iframe>
	</section>
</body>
</html>