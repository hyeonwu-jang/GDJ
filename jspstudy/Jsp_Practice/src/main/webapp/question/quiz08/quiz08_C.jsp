<%@page import="java.io.BufferedWriter"%>
<%@page import="java.io.FileWriter"%>
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

	<% request.setCharacterEncoding("UTF-8"); 
		String chk = request.getParameter("chk");
		
		if(chk.equals("yes")) {
			String id = (String)session.getAttribute("id");
			String pw = (String)session.getAttribute("pw");
			String name = (String)session.getAttribute("name");
			
			String realPath = request.getServletContext().getRealPath("storage");
			String fileName = id + ".txt";
			File file = new File(realPath, fileName);
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write("가입 아이디 : " + id); bw.newLine();				
			bw.write("가입 아이디 : " + pw); bw.newLine();				
			bw.write("가입 아이디 : " + name); bw.newLine();
			bw.flush();
			if(bw != null) {
				bw.close();
			}
			session.setAttribute("fileName", fileName);
			response.sendRedirect("quiz08_D.jsp");
		} else
	%>
	
	<%  { %>
			<h1>가입되지 않았습니다.</h1>
			<a href="quiz08_A.jsp">다시 가입하기</a>
	<% 	} %>
	
	
</body>
</html>