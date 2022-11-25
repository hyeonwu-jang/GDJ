<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>
<script>
	
	$(document).ready(function(){
		
		fn_list();
		fn_query();
		
		function fn_list() {
			$('#list').empty();
			$.ajax({
				type: 'get',
				url: '${contextPath}/searchAllMovies',
				
				dataType: 'json',
				success: function(resData) {
					if(resData.status == 200) {
						alert(resData.message);
						$.each(resData.list, function(i, movie){
							$('#list')
							.append( $('<tr>'))
							.append( $('<td>').html(movie.title))
							.append( $('<td>').html(movie.genre))
							.append( $('<td>').html(movie.description))
							.append( $('<td>').html(movie.star));
						}); 
					}
				}
			});
		
		}
		
		function fn_query() {
			$('#btn_search').click(function() {
				$('#list').empty();
				$.ajax({
					
					type: 'get',
					url: '${contextPath}/searchMovie',
					data: 'column=' + $('#column').val() + '&searchText=' + $('#searchText').val(),
					
					dataType: 'json',
					success: function(resData) {
						if(resData.status == 200) {
							alert(resData.message);
							$.each(resData.list, function(i, movie){
								$('#list')
								.append( $('<tr>'))
								.append( $('<td>').html(movie.title))
								.append( $('<td>').html(movie.genre))
								.append( $('<td>').html(movie.description))
								.append( $('<td>').html(movie.star));
							}); 
						} 
						
						else {
							alert(resData.message);
							$('#list')
							.append( $('<tr>'))
							.append( $('<td colspan="4">').text('검색결과가 없습니다'));
						}
					}
				});
			});
		}
		
		function fn_reset() {
			fn_list();
		}
		
		
	});
	
</script>
</head>
<body>

	<div>
	
		<form id="frm_search">
			
			<select id="column" name="column">
				<option value="TITLE">제목</option>
				<option value="GENRE">장르</option>
				<option value="DESCRIPTION">내용</option>
			</select>
			<input type="text" id="searchText" name="searchText">
			<input type="button" id="btn_search" value="검색">
			<input type="button" id="btn_init" value="초기화" onclick="location.href='${contextPath}'">
			
			<br><hr><br>
			
			<table border="1">
				<thead>
					<tr>
						<td>제목</td>
						<td>장르</td>
						<td>내용</td>
						<td>평점</td>
					</tr>
				</thead>
				<tbody id="list"></tbody>
			</table>
			
		</form>
		
	</div>

</body>
</html>