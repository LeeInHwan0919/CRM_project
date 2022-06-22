<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib  uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
  <style type="text/css">
    #body{
      float:left;
      width: 750px;
      height: 550px;
      margin-left: 50px; 
      margin-top: 100px; 
      background-color: #FFFAFA;
      border-color: #a19b9b;
      border-width: unset;
      border-style: double;
      border-radius: 15px;
    }
    
    #body2{
      float:left;
      width: 750px;
      height: 550px;
      margin-left: 50px; 
      margin-top: 100px;  
      background-color: #FFFAFA;
      border-color: #a19b9b;
      border-width: unset;
      border-style: double;
      border-radius: 15px;
    }
    
    td,th{
      text-align: center;
    }
    
    #allbody{
      margin-left: 140px;
    }
  </style>
</head>
<!-- <script type="text/javascript" src="./js/main.js"></script> -->
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script> <!-- 필수 CDN -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<%@include file="./header.jsp" %>
<body style="margin-left: 60px; background-color: #FFFAFA">	
<div id="allbody">
<div id="body">
<h2 style="text-align: center;">연도별 거래처 계약 건수</h2>
<hr style="border-color: gray; border-width: 5px;">
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
  <h2 style="text-align: center">상품 납품량 통계</h2>
<hr style="border-color: gray; border-width: 5px;">
<canvas id="GoodsChart" style="height:400px; width:750px;"></canvas>
</div>

<div class="container" id="body2">
  <h2 style="text-align: center">지역별 계약 현황</h2><p>현재 날짜 기준</p>
<hr style="border-color: gray; border-width: 5px;">
<canvas id="LocationChart"></canvas>
</div>
</div>
<script type="text/javascript">
$(document).ready(function(){
	lineGraph();
	console.log("javascript 실행");
	pieGraph();
	barGraph();
});


function lineGraph(){
	var cList =[];
	
 	$.ajax({
 		url:"./ClientChart.do",
 		type:"post",
 		dataType:"json",
 		success:function(data){
 			console.log("ClientChart.do 실행");
 			console.log(data[0]);
 		//그래프로 나타낼 데이터 리스트에 담기
 		for(let i=0; i<data.length;i++){
 			cList.push(data[i]);//y축 data
 		}
 		//그래프
		new Chart(document.getElementById("ClientChart"),{
			type:"line",
			data:{
				labels:["2016","2017","2018","2019","2020","2021","2022"],//x축 data
				datasets:[{
					data:cList,//y축 data
					label:"계약 건수",
					borderColor:"#3e95cd",
					fill:false
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



function pieGraph(){
	var gList =[];
	
	$.ajax({
 		url:"./GoodsChart.do",
 		type:"post",
 		dataType:"json",
 		success:function(data){
 			console.log("ClientChart.do 실행");
 			console.log(data[0]);
 		//그래프로 나타낼 데이터 리스트에 담기
 		for(let i=0; i<data.length;i++){
 			gList.push(data[i]);//y축 data
 		}
	//파이 차트 (상품별 납품량)
	new Chart(document.getElementById("GoodsChart"),{
		type:"pie",
		data:{
			labels:["르완다버몬","예가체프하라","멕시코알투라","예가체프하라","인도네시아토라자","예맨모카"],//x축 data
			datasets:[{	
				data:gList,//y축 data
				backgroundColor: ['rgb(255, 99, 132)', 'rgb(255, 159, 64)', 'rgb(255, 205, 86)', 'rgb(75, 192, 192)', 'rgb(54, 162, 235)', 'rgb(153, 102, 255)']
			}
		  ]
		},
		options:{
			title:{ 
				display:true,
				text:"상품판매량"
			},
			plugins: {
	            legend: {
	                position: 'left'
	            }
	          },
			responsive:false
		}
	});//그래프
 		},
 		error:function(err){
 			alert("실패 에러메세지 : "+err);
 		}
 	})//ajax
 	
 	
}//goodsGraph


function barGraph(){
	var lList =[];
	
 	$.ajax({
 		url:"./LocationChart.do",
 		type:"post",
 		dataType:"json",
 		success:function(data){
 			console.log("LocationChart.do 실행");
 			console.log(data[0]);
 		//그래프로 나타낼 데이터 리스트에 담기
 		for(let i=0; i<data.length;i++){
 			lList.push(data[i]);//y축 data
 		}
 		//그래프
		new Chart(document.getElementById("LocationChart"),{
			type:"bar",
			data:{
				labels:["서울","부산","대구","춘천"],//x축 data
				datasets:[{
					data:lList,//y축 data
					label:"계약 건수",
					backgroundColor:"#556B2F"
				}
			  ]
			},
			options:{
				 indexAxis: 'y',
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
	
}//LocationChart
</script>

</body>
</html>