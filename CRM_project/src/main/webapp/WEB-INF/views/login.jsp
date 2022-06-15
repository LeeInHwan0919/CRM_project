<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./resources/css/login.css">
<style type="text/css">
div#img{
  text-align: center;
}

div.container{
  margin-top: 180px;
}
</style>
<title>로그인 페이지</title>
</head>
<body>
<div class="container">
<div id="img">
<img style="text-align: center; height: 66px;" src="./resources/img/blue_logo.png">
</div>
	<form action="./logingo.do" class="signin-form" method="POST">
		<div class="login" style="margin-top: 30px;">
			<input type="text" placeholder="사원코드를 입력해 주세요." id="username" name="emp_code"> 
				<input type="password" placeholder="패스워드를 입력해 주세요." id="password" name="emp_pw"> 
				<b style="color: red; margin-left: 40px;" >${msg}</b>
				<a href="./findpw.do" class="forgot">비밀번호를 잊으셨습니까악?</a> 
				<input type="submit" value="LOGIN">
		</div>
		<div class="shadow"></div>
	</form>
</div>
</body>
<script type="text/javascript">
  

</script>
</html>