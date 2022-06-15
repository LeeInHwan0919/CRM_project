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
<style>
    .dragAndDropDiv {
        border: 2px dashed #92AAB0;
        width: 650px;
        height: 200px;
        color: #92AAB0;
        text-align: center;
        vertical-align: middle;
        padding: 10px 0px 10px 10px;
        font-size:200%;
        display: table-cell;
    }
    .progressBar {
        width: 200px;
        height: 22px;
        border: 1px solid #ddd;
        border-radius: 5px; 
        overflow: hidden;
        display:inline-block;
        margin:0px 10px 5px 5px;
        vertical-align:top;
    }
     
    .progressBar div {
        height: 100%;
        color: #fff;
        text-align: right;
        line-height: 22px; /* same as #progressBar height if we want text middle aligned */
        width: 0;
        background-color: #0ba1b5; border-radius: 3px; 
    }
    .statusbar{
        border-top:1px solid #A9CCD1;
        min-height:25px;
        width:99%;
        padding:10px 10px 0px 10px;
        vertical-align:top;
    }
    .statusbar:nth-child(odd){
        background:#EBEFF0;
    }
    .filename{
        display:inline-block;
        vertical-align:top;
        width:250px;
    }
    .filesize{
        display:inline-block;
        vertical-align:top;
        color:#30693D;
        width:100px;
        margin-left:10px;
        margin-right:5px;
    }
    .abort{
        background-color:#A8352F;
        -moz-border-radius:4px;
        -webkit-border-radius:4px;
        border-radius:4px;display:inline-block;
        color:#fff;
        font-family:arial;font-size:13px;font-weight:normal;
        padding:4px 15px;
        cursor:pointer;
        vertical-align:top
    }
    
    
    input[type=checkbox] {
	-ms-transform: scale(2); /* IE */
	-moz-transform: scale(2); /* FF */
	-webkit-transform: scale(2); /* Safari and Chrome */
	-o-transform: scale(2); /* Opera */
	padding: 10px;

}
</style>

</head>
<%@include file="./header.jsp" %>
<body>

<div class="container"><br><br>
		        <h3><strong>새 공지사항 입력</strong></h3><br>
		        <table class="table table-hover">
		        <tr>
		        		<td>제목</td>
		        	<td>
		       			<input type="text" id="title" name="title" class="form-control"placeholder="제목을 입력해 주세요">
		        	</td>
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
		        		<td>중요 공지 </td>
		        <td>
		        	 <input type="checkbox" id="important" name="important" value="1">
		        </td>
		        </tr>
		        <tr>
		        		<td>첨부파일</td>
		        	<td>
		        		<div id="fileUpload" class="dragAndDropDiv">마우스로 파일을 끌어놓으세요</div>
		        	</td>
		        </tr>
		         <tr>
		        		<td>내용</td>
		        	<td>
		        		<textarea name="content" id="content"></textarea>
		        	</td>
		        </tr>
		        
		        </table><br><br>
		        	<div style="text-align: center;">
				        <input class="btn btn-success" style="margin: 0 0 0 10px;"  type="button" value="거래처 등록" onclick="insertBtn()">
				        <input class="btn btn-info" style="margin: 0 0 0 10px;"  type="button" value="뒤로가기" onclick="javascript:history.back(-1)">
		       		</div>
		    </div>
	<br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br>
</body>

	
	
<script type="text/javascript">
CKEDITOR.replace( 'content', {
    language: 'ko',
    uiColor: '#9AB8F3',

});
 

function insert(){
	var data = document.getElementById("inputContent").value;
	console.log(data);
	CKEDITOR.instances.content.setData(data); 
}


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

	
	
function Btnsave() {
	
	
	var data = confirm("새 공지사항을 입력 하시겠습니까?");
	
	if(!data){
		return false;
	}
	
	let checkState = 0;
	if($("#important").is(":checked")){
		checkState = 1;
	}

	var regText = /<[^>]*>?/g;
	
	var datalist = {
			"startdate" : $("#datepicker").val(),
			"enddate" : $("#datepicker2").val(),
			"title" : $("#title").val(),
			"content" : CKEDITOR.instances.content.getData().replace(regText,''),
			"important" : checkState
	}

	
	$.ajax({
	    type:"POST",
	    url:"./insertBoard.do",
	    data : datalist,
	    success : function(){
	       alert("공지사항 입력 성공"); 
	       window.location.href = './boardList.do';
	       
	    },
	    error:function(error){
	       console.log("error");
	    }
	});
}

var board_seq = 0;

$.ajax({
    type:"POST",
    url:"./selectSEQ.do",
    success : function(data){
    	console.log(data);
    	board_seq = data;
    },
    error:function(error){
       console.log("error");
    }
});




$(function() {
	$( "#datepicker" ).datepicker({ minDate: 0});
	});

$(function() {
	$( "#datepicker2" ).datepicker({ minDate: 0});
	});

$( function() {
	$("#datepicker").datepicker();
    $("#datepicker").datepicker("option", "dateFormat","yy-mm-dd");
})

$( function() {
	$("#datepicker2").datepicker();
    $("#datepicker2").datepicker("option", "dateFormat","yy-mm-dd");
}); 


//파일 업로드
$(document).ready(function(){
    var objDragAndDrop = $(".dragAndDropDiv");
    
    $(document).on("dragenter",".dragAndDropDiv",function(e){
        e.stopPropagation();
        e.preventDefault();
        $(this).css('border', '2px solid #0B85A1');
    });
    $(document).on("dragover",".dragAndDropDiv",function(e){
        e.stopPropagation();
        e.preventDefault();
    });
    $(document).on("drop",".dragAndDropDiv",function(e){
        
        $(this).css('border', '2px dotted #0B85A1');
        e.preventDefault();
        var files = e.originalEvent.dataTransfer.files;
    
        handleFileUpload(files,objDragAndDrop);
    });
    
    $(document).on('dragenter', function (e){
        e.stopPropagation();
        e.preventDefault();
    });
    $(document).on('dragover', function (e){
      e.stopPropagation();
      e.preventDefault();
      objDragAndDrop.css('border', '2px dotted #0B85A1');
    });
    $(document).on('drop', function (e){
        e.stopPropagation();
        e.preventDefault();
    });
    //drag 영역 클릭시 파일 선택창
    objDragAndDrop.on('click',function (e){
        $('input[type=file]').trigger('click');
    });

    $('input[type=file]').on('change', function(e) {
        var files = e.originalEvent.target.files;
        handleFileUpload(files,objDragAndDrop);
    });
    
    function handleFileUpload(files,obj)
    {
       for (var i = 0; i < files.length; i++) 
       {
            var fd = new FormData();
            fd.append('file', files[i]);
            fd.append('seq', board_seq);
     
            var status = new createStatusbar(obj); 
            status.setFileNameSize(files[i].name,files[i].size);
            sendFileToServer(fd,status);
     
       }
    }
    
    var rowCount=0;
    function createStatusbar(obj){
            
        rowCount++;
        var row="odd";
        if(rowCount %2 ==0) row ="even";
        this.statusbar = $("<div class='statusbar "+row+"'></div>");
        this.filename = $("<div class='filename'></div>").appendTo(this.statusbar);
        this.size = $("<div class='filesize'></div>").appendTo(this.statusbar);
        this.progressBar = $("<div class='progressBar'><div></div></div>").appendTo(this.statusbar);
        this.abort = $("<div class='abort'>중지</div>").appendTo(this.statusbar);
        
        obj.after(this.statusbar);
     
        this.setFileNameSize = function(name,size){
            var sizeStr="";
            var sizeKB = size/1024;
            if(parseInt(sizeKB) > 1024){
                var sizeMB = sizeKB/1024;
                sizeStr = sizeMB.toFixed(2)+" MB";
            }else{
                sizeStr = sizeKB.toFixed(2)+" KB";
            }
     
            this.filename.html(name);
            this.size.html(sizeStr);
        }
        
        this.setProgress = function(progress){       
            var progressBarWidth =progress*this.progressBar.width()/ 100;  
            this.progressBar.find('div').animate({ width: progressBarWidth }, 10).html(progress + "% ");
            if(parseInt(progress) >= 100)
            {
                this.abort.hide();
            }
        }
        
        this.setAbort = function(jqxhr){
            var sb = this.statusbar;
            this.abort.click(function()
            {
                jqxhr.abort();
                sb.hide();
            });
        }
    }
    
    
    function sendFileToServer(formData,status)
    {
    	console.log(status);
        var uploadURL = "./fileUpload.do"; //Upload URL
        var extraData ={}; //Extra Data. 
        var jqXHR=$.ajax({
                xhr: function() {
                var xhrobj = $.ajaxSettings.xhr();
                if (xhrobj.upload) {
                        xhrobj.upload.addEventListener('progress', function(event) {
                            var percent = 0;
                            var position = event.loaded || event.position;
                            var total = event.total;
                            if (event.lengthComputable) {
                                percent = Math.ceil(position / total * 100);
                            }
                            //Set progress
                            status.setProgress(percent);
                        }, false);
                    }
                return xhrobj;
            },
            url: uploadURL,
            type: "POST",
            contentType:false,
            processData: false,
            data: formData,
            success: function(data){
            	console.log(data);
                status.setProgress(100);
            }
        }); 
        status.setAbort(jqXHR);
    }
});




</script>

<%@include file="./footer.jsp" %>
</html>