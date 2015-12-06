<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<%@page import="com.firstproject.bean.*"%>

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
	String today = sdf.format(todayCal.getTime());
	
	System.out.println(today);
	
	ArrayList<ScheduleBean> scheduleList = new ArrayList<ScheduleBean>();
	
	scheduleList = (ArrayList<ScheduleBean>) request.getAttribute("scheduleList");
	
	
%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/mainfr.css">
<script>
function readcal(index){
	window.open("readSchedule.schedul?number="+index ,
			"sub","toolbar=no, titlebar=no, status=no, scrollbar=no, menubar=no,"+
			"location=no,directories=no, height=500px, width=600px");
	} 
</script>
</head>
<style>
	a { text-decoration: none; }
</style>
<body>
<div id="dark" class="container">
    <div id="indented" class="box">
        <h2>Today Schedule</h2>
            <ul>
<% 
for (int i = 0; i < scheduleList.size(); i++) {

		if (today.equals(scheduleList.get(i).getScheduleDate())) {
%>
	<li><a name="number" href="javascript:readcal('<%=scheduleList.get(i).getScheduleNumber() %>')" />
					<%= scheduleList.get(i).getScheduleTitle() %></a></li>
<%		
		}	
}
%>
		</ul>
		<a href="calendarForm.schedul" target = "mainfr" style="float: right; color:white;">더보기</a><br/>
	</div>
	</div>
</body>
</html>