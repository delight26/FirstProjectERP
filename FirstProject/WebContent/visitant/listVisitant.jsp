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
	int tempInt = PAGE_SIZE -1;
	int endRow = pageInteger * PAGE_SIZE;
	int startRow = endRow - tempInt;
	
	int listCount = 0;
	VisitantDao dao = VisitantDao.getInstans();
	listCount = dao.getCount();
	ArrayList<VisitantBean> visitantList = null;
	if(listCount > 0) visitantList = dao.getvisitantList(startRow,endRow);
	
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
		<td colspan="6" class="boardTitle"><h3>미퇴행 리스트</h3></td>
	</tr>

	<tr>
		<td class="listCount" colspan="6">정문 미퇴행 자 : <%=listCount %></td> 
	</tr>
	<tr>
		<td class="listTime">출입날짜</td>
		<td class="listNumber">출입증 번호</td>
		<td class="listName">출입자</td>
		<td class="listcompany">소속</td>
		<td class="listPhone">연락처</td>
		<td class="listState">출입상태</td>		
	</tr>
	<c:if test="<%= listCount ==0 %>">
	<tr>
		<td class="listTdSpan" colspan="6">출입자가 존재하지 않습니다.</td>
	</tr>
	</c:if>
	<c:if test="<%= listCount !=0 %>">
	<c:forEach var="visitant" items="<%= visitantList %>">
	<tr class="listTr">
		<td class="listTime"><fmt:formatDate value="${ visitant.inTime }" 
			pattern="yyyy-MM-dd HH:mm:ss" /></td>
		<td class="listNumber">${visitant.passNum }		</td>
		<td class="listName">${ visitant.visitantName }</td>
		<td class="listcompany">${ visitant.company }</td>
		<td class="listPhone">${ visitant.phone }</td>
		<c:if test="${visitant.state==0}"><td>퇴행</td></c:if>
		<c:if test="${visitant.state==1}"><td>출입</td></c:if>
		<c:if test="${visitant.state==2}"><td style="color: red;">보안구역출입</td></c:if>		
	</tr>
	</c:forEach>
	</c:if>
	<tr>
		<td colspan="6" class="listPage">
	
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
		
			<a href="listVisitant.jsp?pageNum=<%= startPage - PAGE_GROUP %>" class="page">
				이전</a>
<% 	}
		for(int i = startPage; i <= endPage; i++) { 
			
			if(i == pageInteger) { %>
			
				<a class="nonstyle" href="listVisitant.jsp?pageNum=<%= i %>" class="page active"><%= i %></a>
										
<%		} else { %>
			
				<a class="nonstyle" href="listVisitant.jsp?pageNum=<%= i %>" class="page"><%= i %></a>
<%
			}
		}
	
		if(endPage < pageCount) {%>
		
			<a href="listVisitant.jsp?pageNum=<%= startPage + PAGE_GROUP %>" class="page">
				다음</a>
<%	}
	}	%>		
		</td>			
	</tr>	
</table>
</body>
</html>









