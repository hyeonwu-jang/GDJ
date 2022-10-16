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

	
	
	
	<%	if(request.getParameter("answer").equals(request.getParameter("input"))) { %>
		<%=request.getParameter("random")%> <%=request.getParameter("x")%> <%=request.getParameter("random2")%> = <%=request.getParameter("input") %><br>
		정답입니다.
	<% } else { %>	
		제출: <%=request.getParameter("random")%> <%=request.getParameter("x")%> <%=request.getParameter("random2") %> = <%=request.getParameter("input") %><br>
		정답: <%=request.getParameter("random")%> <%=request.getParameter("x")%> <%=request.getParameter("random2") %> = <%=request.getParameter("answer") %>
	<% } %>
	<br><br>
	<a href="quiz04_A.jsp">다시풀기</a>

</body>
</html>