<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<jsp:include page="../layout/header.jsp">
	<jsp:param value="${blog.blogNo}번 수정" name="title"/>
</jsp:include>
<script>
function getContextPath() {
	var begin = location.href.indexOf(location.origin) + location.origin.length;
	var end = location.href.indexOf("/", begin + 1);
	return location.href.substring(begin, end);
}

$(document).ready(function() {
	
	console.log(getContextPath());
	
	$('#content').summernote({
		width: 800,
		height: 400,
		lang: 'ko-KR',
		toolbar: [
		    // [groupName, [list of button]]
		    ['style', ['bold', 'italic', 'underline', 'clear']],
		    ['font', ['strikethrough', 'superscript', 'subscript']],
		    ['fontsize', ['fontsize']],
		    ['color', ['color']],
		    ['para', ['ul', 'ol', 'paragraph']],
		    ['height', ['height']],
		    ['insert', ['link', 'picture', 'video']]
		]
	
	});
</script>


	<h1>${blog.title}</h1>
	
	
	<div>
		<h1>수정 화면</h1>
		<form id="frm_modify" method="post" action="${contextPath}/'blog/detail" method="post">
			<div>
				<label for="title">제목</label>
				<input type="text" name="title" id="title" value="${blog.title}">
			</div>
			<div>
				<label for="content">내용</label>
				<textarea id="content" name="content" id="content"></textarea>
			</div>
			<div>
				<button>작성완료</button>
				<input type="reset" value="입력초기화">
				<input type="button" value="목록" id="btn_list">
			</div>
		</form>
	</div>
		
			<input type="button" value="수정" id="btn_edit_blog">
		<script>
			$('#btn_edit_blog').click(function() {
				$('#frm_btn').attr('action', '${contextPath}/blog/edit');
				$('#frm_btn').submit();
			});
		</script>
		</form>
	</div>
	
</body>
</html>