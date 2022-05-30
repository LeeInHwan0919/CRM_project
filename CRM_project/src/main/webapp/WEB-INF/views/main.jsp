<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공!</title>
</head>
<body>
환영합니다!<br>
${user}
<a href="./logout.do">로그아웃</a>

<h1>This is the body of the sample view</h1>

	<security:authorize access="isRememberMe()">
		<h2># This user is login by "Remember Me Cookies".</h2>
	</security:authorize>

    <security:authorize access="hasRole('Admin')">
        당신은 관리자 입니다
        <br/> <br/>
        <a href="<c:url value="/admin/adminPage.do" />">Restricted Admin Page</a>
        <br/> <br/>
    </security:authorize>
	
    <security:authorize access="hasRole('User')">
        당신은 사용자 입니다
        <br/>
        <a href="<c:url value="/admin/adminpage.html" />">Admin Page</a>
        <br/>
    </security:authorize>

    <a href="./logout.do">Logout</a>
</body>
</html>