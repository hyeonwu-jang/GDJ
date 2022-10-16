<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>
<body>
	
	<% request.setCharacterEncoding("UTF-8"); %>
	<%
		String fileName = (String)session.getAttribute("id") + ".txt";
		String realPath = request.getServletContext().getRealPath("storage");
	
		File file = new File(realPath, fileName);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = null;
		StringBuilder sb = new StringBuilder();
		while((line = br.readLine()) != null) {
			sb.append(line + "<br>");
		}
		if(br!=null) {
			br.close();
		}
	%>
	
	<h1>가입되었습니다.</h1>
	<h3>가입내용</h3>
	<%=sb.toString()%>
	<br><Br>
	<form action="quiz08_E.jsp" id="btn">
		<input type="hidden" name="fileName" value="<%=fileName%>">
		<input type="submit" value="탈퇴" > 
	</form>
 	
 	<script>
 		$('#btn').on('submit', function(event) {
 			if(confirm('탈퇴하시겠습니까?') == false) {
 				event.preventDefault();
 				return false;
 			} 
 			return true;
 		});
 	</script>
 	
</body>
</html>