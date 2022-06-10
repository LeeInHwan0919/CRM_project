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
                    <td>내용</td>
                    <td> <textarea class="form-control" name="content" id="content" rows="5"></textarea>
                 </tr>
                 </table>
              <div style="text-align: center;">
              <input class="btn btn-default" id="updateBtn" type="button" value="수정하기">
              <input class="btn btn-default"  type="button" value="뒤로가기" onclick="javascript:history.back(-1)">
              </div>
</div>
   </body>
<script type="text/javascript">

   var title = "<%=srMap.getTitle() %>";
   var content = "<%=srMap.getContent() %>";

   console.log(title);
   console.log(content);
   
   document.getElementById("title").value = title;
   document.getElementById("content").value = content;

   
   
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
	
	   
	   //valide
       // json 형식으로 데이터 set
       var params = {
                 title     : $("#title").val()
               , content   : $("#content").val()
               , bSeq       : $("#bSeq").val()
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