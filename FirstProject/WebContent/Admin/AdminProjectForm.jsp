<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테이블관리_프로젝트관리</title>
</head>
<style>
	* {
		font: '맑은 고딕';
	}
	#project > tr {
		font-weight: bold;
	}
	#t_project {
		border: 1px solid black;
		border-collapse: collapse;
	}
	#t_project th, #t_project td {
		border: 1px solid black;
		border-collapse: collapse;
		height: 23px;
	} 
	#t_project td:last-child {
		line-height: 23px;
		text-align: center;
		padding-bottom: 3px;
	}
	#project fieldset {
		border: none;
	}
	#project div {
		padding-left: 310px; 
	}
	#project legend {
		font-size: 16px;
		font-weight: bold;
	}
	
</style>
<body>
	<form id="project">
		<fieldset>
			<legend>프로젝트 리스트</legend>
			<table id="t_project">
				<thead style="font-size: 12px">
					<tr>
						<th width="70px">번호</th>
						<th width="300px">프로젝트명</th>
						<th width="70px">담당자</th>
						<th width="110px">현황</th>
						<th width="50px">작성일</th>
						<th width="50px"></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><input type="button" value="삭제" /></td>
					</tr>
				</tbody>
			</table>
		</fieldset>
	</form>

</body>
</html>