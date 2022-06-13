<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 정보 등록</title>
<%@include file="./header.jsp"%>
<style type="text/css">
 
 table{
   margin-top: 30px;
   margin-left: 300px;
 }
 
 #btn{
   margin-top: 10px;
   margin-left: 570px;
 }
</style>
</head>
<body>
 <form action="./insertUser.do" method="post">
   <div class="container">
		<h2 style="margin-left: 300px; margin-top: 100px;">사원 정보 등록</h2>
     <table border="1">
         <tr>
           <th>사원코드(아이디)</th>
           <td><input type="text" id="emp_code" name="emp_code" placeholder="사원코드를 입력해주세요."></td>
         </tr>
         <tr>
           <th>담당지역</th>
           <td>
           <select id="area_code" name="area_code">
             <option value="default">--선택--</option>
             <option value="LC01">서울</option>
             <option value="LC02">대구</option>
             <option value="LC03">울산</option>
             <option value="LC04">부산</option>
             <option value="LC05">춘천</option>
             <option value="LC06">천안</option>
             <option value="LC07">대전</option>
             <option value="LC08">광주</option>
           </select>
           </td>
         </tr>
         <tr>
           <th>사원이름</th>
           <td><input type="text" id="emp_name" name="emp_name" placeholder="사원이름을 입력해주세요."></td>
         </tr>
         <tr>
           <th>비밀번호</th>
           <td><input type="text" id="emp_pw" name="emp_pw" placeholder="비밀번호를 입력해주세요."></td>
         </tr>
         <tr>
           <th>성별</th>
           <td><input type="text" id="emp_gender" name="emp_gender" placeholder="성별을 입력해주세요."></td>
         </tr>
         <tr>
           <th>담당업무(권한)</th>
           <td>
           <select id="emp_auth" name="emp_auth">
             <option value="default">--선택--</option>
             <option value="IV_ADMIN">재고 관리자</option>
             <option value="CL_ADMIN">거래처 관리자</option>
             <option value="SYSTEM">시스템 관리자</option>
           </select>
           </td>
         </tr>
         <tr>
           <th>전화번호</th>
           <td><input type="text" id="emp_tel" name="emp_tel" placeholder="전화번호를 입력해주세요."></td>
         </tr>
         <tr>
           <th>주소</th>
           <td><textarea rows="3" cols="40" id="emp_addr" name="emp_addr"></textarea></td>
         </tr>
     </table>
     <div id="btn">
     <button type="submit" class="btn btn-success">등록</button>
     <input type="button" class="btn btn-warning" onclick="javascript:history.back(-1)" value="뒤로가기">
     </div>
   </div>
 </form>
</body>

</html>