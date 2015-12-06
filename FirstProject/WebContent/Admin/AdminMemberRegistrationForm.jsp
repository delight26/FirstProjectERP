<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" href="../css/table.css" rel="stylesheet"/>
<style type="text/css">
#t_join td{
	text-align: left;
}
#t_join th {
	padding: 10px 30px;
}
#t_join {
	font: 16px '맑은 고딕';
	width: 800px;
	height: 700px;
}
#t_join input {
	height: 18px;
}
#d_btn {
	margin-left: 650px;
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
<title>관리자페이지_사원 등록</title>
</head>
<body>
	<form id="join" action="memberRegistrationResult.member" enctype="multipart/form-data" method="post">
			<table id="t_join">
				<tr>
					<th>사원번호</th>
					<td><input type="text" name="membernumber" size="16px" /></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" size="16px" /></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="password" size="16px" /></td>
				</tr>
				<tr>
					<th>핸드폰번호</th>
					<td>
						<select name="phonenumber1">
							<option>010</option>
							<option>011</option>
							<option>017</option>
							<option>018</option>
							<option>019</option>
						</select>-
						<input type="text" name="phonenumber2" size="5px" maxlength="4" />-
						<input type="text" name="phonenumber3" size="5px" maxlength="4" />
					</td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td><input type="date" name="birthday" size="25px" /></td>
				</tr>
				<tr>
					<th>입사일</th>
					<td><input type="date" name="hiredate" size="25px" /></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" name="adress" size="70px" /></td>
				</tr>
				<tr>
					<th>소속부서</th>
					<td>
						<select name="departmentnumber">
							<option value="10">경리부</option>
							<option value="20">인사부</option>
							<option value="30">영업부</option>
							<option value="40">전산부</option>
							<option value="50">프로젝트1팀</option>
							<option value="60">프로젝트2팀</option>
							<option value="70">프로젝트3팀</option>
							<option value="80">프로젝트4팀</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>매니저</th>
					<td><input type="text" name="managernumber" size="16px" /></td>
				</tr>
				<tr>
					<th>직급</th>
					<td>
						<select name="jobnumber">
							<option value="47">사원</option>
							<option value="46">대리</option>
							<option value="45">과장</option>
							<option value="44">팀장</option>
							<option value="43">차장</option>
							<option value="42">부장</option>
						</select>
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
				<input type="reset" value="취소" class="css3button"/>&nbsp;&nbsp;
				<input type="submit" value="등록" class="css3button"/>
			</div>
	</form>
</body>
</html>