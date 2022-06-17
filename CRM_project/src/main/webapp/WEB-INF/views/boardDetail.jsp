<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./header.jsp" %>
<br>
<title>공지 글 상세보기</title>  
</head>
<body style="background-color: #FFFAFA">
<div class="container">
<table class="table table-bordered" style="text-align: center;"> 
			<h3><strong>공지 글 상세 조회</strong></h3><br>
			<tr>
				<th>번호</th>
				<td>${bVo.seq}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>관리자</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${bVo.title}</td>
			</tr>
			<tr>
				<th>등록일자</th>
				<td>${bVo.startdate}</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td><div id="fileList"></div></td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
				<textarea class="form-control" rows="10" cols="50" name="content" style="text-align: center;" readonly>${bVo.content}</textarea>
				</td>
			</tr>
	</table>
	<div><br>
			<button class="btn btn-warning" onclick="location.href='./boardList.do'" style="float: right; margin: 0 0 0 10px;" >목록</button>
			<c:if test="${fn:substring(id, 0, 3) eq 'SYS'}">	
			<button class="btn btn-danger" onclick="deletboard(${bVo.seq})"style="float: right; margin: 0 0 0 10px;">삭제</button>
			</c:if>
			<c:if test="${fn:substring(id, 0, 3) eq 'SYS'}">	
			<button class="btn btn-success" onclick="location.href='./updateBoard.do?seq=${bVo.seq}'" style="float: right; margin: 0 0 0 10px;">수정</button>
			</c:if>
	</div>
</div>
</body>
<script type="text/javascript">
function deletboard(seq){
	console.log(seq) 
	
	var data = confirm("삭제하시겠습니까?");
	
	if(!data){
		return false;
	}
	
    $.ajax({
         type:"POST",
         url:"./deleteBoard.do",
         data : {seq : seq},
         success : function(){
            alert("삭제 성공"); 
            window.location.href = './boardList.do';
            
         },
         error:function(error){
            console.log("error");
         }
    });
 }


$.ajax({
    type:"POST",
    url:"./selectFileInfo.do",
    data : {seq : ${bVo.seq}},
    success : function(data){
    	console.log(data);
    	console.log(data.data[0].file_folder);
    	var htmlMarker = "";
    	var item = "";
    	for(var i=0;i<data.data.length;i++){
    		item = data.data[i].file_name;
    		htmlMarker += '<a href="javascript:download('+ "'" + item + "'" +')">' + item +'</a>';
    	}
    	$("#fileList").append(htmlMarker);

       
    },
    error:function(error){
       console.log("error");
    }
});


function download(fileName){
	
	var filePath = "C:/test/";
	var originPath = filePath+fileName;
	
	var data =  {
		"filePath" : originPath
		, "fileName" : fileName
	}
	
	$.ajax({
	    type:"POST",
	    url:"./filedownload.do",
	    data : data,
	    cache: false,
	    xhrFields: {
	        responseType: "blob",
	    },
	    success : function(blob, status, xhr){
	    	
	    	var fileName = "";
	    	var disposition = xhr.getResponseHeader("Content-Disposition");

	    	if (disposition && disposition.indexOf("attachment") !== -1) {
	    	    var filenameRegex = /filename[^;=\n]*=((['"]).*?\2|[^;\n]*)/;
	    	    var matches = filenameRegex.exec(disposition);

	    	    if (matches != null && matches[1]) {
	    	        fileName = decodeURI(matches[1].replace(/['"]/g, ""));
	    	    }
	    	}
	    	
	    	
	    	// for IE
	    	if (window.navigator && window.navigator.msSaveOrOpenBlob) {
	    	    window.navigator.msSaveOrOpenBlob(blob, fileName);
	    	} else {
	    	    var URL = window.URL || window.webkitURL;
	    	    var downloadUrl = URL.createObjectURL(blob);

	    	    if (fileName) {
	    	        var a = document.createElement("a");

	    	        // for safari
	    	        if (a.download === undefined) {
	    	            window.location.href = downloadUrl;
	    	        } else {
	    	            a.href = downloadUrl;
	    	            a.download = fileName;
	    	            document.body.appendChild(a);
	    	            a.click();
	    	        }
	    	    } else {
	    	        window.location.href = downloadUrl;
	    	    }
	    	}
	    },
	    error:function(error){
	       console.log("error");
	    }
	});
}
</script>

<%@include file="./footer.jsp" %>
</html>