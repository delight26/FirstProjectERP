<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery-1.11.3.min.js"></script>
<link type="text/css" href="css/table.css" rel="stylesheet"/>
<script type="text/javascript">
function subm(){
	var scheduleTitle = $("#scheduleTitle").val();
	var scheduleContent = $("#scheduleContent").val();
	var scheduleDate = $("#scheduleDate").val();
	var number = $("#number").val();
		opener.location.href = "updateScheculeService.schedul?title="
			+ scheduleTitle
			+ "&content="
			+ scheduleContent
			+ "&date="
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
#t1 th{
	width: 150px;
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
</style>
<style type="text/css">
.content {
	font-family: "돋움";
	font-size: 9pt;
	color: #666666;
	border: 1px #c9c9c9 solid;
	background-image: url(image/textline.gif);
	line-height: 15pt;
	scrollbar-face-color: #FFFFFF;
	scrollbar-shadow-color: #C9C9C9;
	scrollbar-highlight-color: #C9C9C9;
	scrollbar-3dlight-color: #FFFFFF;
	scrollbar-darkshadow-color: #FFFFFF;
	scrollbar-track-color: #FFFFFF;
	scrollbar-arrow-color: #666666;
	overflow: hidden;
}
</style>
</head>
<body>
	<%
	String number = request.getParameter("number");
	String date = request.getParameter("date");
	%>
	<form name="form1" id="form1" onsubmit="return subm()">
		<table id="t1" style="margin: 0; width: 500px;">
			<tr>
				<th>Title</th>
				<td><input type="text" name="title" id="scheduleTitle" value="${ schedule.scheduleTitle}" size="40px"/></td>
			</tr>
			<tr>
				<th>Date</th>
				<td>${ schedule.scheduleDate }</td>
			</tr>
			<tr>
				<th style="height: 200px;">Content</th>
				<td><textarea name="content" id="scheduleContent" rows="12" cols="40">${ schedule.scheduleContent }
						</textarea></td>
			</tr>
		</table>
		<br/>
		<div style="margin-left: 150px;">
			<input id="sub"type="submit" value="수정" class="css3button"/>
			<input type="button" value="취소" class="css3button" onclick="history.back();"/>
			<input type="hidden" name="number" id="number"value="<%=number %>"/>
			<input type="hidden" name="date" id="scheduleDate"value="<%=date %>"/>
		</div>
	</form>
</body>
</html>