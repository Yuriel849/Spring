$(document).ready(function(){
	
	//비번 , 이름 , 이메일
	$('#changeCustomer').on('click', function() {
		$.ajax({
    		url : '/customer/member/' + $('#id').val() + '/modify'
    		, type : 'POST'
			, contentType : 'application/json'
    		, data : JSON.stringify({
    				id : $('#id').val(),
    				 pw : $('#pw').val()
    				, name : $('#name').val()
    				, email : $('#email').val()
    			})
    		, error : function() { alert("회원 정보를 수정하는데 에러가 발생했습니다."); }
    		, success : function() { alert("성공적으로 회원 정보를 수정했습니다."); }
		});
	});
	
	
	/* modal의 "X" 버튼을 눌러 닫을 때 modal을 숨기고 초기화하기 */
	$('body').on('click', '.modal-popup .close-link', function(event){
		event.preventDefault();
		$('.modal').modal('hide');
		$('#myLogin input').val("");
		$('#myId').text("");
		$('#myId').append('<div class="login_icon" style="margin-top: 20px; margin-bottom: 10px;">' +
				'<i class="material-icons" style="width: 60px; font-size: 60px;">lock_alt</i></div>' +
				'<h2>ID 찾기</h2><h5>ID를 찾으려면 본인인증을 해주세요.</h5>' +
				'<input type="text" class="form-control form-white" placeholder="이름">' +
				'<input type="text" class="form-control form-white" placeholder="이메일">' +
				'<button type="button" id="getId" class="btn btn-submit">ID 찾기</button>');
	});
	
	
	

	/* 로그인 절차 */
	$('#myLogin button').on('click', function() {
		$.ajax({
    		url : 'http://localhost:3001/customer/member/'
    		, type : 'POST'
			, contentType : 'application/json'
    		, data : JSON.stringify({
    				  id : $('#myLogin input:eq(0)').val()
    				, pw : $('#myLogin input:eq(1)').val()
    			})
    			, error : function(data) {
        			console.log(data);
        		}
        		, success : function(data) {
        			if(data == "성공적으로 로그인했습니다.") {
        				 alert('로그인 성공');		
        			} else {
        				alert("로그인 실패");

        				
        				    				
        			}
        			$('.modal').modal('hide');
        			$('#myLogin input').val("");
        		}
    		});
    	})
    	
	
	// 회원가입 절차 
	$('#myRegister button').on('click', function() {
		$.ajax({
    		url : 'http://localhost:3001/customer/member/register'
    		, type : 'POST'
    	    , contentType : 'application/json; charset=UTF-8'
			, dataType : 'text'
			, data :            
    		          JSON.stringify({
    				  id : $('#myRegister input:eq(0)').val()
    				, pw : $('#myRegister input:eq(1)').val()
    				, name : $('#myRegister input:eq(3)').val()
    				, birthDate : $('#myRegister input:eq(4)').val()
    				, phone : $('#myRegister input:eq(5)').val()
    				, email : $('#myRegister input:eq(6)').val()
    				, gender : $('#myRegister input:eq(9)').val()
    			})
    		, error : function(data) {
    			console.log(data);
    		}
    		, success : function(data) {
    			if(data == "가입 성공.") {
    				alert('회원가입 ');    				
    			} else {
    				alert('회원가입 성공');  			
    			}
    			$('.modal').modal('hide');
    			$('#myRegister input').val("");
    		}
		});
	})
	
	
	/* ID 찾기 인증 절차 */
	$('#findId').on('click', function(event) {
		event.preventDefault();
		$('.modal').modal('hide');
		$('#finder').modal('show');
    	$('#getId').on('click', function() {
    		$.ajax({
        		url : 'http://localhost:3001/customer/member/verify'
        		, type : 'POST'
				, contentType : 'application/json'
        		, data : JSON.stringify({
        				  name : $('#myId input:eq(0)').val()
        				, email : $('#myId input:eq(1)').val()
        			})
        		, error : function(data) {
        			$("#myId input").remove();
	        		$("#myId h2").replaceWith("<h5>에러가 발생했습니다. 조금 있다가 다시 시도해주세요.</h5>");
	        		$('#myId h5:eq(1)').remove();
	        		$('#myId #getId').remove();
        		}
        		, success : function(data) {
        			if(data != "") {
		        		$("#myId input").remove();
		        		$("#myId h2").replaceWith("<h5>성공적으로 사용자 ID를 찾았습니다.</h5>");
		        		$('#myId h5:eq(1)').text("사용자 ID는 " + data + "입니다.");
		        		$('#myId #getId').replaceWith('<button type="button" id="goLogin" class="btn btn-submit">로그인하러 가기</button>');		        				
        			} else {
	        			$("#myId input").remove();
		        		$("#myId h2").replaceWith("<h5>사용자 ID를 찾는데 실패했습니다.</h5>");
		        		$('#myId h5:eq(1)').text("사용자 이름, 이메일을 다시 확인하시고 다시 입력해주세요.");
		        		$('#myId #getId').remove();
        			}
        		}
    		});
    	})
	});
	
	/* ID 찾은 후 로그인 페이지로 넘어가기 */
	$('body').on('click', '#goLogin', function(event){
		event.preventDefault();
		$('#login_2').modal('show');
		$('#finder').modal('hide');
		$('#myId').children().remove();
		$('#myId').append('<div class="login_icon" style="margin-top: 20px; margin-bottom: 10px;">' +
				'<i class="material-icons" style="width: 60px; font-size: 60px;">lock_alt</i></div>' +
				'<h2>ID 찾기</h2><h5>ID를 찾으려면 본인인증을 해주세요.</h5>' +
				'<input type="text" class="form-control form-white" placeholder="이름">' +
				'<input type="text" class="form-control form-white" placeholder="이메일">' +
				'<button type="button" id="getId" class="btn btn-submit">ID 찾기</button>');
		$('#login_2 input').val("");
	});
	
	
	
	
	/* PW 재설정 절차 */
	$('.changePw').on('click', function(event) {
		event.preventDefault();
		$('.modal').modal('hide');
		$('#finder h2').text("PW 재설정");
		$('#finder h5').text("PW을 재설정하려면 본인인증을 해주세요.").after('<input type="text" class="form-control form-white" placeholder="사용자 아이디">');
		$('#finder button').text('본인인증하기')
		$('#finder').modal('show');
    	$('#getId').on('click', function() {
    		$.ajax({
        		url : 'http://localhost:3001/customer/member/verify'
        		, type : 'POST'
				, contentType : 'application/json'
        		, data : JSON.stringify({
        				  id : $('#myId input:eq(0)').val()
        				, name : $('#myId input:eq(1)').val()
        				, email : $('#myId input:eq(2)').val()
        			})
        		, error : function(data) {
        			$("#myId input").remove();
	        		$("#myId h2").replaceWith("<h5>에러가 발생했습니다. 조금 있다가 다시 시도해주세요.</h5>");
	        		$('#myId h5:eq(1)').remove();
	        		$('#myId #getId').remove();
        		}
        		, success : function(data) {
        			if(data != "") {
		        		$('#myId h5').text("본인증에 성공했습니다. PW를 재설정해주세요.");
		        		$('#myId input').not(':eq(0)').val("").attr( {'placeholder' : '비밀번호를 입력해주세요', 'type' : 'password'} ).css( {'margin-top': '0px'} );
 		        		$('#myId input:eq(0)').attr( {'type' : 'hidden'} );
		        		$('#myId input:eq(1)').before('<label style="color: white;">새 비밀번호 입력하기</label>');
		        		$('#myId input:eq(1)').after('<label style="color: white;">새 비밀번호 다시 입력하기</label>');
		        		$('#myId #getId').replaceWith('<button type="button" id="changePw" class="btn btn-submit">비밀번호 재설정</button>');
        			} else {
	        			$("#myId input").remove();
		        		$("#myId h2").replaceWith("<h5>본인인증하는데 실패했습니다.</h5>");
		        		$('#myId h5:eq(1)').text("사용자 아이디, 이름, 이메일을 다시 확인하시고 다시 입력해주세요.");
		        		$('#myId #getId').remove();
        			}
        		}
    		});
    	})
	});
	
	/* 비밀번호 재설정 modal에서 재설정하기 클릭 시 실행 */
	$('body').on('click', '#changePw', function(event) {
		event.preventDefault();
		const hiddenId = $('#myId input:eq(0)').val();
		const pwOrg = $('#myId input:eq(1)').val();
		const pwChk = $('#myId input:eq(2)').val();
		/* 입력한 2개 비밀번호가 일치하지 않을 경우 함수를 종료한다 */
		if(pwOrg != pwChk) {
			$('#myId label').not(':eq(0), :eq(1)').remove();
    		$('#myId input:eq(2)').after('<label style="color: red; font-size: 16px;">비밀번호가 일치하지 않습니다.</label>');
			return;
		}

		$.ajax({
    		url : 'http://localhost:3001/customer/member/' + hiddenId + '/modify'
    		, type : 'POST'
			, contentType : 'application/json'
    		, data : JSON.stringify({
    				  id : hiddenId
    				, pw : pwOrg
    			})
    		, error : function() {
    			$("#myId h2").replaceWith("<h5>에러가 발생했습니다. <br> 조금 있다가 다시 시도해주세요.</h5>");
    			$("#myId input").remove();
    			$('#myId label').remove();
        		$('#myId h5:eq(1)').remove();
        		$('#myId #getId').remove();
    		}
    		, success : function() {
    			alert('성공적 비번 수행 ')
    			$('.modal').modal('hide');
    			$('#myLogin input').val("");
    			$('#myId').text("");
    			$('#myId').children().remove();
    			$('#myId').append('<div class="login_icon" style="margin-top: 20px; margin-bottom: 10px;">' +
    					'<i class="material-icons" style="width: 60px; font-size: 60px;">lock_alt</i></div>' +
    					'<h2>ID 찾기</h2><h5>ID를 찾으려면 본인인증을 해주세요.</h5>' +
    					'<input type="text" class="form-control form-white" placeholder="이름">' +
    					'<input type="text" class="form-control form-white" placeholder="이메일">' +
    					'<button type="button" id="getId" class="btn btn-submit">ID 찾기</button>');
    		}
		});
	});
	
	
	
	
})