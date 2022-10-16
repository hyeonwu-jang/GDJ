<%@page import="java.io.UnsupportedEncodingException"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%!
		public String getCookieValue(Cookie[] cookies, String cookieName) {
			String result = null;
			try {
				if(cookies != null && cookies.length != 0) {
					for(Cookie cookie : cookies) {
						if(cookie.getName().equals(cookieName)) {
							result = URLDecoder.decode(cookie.getValue(), "UTF-8");
						}
					}
				}
				
			} catch(UnsupportedEncodingException e) {
				
			}
			return result;
		}
	%>
	<% Cookie[] cookies = request.getCookies(); %>
	
	
	<h1>가입 내용</h1>
	<ul>
		<li>아이디 : <%=getCookieValue(cookies, "id") %></li>
		<li>비밀번호 : <%=getCookieValue(cookies, "pw") %></li>
		<li>성명 : <%=getCookieValue(cookies, "name") %></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
	</ul>
	
</body>
</html>