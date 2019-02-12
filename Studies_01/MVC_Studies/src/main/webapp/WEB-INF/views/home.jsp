<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>
		Hello Spring World! 스프링의 세계에 어세오세요~!!
	</h1>

	<P>  The time on the server is ${serverTime}. </P>
	
	<ul>
		<li><a href="<%= request.getContextPath() %>/hello">/hello</a></li>
		<li><a href="/mvc/member/regForm">/member/regForm</a></li>
		<li><a href="/mvc/member/memberReg">회원가입</a></li>
		<li><a href="/mvc/order/order">상품주문</a></li>
		<li><a href="/mvc/cookie/makeCookie">쿠키생성</a></li>
		<li><a href="/mvc/header/view">헤더정보확인</a></li>
		<li><a href="/mvc/search/searchForm">검색페이지</a></li>
		<li><a href="/mvc/fileupload/form">파일업로드</a></li>
		<li><a href="/mvc/guest/10">10번 손님의 메시지 확인</a></li>
		<li><a href="/mvc/guest/1001">1001번 손님의 메시지 확인</a></li>
		<li><a href="/mvc/guest/80">80번 손님의 메시지 확인</a></li>
		<li><a href="/mvc/guest/8080">8080번 손님의 메시지 확인</a></li>
		<li><a href="/mvc/member/login">로그인하기</a></li>
		<li><a href="/mvc/interceptor/mypage1">INTERCEPTOR 작동 테스트 1번</a></li>
		<li><a href="/mvc/interceptor/mypage2">INTERCEPTOR 작동 테스트 2번</a></li>
	</ul>
</body>
</html>