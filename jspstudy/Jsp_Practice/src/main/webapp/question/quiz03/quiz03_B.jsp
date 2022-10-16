<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	
	<form method="GET" action="quiz03_C.jsp">
		<h3>2. 좋아하는 운동선수는 누구인가요?</h3>
		<input type="text" name="fav_athlete">
		<input type="hidden" name="fav_talent"  value="<%=request.getParameter("fav_talent")%>">
		<input type="hidden" name="name"  value="<%=request.getParameter("name")%>">
		<button>결과보기</button>	
	</form>

</body>
</html>