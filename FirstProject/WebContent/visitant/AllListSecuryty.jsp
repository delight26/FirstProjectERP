<%@page import="com.firstproject.visitant.*"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<%!
	int PAGE_SIZE = 20;
	int PAGE_GROUP = 5;
%>
<%
	String pageNum = request.getParameter("pageNum");
	if(pageNum==null) pageNum = "1";	
	int pageInteger = Integer.parseInt(pageNum);
	int tempInt = PAGE_SIZE - 1;
	int endRow = pageInteger * PAGE_SIZE;
	int startRow = endRow - tempInt;
	
	int listCount = 0;
	SecurityVisitantDao dao = SecurityVisitantDao.getInstans();
	listCount = dao.getAllCount();
	ArrayList<ListSecurityBean> listSecurity = null;
	if(listCount > 0) listSecurity = dao.getAllListSecurity(startRow, endRow);		
			
	
%>    

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" href="../css/table.css" rel="stylesheet"/>
<link type="text/css" href="../css/pageBtn.css" rel="stylesheet"/>
<script type="text/javascript" src="./js/formcheck.js"></script>
<style type="text/css">
.listTime .listNumber .listName .listcompany .listOutTime .listState{ 
	width: 50px; 
	height: 30px;
	text-align: center; 
	border: 1px solid #787878; 
	background: #EAEAEA; 
}
</style>
</head>
<body>
<table id="t1">
	<tr>
		<td colspan="8" class="boardTitle"><h3>보안구역 출입 리스트</h3></td>
	</tr>

	<tr>
		<td class="listCount" colspan="8">출입자 : <%=listCount %></td> 
	</tr>
	<tr>
		<td class="listTime">보안구역 출입시간</td>
		<td class="listNumber">보안 출입증 번호</td>
		<td class="listName">출입자</td>
		<td class="listcompany">소속</td>
		<td class="listPhone">연락처</td>
		<td class="listWork">작업내용</td>
		<td class="listMember">담당직원</td>
		<td class="listState">출입상태</td>		
	</tr>
	<c:if test="<%= listCount ==0 %>">
	<tr>
		<td class="listTdSpan" colspan="6">출입자가 존재하지 않습니다.</td>
	</tr>
	</c:if>
	<c:if test="<%= listCount !=0 %>">
	<c:forEach var="security" items="<%= listSecurity %>">
	<tr class="listTr">
		<td class="listTime"><fmt:formatDate value="${ security.securityInTime }" 
			pattern="yyyy-MM-dd HH:mm:ss" /></td>
		<td class="listNumber">${security.securityPass }</td>
		<td class="listName">${ security.visitantName}</td>
		<td class="listcompany">${ security.company }</td>
		<td class="listPhone">${ security.phone }</td>
		<td class="listWork">${ security.work }</td>
		<td class="listMember">${ security.memberNumber }</td>
		<c:if test="${security.securityState==0}"><td>보안구역 퇴행</td></c:if>
		<c:if test="${security.securityState==1}"><td style="color: red;">보안구역 출입</td></c:if>
	</tr>
	</c:forEach>
	</c:if>
	<tr>
		<td colspan="8" class="listPage">
	
<%
	if(listCount > 0) {
		int pageCount = listCount / PAGE_SIZE 
				+ (listCount % PAGE_SIZE == 0 ? 0 : 1);
		 int startPage = ( pageInteger/ PAGE_GROUP) * PAGE_GROUP + 1
			- (pageInteger % PAGE_GROUP == 0 ? PAGE_GROUP : 0);
		int endPage = startPage + PAGE_GROUP - 1;
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		if(startPage > PAGE_GROUP) {	%>
		
			<a href="AllListSecuryty.jsp?pageNum=<%= startPage - PAGE_GROUP %>" class="page">
				이전</a>
<% 	}
		for(int i = startPage; i <= endPage; i++) { 
			
			if(i == pageInteger) { %>
			
				<a href="AllListSecuryty.jsp?pageNum=<%= i %>" class="page active"><%= i %></a>
										
<%		} else { %>
			
				<a href="AllListSecuryty.jsp?pageNum=<%= i %>" class="page"><%= i %></a>
<%
			}
		}	
		if(endPage < pageCount) {%>
		
			<a href="AllListSecuryty.jsp?pageNum=<%= startPage + PAGE_GROUP %>" class="page">
				다음</a>
<%	}
	}	%>		
		</td>			
	</tr>	
</table>
</body>
</html>









