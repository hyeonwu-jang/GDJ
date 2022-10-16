<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<% session.invalidate();%>
	
	<form action="quiz07_B.jsp">
		설문작성자<input type="text" name="name"><br>
		<h1>1. 좋아하는 연예인은 누구인가요?</h1>
		<input type="text" name="fav_talent">
		<button>다음</button>
	</form>

</body>
</html>