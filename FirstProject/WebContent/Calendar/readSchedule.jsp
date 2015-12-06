<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.firstproject.bean.ScheduleBean" %>
<!DOCTYPE html	>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery-1.11.3.min.js"></script>
<link type="text/css" href="css/table.css" rel="stylesheet"/>
<script type="text/javascript">
function deletecal(){
	var scheduleDate = $("#deletedate").val();
	var number = $("#deletenumber").val();
		opener.location.href = "deleteSchedule.schedul?&date="
			+ scheduleDate
			+"&number="+number;
	window.close();
		return false;
	
	}
	
</script>
<style type="text/css">
body{
	background: lightcyan;
}
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
form {
	float:left;
	margin:5px;
}
#t1 th{
	width: 150px;
}
</style>
</head>
<body>
	<div>
		<table id="t1" style="margin: 0; width: 500px;">
			<tr>
				<th>Title</th>
				<td>${ schedule.scheduleTitle }</td>
			</tr>
			<tr>
				<th>Date</th>
				<td>${ schedule.scheduleDate }</td>
			</tr>
			<tr>
				<th style="height: 200px;">Content</th>
				<td>${ schedule.scheduleContent }</td>
			</tr>
		</table>
		<br/>
		<%-- <%
		
		ScheduleBean schedule = (ScheduleBean) request.getAttribute("schedule");
		
		String year = schedule.getScheduleDate().substring(0, 4);
		String month = schedule .getScheduleDate().substring(4, 6);
		int imonth = Integer.parseInt(month);
		imonth--;
		%> --%>
		<form action="updateSchedule.schedul" style="margin-left: 150px;">
			<input type="hidden" name="number" value="${ schedule.scheduleNumber }"/>
			<input type="hidden" name="date" value="${ schedule.scheduleDate }"/>
			<input type="hidden" name="title" value="${ schedule.scheduleTitle}"/>
			<input type="hidden" name="content" value="${ schedule.scheduleContent }"/>
			<input type="submit"  value="수정하기" class="css3button"/>
		</form>
		<form action="deleteSchedule.schedul" onsubmit="return deletecal()">
			<input type="hidden" name="number" id="deletenumber"value="${ schedule.scheduleNumber }"/>
			<input type="hidden" name="date" id="deletedate"value="${ schedule.scheduleDate }"/>
			<input type="submit" value="삭제하기" class="css3button"/>
		</form>
	</div>
</body>
</html>
