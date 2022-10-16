<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% request.setCharacterEncoding("UTF-8");
		session.setAttribute("id", request.getParameter("id"));
		session.setAttribute("pw", request.getParameter("pw"));
		session.setAttribute("name", request.getParameter("name"));
	%>
	<h1>이용약관</h1>
	aa<br>
	bb<br>
	cc<br>
	위 약관에 도으이?
	<form action="quiz08_C.jsp">
		<input type="radio" name="chk" value="yes">동의함
		<input type="radio" name="chk" value="no">동의안함
		<button>회원가입</button>
	</form>
	
</body>
</html>