<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Form</title>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<h1>메시지 작성 양식</h1>
	<br>
	
	<!-- form tag is not used because jQuery's ajax method is used instead -->
<!-- 	<form action="../rest/msgs" method="post"> -->
		아이디 : <input type="text" id="id" name="id">
		메세지 : <input type="text" id="message" name="message">
		<input type="submit" id="btn">
<!-- 	</form> -->
	
	<script type="text/javascript">
		$("#btn").click(function() {
			var arr = {id : $("#id").val(), message : $("#message").val()}
			
			$.ajax({
				url : '../rest/msgs'
				, type : 'POST'
				, contentType : 'application/json; charset=utf-8'
				, data : JSON.stringify(arr)
				, dataType : 'json'
				, success : function(msg) {
					console.log(msg);
					alert(msg);
				}
				, error : function(msg) {
					console.log(msg);
					alert("failure!");
				}
			});
		});
	</script>
</body>
</html>
