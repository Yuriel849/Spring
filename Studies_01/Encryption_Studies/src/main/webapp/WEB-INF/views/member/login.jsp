<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>After encryption</title>
</head>
<body>
	<h1>암호화 후</h1>

	<P>  The time on the server is ${serverTime}. </P>

	<ul>
		<li><a href="mail/simpleMailSend">Send email (simple)</a></li>
		<li><a href="mail/mimeMailSend">Send email (html)</a></li>
		<li><a href="mail/mimeAttachment">Send email (attachment)</a></li>
	</ul>
</body>
</html>
