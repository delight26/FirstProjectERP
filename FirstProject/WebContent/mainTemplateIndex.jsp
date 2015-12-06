<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈</title>
<link type="text/css" href="css/mainTemplateIndex.css" rel="stylesheet" />
<link type="text/css" href="css/header.css" rel="stylesheet" />
</head>
<body>
<%
    if(session.getAttribute("loginUser")==null){
    	%>
		<script type="text/javascript">
			alert('세션이 종료 되었습니다.');
			parent.location = "./LoginMain/LoginForm.jsp";
		</script>
	<%
    }else{
    	%>
	<section id="h_section">
		<br/>
		<div id="wrap">
			<%@ include file="pages/templateHeader.jsp"%><br />
			<%
		Member member = (Member)session.getAttribute("loginUser");
		int membernum = member.getMembernumber();
		%>
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
	</section>
	<div class="clear"></div>
	<section id="n_section">
		<%
		if(membernum==1000){
			
			%>
		<%@ include file="Admin/AdminMainForm.jsp"%>

		<%
		}else{
		%>
		<%@ include file="pages/templateNav.jsp"%>
		<%
		}
		%>
	</section>
	<c:if test="${ empty param.body }">
	</c:if>
	<c:if test="${ not empty param.body }">
		<jsp:include page="${ param.body }" />
	</c:if>
	<div class="clear"></div>
	<section id="h_section">
		<%@ include file="pages/templateFooter.jsp"%></section>
	</div>
	<%
	}
	%>
</body>
</html>