<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%request.setCharacterEncoding("UTF-8"); %>
	
	<%session.setAttribute("fav_athlete", request.getParameter("fav_athlete")); %>
	
	<h1><%=session.getAttribute("name") %>님의 선호도 조사 결과</h1>
	<ul>
		<li>좋아하는 연예인 : <%=session.getAttribute("fav_talent") %></li>
		<li>좋아하는 운동선수 : <%=session.getAttribute("fav_athlete") %></li>
	</ul><br>
	<a href="quiz07_A.jsp">
		<input type="button" value="처음부터 다시하기">	
	</a>
</body>
</html>