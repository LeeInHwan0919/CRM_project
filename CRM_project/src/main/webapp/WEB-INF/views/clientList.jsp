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
<div class="container">
<table id="myTable" class="display" style="width:100%">
		<thead>
			<tr>
				<th>사업자 번호</th>
		        <th>거래처명</th>
		        <th>거래처 위치</th>
		      	<th>거래처 전화번호</th>
		        <th>거래처 지역</th>
			</tr>
		</thead>
		
		<tbody>
      <c:forEach var="clists" items="${clists}">
      <tr>
        
		<td>${clists.cli_num}</td>
        <td style= 'text-align: center;' ><a href="./clientDetail.do?cli_num=${clists.cli_num}">${clists.cli_name}</a></td>
        <td style= 'text-align: center;'><a href="./clientDetail.do?cli_num=${clists.cli_num}">${clists.cli_addr}</a></td>
        <td>${clists.cli_tel}</td>
        <td>${clists.cli_area}</td>
      </tr>
    </c:forEach>
    </tbody>
</table>

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

</html>