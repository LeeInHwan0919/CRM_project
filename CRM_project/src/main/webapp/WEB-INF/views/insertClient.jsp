<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@include file="./header.jsp" %>
<body>

<div class="container">
		        <h3>계약 등록</h3>
		        <table class="table table-hover">
		        <tr>
		        		<td>사업자 번호</td>
		        	<td>
		       			<input name="cliid" id="cliid">
		        	</td>
		        </tr>
		        <tr>
		        		<td>거래처명</td>
		        	<td>
		        		<input type="text" name="cliname" id="cliname">
		        	</td>
		        </tr>
		         <tr>
		        		<td>거래처 주소</td>
		        	<td>
		        		<input type="text" name="cliaddr" id="cliaddr">
		        	</td>
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
		        	<td>
		        		<input type="text" name="clitel" id="clitel">
		        	</td>
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
		        <table class="table table-hover" id="cofficeTable">
		        <tbody>
		        </tbody>
		        </table>
		        	<div style="text-align: center;">
		        <input class="btn btn-default"  type="button" value="거래처 등록" onclick="insertBtn()">
		        <input class="btn btn-default"  type="button" value="뒤로가기" onclick="javascript:history.back(-1)">
		       		</div>
		    </div>
	</body>
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


$.ajax({
	type:"POST",
	url:"./selectCliNum.do",
	success : function(data) {
		console.log(data)
		clinum = data;
	},
	 error:function(error){
      console.log("error");
	 }
	
});



var clinum = [];
var ctm_code = 0;

$.ajax({
	type:"POST",
	url:"./selectMGR.do",
	success : function(data) {
		console.log(data);
		ctm_code = data.data;
		ctm_code = Number(ctm_code.substring(2))+1;
		ctm_code = "CM"+String(ctm_code);
	},
	 error:function(error){
      console.log("error");
	 }
	
});


$.ajax({
    type:"POST",
    url:"./selectGoodsName.do",
    success : function(data){
       console.log(data);
       let htmlData  = "";
       for(i=0;i<data.gCode.length;i++){
    	   
    	   htmlData += "<tr>";
    	   htmlData += "<td>"+ data.gName[i] +"</td>";
    	   htmlData += "<input type='hidden' name='cofficeName' id='cofficeName"+i+"' value="+data.gName[i]+">";
    	   htmlData += "<input type='hidden' name='cofficeCode' id='cofficeCode"+i+"' value="+data.gCode[i]+">";
    	   htmlData += "<td>납품 수량 : <input type='text' name='cofficeCount' id='cofficeCount"+i+"'></td>";
    	   htmlData += "<td>금액 : <input type='text' name='cofficePrice' id='cofficePrice"+i+"'></td>";
    	   htmlData += "</tr>";
       }
       
       $("#cofficeTable").append(htmlData);
    
    },
    error:function(error){
       console.log("error");
    }
});


function insertBtn(){
	var strid = $("#cliid").val();
	if(strid == null || strid == " "){
		alert("not null data")
	/* 	strid.force(); */
		return false;
	}
		
	var check = false;
	clinum.gCliNum.forEach (function (el, index) {
	  console.log(el);
	  if(el === strid){
		  check = true;
	  }
	});
	
	
	console.log(check);
	
	if(!check){
		
		var date = new Date($("#datepicker").val());
		var mons = date.getMonth()+2;
		var year = date.getFullYear();
		var day = date.getDate();

		var du_date = year + '-' +(("00"+mons.toString()).slice(-2))+"-"+(("00"+day.toString()).slice(-2));
		
		
		var data = {
				"cli_num"  : strid,
				"cli_name" : $("#cliname").val(),
				"cli_addr" : $("#cliaddr").val(),
				"cli_tel"  : $("#clitel").val(),
				"ct_start" : $("#datepicker").val(),
				"ct_end"   : $("#datepicker2").val(),
				"cli_area" : $("#selectarea").val(),
				"ctm_code" : ctm_code,
				"du_date"  : du_date
 		}
		console.log(data);
		
		 $.ajax({
		     type:"POST",
		     url:"./insertClient.do",
		     data : data,
		     success : function(data){
		     	console.log(data)
		     	let flag = cofficeInsert();
		     	
		     	if(flag){
		        	alert("성공"); 
		        	window.location.href = './clientList.do';
		     	}
		     },
		     error:function(error){
		        console.log("error");
		     }
		 });
	}else{
		alert("중복된 사업자입니다.");
		return false;
	}
}

function cofficeInsert(){
	
	var cofficeCountList = [];
	var cofficePriceList = [];
	var cofficeNameList = [];
	var cofficeCodeList = [];
	
	for(var i=0;i<23;i++){
	  cofficeCountList.push($("#cofficeCount"+i).val());
	  cofficePriceList.push($("#cofficePrice"+i).val());
	  cofficeNameList.push($("#cofficeName"+i).val());
	  cofficeCodeList.push($("#cofficeCode"+i).val());
	}
	
	var dataList = {
			"cofficeCountList": cofficeCountList,
			"cofficePriceList": cofficePriceList,
			"cofficeNameList": cofficeNameList,
			"cofficeCodeList": cofficeCodeList,
			"size" : 23
	}
	console.log(dataList);
	//insertGoods
	
	$.ajax({
	     type:"POST",
	     url:"./insertGoods.do",
	     data : dataList,
	     success : function(data){
	     	console.log(data)
	     	cofficeInsert();
	     	
	        alert("성공1"); 
	        return true;
	     
	     },
	     error:function(error){
	        console.log("error");
	     }
	 });
	
}





// $.ajax({
//     type:"POST",
//     url:"./selectGoodsName.do",
//     success : function(data){
//     	console.log(data)
//     	for(var i=0; i< data.gName.length;i++){
//     		var option = $("<option value="+ data.gCode[i] +">"+data.gName[i]+"</option>");
//     		$('#model').append(option);
//     	}
    	
/*        alert("성공");  */
//        window.location.href = './boardList.do';
       
//     },
//     error:function(error){
//        console.log("error");
//     }
// });


</script>
</html>