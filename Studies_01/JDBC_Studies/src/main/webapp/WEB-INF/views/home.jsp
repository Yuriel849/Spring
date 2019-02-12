<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1> Spring JdbcTemplate! </h1>

	<P>  The time on the server is ${serverTime}. </P>

	<ul>
		<li><a href="member/insert">Insert into DB (Table : spring.test_member)</a></li>
		<li><a href="member/view">Select from DB (Table : spring.test_member)</a></li>
		<li><a href="member/insertKey">Insert with key into DB (Table : spring.test_member)</a></li>
	</ul>
</body>
</html>
