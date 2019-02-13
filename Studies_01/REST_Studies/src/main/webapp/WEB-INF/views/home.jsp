<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>XML / JSON / RestController </h1>

	<P>  The time on the server is ${serverTime}. </P>

	<ul>
		<li><a href="guest/message/list.xml">Get XML</a></li>
		<li><a href="guest/message/list.json">Get JSON</a></li>
		<li><a href="rest/msgs/25">Use RestController for String response</a></li>
		<li><a href="rest/msgs/id/100">Use RestController for JSON response</a></li>
		<li><a href="rest/msgs">Use RestController for JSON response</a></li>
		<li><a href="guest/form">To submission form</a></li>
	</ul>
</body>
</html>
