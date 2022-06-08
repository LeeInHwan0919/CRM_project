<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>재고 리스트</title>
<%@include file="./header.jsp" %>
</head>
<body>
<div class="container" style="text-align: center; margin-top: 50px;">
<h2>재고 관리</h2><br>
<table id="myTable" class="display" style="width:100%">
		<thead>
			<tr >
				<th style="width:10%">상품명</th>
				<th style="width:10%">할인적용</th>
		        <th style="text-align: center;">재고수량</th>
		        <th style="text-align: center;">포장 단위(kg)</th>
		      	<th style="text-align: center; width:10%;">원산지</th>
		        <th style="text-align: center;">원재료(%)</th>
		        <th style="text-align: center;">포장 단위(EA)</th>
			</tr>
		</thead>
		
		<tbody>
      <c:forEach var="goods" items="${goods}">
      <tr>
		<td>${goods.g_name}</td>
		<td>${goods.dcode_goods}</td>
        <td style= 'text-align: center;'>${goods.iv_cnt}</td>
        <td style= 'text-align: center;'>${goods.g_kg}</td>
        <td style="text-align: center;">${goods.g_country}</td>
        <td style="text-align: center;">${goods.g_content}</td>
        <td style="text-align: center;">${goods.g_amount}</td>
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
		
        pagingType: "full_numbers",
        displayLength: 10, 
        lengthChange: false,
        info: false
    });
});


</script>

</html>