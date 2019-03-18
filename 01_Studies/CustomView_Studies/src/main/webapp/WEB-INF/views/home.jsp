<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>
		Custom VIEW
	</h1>

	<P>  The time on the server is ${serverTime}. </P>

	<ul>
		<li><a href="download/file">Download Notice download</a></li>
		<li><a href="download/excel">EXCEL download</a></li>
		<li><a href="download/pdf">PDF download</a></li>
	</ul>
</body>
</html>
