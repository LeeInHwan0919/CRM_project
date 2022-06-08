/**
 * 
 */

$(document).ready(function(){
	barGraph();
	console.log("javascript 실행");
});

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
 			timeList.push(data[i].years);//x축 data
 			posList.push(data[i].cnt);//y축 data
 		}
// 		console.log(timeList);
// 		console.log(posList);
 		//그래프
		new Chart(document.getElementById("ClientChart"),{
			type:"line",
			data:{
				labels:timeList,//x축 data
				datasets:[{
					data:posList,//y축 data
					label:"A상품",
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



