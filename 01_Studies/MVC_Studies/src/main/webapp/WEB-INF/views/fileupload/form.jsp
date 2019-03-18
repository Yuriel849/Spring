<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>파일업로드</h1>

	<h3>@RequestParam 이용한 파일 업로드</h3>

	<form action="upload1" method="post" enctype="multipart/form-data">
		번호 <input type="text" name="sno"><br>
		파일 <input type="file" name="report"> <br>
		<input type="submit" value="업로드">
	</form>

	<hr>

	<h3>MultipartHttpServletRequest 이용한 파일 업로드</h3>

	<form action="upload2" method="post" enctype="multipart/form-data">
		번호 <input type="text" name="sno"><br>
		파일 <input type="file" name="report"> <br>
		<input type="submit" value="업로드">
	</form>

	<hr>
	
	<h3>커멘드 객체를 이용한 파일 업로드</h3>

	<form action="upload3" method="post" enctype="multipart/form-data">
		번호 <input type="text" name="sno"><br>
		파일 <input type="file" name="report"> <br>
		<input type="submit" value="업로드">
	</form>
</body>
</html>