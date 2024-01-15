<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>

<style type="text/css">
	body{width: 500px; text-align: center;}
</style>
</head>
<body>
	<h1>게시판</h1>
	
	<table>
		<tr>
			<td colspan="4">총 레코드수 : ${ totalRecord } </td>
		</tr>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>삭제</td>
		</tr>
		<c:forEach items="${ list }" var="blist">
			<tr>
				<td>${ blist.no }</td>
				<td><a href="detail?no=${ blist.no }">${ blist.title }</a></td>
				<td>${ blist.writer }</td>
				<td><button type="button" class="btn btn-light" onclick="location.href='delete?no=${ blist.no }'">삭제</button></td>
			</tr>
			
		</c:forEach>
	</table>
	<a href="writeForm"><button type="button">글작성</button></a>
</body>
</html>