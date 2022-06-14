<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>재고 리스트</title>
<%@include file="./header.jsp" %>
<script type="text/javascript">
var today
var year
var month
var date
var hours 
var minute

function callFun(str){
      $.ajax({
           type:"POST",
           url:"DBtoPdf.do",
           data : {
               fileName : str
           },
           success : function(){
              alert("PDF 다운로드 성공"); 
           },
           error:function(error){
              console.log("error");
           }
      });
   }
   
function clickBtn(){
	 today = new Date();   
     year = today.getFullYear(); // 년도
     month = today.getMonth() + 1;  // 월
     date = today.getDate();  // 날짜
//      hours = today.getHours(); //시간
//      minutes = today.getMinutes();//분
     
     var str = year + '_' + month + '_' + date /* + '_' + hours + '_' + minutes */;
     console.log(str);
     
     $.ajax({
         type:"POST",
         url:"DBtoExcel.do",
         data : {
             fileName : str
         },
         success : function(){
            alert("Excel 다운로드 성공"); 
            callFun(str);
         },
         error:function(error){
            console.log("error");
         }
    });
}

</script>
</head>
<body>
<div class="container" style="text-align: center; margin-top: 50px;">
<h2><strong>재고 관리</strong></h2><br>
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
</table><br><br>
		<div style='text-align: right;'>
		 <input style= 'text-align: right;' type="button" class="btn btn-info"  style="margin: 0 0 0 10px;" value="재고 리스드 다운" onclick="clickBtn();">
		 <button  class="btn btn-warning"  style="margin: 0 0 0 10px;" onclick="location.href='./result.do'">뒤로가기</button>
         </div>
</div>
<br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br>
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