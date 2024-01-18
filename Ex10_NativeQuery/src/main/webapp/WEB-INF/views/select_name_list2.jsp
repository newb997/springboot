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
	<h1>JSQL_nativeQuery - @Query : Name Like - 2page</h1>
 	총 글의 개수 : ${ totalElements }<br>
 	총 페이지 : ${ totalPages }<br>
 	한 페이지당 글의 수 : ${ size }<br>
 	현재페이지 : ${ pageNumber }<br>
 	현재페이지 글의 수 : ${ numberOfElements }<br>
 	<hr>
 	
 	<!-- var : model에서 넘어온 키값 var에 넣어서 씀 / items : model에서 가져온거 -->
 	<c:forEach var="member" items="${ members }">
 		아이디 : ${ member.id }<br>
 		이름 : ${ member.name }<br>
 		이메일 : ${ member.email }<br>
 		<hr>
 	</c:forEach>
 	
</body>
</html>