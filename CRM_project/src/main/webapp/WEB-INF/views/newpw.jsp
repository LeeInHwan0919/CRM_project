<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./resources/css/login.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.js"></script>
<title>새 비밀번호 입력</title>
</head>
<body>

		<div class="login">
			<input type="password" placeholder="변경할 새 비밀번호를 입력하세요." id="pwd1" name="pwd1"> 
				<input type="password" placeholder="새 비밀번호를 확인입력 해주세요." id="pwd2" name="pwd2"> 
				<div class="alert alert-bin" id="alert-bin" style="text-align:center; font-size:6px; color:red;">비밀번호는 4자리 이상 입력해주세요.</div>
				<div class="alert alert-success" id="alert-success" style="text-align:center; font-size:6px; color:red;">비밀번호가 일치합니다.</div>
				<div class="alert alert-danger" id="alert-danger" style="text-align:center; font-size:6px; color:red;">비밀번호가 일치하지 않습니다.</div>
				<input type="submit" id="submit" value="변경">
		</div>
		<script type="text/javascript">
	    
		$(function(){
	        $("#alert-bin").hide();
	        $("#alert-success").hide();
	        $("#alert-danger").hide();
	        $("input").keyup(function(){
	            var pwd1=$("#pwd1").val();
	            var pwd2=$("#pwd2").val();
	            if(pwd1 != "" || pwd2 != ""){
	                if(pwd1 == pwd2){
	                    $("#alert-success").show();
	                    $("#alert-danger").hide();
	                    $("#submit").removeAttr("disabled");
	                }else{
	                    $("#alert-success").hide();
	                    $("#alert-danger").show();
	                    $("#submit").attr("disabled", "disabled");
	                }    
	            }else{
	            	$("#submit").attr("disabled", "disabled");
                    $("#alert-bin").show();
	            }
	        });
	        
	        $('#submit').click(function(){
	        	var pwd1=$("#pwd1").val();
	            var pwd2=$("#pwd2").val();
	            if(pwd1 != "" || pwd2 != ""){
		    	  if(pwd1 == pwd2){
		    		alert('비밀번호를 변경되었습니다. 로그인 페이지로 넘어갑니다.');
		    		location.href="./loginPage.do";
		    	  }else{
		    		alert('비밀번호가 일치하지 않습니다.');
		    	  }
		    	  }else{
		    		alert('비밀번호를 입력해 주세요.');
		    	}
		    });
	    });
	</script>​
</body>
</html>















