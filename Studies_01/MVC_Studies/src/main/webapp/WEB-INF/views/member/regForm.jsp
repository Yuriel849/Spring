<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h2> ${title} 가입 </h2>
	
	<form method="post"> <!-- action 속성을 사용하지 않으면 action="#"와 같다 -> 현재 페이지의 URL을 호출한다! -->
		<table>
			<tr>
				<td>ID (EMAIL)</td>
				<td><input type="text" name="uid" id="uid">
			</tr>
			<tr>
				<td>PW</td>
				<td><input type="password" name="upw" id="upw">
			</tr>
			<tr>
				<td>NAME</td>
				<td><input type="text" name="uname" id="uname">
			</tr>
			<tr>
				<td>PICTURE</td>
				<td><input type="file" name="upic" id="upic">
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="SUBMIT"></td>
			</tr>
		</table>	
	</form>
</body>
</html>