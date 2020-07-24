<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE unspecified PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
	<title>Document</title>
</head>
<body>
	${members}
	<div>
		<form action="./doLogin" method="POST">
			<input type="text" name="loginId"/>
			<input type="password" name= "loginPw"/>
			<button type="submit">로그인</button>
			<a href="./member/join">
				<button>회원가입</button>
			</a>
		</form>
	</div>
</body>
</html>