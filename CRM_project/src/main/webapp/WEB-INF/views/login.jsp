<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./resources/css/login.css">

<title>로그인 페이지</title>
</head>
<body>
	msg:${msg} ${user}

	<form action="./logingo.do" class="signin-form" method="POST">
		<div class="login">
			<input type="text" placeholder="사원코드를 입력해 주세요." id="username" name="emp_code"> 
				<input type="password" placeholder="패스워드를 입력해 주세요." id="password" name="emp_pw"> <a
				href="./pwFind.do" class="forgot">비밀번호를 잊으셨습니까?</a> 
				<input type="submit" value="LOGIN">
		</div>
		<div class="shadow"></div>
	</form>
</body>
</html>















