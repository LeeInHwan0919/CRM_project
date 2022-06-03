<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="UTF-8">
<title>새 게시글 입력 폼</title>
</head>
<%@include file="./header.jsp" %>
<body>
<!-- style='text-align: center;' -->
		<div class="container" >
			  <form id="editorFrm" onsubmit="return editorAction()" method="post">
<%-- 				사원번호 :<div>${mem.Emp_code}</div><br> --%>
				제목: <input type="text" id="title" name="title" class="form-control"><br>
					기간설정:<input type="text" name="start" id="datepicker" readonly="readonly"><br>
<!-- 				기간설정: <input type="text" id="" name="" class="form-control"><br> -->
<!-- 				첨부파일: <input type="text" id="" name="" class="form-control"><br> -->
				내용: <textarea name="content" id="content"></textarea><br><br>
				<input type="submit" class="btn btn-default" value="저장">
<!-- 				<input type="reset" class="btn btn-default" value="초기화" onclick="resetCon()"> -->
<!-- 			 	<input class="btn btn-default" type="reset" value="다시작성"> -->
			  </form>
				<button  class="btn btn-default" onclick="javascript:history.back(-1)" >뒤로가기</button>
		</div>
	</body>
	
	
<script type="text/javascript">
<!-- <script> -->
CKEDITOR.replace( 'content', {
    language: 'ko',
    uiColor: '#9AB8F3',

});
function insert(){
	var data = document.getElementById("inputContent").value;
	console.log(data);
	// <textarea>에 넣어줄 값을 data 부분에 넣어주면 됨 
	CKEDITOR.instances.content.setData(data); 
}


function editorAction() {
	
	var title = document.getElementById("title");
	var content = document.getElementById("content");
	if(title.value == "" ) {
		swal("필수 사항","제목을 입력하여 주세요");
	} else if(content.value == ""){
		swal("필수 사항","내용을 입력하여 주세요");
	} else {
		var str = content.value;
		console.log(content.value);
		isShow = false;
		swal("등록 완료","해당 공지사항을 등록 완료하였습니다.");
		form.submit();
	}
	return false;
}

$( function() {
	$("#datepicker").datepicker();
    $("#datepicker").datepicker("option", "dateFormat","yy-mm-dd");
});
</script>


</script>
<!-- </script>   -->
<%@include file="./footer.jsp" %>
</html>