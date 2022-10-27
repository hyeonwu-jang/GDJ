<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	총 게시글 : 개
	<table border="1">
		<thead>
			<tr>
				<td>순번</td>
				<td>작성자</td>
				<td>제목</td>
				<td>작성일</td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty boards}">
				<tr>
					<td colspan="4">게시물이 없습니다.</td>
				</tr>			
			</c:if>
			<c:if test="${not empty boards}">
				<c:forEach items="${boards}" var="board">
				<tr>
					<td>${board.boardNo}</td>
					<td>${board.writer}</td>
					<td><a href="${contextPath}/detail.do?boardNo=${board.boardNo}">${board.title}</a></td>
					<td>${board.createDate}</td>
				</tr>
			</c:forEach>
			</c:if>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="4">
					<input type="button" value="새글작성" onclick="location.href='${contextPath}/add.do'">
				</td>
			</tr>
		</tfoot>
	</table>
	
</body>
</html>