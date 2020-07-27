<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../common/header.jsp"%>

<div class="con article-detail-box">
		<table>
			<colgroup>
				<col width="100" />
			</colgroup>
			<tbody>
				<tr>
					<th>제목</th>
					<td>${article.title}</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${article.memberId}</td>
				</tr>
				<tr>
					<th>조회</th>
					<td>${article.hit}</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>${article.body}</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>