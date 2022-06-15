<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./resources/css/findpw.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.js"></script>
<style type="text/css">
div#img{
  text-align: center;
}

div.container{
  margin-top: 180px;
}

.findpw {
  background: #eceeee;
  border: 1px solid #42464b;
  border-radius: 6px;
  height: 450px;
  margin: 20px auto 0;
  width: 400px;
  margin-top:30px;
}

</style>
<title>비밀번호 찾기</title>
</head>
<body style="background-color: #FFFAFA">
<div class="container">
<div id="img">
<img style="text-align: center; height: 100px; width: 400; " src="./resources/img/blue_logo.png">
</div>
		<div class="findpw">
			<input type="text" placeholder="사원코드를 입력해 주세요." id="emp_code" name="emp_code"> 
				<input type="text" placeholder="전화번호를 입력해 주세요." id="emp_tel" name="emp_tel"> 
				<input type="button" id="sendPhoneNumber" value="SMS전송">
				<div class="time"></div>
				<input type="text" id="inputCertifiedNumber" placeholder='인증번호'>
				<input type="button" id="checkBtn" value="확인">
		</div>
		
		
	<!--인증번호 타이머 -->
		<div class="shadow"></div>
</div>
<script>

var timer = null;
var isRunning = false;
        $('#sendPhoneNumber').click(function(){
        	
            let phoneNumber = $('#emp_tel').val();
            let emp_code = $('#emp_code').val();
            
            $.ajax({
                type: "POST",
                url: "./findpw.do",
                data: {"phoneNumber" : phoneNumber},
                dataType:"text",
                success: function(msg){
                	if(msg=='성공'){
                		if(phoneNumber == '' || emp_code==''){
                        	alert('값을 입력하세요.');
                        }else{
                        	alert('인증번호 발송 완료!');
//                         	window.close();
                            var display = $('.time');
                        	var leftSec = 180;
                        	// 남은 시간
                        	// 이미 타이머가 작동중이면 중지
                        	if (isRunning){
                        		clearInterval(timer);
//                         		display.html("");
                        		startTimer(leftSec, display);
                        	}else{
                        		startTimer(leftSec, display);
                        	}
                        }
                	}else{
                		alert('사원번호에 해당하는 전화번호가 아닙니다. 다시 입력해주세요.');
                	}
                },
                error:function(err){
                	alert(JSON.stringify(err));
                }
            });
            
            
            
            	
            
            
            

            var docum = document.getElementById("checkBtn").disabled;
            $.ajax({
                type: "POST",
                url: "./sendSMS.do",
                data: {"phoneNumber" : phoneNumber}, // 핸드폰 값이 넘어감
                success: function(res){ // 인증번호 값이 넘어옴
                    $('#checkBtn').click(function(){
                    	if($('#inputCertifiedNumber').val()=='') {
                    		alert('값을 입력하세요.');
                    	} else if(isRunning && $.trim(res) ==$('#inputCertifiedNumber').val()){
                            // 타이머가 활성화 되어있고 값이 정확히 입력되었을 때
                    		alert('인증성공!'+'휴대폰 인증이 정상적으로 완료되었습니다.'+'새 비밀번호 입력창으로 넘어갑니다.');
							clearInterval(timer);
// 			        		display.html("");
			        		location.href="./newpw.do?emp_code="+emp_code
                        }else{
                        	if(isRunning) {
                        		// 타이머가 활성화 되어있고 인증번호가 틀렸을때
	                        	alert('인증번호가 맞지 않습니다.');
                        	} else {
                        		// 타이머가 활성화 되어 있지 않을때
	                        	alert('시간이 초과되었습니다.');
                        	}
                        }
                    })
                }
            })
            
        });
//--------------------타이머
        

            
        function startTimer(count, display) {
            		var minutes, seconds;
                    timer = setInterval(
        function () {
                    minutes = parseInt(count / 60, 10);
                    seconds = parseInt(count % 60, 10);
             
                    minutes = minutes < 10 ? "0" + minutes : minutes;
                    seconds = seconds < 10 ? "0" + seconds : seconds;
             
                    display.html(minutes + ":" + seconds);
             
                    // 타이머 끝
                    if (--count < 0) {
            	     clearInterval(timer);
            	     alert("시간초과");
            	     display.html("시간초과");
            	     $('#checkBtn').attr("disabled","disabled");
            	     isRunning = false;
                    }
                }, 1000);
                     isRunning = true;
        }
</script>
</body>
</html>















