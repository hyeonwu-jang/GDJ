<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js" ></script>
<script>
	$(document).ready(function() {
		
		$('#btn_submit').click(function(event) {
			alert('연락처가 등록되었습니다.');
			$('#frm').submit();
		});
		
		
		$('#btn_list').click(function() {
			location.href='${contextPath}/';
		});
			
		
		
	});
</script>
</head>
<body>
	<form id="frm" method="post" action="${contextPath}/write">
		<input type="hidden" name="no">
		<h1>연락처 등록</h1>
		<div>
			<label for="name">이름*</label><br>
			<input type="text" name="name" id="name">
		</div>
		<br>
		<div>
			<label for="tel">전화*</label><br>
			<input type="text" name="tel" id="tel">
		</div>
		<br>
		<div>
			<label for="addr">주소*</label><br>
			<input type="text" name="addr" id="addr">
		</div>
		<br>
		<div>
			<label for="email">이메일*</label><br>
			<input type="text" name="email" id="email">
		</div>
		<br>
		<div>
			<label for="note">비고</label><br>
			<input type="text" name="note" id="note">
		</div>
		<br>
		<input type="button" value="연락처 저장하기" id="btn_submit">
		<input type="button" value="전체연락처" id="btn_list">
	</form>

</body>
</html>