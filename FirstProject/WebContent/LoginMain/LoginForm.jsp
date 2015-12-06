<%@page import="com.firstproject.bean.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" href="/FirstProject/css/login.css" rel="stylesheet">

<style>
* {
 text-align: center;
}
fieldset {
width: 300px;
}
</style>
</head>
<body class="align">
<div class="logo">
  <a href="#">welcome to<br>G&HERP.co.kr</a><br/><br/><br/><br/>
<div class="site__container">
<div class="grid__container">
	<form action="login.login" method="post" name="frm" class="form form--login">
		<fieldset>
		<div class="form__field">
          <label class="fontawesome-user" for="login__username">
          <span class="hidden">ID</span></label>
          <input id="login__username" type="text" class="form__input" name="membernumber" placeholder="ID" required>
        </div>
	
	<div class="form__field">
          <label class="fontawesome-lock" for="login__password"><span class="hidden">Password</span></label>
        <input id="login__password" type="password" class="form__input" name="password"  placeholder="Password" required>
        </div>
		
			<div class="form__field">
          <input type="submit" value="Log In">
        </div>
			<br/><br/>
			로그인 문제시 <br/>
			전산과 장완순 주임 <br/>
			사내번호 4563~4564<br/>
		</fieldset>
	</form>
	</div></div></div>
	
	
</body>
</html>