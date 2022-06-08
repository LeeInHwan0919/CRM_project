<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib  uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공!</title>
  <style type="text/css">
    #body{
      float:left;
      width: 750px;
      height: 550px;
      margin-left: 150px; 
      margin-top: 60px; 
      background-color: #CCCCCC;
      border-radius:15px;
    }
    
    #body2{
      float:left;
      width: 750px;
      height: 550px;
      margin-left: 150px; 
      margin-top: 60px; 
      background-color: #CCCCCC;
      border-radius:15px;
    }
    
    td,th{
      text-align: center;
    }
  </style>
</head>
<!-- <script type="text/javascript" src="./js/main.js"></script> -->
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script> <!-- 필수 CDN -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<%@include file="./header.jsp" %>
<body style="margin-left: 60px;">

<div id="body">
<h2 style="text-align: center;">기간별 거래처 계약 건수</h2>
<hr style="border-color: gray; border-width: 5px;">
<select id="select" style="float: left; margin-top: 20px; margin-left: 20px;">
	<option value="1">1년</option>
	<option value="3">3년</option>
	<option value="5">5년</option>
</select>
<canvas id="ClientChart"></canvas>
</div>

<div class="container" id="body">
  <h2 style="text-align: center">공지 게시판</h2>
<hr style="border-color: gray; border-width: 5px;">
  <table class="table">
    <thead>
      <tr>
        <th style="text-align: center;">글 번호</th>
        <th style="text-align: center;">제목</th>
        <th style="text-align: center;">등록일</th>
        <th style="text-align: center;">작성자</th>
        <th style="text-align: center;">조회수</th>
        <th style="font-size: 20px;"><a href="./boardList.do">+</a></th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="ls" items="${lists}" begin="1" end="10" step="1">
      <tr>
        <td>${ls.seq}</td>
        <td>${ls.title}</td>
        <td >${ls.startdate}</td>
        <td>관리자</td>
        <td>${ls.s_count}</td>
        <td></td>
	  </tr>
	  </c:forEach>
    </tbody>
  </table>
</div>

<div class="container" id="body2">
  <h2 style="text-align: center">chart</h2>
<hr style="border-color: gray; border-width: 5px;">
<select id="select" style="float: left; margin-top: 20px; margin-left: 20px;">
	<option value="1">1년</option>
	<option value="3">3년</option>
	<option value="5">5년</option>
</select>
<canvas id="GoodsChart"></canvas>
</div>

<div class="container" id="body2">
  <h2 style="text-align: center">chart</h2>
<hr style="border-color: gray; border-width: 5px;">
<select id="select" style="float: left; margin-top: 20px; margin-left: 20px;">
	<option value="1">1년</option>
	<option value="3">3년</option>
	<option value="5">5년</option>
</select>
<canvas id="LocaleChart"></canvas>
</div>

<script type="text/javascript">
$(document).ready(function(){
	barGraph();
	console.log("javascript 실행");
});

function handleOnChange(e) {
	const year = e.
}

function barGraph(){
	var timeList =[];
	var posList =[];
	
 	$.ajax({
 		url:"./ClientChart.do",
 		type:"post",
 		dataType:"json",
 		success:function(data){
 			console.log("ClientChart.do 실행");
 			console.log(data[0]);
 		//그래프로 나타낼 데이터 리스트에 담기
 		for(let i=0; i<data.length;i++){
//  			timeList.push(data[i].years);//x축 data
 			posList.push(data[i]);//y축 data
 		}
// 		console.log(timeList);
// 		console.log(posList);
 		//그래프
		new Chart(document.getElementById("ClientChart"),{
			type:"line",
			data:{
				labels:["2016","2017","2018","2019","2020","2021","2022",],//x축 data
				datasets:[{
					data:posList,//y축 data
					label:"계약 건수",
					borderColor:"#3e95cd",
					fill:false
// 				    - false  : 아무것도 채워지지 않음
// 				    - origin : 기준점 사이로 채워짐 
// 				    - start : x축 선부터 채워짐
// 				    - end : x축의 최대값의 기준으로 채워짐
				}
			  ]
			},
			options:{
				title:{ 
					display:true,
					text:"상품판매량"
				},
				scales: {
		            y: {
		                beginAtZero: true //y축 시작점이 0으로 시작하는지
		            }
				}
			}
		});//그래프
 		},
 		error:function(err){
 			alert("실패 에러메세지 : "+err);
 		}
 	})//ajax 
	
}//ClientGraph
</script>

</body>
</html>