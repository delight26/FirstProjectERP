<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.*, com.firstproject.bean.*, java.util.*"%>
<%
	if (session.getAttribute("loginUser") == null) {
%>
<script type="text/javascript">
	alert('세션이 종료 되었습니다.');
	parent.location = "./LoginMain/LoginForm.jsp";
</script>
<%
	} else {
		Member member = (Member) session.getAttribute("loginUser");
		String name = member.getName();
		int memberNumber = member.getMembernumber();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<script src="js/jquery-1.11.3.min.js"></script>
<link type="text/css" href="css/table.css" rel="stylesheet" />
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

#t_write {
	width: 680px;
}
</style>
<script>
	function clearmessage(frm) {
		frm.value = "";
	}
	$(function() {
		$("form").on("submit", function() {
			if ($("dept") == 0) {
				alert("부서를 선택해 주세요");
				return false;
			}

		});
	});
</script>
</head>
<body>
	<form name="form" action="DepartmentWriteResult.dept">
		<table id="t_write">
			<tr>
				<th>작성자</th>
				<td style="text-align: left;"><input type="text"
					name="membername" value="<%=name%>" readonly="readonly" /> <input
					type="hidden" name="membernum" value="<%=memberNumber%>" /></td>
				<th>부서명</th>
				<td><select name="dept" id="dept">
						<option value="0" selected>부서 선택</option>
						<option value="10">경리부</option>
						<option value="20">인사부</option>
						<option value="30">영업부</option>
						<option value="40">전산부</option>
						<option value="50">프로젝트1팀</option>
						<option value="60">프로젝트2팀</option>
						<option value="70">프로젝트3팀</option>
						<option value="80">프로젝트4팀</option>
				</select></td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3"><input name="txtTitle" type="text" size="80"
					onfocus="clearmessage(this.form.txtTitle);" /></td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3" style="text-align: left;"><textarea
						name="content" cols="80" rows="15"></textarea></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td colspan="3" style="text-align: left;"><input
					type="password" name="pass" /></td>
			</tr>
		</table>
		<br/>
		<div style="margin-left: 620px;">
			<input type="button" value="취소" onclick="history.back();" class="css3button"/>
			<input type="submit" value="등록" class="css3button" />
		</div>	
	</form>
	<%
		}
	%>
</body>
</html>