<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		요청을 처리하는 과정에서 오류가 발생했습니다.
		오류명 : <%=exception.getClass().getName()%>
		오류 메시지 :  <%=exception.getMessage()%>
		<a href="mailto:jhw3603@naver.com">오류 메일 보내기</a>
		<a href="quiz02A.jsp">처음으로 가기</a>
	</div>
</body>
</html>