<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="assets/js/jquery-3.6.1.min.js"></script>
<script>
	$(document).ready(function(){
		$('#btn_modify').click(function(event) {
			$('#frm').submit();
		});
	});
</script>
</head>
<body>

	<h1>자유게시판 게시글 상세보기화면</h1>
	
		<form method="post" id="frm" action="${contextPath}/modify.do">
			<input type="hidden" name="freeNo" value="${free.freeNo}">
			<div>
				게시글번호 ${free.freeNo}
			</div>
			<div>
				작성자 ${free.writer}
			</div>
			<div>
				작성IP ${free.ip}
			</div>
			<div>
				조회수 ${free.hit}
			</div>
			<div>
				제목<input type="text" name="title" value="${free.title}">
			</div>
			<div>
				<textarea rows="5" cols="20" name="content">${free.content}</textarea>
			</div>
				<input type="button" value="수정" id="btn_modify">
				<input type="button" id="btn_list" value="목록" onclick="location.href='${contextPath}/list.do'">
		</form>
</body>
</html>