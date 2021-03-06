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
</style>
</head>
<body>
<div class="container"> 
              <h3>글 수정</h3>
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
<<<<<<< HEAD
					<td>중요 공지 사항 :</td>
					<td><input type="checkbox" id="important" name="important" value="1"></td>
=======
               <td>중요 공지 사항 :</td>
               <td><input type="checkbox" id="important" name="important" value="1"></td>
>>>>>>> 74ac50bc660a36429b827e3f8f3da5e5a187ff27
                 </tr>
                 
                 <tr>
                    <td>내용</td>
                    <td><textarea class="form-control" name="content" id="content"></textarea></td>
                 </tr>
                 </table>
              <div style="text-align: center;">
              <input class="btn btn-success" id="updateBtn" type="button" value="수정하기">
              <input class="btn btn-info"  type="button" value="뒤로가기" onclick="javascript:history.back(-1)">
              </div>
</div>
   </body>
<script type="text/javascript">
CKEDITOR.replace( 'content', {
    language: 'ko',
    uiColor: '#9AB8F3'
});

<<<<<<< HEAD
CKEDITOR.editorConfig = function( config ) {
	config.enterMode = CKEDITOR.ENTER_BR;
	config.shiftEnterMode = CKEDITOR.ENTER_P;
};

function insert(){
	var data = document.getElementById("inputContent").value;
	console.log(data);
	CKEDITOR.instances.content.setData(data); 
}
=======
// CKEDITOR.editorConfig = function( config ) {
//    config.enterMode = CKEDITOR.ENTER_BR;
//    config.shiftEnterMode = CKEDITOR.ENTER_P;
// };

// function insert(){
//    var data = document.getElementById("inputContent").value;
//    console.log(data);
//    CKEDITOR.instances.content.setData(data); 
// }
>>>>>>> 74ac50bc660a36429b827e3f8f3da5e5a187ff27


$( "#datepicker" ).change(function() {
   dateCheck($("#datepicker"),$("#datepicker2"));
});

$( "#datepicker2" ).change(function() {
   dateCheck($("#datepicker"),$("#datepicker2"));
});
<<<<<<< HEAD
	
	
function dateCheck (first, last) {
	let firstDates = new Date(first.val()); //시작 
	let SecondDates = new Date(last.val()); //지막 
	if (firstDates >= SecondDates) {
		alert("일정 종료일이 시작일보다 이전 날짜입니다.");
		first.val('');
		last.val(''); 
		return false;
	}
}


	
=======
   
   
function dateCheck (first, last) {
   let firstDates = new Date(first.val()); //시작 
   let SecondDates = new Date(last.val()); //지막 
   if (firstDates >= SecondDates) {
      alert("일정 종료일이 시작일보다 이전 날짜입니다.");
      first.val('');
      last.val(''); 
      return false;
   }
}


   
>>>>>>> 74ac50bc660a36429b827e3f8f3da5e5a187ff27
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
//    document.getElementById("content").value = content;
   CKEDITOR.instances.content.setData(content); 
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
   
  console.log('title val: '+$("#title").val());
  console.log('title match: '+$("#title").val().match(pattern));
   if($("#title").val().match(pattern)){
      alert("제목은 필수값 입니다. 입력해주세요");
      return false;
   }
   
   var data = CKEDITOR.instances.content.getData();
   console.log('content val:'+data);
   console.log('contentmatch: '+$("#content").val().match(pattern));
   if(data.match(pattern)){
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
               , "content"   : data.replace(regText,'')
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