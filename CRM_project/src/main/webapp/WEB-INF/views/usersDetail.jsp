<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 정보 수정</title>
<%@include file="./header.jsp"%>
</head>
<style type="text/css">
p{
  font-size: 15px;
  font: bold;
  font-style: inherit;
}

img{
    max-width: 100%;
    max-height: 100%;
}

.form-group{
  width:200px;
  display:inline-block;
}

table{
  width:400px;
}


</style>
<body>
<c:forEach var="users" items="${users}">

<div class="container" style="margin-top: 30px; margin-left: 550px;">
  <table border="1">
    <tr>
      <td rowspan="3" width="150px;"><img src="${users.emp_img}"></td>
      <td>사원코드</td>
      <td colspan="2" id="emp_code">${users.emp_code}</td>
    </tr>
    <tr>
      <td>사원이름</td>
      <td colspan="2">${users.emp_name}</td>
    </tr>
    <tr>
      <td>권한</td>
      <td colspan="2">${users.emp_auth}</td>
    </tr>
    <tr>
      <td><button style="width: 100%;">사진 업로드</button></td>
      <td colspan="3"></td>
    </tr>
    <form action="#" method="post">
    <input type="hidden" value="${users.emp_code}">
    <tr>
      <td>성별</td>
      <td colspan="3">
      <select name='use'>
		  <option value='default' selected>${users.emp_gender}</option>
		  <option value='man'>남</option>
		  <option value='woman'>여</option>
	  </select>
      </td>
    </tr>
    <tr>
      <td>전화번호</td>
      <td colspan="3"><input type="text" id="emp_tel" value="${users.emp_tel}"></td>
    </tr>
    <tr>
      <td>주소</td>
      <td colspan="3"><input type="text" id="emp_addr" value="${users.emp_addr}"></td>
    </tr>
    <tr>
      <td>계정여부</td>
      <td colspan="3">
      <select id='emp_use'>
		  <option value='default' selected>${users.emp_use}</option>
		  <option value='Y'>계정 활성화</option>
		  <option value='N'>계정 비활성화</option>
	  </select>
      </td>
    </tr>
    <tr>
      <td>담당지역</td>
      <td colspan="3">
      ${users.area}
	  </td>
    </tr>
  </table>
  <button class="btn btn-success" type="submit">수정</button>
</form>
  <button class="btn btn-warning" onclick="location.href='./UsersList.do'">뒤로가기</button>
</div>
</c:forEach>
</body>

</html>