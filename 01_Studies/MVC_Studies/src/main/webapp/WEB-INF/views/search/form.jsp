<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.tag {
		border : 1px solid #EEEEEE;
		margin : 0 5px;
		padding : 5px; 
	}
</style>
</head>
<body>
	인기 검색어 :  

	<c:forEach items="${pkeyword}" var="keyword">
		<span class="tag">${keyword}</span>  	
	</c:forEach>
	
	<hr>
	
	검색 
	<select>
		<c:forEach items="${searchType}" var="type">
			<option value="${type.value}">${type.label}</option>
		</c:forEach>
	</select>
	<input type="text"> <input type="submit" value="submit">
</body>
</html>