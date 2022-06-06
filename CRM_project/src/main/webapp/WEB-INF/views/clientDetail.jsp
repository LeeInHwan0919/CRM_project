<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>거래처 상세 조회</title>
<%@include file="./header.jsp" %>
</head>
<body>
<div class="container">

<table class="table table-bordered" style="text-align: center;"> 
	<thead>
			<tr>
				<th>사업자 번호</th>
		        <th>사원코드</th>
		        <th>사업장 이름</th>
		      	<th>주소</th>
		        <th>전화번호</th>
		        <th>총 계약 년수</th>
		        <th>시작날짜</th>
		        <th>종료날짜</th>
			</tr>
		</thead>

<%-- 			${cVo} --%>
	
		<tbody>
			<c:forEach var="cVo" items="${cVo}" begin="0" end="0"> 
				<td>${cVo.cli_num}</td>
				<td>${cVo.emp_code}</td>
				<td>${cVo.cli_name}</td>
 				<td>${cVo.cli_addr}</td>
 				<td>${cVo.cli_tel}</td>
 				<td>${cVo.ct_date_year_sum}</td>
 				<td>${cVo.ct_start}</td>
 				<td>${cVo.ct_end}</td>
			</c:forEach>
		</tbody>		
			
<%-- 	<button class="btn btn-default" onclick="location.href='./deleteClient.do?cli_num=${cVo.cli_num}'">삭제</button> --%>
	</table>
<table class="table table-bordered" style="text-align: center;"> 
	<thead>
			<tr>
		        <th style="text-align: center;"> 원두 종류</th>
				<th style="text-align: center;">할인율</th>
		        <th style="text-align: center;">상품할인율</th>
		        <th style="text-align: center;">계약상태</th>
		        
			</tr>
		</thead>
		<tbody>
		<c:forEach var="cVo" items="${cVo}">
 			<tr> 
 				<td>${cVo.g_name}</td>
 				<td style="width:10%">${cVo.rate}</td>
 				<td style="width:10%">${cVo.g_code}</td>
 				<td  style="width:10%">${cVo.status}</td>
 			</tr>
			</c:forEach>
		</tbody>
</table>	
		<button class="btn btn-danger" onclick="deletClient()"style="float: right;">삭제</button>
	</div>
	</body>
	<script type="text/javascript">
	function deletClient(cli_num){
		console.log(cli_num) 
		
		var data = confirm("삭제하시겠습니까?");
		
		if(!data){
			return false;
		}
		
	    $.ajax({
	         type:"POST",
	         url:"./deleteClient.do",
	         data : {cli_num : cli_num},
	         success : function(){
	            alert("삭제 성공"); 
	            window.location.href = './clientList.do';
	            
	         },
	         error:function(error){
	            console.log("error");
	         }
	    });
	 }
	
	
	</script>
</html>