<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Spring 계산기</title>
</head>
<body style="margin: 40px;">
	<h1>Spring으로 만든 계산기</h1>
	<hr>
	<form method="post" action="/sbbs/basic/calc">
		<input type="text" name="num1">
		<select name="op">
			<option selected>+</option>
			<option>-</option>
			<option>*</option>
			<option>/</option>
		</select>
		<input type="text" name="num2">
		<input type="submit" value="=">
		${result}
	</form>
</body>
</html>