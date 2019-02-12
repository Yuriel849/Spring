<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>
		Hello world!  
	</h1>

	<P>  The time on the server is ${serverTime}. </P>

	<ul>
		<li><a href="mail/simpleMailSend">Send email (simple)</a></li>
		<li><a href="mail/mimeMailSend">Send email (html)</a></li>
		<li><a href="mail/mimeAttachment">Send email (attachment)</a></li>
	</ul>
</body>
</html>
