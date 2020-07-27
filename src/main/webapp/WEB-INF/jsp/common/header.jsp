<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>kyungjong</title>
</head>
<body>
	<div id="header">
		<div class="Wrapper container after">
			<ul class="nav after">
				<c:if test="${loginedMember == null}">
						<li><a href="/member/Join">회원가입</a></li>
						<li><a href="/member/login">로그인</a></li>
				</c:if>
				<c:if test="${loginedMember != null}">
					<li><a href="/member/logout"
						onclick="if(!confirm('로그아웃 하시겠습니까?')) return false;">로그아웃</a></li>
				</c:if>
			</ul>
			<div class="nameBox">
				<c:if test="${loginedMember != null}">
						<li><span>${loginedMember.name}</span> 님 환영합니다.</li>
				</c:if>
			</div>

		</div>
		<div class="gnb container">
			<ul class="after">
				<li><a href="../article/list?boardId=1&page=1"
					class="
					<c:if test="${boardId eq 1}">
						currentBoard
					</c:if>	">공지사항</a></li>
				<li><a href="../article/list?boardId=2&page=1"
					class="
					<c:if test="${boardId eq 2}">
						currentBoard
					</c:if>	">자유게시판</a></li>
			</ul>
		</div>
	</div>