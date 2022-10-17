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

	<%-- 너비/높이 입력 폼 : 삼각형 버튼, 사각형 버튼 --%>
	
	<form id="f">
		<div>
			너비<input type="text" name="a"><br>
			높이<input type="text" name="b"><br>
		</div>
		<div>
			<input type="button" value="삼각형 넓이 보기" onclick="fn_triangle()">
			<input type="button" value="사각형 넓이 보기" onclick="fn_rectangle()">		
		</div>
	</form>
	
	<hr>
	
	<%-- 반지름 입력 폼 : 원 버튼 --%>
	<form action="${contextPath}/circle.do">
		반지름<input type="text" name="r"><br>
		<button>원 넓이 보기</button>
	</form>

	<script>
		function fn_rectangle() {
			var f = document.getElementById('f');
			f.action = '${contextPath}/rectangle.do';
			f.submit();
		}
		
		function fn_triangle() {
			var f = document.getElementById('f');
			f.action = '${contextPath}/triangle.do';
			f.submit();
		}
	</script>


</body>
</html>