<%@page import="java.sql.Timestamp"%>
<%@page import="com.firstproject.visitant.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String passNum = request.getParameter("passNum");
	String name = request.getParameter("name");
	String company = request.getParameter("company");
	String phone = request.getParameter("phone1") + "-" + request.getParameter("phone2") 
					+ "-" + request.getParameter("phone3");
	
	VisitantBean visitant = new VisitantBean();
	
	visitant.setPassNum(Integer.parseInt(passNum));
	visitant.setVisitantName(name);
	visitant.setCompany(company);
	visitant.setPhone(phone);
	visitant.setInTime(new Timestamp(System.currentTimeMillis()));
	
	VisitantDao dao = VisitantDao.getInstans();
	dao.insertVisitant(visitant);
	
	response.sendRedirect("listVisitant.jsp");
%>