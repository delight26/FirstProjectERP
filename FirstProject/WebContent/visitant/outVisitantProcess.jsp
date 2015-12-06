<%@page import="com.firstproject.visitant.*"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int passNum = Integer.parseInt(request.getParameter("passNum"));
	VisitantBean visitant = new VisitantBean();	
	visitant.setPassNum(passNum);
	visitant.setOutTime(new Timestamp(System.currentTimeMillis()));
	visitant.setState(0);
	
	VisitantDao dao = VisitantDao.getInstans();
	dao.outVisitant(visitant);
	response.sendRedirect("AllListVisitant.jsp");
%>