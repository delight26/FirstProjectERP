<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" href="css/table.css" rel="stylesheet"/>
<style type="text/css">
#t_my td{
	text-align: left;
}
#t_my th {
	padding: 10px 30px;
}
#t_my {
	font: 16px '맑은 고딕';
	width: 800px;
	height: 700px;
}
#t_my input {
	height: 18px;
}
#d_btn {
	margin-left: 680px;
}
.css3button {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 13px;
	color: #ffffff;
	padding: 6px 20px;
	background: -moz-linear-gradient(
		top,
		#c9c9c9 0%,
		#000000 55%,
		#050505);
	background: -webkit-gradient(
		linear, left top, left bottom,
		from(#c9c9c9),
		color-stop(0.55, #000000),
		to(#050505));
	-moz-border-radius: 87px;
	-webkit-border-radius: 87px;
	border-radius: 87px;
	border: 2px solid #fcfcfc;
	-moz-box-shadow:
		0px 3px 11px rgba(000,000,000,0.5),
		inset 0px 0px 1px rgba(000,000,000,1);
	-webkit-box-shadow:
		0px 3px 11px rgba(000,000,000,0.5),
		inset 0px 0px 1px rgba(000,000,000,1);
	box-shadow:
		0px 3px 11px rgba(000,000,000,0.5),
		inset 0px 0px 1px rgba(000,000,000,1);
	text-shadow:
		0px -1px 0px rgba(000,000,000,0),
		0px 1px 0px rgba(255,255,255,0.3);
}
</style>
<script>
function back() {
    parent.location.href="mainTemplateIndex.jsp";
}
</script>
<title>관리자페이지_사원 등록</title>
</head>
<body>
	<form id="join" action="memberupdate.member" enctype="multipart/form-data" method="post">
			<table id="t_my">
				<tr>
					<th>사원번호</th>
					<td><input type="text" name="membernumber" size="16px" value="${member.membernumber }" readonly="readonly" /></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" size="16px" value="${member.name }" readonly="readonly"/></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="password" size="16px" /></td>
				</tr>
				<tr>
					<th>핸드폰번호</th>
					<td>
					<% %>
						<select name="phonenumber1" value="${member.phonenumber.substring(0,3) }">
							<option>010</option>
							<option>011</option>
							<option>017</option>
							<option>018</option>
							<option>019</option>
						</select>-
						<input type="text" name="phonenumber2" size="5px" maxlength="4" value="${member.phonenumber.substring(4,8) }"/>-
						<input type="text" name="phonenumber3" size="5px" maxlength="4" value="${member.phonenumber.substring(9) }"/>
					</td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td><input type="text" name="birthday" size="25px" value="${member.birthday }"readonly="readonly"/></td>
				</tr>
				<tr>
					<th>입사일</th>
					<td><input type="text" name="hiredate" size="25px" value="${member.hiredate }" readonly="readonly"/></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" name="adress" size="70px" value="${member.adress }"/></td>
				</tr>
				<tr>
					<th>소속부서</th>
					<td>
						<input type="text" value="${member.dname }" readonly="readonly">
					</td>
				</tr>
				<tr>
					<th>매니저</th>
					<td><input type="text" name="managernumber" size="16px" value="${member.managernumber }" readonly="readonly"/></td>
				</tr>
				<tr>
					<th>직급</th>
					<td>
					<input type="text" name="jobname" value="${member.jobname }" readonly = "readonly"/>
					</td>
				</tr>
				<tr>
					<th>사진</th>
					<td>
					<input type="file" name ="photo"/>
					</td>
				</tr>
			</table>
			<div id="d_btn">
				<input type="button" value="취소" onclick="back()" class="css3button"/>
				<input type="submit" value="수정" class="css3button"/>
			</div>
	</form>
</body>
</html>	