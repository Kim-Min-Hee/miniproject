<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>생성 결과</title>
</head>
<body>
	<h3> <%=request.getParameter("USER_ID")%> 님 가입이 완료 되었습니다. </h3>
	
	<%@ include file="home.jsp" %>
	
</body>
</html>