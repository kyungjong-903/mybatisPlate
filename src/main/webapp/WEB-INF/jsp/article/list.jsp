<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="totalPage" value="${pagedListRs.totalPage}" />
<c:set var="boardId" value="${pagedListRs.boardId}" />
<c:set var="page" value="${pagedListRs.page}" />
<c:set var="first" value="${pagedListRs.first}" />
<c:set var="last" value="${pagedListRs.last}" />


<%@ include file="../common/header.jsp"%>

<div class="container">
	<table class="table table-hover text-center">
		<thead>
			<tr>
				<th class="text-center" style="width: 10%;">글</th>
				<th class="text-center" style="width: 30%;">제목</th>
				<th class="text-center" style="width: 15%;">작성자</th>
				<th class="text-center" style="width: 15%;">등록일</th>
				<th class="text-center" style="width: 7%;">조회수</th>
				<th class="text-center" style="width: 9%;">----</th>
			</tr>
		</thead>

		<c:forEach items="${articles}" var="article">
			<tbody>
				<tr>
					<td style="width: 10%;"><c:out value="${article.id}" /></td>
					<td style="width: 30%; text-align: left;"><a
						href="/article/detail?articleId=${article.id}">${article.title} </a></td>
					<td style="width: 15%;">${article.memberId}</td>
					<td style="width: 15%;">${article.regDate}</td>
					<td style="width: 7%;">${article.hit}</td>
					<td style="width: 9%;">
					
					</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
	<c:if test="${isLogined == true}">
		<a href="/article/write" class="btn btn-success btn-sm">글 쓰기</a>
	</c:if>
</div>
<div class="pageList">
	<ul class="pagination justify-content-center">
		<li class="page-item"><a class="page-link"
			href="./list?boardId=${boardId}&page=1">처음</a></li>

		<c:forEach var="i" begin="${first}" end="${last}" step="1">
			<%
				String Class = "";
			%>
			<c:if test="${i eq page}">
				<%
					Class = "active";
				%>
			</c:if>
			<li class="page-item <%=Class%>"><a
				href="./list?boardId=${boardId}&page=${i}" class="page-link">${i}</a></li>

		</c:forEach>
		<li class="page-item"><a class="page-link"
			href="./list?boardId=${boardId}&page=${totalPage}">끝</a></li>

	</ul>
</div>