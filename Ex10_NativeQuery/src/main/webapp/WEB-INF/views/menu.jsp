<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSQL_nativeQuery</h1>
	<!-- JSQL = JPQL -->
	<a href="/selectByNameLike1?name=user">Name Like 조회 : JSQL 1</a><p/><br>
	<a href="/selectByNameLike2?name=user">Name Like 조회 : JSQL 2</a><p/><br>
	<a href="/selectByNameLike3?name=user&page=2">Name Like 조회 : JPQL 3 - 2페이지</a><p/><br>
	<a href="/selectByNameLike4?name=user">Name Like 조회 : Native SQL</a><p/><br>
</body>
</html>