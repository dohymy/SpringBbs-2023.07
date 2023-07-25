<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body style="margin: 40px;">
	<h1>데이터 전송</h1>
	<hr>
	<h3>파일 이름: ${filename}</h3>
	<h3>전달 내용: ${message}</h3>
	<h3>과일 목록:</h3>
	<ul>
		<c:forEach var="fruit" items="${fruits}">
			<li>${fruits}</li>
		</c:forEach>
	</ul>
	<img src="/img/koala.jpg" width="256">
	<h3>이미지와 같은 정적인 자료는 반드시 static 폴더에 넣어야 함</h3>
</body>
</html>