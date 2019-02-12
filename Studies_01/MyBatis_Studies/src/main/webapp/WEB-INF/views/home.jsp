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

	<h3>
		<ul>
			<li><a href="member/reg"> ADD MEMBER </a></li>
			<li><a href="member/view"> VIEW MEMBER </a></li>
			<li><a href="member/list"> VIEW ALL MEMBERS </a></li>
		</ul>
	</h3>

	<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
