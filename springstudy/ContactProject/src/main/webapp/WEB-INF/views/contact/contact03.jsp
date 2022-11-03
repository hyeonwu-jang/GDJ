<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="frm" method="post" action="${contextPath}/modify">
		<h1>연락처 보기</h1>
		<div>
			<label for="name">이름*</label><br>
			<input type="text" name="name" id="name" value="${contact.name}">
		</div>
		<br>
		<div>
			<label for="tel">전화*</label><br>
			<input type="text" name="tel" id="tel" value="${contact.tel}">
		</div>
		<br>
		<div>
			<label for="addr">주소*</label><br>
			<input type="text" name="addr" id="addr" value="${contact.addr}">
		</div>
		<br>
		<div>
			<label for="email">이메일*</label><br>
			<input type="text" name="email" id="email" value="${contact.email}">
		</div>
		<br>
		<div>
			<label for="note">비고</label><br>
			<input type="text" name="note" id="note" value="${contact.note}">
		</div>
		<br>
		<input type="button" value="수정하기" id="btn_modify">
		<input type="button" value="삭제하기" id="btn_delete">
		<input type="button" value="전체연락처" id="btn_list">
	</form>

</body>
</html>