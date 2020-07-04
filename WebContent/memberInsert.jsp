<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action = memberInsert.do method="post">
	<h1>회원가입 페이지</h1>
	아이디: <input type = "text"name="USER_ID"size="15"><br>
	비밀번호: <input type= "password"name="USER_PASSWORD"size="15"><br>
	이름: <input type= "text" name="USER_NAME" size="10"><br>
	<input type = "submit"name="전송">
	</form>
</body>
</html>