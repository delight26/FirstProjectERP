<%@page import="com.firstproject.visitant.*"%>
<%@page import="java.sql.Timestamp"%>
>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int securityPass = Integer.parseInt(request.getParameter("securityPass"));
	SecurityVistantBean security = new SecurityVistantBean();	
	security.setSecurityPass(securityPass);
	security.setSecurityOutTime(new Timestamp(System.currentTimeMillis()));
	security.setSecurityState(0);
	
	SecurityVisitantDao dao = SecurityVisitantDao.getInstans();
	dao.outSecurityVistant(security);
	response.sendRedirect("listVisitant.jsp");
%>    
 