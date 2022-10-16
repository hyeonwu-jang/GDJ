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
		String fileName = request.getParameter("fileName");
		String realPath = request.getServletContext().getRealPath("storage");
		File file = new File(realPath, fileName);
		if(file.exists()) {
			file.delete();
		}
		
		boolean fileExist = file.exists();
	%>
	<script>
		if(<%=fileExist%>) {
			alert('파일이 삭제되지 않았습니다.');
			history.back();
		} else {
			alert('파일이 삭제되었습니다. 탈퇴 완료');
			location.href = "quiz05_A.jsp";
		}
	</script>

</body>
</html>