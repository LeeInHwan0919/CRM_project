<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@include file="./header.jsp" %>
<body style="background-color: #FFFAFA">

<div class="container"><br><br>
		        <h3><strong>계약 등록</strong></h3><br>
		        <table class="table table-hover">
		        <tr>
		        		<td>사업자 번호</td>
		        	<td>
		       			<input name="cliid" id="cliid" placeholder="999-99-99999" maxlength="12">
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
		        		<input type="text" name="cliaddr" id="cliaddr" >
		        	</td>
		        </tr>
		        <tr>
		        		<td>거래처 위치</td>
		        	<td>
		        	 <select id="selectarea">
			        		<option value="서울">서울</option>
			        		<option value="대구">대구</option>
			        		<option value="울산">울산</option>
			        		<option value="부산">부산</option>
			        		<option value="춘천">춘천</option>
			        		<option value="천안">천안</option>
			        		<option value="대전">대전</option>
			        		<option value="광주">광주</option>
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
							<input type="text" name="startdate" id="datepicker" readonly="readonly">
		        	</td>
		        </tr>
		         <tr>
		        		<td>계약만료 일자</td>
		        	<td>
							<input type="text" name="enddate" id="datepicker2" readonly="readonly">
		        	</td>
		        </tr>
		        </table>
		        <table class="table table-hover" id="cofficeTable">
		        <tbody>
		        </tbody>
		        </table><br><br>
		        	<div style="text-align: center;">
				        <input class="btn btn-success" style="margin: 0 0 0 10px;"  type="button" value="거래처 등록" onclick="insertBtn()">
				        <input class="btn btn-info" style="margin: 0 0 0 10px;"  type="button" value="뒤로가기" onclick="javascript:history.back(-1)">
		       		</div>
		    </div>
	<br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br>
</body>
<script type="text/javascript">

// 사업자 번호 정규식 
$('#cliid').on('keyup', function(){
    var num = $('#cliid').val();
    num.trim(); 
    this.value = AutoHypen(num) ;
});

function AutoHypen(companyNum){
    companyNum = companyNum.replace(/[^0-9]/g, '');
    var tempNum = '';   

    if(companyNum.length < 4){
      return companyNum;
    }
    else if(companyNum.length < 6){
      tempNum += companyNum.substr(0,3);
      tempNum += '-';
      tempNum += companyNum.substr(3,2);
      return tempNum;
    }
    else if(companyNum.length < 11){
      tempNum += companyNum.substr(0,3);
      tempNum += '-';
      tempNum += companyNum.substr(3,2);
      tempNum += '-';
      tempNum += companyNum.substr(5);
      return tempNum;
    }
    else{        
      tempNum += companyNum.substr(0,3);
      tempNum += '-';
      tempNum += companyNum.substr(3,2);
      tempNum += '-';
      tempNum += companyNum.substr(5);
      return tempNum;
    }
  }





//datepicker api 사용 
$( "#datepicker" ).datepicker({ minDate: 0});
$( "#datepicker2" ).datepicker({ minDate: 0});
	
$("#datepicker").datepicker("option", "dateFormat","yy-mm-dd");
$("#datepicker2").datepicker("option", "dateFormat","yy-mm-dd");


$( "#datepicker" ).change(function() {
	dateCheck($("#datepicker"),$("#datepicker2"));
});

$( "#datepicker2" ).change(function() {
	dateCheck($("#datepicker"),$("#datepicker2"));
});


//시작일자 마지막 일자 비교 ( 이전날짜 선택 못하게)
function dateCheck (first, last) {
	let firstDates = new Date(first.val()); //시작 
	let SecondDates = new Date(last.val()); //마지막 
	if (firstDates >= SecondDates) {
		alert("게시 시작일짜 보다 빠른 날짜를 선택하 실 수는 없습니다. ");
		first.val('');
		last.val(''); 
		return false;
	}
}


//거래처 사업자번호 조회
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


//계약 관리 코드 조회
var clinum = [];
var ctm_code = 0;
var cofficeCount1 = 0;

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

//원두 상품 정보 
$.ajax({
    type:"POST",
    url:"./selectGoodsName.do",
    success : function(data){
       console.log(data);
       let htmlData  = "";
       for(i=0;i<data.gCode.length;i++){
    	   cofficeCount1++;
    	   htmlData += "<tr>";
    	   htmlData += "<td>"+ data.gName[i] +"</td>";
    	   htmlData += "<input type='hidden' name='cofficeName' id='cofficeName"+i+"' value="+data.gName[i]+">";
    	   htmlData += "<input type='hidden' name='cofficeCode' id='cofficeCode"+i+"' value="+data.gCode[i]+">";
    	   htmlData += "<td>납품 수량 : <input type='number' min='0' max='1000' name='cofficeCount' id='cofficeCount"+i+"'></td>";
    	   htmlData += "<td>금액 : <input type='number' min='0S' max='10000000' name='cofficePrice' id='cofficePrice"+i+"'></td>";
    	   htmlData += "</tr>";
       }
       
       $("#cofficeTable").append(htmlData);
    
    },
    error:function(error){
       console.log("error");
    }
});



//거래처 등록 
function insertBtn(){
	
	var data = confirm("새로운 거래처를 등록 하시겠습니까?");
	
	
	var strid = $("#cliid").val();
	if(strid == null || strid == " "){
		alert("not null data")
		return false;
	}
		
	var check = false;
	clinum.gCliNum.forEach (function (el, index) {
	  console.log(el);
	  if(el === strid){
		  check = true;
	  }
	});
	
	
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
				cofficeInsert();
		     	alert("등록이 완료되었습니다."); 
		        window.location.href = './clientList.do';
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


//거래처 등록 시 원두 입력 
function cofficeInsert(){
	
	var dataObj = {};
	var dataArr = [];
	
	for(var i=0;i<cofficeCount1;i++){
		dataObj.count = $("#cofficeCount"+i).val();
		dataObj.price = $("#cofficePrice"+i).val();
		dataObj.name = $("#cofficeName"+i).val();
		dataObj.code = $("#cofficeCode"+i).val();
		dataArr.push(dataObj);
		dataObj = {};
	}
	
	var jsonData = JSON.stringify(dataArr);
	
	$.ajax({
	     type:"POST",
	     url:"./insertGoods.do",
	     data : {"codeArrObj" : jsonData},
	     dataType : 'json',
	     success : function(data){
	        console.log(data);
	     },
	     error:function(error){
	        console.log("error");
	     }
	 });
}
</script>
</html>