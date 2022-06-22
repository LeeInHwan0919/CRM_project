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
    max-width:100%;
    max-height: 100%;
}

td#label {
    width: 25%;
}

.table{
  width: 500px;
  height: 500px;
  }

.form-group{
  width:200px;
  display:inline-block;
}

table{
  margin-left: 100px;
  margin-top:20px;
}

 
#btn{
 margin-top: 10px;
   margin-left: 10px;
   float: left;
 }
#btn2{
   margin-left: 250px;
 }
#label{
  font: bold;
}


</style>
<script type="text/javascript">

	
	function readURL(input) {
		  if (input.files && input.files[0]) {
		    var reader = new FileReader();
		    reader.onload = function(e) {
		      document.getElementById('img').src = e.target.result;
		      jQuery('#emp_img').attr("value",e.target.result);
		    };
		    reader.readAsDataURL(input.files[0]);
		    alert('이미지가 업로드 되었습니다.');
		  } else {
		    document.getElementById('img').src = "";
		    jQuery('#emp_img').attr("value","");
		    alert('이미지 업로드에 실패하였습니다.');
		  }
		}
</script>
<body style="background-color: #FFFAFA">
<c:forEach var="users" items="${users}">
      <input type="hidden" id="emp_img" name="emp_img" value="${users.emp_img}">
<div class="container" style="margin-top: 30px; margin-left: 550px;">
<h2 style="margin-left: 100px; margin-top: 20px;">사원 정보 수정</h2>
    <form action="./updateUser.do" method="post">
  <table class="table table-bordered">
    <tr>
      <td rowspan="3" width="150px;"><img src="${users.emp_img}" id="img"></td>
      <td id="label">사원코드</td>
      <td  colspan="2">${users.emp_code}</td>
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
      <td><input type="file" accept="image/*" style="width: 100%;" id="Inputfile" onchange="readURL(this);"></td>
      <td colspan="3"></td>
    </tr>
    <input type="hidden" value="${users.emp_code}" id="emp_code" name="emp_code">
    <tr>
      <td id="label">성별</td>
      <td colspan="3">
      <select name="emp_gender" id="emp_gender">
		  	  <c:if test="${users.emp_gender eq '남'}">
		  		<option value="${users.emp_gender}" selected>남</option>
		  		<option value="여">여</option>
			  </c:if>
			  <c:if test="${users.emp_gender eq '여'}">
		  		<option value="${users.emp_gender}" selected>여</option>
		  		<option value="남">남</option>
			  </c:if>
	  </select>
      </td>
    </tr>
    <tr>
      <td id="label">전화번호</td>
      <td colspan="3">
        <input type="text" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"  placeholder="010-000-0000" maxlength="11" id="emp_tel" name="emp_tel" value="${users.emp_tel}">
      </td>
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
			  <c:if test="${users.emp_use eq 'Y'}">
		  		<option value="${users.emp_use}" selected>계정 활성화</option>
		  		<option value="N">계정 비활성화</option>
			  </c:if>
		      <c:if test="${users.emp_use eq 'N'}">
		  		<option value="${users.emp_use}" selected>계정 비활성화</option>
		  		<option value="Y">계정 활성화</option>
			  </c:if>
	  </select>
      </td>
    </tr>
    <tr>
      <td id="label">담당지역</td>
      <td colspan="3">
      <select id="area_code" name="area_code">
      		 <c:if test="${users.area_code eq 'LC01'}">
		  		<option value="${users.area_code}" selected>서울</option>
                <option value="LC02">대구</option>
                <option value="LC03">울산</option>
                <option value="LC04">부산</option>
                <option value="LC05">춘천</option>
                <option value="LC06">천안</option>
                <option value="LC07">대전</option>
                <option value="LC08">광주</option>
			  </c:if>
			  <c:if test="${users.area_code eq 'LC02'}">
		  		<option value="${users.area_code}" selected>대구</option>
                <option value="LC01">서울</option>
                <option value="LC03">울산</option>
                <option value="LC04">부산</option>
                <option value="LC05">춘천</option>
                <option value="LC06">천안</option>
                <option value="LC07">대전</option>
                <option value="LC08">광주</option>
			  </c:if>
			  <c:if test="${users.area_code eq 'LC03'}">
		  		<option value="${users.area_code}" selected>울산</option>
                <option value="LC01">서울</option>
                <option value="LC02">대구</option>
                <option value="LC04">부산</option>
                <option value="LC05">춘천</option>
                <option value="LC06">천안</option>
                <option value="LC07">대전</option>
                <option value="LC08">광주</option>
			  </c:if>
			  <c:if test="${users.area_code eq 'LC04'}">
		  		<option value="${users.area_code}" selected>부산</option>
                <option value="LC01">서울</option>
                <option value="LC02">대구</option>
                <option value="LC03">울산</option>
                <option value="LC05">춘천</option>
                <option value="LC06">천안</option>
                <option value="LC07">대전</option>
                <option value="LC08">광주</option>
			  </c:if>
			  <c:if test="${users.area_code eq 'LC05'}">
		  		<option value="${users.area_code}" selected>춘천</option>
                <option value="LC01">서울</option>
                <option value="LC02">대구</option>
                <option value="LC03">울산</option>
                <option value="LC04">부산</option>
                <option value="LC06">천안</option>
                <option value="LC07">대전</option>
                <option value="LC08">광주</option>
			  </c:if>
			  <c:if test="${users.area_code eq 'LC06'}">
		  		<option value="${users.area_code}" selected>천안</option>
                <option value="LC01">서울</option>
                <option value="LC02">대구</option>
                <option value="LC03">울산</option>
                <option value="LC04">부산</option>
                <option value="LC05">춘천</option>
                <option value="LC07">대전</option>
                <option value="LC08">광주</option>
			  </c:if>
			  <c:if test="${users.area_code eq 'LC07'}">
		  		<option value="${users.area_code}" selected>대전</option>
                <option value="LC01">서울</option>
                <option value="LC02">대구</option>
                <option value="LC03">울산</option>
                <option value="LC04">부산</option>
                <option value="LC05">춘천</option>
                <option value="LC06">천안</option>
                <option value="LC08">광주</option>
			  </c:if>
			  <c:if test="${users.area_code eq 'LC08'}">
		  		<option value="${users.area_code}" selected>광주</option>
                <option value="LC01">서울</option>
                <option value="LC02">대구</option>
                <option value="LC03">울산</option>
                <option value="LC04">부산</option>
                <option value="LC05">춘천</option>
                <option value="LC06">천안</option>
                <option value="LC07">대전</option>
			  </c:if>
       </select>
	  </td>
    </tr>
  </table>
  <div id="btn2">
  <button id="btn" class="btn btn-success" id="modify" type="submit">수정</button>
</form>
  <div id="btn">
  <button class="btn btn-warning" onclick="location.href='./UsersList.do'">뒤로가기</button>
  </div>
  </div>
</div>
</c:forEach>
</body>
</html>