<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<%@page import="com.firstproject.bean.*"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Calendar cal = Calendar.getInstance();

	String strYear = request.getParameter("year");
	String strMonth = request.getParameter("month");

	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH);
	int date = cal.get(Calendar.DATE);

	if (strYear != null) {
		year = Integer.parseInt(strYear);
		month = Integer.parseInt(strMonth);

	} else {

	}
	//년도/월 셋팅
	cal.set(year, month, 1);

	int startDate = cal.getMinimum(java.util.Calendar.DATE);
	int endDate = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
	int startDay = cal.get(java.util.Calendar.DAY_OF_WEEK);
	int newLine = 0;

	//오늘 날짜 저장.
	Calendar todayCal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyMMdd");
	int intToday = Integer.parseInt(sdf.format(todayCal.getTime()));
%>
<html lang="ko">
<HEAD>
<TITLE>캘린더</TITLE>
<meta charset="utf-8">
<link rel="stylesheet" href="css/calenderForm.css">
<script src="js/jquery-1.11.3.min.js"></script>
<script>
$(function(){
	$("#prevNav").on("click", function(){
		var month = <%=month%>
		if(month > 0){
	window.location.href="calendarForm.schedul?"+
			"year="+<%=year%>+"&month="+<%=month - 1%>;
		}else{
			window.location.href="calendarForm.schedul?"+
			"year="+<%=year -1%>+"&month=11";}
		});
	$("#afterNav").on("click", function(){
		var month = <%=month%>
		if(month <11){
			window.location.href="calendarForm.schedul?"
					+"year="+<%=year%>+"&month="+<%=month + 1%>;
		}else{
			window.location.href="calendarForm.schedul?"+
			"year="+<%=year +1%>+"&month=0";}
		});
	$("#number1").on("click",function(index){
		window.open("readSchedule.schedul?number="+index ,
				"sub","toolbar=no, titlebar=no, status=no, scrollbar=no, menubar=no,"+
				"location=no,directories=no, height=800px, width=600px");
		
			 return false;
	});
	$("#seleteCal").on("submit", function(){
		var year = $("#year").val();
		var month = $("#month").val();
		window.location.href="calendarForm.schedul?year="+year+"&month="+month;
		return false;
	});
	$("#selectBtn").on("click", function(){
		var year = $("#year").val();
		var month = $("#month").val();
		window.location.href="calendarForm.schedul?year="+year+"&month="+month;
	});
	
});
	function readcal(index){
	window.open("readSchedule.schedul?number="+index ,
			"sub","toolbar=no, titlebar=no, status=no, scrollbar=no, menubar=no,"+
			"location=no,directories=no, height=500px, width=600px");
	} 
</script>
<style>
* {
	font-family: '맑은 고딕';
}
#number{
background:#666;
border-radius: 5px;
color:white;
width:100%;
border:1px solid #eaeaea;
}
</style>
</HEAD>
<BODY>
	<form name="calendarFrm" id="calendarFrm" action="" method="post">
		<DIV id="content" style="width: 1260px;">


			<!--날짜 네비게이션  -->
			<table width="100%" border="0" cellspacing="1" cellpadding="1"
				id="KOO" bgcolor="lightcyan"  style="height: 130px">
				<tr>
					<td height="60">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="10"></td>
							</tr>
							<tr>
								<td class='tdNav' align="center">
									 <input id="prevNav" class='Nav' type='button' 
									value="◀" /> <!-- 이전달 --> 
  
									&nbsp;&nbsp;&nbsp;<input id='btnNav' class="Nav"type='button'
									onclick="window.location.href='calendarForm.schedul'"
									value="오늘" />&nbsp;&nbsp;&nbsp;  
									<input type='button' class='Nav' id="afterNav"
									
									value="▶" /> 

								</td>
								<td class='tdNav' align="center" style="font-size: 35px;"><strong><%=year%>년
										<%=month + 1%>월</strong></td>
								<td class='tdNav' align="center">
									<form>
										<select name="year" id="year">
											<option value='2010'>2010년</option>
											<option value='2011'>2011년</option>
											<option value='2012'>2012년</option>
											<option value='2013'>2013년</option>
											<option value='2014'>2014년</option>
											<option selected="selected" value='2015'>2015년</option>
											<option value='2016'>2016년</option>
											<option value='2017'>2017년</option>
											<option value='2018'>2018년</option>
											<option value='2019'>2019년</option>
											<option value='2020'>2020년</option>
											<option value='2021'>2021년</option>
										</select> <select name="month" id="month">
											<option value='0'>1월</option>
											<option value='1'>2월</option>
											<option value='2'>3월</option>
											<option value='3'>4월</option>
											<option value='4'>5월</option>
											<option value='5'>6월</option>
											<option value='6'>7월</option>
											<option value='7'>8월</option>
											<option value='8'>9월</option>
											<option value='9'>10월</option>
											<option selected="selected" value='10'>11월</option>
											<option value='11'>12월</option>
										</select> <input id='selectBtn' class="Nav"type="button" value="이동" />
									</form>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<table border="0" cellspacing="1" cellpadding="1" bgcolor="#F5F5F5">
				<THEAD>
					<TR bgcolor="#CECECE" height="40px">
						<TD width='180px'>
							<DIV align="center">
								<font color="red" size="3px">SUN</font>
							</DIV>
						</TD>
						<TD width='180px'>
							<DIV align="center"><font  size="3px">MON</font></DIV>
						</TD>
						<TD width='180px'>
							<DIV align="center"><font  size="3px">TUE</font></DIV>
						</TD>
						<TD width='180px'>
							<DIV align="center"><font  size="3px">WED</font></DIV>
						</TD>
						<TD width='180px'>
							<DIV align="center"><font  size="3px">THU</font></DIV>
						</TD>
						<TD width='180px'>
							<DIV align="center"><font  size="3px">FRI</font></DIV>
						</TD>
						<TD width='180px'>
							<DIV align="center">
								<font color="blue" size="3px">SAT</font>
							</DIV>
						</TD>
					</TR>
				</THEAD>
				<TBODY>
					<a
						href="calendarForm.schedul?
												year=<%=year - 1%>&amp;
												month=<%=month%>"></a>
					<TR>
						<%
							//처음 빈공란 표시
							for (int index = 1; index < startDay; index++) {
								out.println("<TD class='tdDate'>&nbsp;</TD>");
								newLine++;
							}

							for (int index = 1; index <= endDate; index++) {
								String color = "";

								if (newLine == 0) {
									color = "RED";
								} else if (newLine == 6) {
									color = "BLUE";
								} else {
									color = "BLACK";
								}
								;

								String sUseDate = Integer.toString(year);

								sUseDate += Integer.toString(month + 1).length() == 1 ? "0" + Integer.toString(month + 1)
										: Integer.toString(month + 1);
								sUseDate += Integer.toString(index).length() == 1 ? "0" + Integer.toString(index)
										: Integer.toString(index);

								int iUseDate = Integer.parseInt(sUseDate);

								String backColor = "#F5F5F5";
								if(iUseDate == intToday ) {
									backColor = "#e6e6e6";
								} else if (newLine == 6) {
									backColor = "#9DCEFF";
								} else if (newLine == 0) {
									backColor = "#F5DEB3";
								}
								out.println("<TD class='tdDate' valign='top' align='left' bgcolor='" + backColor + "' nowrap>");
								/* 일정 입력 구간 시작*/
						%>
						
						<font color='<%=color%>'> 
						
						<%
						if(newLine == 6) {
							%>
							<a name="date"
								style="color:blue"
									href="#" onclick="window.open('addSchedule.schedul?date=<%=sUseDate%>','sub','toolbar=no, titlebar=no, status=no, scrollbar=no, menubar=no,location=no,directories=no, height=500px, width=600px')">
								<%=index%>
									
							</a>
							
							<%
						} else if(newLine == 0) {
							%>
							<a name="date"
								style="color:red"
									href="#" onclick="window.open('addSchedule.schedul?date=<%=sUseDate%>','sub','toolbar=no, titlebar=no, status=no, scrollbar=no, menubar=no,location=no,directories=no, height=500px, width=600px')">
								<%=index%>
							</a>
							<%
						} else {
							%>
							<a name="date"
								style="color:#000000"
									href="#" onclick="window.open('addSchedule.schedul?date=<%=sUseDate%>','sub','toolbar=no, titlebar=no, status=no, scrollbar=no, menubar=no,location=no,directories=no, height=500px, width=600px')">
								<%=index%>
							</a>
							<%
						}
						%>
						</font>
						
						
						
						
						<%
							out.println("<br/>");
								out.println("<br/>");

								ArrayList<ScheduleBean> scheduleList =

								(ArrayList<ScheduleBean>) request.getAttribute("scheduleList");

								for (int i = 0; i < scheduleList.size(); i++) {

									if (sUseDate.equals(scheduleList.get(i).getScheduleDate())) {
						%>
						<input id="number" type="button" value="<%=scheduleList.get(i).getScheduleTitle()%>"
							onclick="readcal('<%=scheduleList.get(i).getScheduleNumber() %>')"/>
							
						
						<%
							out.println("<br/>");
									}
								}

								//기능 제거	
								/* 일정 입력 구간 끝*/
								out.println("</TD>");
								newLine++;

								if (newLine == 7) {
									out.println("</TR>");
									if (index <= endDate) {
										out.println("<TR>");
									}
									newLine = 0;
								}
							}
							//마지막 공란 LOOP
							while (newLine > 0 && newLine < 7) {
								out.println("<TD>&nbsp;</TD>");
								newLine++;
							}
						%>
					</TR>

				</TBODY>
			</TABLE>
		</DIV>
	</form>
</BODY>
</HTML>
