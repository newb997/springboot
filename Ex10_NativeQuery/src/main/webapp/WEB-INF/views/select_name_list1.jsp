<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>JSQL_nativeQuery - @Query : Name Like</h1>
	
 	<!-- var : controller의 model에서 넘어온 키값 var에 넣어서 씀 / items : controller의 model에서 가져온거 -->
 	<c:forEach var="member" items="${ members }">
 		아이디 : ${ member.id }<br>
 		이름 : ${ member.name }<br>
 		이메일 : ${ member.email }<br>
 		<hr>
 	</c:forEach>
</body>
</html>