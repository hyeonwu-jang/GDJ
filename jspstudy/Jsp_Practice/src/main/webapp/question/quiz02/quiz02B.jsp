<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page errorPage="quiz02_error.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		request.setCharacterEncoding("UTF-8");
		int ipt_age = request.getParameter("ipt_age").isEmpty() ? 0 : Integer.parseInt(request.getParameter("ipt_age"));
		
		Map<String, String> map = new HashMap<>();
		
		if(ipt_age < 20) {
			map.put("result1", "미성년자");
			map.put("result2", "불가능");
		} else {
			map.put("result1", "성인");
			map.put("result2", "가능");
		}
		
		request.setAttribute("map", map);
		request.getRequestDispatcher("quiz02C.jsp").forward(request, response);
		
	%>

	
	
	
</body>
</html>
    
