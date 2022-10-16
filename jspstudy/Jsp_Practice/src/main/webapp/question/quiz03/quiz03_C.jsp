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
	<h3><%=request.getParameter("name")%>님의 선호도 조사 결과</h3>
	<ul>
		<li>좋아하는 연예인: <%=request.getParameter("fav_talent")%></li>
		<li>좋아하는 운동선수: <%=request.getParameter("fav_athlete")%></li>
	</ul>
	<a href="quiz03_A.jsp">
		<input type="button" value="처음부터 다시하기">	
	</a>
	
</body>
</html>