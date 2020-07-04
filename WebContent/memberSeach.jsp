<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String msg = (String) request.getAttribute("msg");
	
	%>
	<%= msg %><br>
		<input type="button" value= "메인으로" onclick = "location.href = 'home.do'">
</body>
</html>