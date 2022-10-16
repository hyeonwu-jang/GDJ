<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% request.setCharacterEncoding("UTF-8"); %>
	<% session.setAttribute("name", request.getParameter("name")); 
	   session.setAttribute("fav_talent", request.getParameter("fav_talent")); %>
	
	<h1>좋아하는 운동선수는 누구인가여??</h1>
	<form action="quiz07_C.jsp">
		<input type="text"	name="fav_athlete">		
		<button>결과보기</button>
	</form>
	
</body>
</html>