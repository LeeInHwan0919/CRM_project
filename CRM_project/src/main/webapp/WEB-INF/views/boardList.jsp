<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 게시판 리스트</title>
<%@include file="./header.jsp" %>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <style type="text/css">
  th,table {
  text-align: center;
}
  </style>
  
</head>
<body>

<div class="container">
    <div style='text-align: center;'>
  	<h2>공지 게시판</h2><br>
	<table id="myTable" class="display" style="width:100%; font-size:120%;">
		<thead>
			<tr>
			<th style="text-align: center;"><strong>번호</strong></th>
		        <th style="text-align: center;">제목</th>
		        <th style="text-align: center;">작성자</th>
		      	<th style="text-align: center;">등록일</th>
		        <th style="text-align: center;">조회</th>
			</tr>
		</thead>
		
		
      <tbody>
      
      <c:forEach var="ls" items="${lists}">
      <tr>
		<td>${ls.seq}</td>
        <c:if test="${ls.important eq 1}">
        <td style= 'text-align: left;' ><strong><a href="./boardDetail.do?seq=${ls.seq}" style=' color: red;'>&nbsp&nbsp&nbsp<img alt=""src="./resources/img/aaa.png">&nbsp&nbsp&nbsp${ls.title}</a></strong></td>
        </c:if>
        <c:if test="${ls.important eq 0}">
        <td style= 'text-align: center;'><a href="./boardDetail.do?seq=${ls.seq}">${ls.title}</a></td>
        </c:if>
        
        <td>관리자</td>
        <td >${ls.startdate}</td>
        <td>${ls.s_count}</td>
      </tr>
    </c:forEach>
    </tbody>
</table>
		<div style='text-align: right;'>
			<c:if test="${user == 'SYS_123456'}">
         <button type="button"class="btn btn-primary" onclick="location.href='./insertBoardPage.do'">새글 입력</button>
			 </c:if>	
		 <button  class="btn btn-warning" onclick="location.href='./result.do'">뒤로가기</button>
         </div><br>
		</div>
</div>
</body>
<script type="text/javascript">
$(document).ready(function () {
	
	table = $("#myTable").DataTable({
		"language": { 
            "emptyTable": "데이터가 없어요.",
            "lengthMenu": "페이지당 _MENU_ 개씩 보기",
            "info": "현재 _START_ - _END_ / _TOTAL_건",
            "infoEmpty": "데이터 없음",
            "infoFiltered": "( _MAX_건의 데이터에서 필터링됨 )",
            "search": "검색: ",
            "zeroRecords": "일치하는 데이터가 없어요.",
            "loadingRecords": "로딩중...",
            "processing":     "잠시만 기다려 주세요...",
            "paginate": {
                "next": "다음",
                "previous": "이전"
            }
        },
		
        pagingType: "full_numbers", // 페이징 타입 설정 : simple, simple_numbers, full_numbers 등
        lengthChange: false,
        info: false
    });
});
</script>

<%@include file="./footer.jsp" %>
</html>