<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Login form</title>
</head>
<body>
	<h1>로그인</h1>

	<form method="post">
		ID <input type="text" name="uid" id="uid"><br>
		PW <input type="password" name="upw" id="upw"><br>
		<input type="submit" value="SUBMIT">	
	</form>
</body>
</html>
