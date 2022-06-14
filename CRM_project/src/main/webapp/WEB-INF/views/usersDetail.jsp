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
  margin-left: 100px;
  margin-top:20px;
}
#btn{
 margin-top: 10px;
   margin-left: 360px;
 }
 
#label{
  font: bold;
}

</style>
<script type="text/javascript">

$("#modify").click(function(){
	console.log("ajax 발동");
	 $.ajax({
        type : "POST",
        url : "./updateUser.do", 
        success : function(msg){
            sweatalert(msg+"성공입니다.");
            location.href="./usersList.do";
        },
        error : function(err){
        	sweatalert(JSON.stringify(err)+"실패입니다.");
        	location.href="redirect:/usersDetail.do"
        }
    });
});

</script>
<body>
<c:forEach var="users" items="${users}">
<div class="container" style="margin-top: 30px; margin-left: 550px;">
<h2 style="margin-left: 100px; margin-top: 20px;">사원 정보 수정</h2>
  <table border="1">
    <tr>
      <td rowspan="3" width="150px;"><img src="${users.emp_img}" id="emp_img"></td>
      <td id="label">사원코드</td>
      <td colspan="2">${users.emp_code}</td>
    </tr>
    <tr>
      <td id="label">사원이름</td>
      <td colspan="2">${users.emp_name}</td>
    </tr>
    <tr>
      <td id="label">권한</td>
      <td colspan="2">${users.emp_auth}</td>
    </tr>
    <tr>
      <td><input type="file" accept="image/*" style="width: 100%;"></td>
      <td colspan="3"></td>
    </tr>
    <form action="./updateUser.do" method="post">
    <input type="hidden" value="${users.emp_code}" id="emp_code" name="emp_code">
    <tr>
      <td id="label">성별</td>
      <td colspan="3">
      <select name="emp_gender" id="emp_gender">
		  <option value="${users.emp_gender}" selected>${users.emp_gender}</option>
		  <option value="남">남성</option>
		  <option value="여">여성</option>
	  </select>
      </td>
    </tr>
    <tr>
      <td id="label">전화번호</td>
      <td colspan="3"><input type="text" id="emp_tel" name="emp_tel" value="${users.emp_tel}"></td>
    </tr>
    <tr>
      <td id="label">주소</td>
      <td colspan="3">
      <textarea rows="3" cols="40" id="emp_addr" name="emp_addr">${users.emp_addr}</textarea></td>
    </tr>
    <tr>
      <td id="label">계정여부</td>
      <td colspan="3">
      <select id="emp_use" name="emp_use">
		  <option value="${users.emp_use}" selected>
			  <c:if test="${users.emp_use eq 'Y'}">
			  <c:out value="계정 활성화">
			  계정 활성화
			  </c:out>
			  </c:if>
			  <c:if test="${users.emp_use eq 'N'}">
			  계정 비활성화
			  <c:out value="계정 비활성화">
			  </c:out>
			  </c:if>
		  </option> 
		  <option value="Y">계정 활성화</option>
		  <option value="N">계정 비활성화</option>
	  </select>
      </td>
    </tr>
    <tr>
      <td id="label">담당지역</td>
      <td colspan="3" id="area">
      ${users.area}
	  </td>
    </tr>
  </table>
  <div id="btn">
  <button class="btn btn-success" id="modify" type="submit">수정</button>
</form>
  <button class="btn btn-warning" onclick="location.href='./UsersList.do'">뒤로가기</button>
  </div>
</div>
</c:forEach>
</body>

</html>