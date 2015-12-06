<%@page import="com.firstproject.visitant.*"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String tempPassNumber = request.getParameter("passNumber");
	String tempSecurityPass = request.getParameter("securityPass");
	String tempMemberNumber = request.getParameter("memberNumber");
	String work = request.getParameter("work");
	
	SecurityVisitantDao dao = SecurityVisitantDao.getInstans();
	int passNumber = Integer.parseInt(tempPassNumber);
	int memberNumber = Integer.parseInt(tempMemberNumber);
	int securityPass = Integer.parseInt(tempSecurityPass);
	boolean check1 = false;
	boolean check2 = false;
	boolean check3 = false;
	int visitNumber = 0;
	check1 = dao.checkMemberNum(memberNumber);
	
	
	if(!check1){ 
%>
	<jsp:forward page="newSecurityVisitant.jsp">
		<jsp:param value="직원 번호를 확인해주세요." name="returnCode"/>	
	</jsp:forward>
<%
	}else{
		check2 = dao.checkSecurityPass(securityPass);
		if(!check2){
%>
	<jsp:forward page="newSecurityVisitant.jsp">
		<jsp:param value="내부 출입번호를 확인해주세요" name="returnCode"/>	
	</jsp:forward>
<%
		}else{				
			visitNumber = dao.getVisitNumber(passNumber);
			check3 = dao.checkSecurityKey(visitNumber);
			if((visitNumber < 1)){%>
	<jsp:forward page="newSecurityVisitant.jsp">
		<jsp:param value="정문출입키를 확인해주세요" name="returnCode"/>	
	</jsp:forward>
<%
			}else{
				if(check3){
%>
	<jsp:forward page="newSecurityVisitant.jsp">
		<jsp:param value="이미 등록처리가 되었있습니다." name="returnCode"/>	
	</jsp:forward>
<%
			}else{
			
			SecurityVistantBean security = new SecurityVistantBean();
			security.setVisitNumber(visitNumber);
			security.setSecurityPass(securityPass);
			security.setMemberNumber(memberNumber);
			security.setWork(work);	
			security.setSecurityInTime(new Timestamp(System.currentTimeMillis()));
			
			dao.insertSecurity(security);
			
			pageContext.forward("listVisitant.jsp");
			}
		}
	}
}
%>	
