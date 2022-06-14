<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.two.crm.dto.ClientDto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%
List<ClientDto>  cMap  = (List<ClientDto>) request.getAttribute("cVo");
String cli_num = cMap.get(0).getCli_num().toString();
String cli_name = cMap.get(0).getCli_name().toString();
String cli_addr = cMap.get(0).getCli_addr().toString();
String cli_area = cMap.get(0).getCli_area().toString();
String cli_tel = cMap.get(0).getCli_tel().toString();
String ct_start = cMap.get(0).getCt_start().toString();
String ct_end = cMap.get(0).getCt_end().toString();
String ct_code = cMap.get(0).getCt_code().toString();

ArrayList<String> priceInfo =  new ArrayList<String>();
ArrayList<String> cntInfo =  new ArrayList<String>();
ArrayList<String> seqInfo =  new ArrayList<String>();

for(int i=0;i<cMap.size();i++){
	priceInfo.add(cMap.get(i).getG_price());
	cntInfo.add(cMap.get(i).getDu_cnt());
	seqInfo.add(cMap.get(i).getSeq());
}

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="./header.jsp" %>
</head>
<body>
<div class="container"> 
              <h3>거래처 수정</h3>
                 <table class="table table-hover">
                 <tr>
                    <td>사업자 번호</td>
                      <td><%=cli_num %></td>
                 </tr>
                 <tr>
                    <td>거래처명</td>
                      <td><input class="form-control" type="text" id="cliname" name="cliname" value="<%=cli_name %>"/></td>
                 </tr>
                 <tr>
                    <td>거래처 주소</td>
                      <td><input class="form-control" type="text" id="cliaddr" name="cliaddr" value="<%=cli_addr %>"/></td>
                 </tr>
                  <tr>
                    <td>거래처 위치</td>
                      <td>
                      <select id="selectarea">
		        	  </select>
                      </td>
                 </tr>
                  <tr>
                    <td>거래처 전화번호</td>
                      <td><input class="form-control" type="text" id="clitel" name="clitel" value="<%=cli_tel %>"/></td>
                 </tr>
                  <tr>
		        		<td>계약 시작일자</td>
		        	<td>
							<input type="text" name="startdate" id="datepicker"  readonly="readonly">
		        	</td>
		        </tr>
		         <tr>
		        		<td>계약만료 일자</td>
		        	<td>
							<input type="text" name="enddate" id="datepicker2"  readonly="readonly">
		        	</td>
		        </tr>
                 </table>
                 
                 <table class="table table-hover" id="cofficeTable">
		        <tbody>
		        </tbody>
		        </table>
              <div style="text-align: center;">
              <input class="btn btn-default" id="updateBtn" type="button" value="수정하기"  onclick="updateBtn()">
              <input class="btn btn-default"  type="button" value="뒤로가기" onclick="javascript:history.back(-1)">
              </div>
</div>
</body>
<script type="text/javascript">

var priceList = "<%= priceInfo %>";
var arr = priceList.split(",");

var cntList = "<%= cntInfo %>";
var arr2 = cntList.split(",");

var cntList = "<%= seqInfo %>";
var arr3 = cntList.split(",");



$( "#datepicker" ).datepicker({ minDate: 0});
$( "#datepicker2" ).datepicker({ minDate: 0});
	
$("#datepicker").datepicker("option", "dateFormat","yy-mm-dd");
$("#datepicker2").datepicker("option", "dateFormat","yy-mm-dd");

document.getElementById("datepicker").value = "<%=ct_start%>";
document.getElementById("datepicker2").value = "<%=ct_end%>";

var cofficeCount1 = 0;
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
    	   htmlData += "<input type='hidden' name='cofficeSeq' id='cofficeSeq"+i+"' value="+arr3[i].replaceAll("]"," ").replaceAll("["," ")+">";
    	   htmlData += "<td>납품 수량 : <input type='text' name='cofficeCount' id='cofficeCount"+i+"' value="+ arr2[i].replaceAll("]"," ").replaceAll("["," ") +"></td>";
    	   htmlData += "<td>금액 : <input type='text' name='cofficePrice' id='cofficePrice"+i+"' value="+ arr[i].replaceAll("]"," ").replaceAll("["," ") +"></td>";
    	   htmlData += "</tr>";
       }
       
       $("#cofficeTable").append(htmlData);
    
    },
    error:function(error){
       console.log("error");
    }
});

$.ajax({
	type:"POST",
	url:"./selectLocation.do",
	success : function(data) {
		let htmlData  = "";
		let selectUserArea = "<%=cli_area%>";
				
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

function updateBtn() {
	
	var strid = "<%=cli_num %>";
		
		
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
			"ct_code" : "<%=ct_code%>",
			"du_date"  : du_date
		}
	console.log(data);
	
	 $.ajax({
	     type:"POST",
	     url:"./updateClient.do",
	     data : data,
	     success : function(data){
	     	console.log(data)
			cofficeUpdate();
	     	alert("등록이 완료되었습니다."); 
	        window.location.href = './clientList.do';
	     },
	     error:function(error){
	        console.log("error");
	     }
	 });
}

function cofficeUpdate(){
	var dataObj = {};
	var dataArr = [];
	
	for(var i=0;i<cofficeCount1;i++){
		dataObj.count = $("#cofficeCount"+i).val();
		dataObj.price = $("#cofficePrice"+i).val();
		dataObj.seq = $("#cofficeSeq"+i).val();
		dataArr.push(dataObj);
		dataObj = {};
	}
	
	var jsonData = JSON.stringify(dataArr);
	
	$.ajax({
	     type:"POST",
	     url:"./updateGoods.do",
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