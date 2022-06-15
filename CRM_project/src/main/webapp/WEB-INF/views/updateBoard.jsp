<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.two.crm.dto.BoardDto" %>
<%
BoardDto srMap = (BoardDto) request.getAttribute("bVo");
int strSeq = srMap.getSeq();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정 양식</title>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<%@include file="./header.jsp" %>
<style type="text/css">
   #container {
      width: 800px;
      height: 540px;
      margin: 40px auto;
      
   }
   
     input[type=checkbox] {
	-ms-transform: scale(S); /* IE */
	-moz-transform: scale(2); /* FF */
	-webkit-transform: scale(2); /* Safari and Chrome */
	-o-transform: scale(2); /* Opera */
	padding: 10px;
	
</style>
</head>
<body>
<div class="container">
           		 <br><h3><strong>글 수정</strong></h3> <br>
                 <table class="table table-hover">
                 <tr>
                 <td>번호</td>
                      <td><%=strSeq%></td>
                       <td><input type="hidden" id="bSeq" name="bSeq" value="<%=strSeq%>"></td>
                 </tr>
                 <tr>
                    <td>제목</td>
                    <td><input class="form-control" type="text" id="title" name="title"/></td>
                 </tr>
                  <tr>
					<td>시작 일자</td>
					<td><input type="text" name="startdate" id="datepicker"  readonly="readonly"></td>
                 </tr>
                 <tr>
					<td>만료 일자</td>
					<td><input type="text" name="enddate" id="datepicker2"  readonly="readonly"></td>
                 </tr>
                  <tr>
					<td>중요 공지 사항 </td>
					<td><input type="checkbox" id="important" name="important" value="1"></td>
                 </tr>
                 
                 <tr>
                    <td>내용</td>
                    <td><textarea class="form-control" name="content" id="content"></textarea></td>
                 </tr>
                 </table>
              <div style="text-align: center;">
              <input class="btn btn-success" id="updateBtn" type="button" style="margin: 0 0 0 10px;" value="수정하기">
              <input class="btn btn-warning"  type="button" value="뒤로가기" style="margin: 0 0 0 10px;" onclick="javascript:history.back(-1)">
              </div>
</div>
   </body>
<script type="text/javascript">
CKEDITOR.replace( 'content', {
    language: 'ko',
    uiColor: '#9AB8F3',

});

	
$( "#datepicker" ).change(function() {
	dateCheck($("#datepicker"),$("#datepicker2"));
});

$( "#datepicker2" ).change(function() {
	dateCheck($("#datepicker"),$("#datepicker2"));
});


	
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

   $( "#datepicker" ).datepicker({ minDate: 0});
   $( "#datepicker2" ).datepicker({ minDate: 0});
	
   $("#datepicker").datepicker("option", "dateFormat","yy-mm-dd");
   $("#datepicker2").datepicker("option", "dateFormat","yy-mm-dd");

   var title = "<%=srMap.getTitle() %>";
   var content = "<%=srMap.getContent() %>";
   var datepicker = "<%=srMap.getStartdate()%>";
   var datepicker2 = "<%=srMap.getEnddate()%>";
   var important = "<%=srMap.getImportant()%>";
   
   
   console.log(title);
   console.log(content);
   console.log(datepicker);
   console.log(datepicker2);
   
   document.getElementById("title").value = title;
   document.getElementById("content").value = content;
   document.getElementById("datepicker").value = datepicker;
   document.getElementById("datepicker2").value = datepicker2;
   
   let checkState = important;
   

   console.log(checkState);
   
   if(important != 0 ){
	   $("input:checkbox[id='important']").prop("checked", true);  
   }
   
   $("#updateBtn").click(function(){
		
	var data = confirm("수정하시겠습니까?");
	
	if(!data){
		return false;
	}
	
	const pattern = /\s/g;
	
	if($("#title").val().match(pattern)){
		alert("제목은 필수값 입니다. 입력해주세요");
		return false;
	}
	
	if($("#content").val().match(pattern)){
		alert("내용은 필수값 입니다. 입력해주세요");
		return false;
	}
	
 	let checkState = 0;
	if($("#important").is(":checked")){
		checkState = 1;
	}
	
	
	var regText = /<[^>]*>?/g;
	
       var params = {
                 "title"     : $("#title").val()
               , "content"   : $("#content").val().replace(regText,'')
               , "bSeq"       : $("#bSeq").val()
               , "datepicker" : $("#datepicker").val()
               , "datepicker2" : $("#datepicker2").val()
               , "important" : checkState
       }
	   
       $.ajax({
           type : "POST",          
           url : "./updateBoard.do",    
           data : params,           
           success : function(data){ 
        	   alert("수정 성공"); 
        	   window.location.href = './boardList.do';
           },
           error : function(XMLHttpRequest, textStatus, errorThrown){ 
               alert("통신 실패.")
           }
       });
   });
</script>   
   
<%@include file="./footer.jsp" %>


</html>