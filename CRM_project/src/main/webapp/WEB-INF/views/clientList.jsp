<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="./header.jsp" %>
</head>
<body>
<jsp:useBean id="now" class="java.util.Date" />
<div class="container" style="text-align: center;">
<div style='text-align: left;'>
<button type="button"class="btn btn-primary" onclick="location.href='./insertPage.do'">새 거래처 등록 </button>
</div><br>
<select id="selectstate" style="float: left;">
	<option value="진행">진행</option>
	<option value="대기">대기</option>
	<option value="종료">종료</option>
</select>
<table id="myTable" class="display" style="width:100%">
		<thead>
			<tr >
				<th style="width:10%">사업자 번호</th>
				<th style="width:10%">상태</th>
		        <th style="text-align: center;">거래처명</th>
		        <th style="text-align: center;">거래처 위치</th>
		      	<th style="text-align: center; width:10%;">거래처 전화번호</th>
		        <th style="text-align: center;">거래처 지역</th>
			</tr>
		</thead>
		
		<tbody>
		<c:out value="${today}" />
      <c:forEach var="clists" items="${clists}">
      <tr>
		<td>${clists.cli_num}</td>
		<td>${clists.status}</td>
        <td style= 'text-align: center;'><a href="./clientDetail.do?cli_num=${clists.cli_num}">${clists.cli_name}</a></td>
        <td style= 'text-align: center;'>${clists.cli_addr}</td>
        <td style="text-align: center;">${clists.cli_tel}</td>
        <td style="text-align: center;">${clists.cli_area}</td>
      </tr>
    </c:forEach>
    </tbody>
</table>
		<div style='text-align: right;'>
		 <button  class="btn btn-warning" onclick="location.href='./result.do'">뒤로가기</button>
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
        displayLength: 20, //기본표시건수 설정
        lengthChange: false,
        info: false
    });
});


var data = {
		"state" : $("#selectstate").val()
}

console.log(data);


</script>

</html>