<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>백업 페이지 입니다. </title>
</head>
<body style="background-color: #FFFAFA">
<select id="selectarea">
</select>
<!--  <input type="button" value="백업하기" onclick="BackUp();"> -->
<!--  <input type="button" value="게시판 백업" onclick="BackUpBoard();"><br> -->
<!--  <input type="button" value="게시판 파일 백업" onclick="BackUpFile();"><br> -->
<!--  <input type="button" value="사원 정보 백업" onclick="BackUpUsers();"><br> -->
<!--  <input type="button" value="지역 정보 백업" onclick="BackUpLocation();"><br> --
>
<!--  <input type="button" value="재고 관리 백업" onclick="BackUpiMGR();"><br> -->
<!--  <input type="button" value="재고 상품 백업" onclick="BackUpGoods();"><br> -->
<!--  <input type="button" value="계약 상품 백업" onclick="BackUpContractGoods();"><br> -->
<!--  <input type="button" value="상품 할인 백업" onclick="BackUpGoodsDiscount();"><br> -->
<!--  <input type="button" value="거래처 백업" onclick="BackUpClient();"><br> -->
<!--  <input type="button" value="계약 관리 백업" onclick="BackUpcMGR();"><br> -->
<!--  <input type="button" value="계약 백업" onclick="BackUpContract();"><br> -->
<!--  <input type="button" value="거래처 할인 백업" onclick="BackUpGoodsClient();"><br> -->
</body>

<script type="text/javascript">

var titleList = "게시판백업"
				, "파일백업"
				, ".do"
				, "";
				, "";
				, "";
				, "";
				, "";
				, "";
				, "";
				, "";
var apiList = ["BackUpBoard.do","BackUpFile.do","BackUpUsers.do"]

//처음에 옵션 리스트 만들고 
//그 만든 select가 이벤트 호출 선택값이 바뀔때 변수값을 계속 변경)

//변수값이 url로 들어감

$.ajax({
	type:"POST",
	url:"./BackUpBoard.do",
	success : function(data) {
		let htmlData  = "";
<%-- 		let selectUserArea = "<%=cli_area%>"; --%>
				
		for(i=0;i<data.AreaName.length;i++){
			htmlData += "<option value='"+data.AreaName[i].AREA+"'>"+data.AreaName[i].AREA+"</option>";
			console.log(data.AreaName[i].AREA);
		}
		 $("#selectarea").append(htmlData);
		 $("#selectarea").val(selectUserArea).prop("selected", true);
	},
	 error:function(error){
      console.log("error");
	 }
});



function BackUpBoard() {
today = new Date();   
   year = today.getFullYear(); // 년도
   month = today.getMonth() + 1;  // 월
   date = today.getDate();  // 날짜
   hours = today.getHours(); //시간
   minutes = today.getMinutes();//분
   
   var str = year + '_' + month + '_' + date + '_' + hours + '_' + minutes;
   console.log(str);
   
$.ajax({
  type:"POST",
  url:"BackUpBoard.do",
  data :{
  	  fileName : str
  },
  success : function(){
     alert("BackUpBoard.do 성공"); 
  },
  error:function(error){
     console.log("error");
  }
});
}




function BackUpFile() {
	 today = new Date();   
     year = today.getFullYear(); // 년도
     month = today.getMonth() + 1;  // 월
     date = today.getDate();  // 날짜
     hours = today.getHours(); //시간
     minutes = today.getMinutes();//분
     
     var str = year + '_' + month + '_' + date + '_' + hours + '_' + minutes;
     console.log(str);
     
$.ajax({
    type:"POST",
    url:"BackUpFile.do",
    data :{
    	  fileName : str
    },
    success : function(){
       alert("BackUpFile.do 성공"); 
    },
    error:function(error){
       console.log("error");
    }
});
}


function BackUpUsers() {
	 today = new Date();   
    year = today.getFullYear(); // 년도
    month = today.getMonth() + 1;  // 월
    date = today.getDate();  // 날짜
    hours = today.getHours(); //시간
    minutes = today.getMinutes();//분
    
    var str = year + '_' + month + '_' + date + '_' + hours + '_' + minutes;
    console.log(str);
    
$.ajax({
   type:"POST",
   url:"BackUpUsers.do",
   data :{
   	  fileName : str
   },
   success : function(){
      alert("BackUpUsers.do 성공"); 
   },
   error:function(error){
      console.log("error");
   }
});
}

function BackUpLocation() {
	 today = new Date();   
   year = today.getFullYear(); // 년도
   month = today.getMonth() + 1;  // 월
   date = today.getDate();  // 날짜
   hours = today.getHours(); //시간
   minutes = today.getMinutes();//분
   
   var str = year + '_' + month + '_' + date + '_' + hours + '_' + minutes;
   console.log(str);
   
$.ajax({
  type:"POST",
  url:"BackUpLocation.do",
  data :{
  	  fileName : str
  },
  success : function(){
     alert("BackUpLocation.do 성공"); 
  },
  error:function(error){
     console.log("error");
  }
});
}


function BackUpiMGR() {
	 today = new Date();   
  year = today.getFullYear(); // 년도
  month = today.getMonth() + 1;  // 월
  date = today.getDate();  // 날짜
  hours = today.getHours(); //시간
  minutes = today.getMinutes();//분
  
  var str = year + '_' + month + '_' + date + '_' + hours + '_' + minutes;
  console.log(str);
  
$.ajax({
 type:"POST",
 url:"BackUpiMGR.do",
 data :{
 	  fileName : str
 },
 success : function(){
    alert("BackUpiMGR.do 성공"); 
 },
 error:function(error){
    console.log("error");
 }
});
}


function BackUpGoods() {
	 today = new Date();   
 year = today.getFullYear(); // 년도
 month = today.getMonth() + 1;  // 월
 date = today.getDate();  // 날짜
 hours = today.getHours(); //시간
 minutes = today.getMinutes();//분
 
 var str = year + '_' + month + '_' + date + '_' + hours + '_' + minutes;
 console.log(str);
 
$.ajax({
type:"POST",
url:"BackUpGoods.do",
data :{
	  fileName : str
},
success : function(){
   alert("BackUpGoods.do 성공"); 
},
error:function(error){
   console.log("error");
}
});
}


function BackUpContractGoods() {
	 today = new Date();   
year = today.getFullYear(); // 년도
month = today.getMonth() + 1;  // 월
date = today.getDate();  // 날짜
hours = today.getHours(); //시간
minutes = today.getMinutes();//분

var str = year + '_' + month + '_' + date + '_' + hours + '_' + minutes;
console.log(str);

$.ajax({
type:"POST",
url:"BackUpContractGoods.do",
data :{
	  fileName : str
},
success : function(){
  alert("BackUpContractGoods.do 성공"); 
},
error:function(error){
  console.log("error");
}
});
}

function BackUpGoodsDiscount() {
	 today = new Date();   
year = today.getFullYear(); // 년도
month = today.getMonth() + 1;  // 월
date = today.getDate();  // 날짜
hours = today.getHours(); //시간
minutes = today.getMinutes();//분

var str = year + '_' + month + '_' + date + '_' + hours + '_' + minutes;
console.log(str);

$.ajax({
type:"POST",
url:"BackUpGoodsDiscount.do",
data :{
	  fileName : str
},
success : function(){
 alert("BackUpGoodsDiscount.do 성공"); 
},
error:function(error){
 console.log("error");
}
});
}

function BackUpClient() {
	 today = new Date();   
year = today.getFullYear(); // 년도
month = today.getMonth() + 1;  // 월
date = today.getDate();  // 날짜
hours = today.getHours(); //시간
minutes = today.getMinutes();//분

var str = year + '_' + month + '_' + date + '_' + hours + '_' + minutes;
console.log(str);

$.ajax({
type:"POST",
url:"BackUpClient.do",
data :{
	  fileName : str
},
success : function(){
alert("BackUpClient.do 성공"); 
},
error:function(error){
console.log("error");
}
});
}


function BackUpcMGR() {
	 today = new Date();   
year = today.getFullYear(); // 년도
month = today.getMonth() + 1;  // 월
date = today.getDate();  // 날짜
hours = today.getHours(); //시간
minutes = today.getMinutes();//분

var str = year + '_' + month + '_' + date + '_' + hours + '_' + minutes;
console.log(str);

$.ajax({
type:"POST",
url:"BackUpcMGR.do",
data :{
	  fileName : str
},
success : function(){
alert("BackUpcMGR.do 성공"); 
},
error:function(error){
console.log("error");
}
});
}

function BackUpContract() {
	 today = new Date();   
year = today.getFullYear(); // 년도
month = today.getMonth() + 1;  // 월
date = today.getDate();  // 날짜
hours = today.getHours(); //시간
minutes = today.getMinutes();//분

var str = year + '_' + month + '_' + date + '_' + hours + '_' + minutes;
console.log(str);

$.ajax({
type:"POST",
url:"BackUpContract.do",
data :{
	  fileName : str
},
success : function(){
alert("BackUpContract.do 성공"); 
},
error:function(error){
console.log("error");
}
});
}


function BackUpGoodsClient() {
	 today = new Date();   
year = today.getFullYear(); // 년도
month = today.getMonth() + 1;  // 월
date = today.getDate();  // 날짜
hours = today.getHours(); //시간
minutes = today.getMinutes();//분

var str = year + '_' + month + '_' + date + '_' + hours + '_' + minutes;
console.log(str);

$.ajax({
type:"POST",
url:"BackUpGoodsClient.do",
data :{
	  fileName : str
},
success : function(){
alert("BackUpGoodsClient.do 성공"); 
},
error:function(error){
console.log("error");
}
});
}


</script>
</html>