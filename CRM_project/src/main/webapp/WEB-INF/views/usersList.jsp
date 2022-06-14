<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 리스트</title>
<%@include file="./header.jsp"%>
</head>
<body style="background-color: #FFFAFA">
	<div class="container" style="text-align: center; margin-top: 50px;">
		<h2>계정 관리</h2>
		<br>
		<table id="myTable" class="display" style="width: 100%">
			<thead>
				<tr>
					<th style="width: 10%">사원이름</th>
					<th style="width: 10%">권한</th>
					<th style="text-align: center;">아이디(코드)</th>
					<th style="text-align: center;">성별</th>
					<th style="text-align: center; width: 10%;">사용여부</th>
					<th style="text-align: center;">전화번호</th>
					<th style="text-align: center;">정보</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="users" items="${users}">
					<tr>
						<td>${users.emp_name}</td>
						<td>${users.emp_auth}</td>
						<td style='text-align: center;' id="emp_code">${users.emp_code}</td>
						<td style='text-align: center;'>${users.emp_gender}</td>
						<td style="text-align: center;">
						  <c:if test="${users.emp_use eq 'Y'}">
						    <c:out value="${users.emp_use}"></c:out>
						  </c:if> 
						  <c:if test="${users.emp_use eq 'N'}">
						    <b style="color: red;">${users.emp_use}</b> 
						  </c:if> 
						</td>
						<td style="text-align: center;">${users.emp_tel}</td>
						<td style="text-align: center;">
						<button type="button" data-toggle="modal" data-target="#myModal"
						onclick="location.href='./usersDetail.do?emp_code=${users.emp_code}'">정보수정</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<div style='text-align: right;'>
		<button class="btn btn-primary" onclick="location.href='./insertUserGo.do'">계정등록</button>
			<button class="btn btn-warning" onclick="location.href='./result.do'">뒤로가기</button>
		</div>


	</div>
</body>

<script type="text/javascript">
	$(document).ready(function() {
		table = $("#myTable").DataTable({
			"language" : {
				"emptyTable" : "데이터가 없어요.",
				"lengthMenu" : "페이지당 _MENU_ 개씩 보기",
				"info" : "현재 _START_ - _END_ / _TOTAL_건",
				"infoEmpty" : "데이터 없음",
				"infoFiltered" : "( _MAX_건의 데이터에서 필터링됨 )",
				"search" : "검색: ",
				"zeroRecords" : "일치하는 데이터가 없어요.",
				"loadingRecords" : "로딩중...",
				"processing" : "잠시만 기다려 주세요...",
				"paginate" : {
					"next" : "다음",
					"previous" : "이전"
				}
			},

			pagingType : "full_numbers",
			displayLength : 4,
			lengthChange : false,
			info : false
		});
	});
</script>

</html>