<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container"> 
              <h3>거래처 수정</h3>
                 <table class="table table-hover">
                 <tr>
                    <td>사업자 번호</td>
                      <td><input class="form-control" type="text" id="title" name="title"/></td>
                 </tr>
                 <tr>
                    <td>거래처명</td>
                      <td><input class="form-control" type="text" id="title" name="title"/></td>
                 </tr>
                 <tr>
                    <td>거래처 주소</td>
                      <td><input class="form-control" type="text" id="title" name="title"/></td>
                 </tr>
                  <tr>
                    <td>거래처 위치</td>
                      <td>
                      <select id="selectarea">
			        		<option value="서울">서울</option>
			        		<option value="부산">부산</option>
			        		<option value="춘천">춘천</option>
		        	  </select>
                      </td>
                 </tr>
                  <tr>
                    <td>거래처 전화번호</td>
                      <td><input class="form-control" type="text" id="title" name="title"/></td>
                 </tr>
                  <tr>
		        		<td>계약 시작일자</td>
		        	<td>
<!-- 		        		<input type="text" name="title" id="title"> -->
							<input type="text" name="startdate" id="datepicker" readonly="readonly">
		        	</td>
		        </tr>
		         <tr>
		        		<td>계약만료 일자</td>
		        	<td>
<!-- 		        		<input type="text" name="title" id="title"> -->
							<input type="text" name="enddate" id="datepicker2" readonly="readonly">
		        	</td>
		        </tr>
                 </table>
              <div style="text-align: center;">
              <input class="btn btn-default" id="updateBtn" type="button" value="수정하기">
              <input class="btn btn-default"  type="button" value="뒤로가기" onclick="javascript:history.back(-1)">
              </div>
</div>
</body>
<script type="text/javascript">
$( function() {
	$("#datepicker").datepicker();
    $("#datepicker").datepicker("option", "dateFormat","yy-mm-dd");
});

$( function() {
	$("#datepicker2").datepicker();
    $("#datepicker2").datepicker("option", "dateFormat","yy-mm-dd");
});


</script>
</html>