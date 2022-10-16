<%@page import="java.io.FileWriter"%>
<%@page import="java.io.BufferedWriter"%>
<%@page import="java.io.File"%>
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
		String chk = request.getParameter("chk");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
	%>
		
	<% if(chk.equals("yes")) { 
		String fileName = id + ".txt";
		String realPath = request.getServletContext().getRealPath("storage");
		
		File dir = new File(realPath);
		if(dir.exists() == false) {
			dir.mkdirs();
		}
	
		File file = new File(dir, fileName);
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		bw.write("가입 아이디 : " + id); bw.newLine();
		bw.write("가입 비밀번호 : " + pw); bw.newLine();
		bw.write("가입 성명 : " + name);
		bw.flush();
		if(bw != null) {
			bw.close();
		}
		
		response.sendRedirect("quiz05_D.jsp?fileName=" + fileName);
	%>	
		
		
	<%  } else {%>	
		<h1>가입되지 않았습니다.</h1>
		<a href="quiz05_A.jsp">다시 가입하기</a>	
	<%  } %>	
		
		
	
</body>
</html>