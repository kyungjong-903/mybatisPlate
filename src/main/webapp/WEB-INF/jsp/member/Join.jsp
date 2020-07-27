<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE unspecified PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
	<title>Document</title>
</head>
<body>
	<div>
		<form action="/member/doJoin" method="POST">
			<input type="text" name="loginId" placeholder="id" />
			<input type="password" name="loginPw" placeholder="Pw" />
			<input type="text" name="name" placeholder="name" />
			<button type="submit">가입</button>
		</form>
	</div>
</body>
</html>