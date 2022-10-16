<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src=></script>
</head>
<body>
		
		<%
			request.setCharacterEncoding("UTF-8");
		%>
		
		<h3>이용약관</h3>
		---------------------------------------<br>
		1. 회원정보는 웹사이트 운영을 위해서만 사용<br>
		2. 원치않으면 정보제공 x<br>
		3. 다만 이 경우 정상적인 웹사이트 이용제한<br>
		---------------------------------------<br>
	<form action="quiz05_C.jsp">
		위 약관에 동의합니까?<br><br>
		동의함<input type="radio" name="chk" value="yes">
		동의 안 함<input type="radio" name="chk" value="no">
		<input type="hidden" name="id" value="<%=request.getParameter("id")%>"><br>
		<input type="hidden" name="pw" value="<%=request.getParameter("pw")%>"><br>
		<input type="hidden" name="name" value="<%=request.getParameter("name")%>"><br>
		<button>회원가입</button>
	</form>

</body>
</html>