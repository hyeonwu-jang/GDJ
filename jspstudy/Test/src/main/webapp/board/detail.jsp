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
	<form method="post" action="${contextPath}/modify.do">
		<table border="1">
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer" value="${board.writer}"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" value="${board.title}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" cols="50" name="content" >${board.content}</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="hidden" value="${board.boardNo}" name="boardNo">
					<button>수정</button>
					<input type="button" value="목록" onclick="location.href='${contextPath}/list.do'">
					<input type="button" value="삭제" onclick="location.href='${contextPath}/delete.do'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>