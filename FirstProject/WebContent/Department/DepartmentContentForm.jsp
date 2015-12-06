<%@ page import="com.firstproject.bean.*, java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
ArrayList<DepartmentBoard> postList = new ArrayList<DepartmentBoard>();
postList = (ArrayList<DepartmentBoard>) request.getAttribute("departmentList");
if (session.getAttribute("loginUser") == null) {
%>
<script type="text/javascript">
alert('세션이 종료 되었습니다.');
parent.location = "./LoginMain/LoginForm.jsp";
</script>
<%
}else{
Member member = (Member) session.getAttribute("loginUser");
String name = member.getName();
int memberNumber = member.getMembernumber();

int i = 0;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-1.11.3.min.js"></script>
<link type="text/css" href="css/table.css" rel="stylesheet" />
<script>
	function deleteDepartment(postNumber) {
		location.href = "DepartmentDelete.dept?postNumber=" + postNumber;
	}
/* 	function updateDepartment(postNumber) {
		location.href = "DepartmentUpdate.dept?postNumber=" + postNumber;
	} */
	function updateDepartment(postNumber) {
		var post = $("#postPassword").val();
		var check = $("#checkPassword").val();
		
		if(post == check){
		location.href = "DepartmentUpdate.dept?postNumber=" + postNumber;
		}else{
			alert("비밀번호를 확인해 주세요");
			
		}
	}
	function nextDepartment(postNumber, departmentnum) {
		location.href = "nextDepartment.dept?postNumber=" + postNumber
				+ "&departmentNum=" + departmentnum;
	}
	function preDepartment(postNumber, departmentnum) {
		location.href = "preDepartment.dept?postNumber=" + postNumber
				+ "&departmentNum=" + departmentnum;
		
	}
	
	function deleteDepartment(postNumber){
		var post = $("#postPassword").val();
		var check = $("#checkPassword").val();
		
		if(post == check){
		location.href = "DepartmentDelete.dept?postNumber=" + postNumber;
		}else{
			alert("비밀번호를 확인해 주세요");			
		}		
	}
	function deleteComment(commentNum , commentCre , postNum, deptno) {
		
		if (commentCre == <%=memberNumber%>) {

			var input = confirm('정말로 삭제하시겠습니까?');
			
			if(input) {
				location.href = "CommentDeleteService.dept?number=" + commentNum
				+ "&id=" + commentCre 
				+"&postNumber=" + postNum
				+"&deptno="+deptno;
			} else {
				alert('댓글 삭제가 취소됐습니다.');
			}
			
		} else {
			alert('본인이 작성한 댓글만 삭제할 수 있습니다.');
		}
		
	}
	
	function updateComment(commentNum, commentCon, commentCre) {
		
		if (commentCre == <%=memberNumber%>) {
			var td = $("#td"+commentNum);
			td.empty();
// 			$("#td"+commentNum).append("<textarea rows='5' cols='20'>" + commentCon + "</textarea>");
			$("#td"+commentNum).append(" <textarea id='updatedComm' rows='5' cols='90'>" + commentCon + "</textarea> " 
					+ "<input type='button' class='css3button'  value='완료'  id='update'"
					+ " onclick='updateCommentService ( " + commentNum + ", "
					+ <%=postList.get(0).getPostNumber() %>+","+<%=postList.get(0).getDepartmentnum()%>+ ") ' "
					+ "   />");
		} else {
			alert('본인이 작성한 댓글만 수정할 수 있습니다.')
		}
	
	}
	
	function updateCommentService(commentNum, postNum, deptno ) {
		
		var commentCon = $('textarea#updatedComm').val()
		location.href = "CommentUpdateService.dept?number=" + commentNum
				+ "&content=" + commentCon + "&postNumber=" + postNum + "&deptno=" + deptno;
	}
	function List(){
		location.href = "departmentList.dept";
	}
	
</script>
<style type="text/css">
.css3button {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 13px;
	color: #ffffff;
	padding: 6px 20px;
	background: -moz-linear-gradient(top, #c9c9c9 0%, #000000 55%, #050505);
	background: -webkit-gradient(linear, left top, left bottom, from(#c9c9c9),
		color-stop(0.55, #000000), to(#050505));
	-moz-border-radius: 87px;
	-webkit-border-radius: 87px;
	border-radius: 87px;
	border: 2px solid #fcfcfc;
	-moz-box-shadow: 0px 3px 11px rgba(000, 000, 000, 0.5), inset 0px 0px
		1px rgba(000, 000, 000, 1);
	-webkit-box-shadow: 0px 3px 11px rgba(000, 000, 000, 0.5), inset 0px 0px
		1px rgba(000, 000, 000, 1);
	box-shadow: 0px 3px 11px rgba(000, 000, 000, 0.5), inset 0px 0px 1px
		rgba(000, 000, 000, 1);
	text-shadow: 0px -1px 0px rgba(000, 000, 000, 0), 0px 1px 0px
		rgba(255, 255, 255, 0.3);
}
</style>
<style>
#t2 {
	width: 800px;
}

#t3 {
	width: 800px;
}
#t1 {
	width: 800px;
}

#t1 th {
	width: 100px;
}

#input_div {
	margin-left: 900px;
}

#comment_form {
	margin-left: 700px;
}
.btn_div2{
	margin-left: 1000px;
}
.btn_div {
	margin-left: 650px;
}
</style>
</head>
<body>
	<form>
		<table id="t2">
			<tbody>
				<c:forEach var="department" items="${departmentList}">
					<tr>
						<th>글번호</th>
						<td>${department.postNumber}</td>
						<th>작성일</th>
						<td colspan="3">${department.postDate}</td>
					</tr>

					<tr>
						<th>작성자</th>
						<td>${department.postCreater}</td>
						<th>부서명</th>
						<td>${department.departmentName}</td>
						<th>조회수</th>
						<td>${department.postLookup}</td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="5" style="text-align: left;">${department.postName}</td>
					</tr>
					<tr>
						<th style="height: 200px;">내용</th>
						<td colspan="5" style="text-align: left;">${department.content}</td>
					</tr>
					<tr>
						<th>비밀번호 확인</th>
						<td colspan="5" style="text-align: left;"><input
							type="hidden" name="postPassword" id="postPassword"
							value="${department.postPassword }"> <input type="password"
							name="checkPassword" id="checkPassword"></td>
					</tr>
				
			</tbody>
		</table>
				<div class="btn_div2">
			<img src="images/btn_pre.gif"
				onclick="preDepartment('${department.postNumber}' , '${department.departmentnum }')" />
		    <img src="images/btn_next.gif"
				onclick="nextDepartment('${department.postNumber}', '${department.departmentnum }')"/>
		</div>
		<div class="btn_div">
			<input type="button" name="btnDelete"
				value="삭제" onclick="deleteDepartment('${department.postNumber}')"
				class="css3button" /> <input type="button" name="btnUpdate"
				value="수정"
				onclick="updateDepartment('${department.postNumber}','${department.postPassword }')"
				class="css3button" /> <input type="button" name="btnBack" class="css3button"
				value="목록보기"
				onclick="List()" />
		</div>
		</c:forEach>
	</form>
	<br />
	<br />
	<table id='t3'>
		<tr>
			<th colspan="9" style='background: white; text-align: left;'>댓글</th>
		</tr>
		<c:forEach var="comment" items="${commentList}">
			<tr>
				<td style='width: 900px; background: white; text-align: left;'
					colspan="6" id='td${ comment.commentNum}'><p>${comment.creatorName}
						&nbsp; ${ comment.commentDate }</p>
					<p style="font-size: 15px">${comment.commentContent}</p>
					<div style="text-align: right">
						<a href="#"
							onclick="
						updateComment('${comment.commentNum}',' ${comment.commentContent }'
							, '  ${ comment.commentCreator }  '   , ' <%=postList.get(0).getPostNumber() %>','<%=postList.get(0).getDepartmentnum()%>'
						)">
							수정 </a> <a href='#'
							onclick="deleteComment(  ${ comment.commentNum }   ,  
						  ${ comment.commentCreator }   ,    <%=postList.get(0).getPostNumber() %> , <%=postList.get(0).getDepartmentnum()%>)">
							삭제 </a>
					</div></td>

				<c:if test="${comment.replyToName != null}">
					<td>@${comment.commentReplyTo}</td>
				</c:if>
			</tr>
		</c:forEach>
		
			<tr>
			<form action="CommentWriteService.dept">
				<td colspan='5' style="border-right: none;"><textarea
						name='comment' rows="5" cols="90"></textarea></td>
				<td style="border-left: none;"><input type='hidden'
					name='creator' value='<%=memberNumber%>' /> <input type='hidden'
					name='postNumber' value='<%=postList.get(0).getPostNumber()%>' />
					<input type='hidden'
					name='deptno' value='<%=postList.get(0).getDepartmentnum()%>' />
					<input type='submit' value='등록' class="css3button" /></td>
			</form>
			</tr>
		
	</table>
	<%
}
	%>
	<br />
	<br />
</body>
</html>
