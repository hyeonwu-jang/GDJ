<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script>
$(document).ready(function(){
	$('#input').on('blur', function(){
		if ( isNaN($(this).val()) ) {  // $(this)는 $('#result')이다.
			alert('정수만 입력할 수 있습니다.');
			$(this).val('');
			$(this).focus();
		}
	});
})
</script>
</head>
<body>

	<%
		int random = ((int)(Math.random() * 10) + 1);
		int random2 = ((int)(Math.random() * 10) + 1);
		String[] operator = {"+", "-", "*", "/", "%"};
		String x = operator[((int)(Math.random() * 5))];
		
		int answer = 0;
		switch(x){
		case "+": answer = random + random2; break;
		case "-": answer = random - random2; break;
		case "*": answer = random * random2; break;
		case "/": answer = random / random2; break;
		case "%": answer = random % random2; break;
		}
	%>

	<h1>랜덤 계산기</h1>
	<form action="quiz04_B.jsp">
			<%=random%> <%=x%> <%=random2%> = 
			<input type="text" name="input" id="input">
			<input type="hidden" name="random" value="<%=random%>">
			<input type="hidden" name="random2" value="<%=random2%>">
			<input type="hidden" name="x" value="<%=x%>">
			<input type="hidden" name="answer" value="<%=answer%>">
			<button>제출</button>	
	</form>

</body>
</html>