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
<!--               <form action="./updateBoard.do" id="updateform" onsubmit="false; updateform()" method="post"> -->
                 <table class="table table-hover">
                 <tr>
                 <td>번호</td>
                      <td><%=strSeq%></td>
                        <input type="hidden" id="bSeq" name="bSeq" value="<%=strSeq%>">
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
<!--               </form> -->
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
	   
	   //valide
       // json 형식으로 데이터 set
       var params = {
                 title     : $("#title").val()
               , content   : $("#content").val()
               , bSeq       : $("#bSeq").val()
       }
       // ajax 통신
       $.ajax({
           type : "POST",            // HTTP method type(GET, POST) 형식이다.
           url : "./updateBoard.do",      // 컨트롤러에서 대기중인 URL 주소이다.
           data : params,            // Json 형식의 데이터이다.
           success : function(data){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
        	   window.location.href = './boardList.do';
           },
           error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
               alert("통신 실패.")
           }
       });
   });
</script>   
   
<%@include file="./footer.jsp" %>


</html>