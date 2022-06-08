<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib  uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공!</title>
</head>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script> <!-- 필수 CDN -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<%@include file="./header.jsp" %>
<body style="margin-left: 60px;">

<div style="width: 750px; height: 500px; margin-left: 60px; margin-top: 60px; background-color: #CCCCCC; border-radius:15px;">
<h2 style="text-align: center;">기간별 거래처 계약 건수</h2>
<select id="select" style="float: left; margin-top: 20px; margin-left: 20px;">
	<option value="1">1년</option>
	<option value="3">3년</option>
	<option value="5">5년</option>
</select>
<canvas id="myChart"></canvas>
</div>

<div style="width: 750px; height: 500px; margin-left: 60px; margin-top: 60px; background-color: #CCCCCC; border-radius:15px;">
<h2 style="text-align: center;">공지 게시판</h2>
<table>
  <thead>
    <tr>
      <th>제목</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>제목입니다.</td>
    </tr>
  </tbody>
</table>
</div>

<script type="text/javascript">
const ctx = document.getElementById('myChart').getContext('2d');//getContext 속성을 통해 2d로 세팅
const myChart = new Chart(ctx, {
    type: 'bar',// 차트의 형태(line, pie ...)
    data: {// 차트에 들어갈 데이터
        labels: ['판매사A', '판매사B', '판매사C', '판매사D', '판매사E', '판매사F'],//x 축 label
        datasets: [{
            label: '판매량',//차트 제목 클릭시 데이터 언바운드
            data: [9, 17, 1, 3, 2, 3], //x축 label에 대응되는 데이터 값
            backgroundColor: [  //색상
                'rgba(255, 99, 132, 0.2)',
                'rgba(255, 99, 132, 0.2)',
                'rgba(255, 99, 132, 0.2)',
                'rgba(255, 99, 132, 0.2)',
                'rgba(255, 99, 132, 0.2)',
                'rgba(255, 99, 132, 0.2)'
            ],
            borderColor: [ //경계선(테두리) 색상
                'rgba(255, 99, 132, 1)',
                'rgba(255, 99, 132, 1)',
                'rgba(255, 99, 132, 1)',
                'rgba(255, 99, 132, 1)',
                'rgba(255, 99, 132, 1)',
                'rgba(255, 99, 132, 1)'
            ],
            borderWidth: 1//경계선(테두리) 굵기
        },
        {
            label: '납품량',//차트 제목 클릭시 데이터 언바운드
            data: [15, 22, 5, 7, 5, 4], //x축 label에 대응되는 데이터 값
            backgroundColor: [  //차트 색상
                'rgba(54, 162, 235, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(54, 162, 235, 0.2)'
            ],
            borderColor: [ //경계선(테두리) 색상
                'rgba(54, 162, 235, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(54, 162, 235, 1)'
            ],
            borderWidth: 1//경계선(테두리) 굵기
        }
        ]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true //y축 시작점이 0으로 시작하는지
            }
        }
    }
});
</script>
</body>
</html>