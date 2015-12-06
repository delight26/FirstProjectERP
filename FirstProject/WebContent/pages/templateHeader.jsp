<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.*, com.firstproject.bean.*, java.util.*" %>
<%
if(session.getAttribute("loginUser") == null){
	%>
	<script type="text/javascript">
		alert('세션이 종료 되었습니다.');
		parent.location = "./LoginMain/LoginForm.jsp";
	</script>
<%
}else{
	Member member = (Member)session.getAttribute("loginUser");
	int membernumber=member.getMembernumber();
	String name = member.getName();
%>   
<script src='http://ajax.googleapis.com/ajax/libs/mootools/1.4.5/mootools-yui-compressed.js'></script>
<script src="js/clock.js"></script>
<link type="text/css" href="css/clock.css" rel="stylesheet"/>
<header>

<h1><a href="mainTemplateIndex.jsp"><span class="light">www.</span><span class="dark">G&HERP</span><span class="light">.co.kr</span></a></h1>
	<div id="header_link">
		<ul>
			<li><%=name %>님</li>
			<li><a href="mainTemplateIndex.jsp">홈</a></li>
			<%
			if(membernumber==1000){
				%>
				<li><a href="memberupdatepage.member" target = "adminframe">Mypage</a></li>
				<%
			}else{
				%>
				<li><a href="memberupdatepage.member" target = "mainfr">Mypage</a></li>
				<%
			}
			%>
			
			<li class="no_line"><a href="./logout.login">로그아웃</a></li>
		</ul>
				<%
	}
	%>
	</div><br/><br/>
	<div class="clock-wrap">
  		<div class="hour-wrap">
				<div class="digit-top">
					<div class="front">00</div>
					<div class="back">00</div>
				</div>
				<div class="digit-bottom">
					<div class="front">00</div>
				</div>
			</div>
			<div class="min-wrap">
				<div class="digit-top">
					<div class="front">00</div>
					<div class="back">00</div>
				</div>
				<div class="digit-bottom">
					<div class="front">00</div>
				</div>
			</div>
      <div class="sec-wrap">
				<div class="digit-top">
					<div class="front">00</div>
					<div class="back">00</div>
				</div>
				<div class="digit-bottom">
					<div class="front">00</div>
				</div>
			</div>
		</div>
</header>


