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
<link rel="stylesheet" type="text/css" href="./css/header.css">
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
              <form id="updateform" action="./updateBoard.do" method="post">
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
              <input class="btn btn-default"  type="submit" value="수정하기">
              <input class="btn btn-default"  type="button" value="뒤로가기" onclick="javascript:history.back(-1)">
              </div>
              </form>
          </div>
   </body>
<script type="text/javascript">
var title = "<%=srMap.getTitle() %>";
var content = "<%=srMap.getContent() %>";

document.getElementById("title").value = title;
document.getElementById("content").value = content;


function updateboard() {
	var con = confirm("해당 공지사항을 수정하시겠습니까?");
	 if(con) {
	      var form = document.forms[0];
	      console.log(form);
	      swal("성공","해당 공지사항을 수정하였습니다.");
	      form.method = 'post';
	      form.onclick = './updateBoard.do';
	      form.submit();
	   }else {
		      swal("취소","수정을 취소하였습니다.");
	   }
	}
}


</script>   
   
<%@include file="./footer.jsp" %>


</html>