<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="home.jsp"/>
	<table border="3">
		<tr>
			<td>num</td>
			<td>id</td>
			<td>password</td>
			<td>name</td>
		</tr>
		
		<c:forEach items = "${memberList}"var="mem">
		<tr>
			<td>${mem.num}</td>
			<td>${mem.id}</td>
			<td>${mem.password}</td>
			<td>${mem.name}</td>
			<td><a href="memberDeleteController.do?num=${mem.num}">삭제</a></td>
			<td><a href="memberUpdateController.do?num=${mem.num}">수정</a></td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>