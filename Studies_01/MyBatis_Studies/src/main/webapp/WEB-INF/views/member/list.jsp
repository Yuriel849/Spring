<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> MEMBER LIST </h1>
	
	<c:forEach var="member" items="${result}">
		<h4>
			${member.id} | ${member.name} | ${member.email} | ${member.password}
		</h4>
	
	</c:forEach>
	
	<a href="../">다시 메인페이지로</a>
</body>
</html>