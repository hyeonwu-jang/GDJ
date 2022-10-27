<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="<%=request.getContextPath()%>" />

<script>
	if (${param.res} > 0) {
		alert('게시글이 수정되었습니다.');
		location.href = '${contextPath}/list.do';
	} else {
		alert('게시글이 수정되지 않았습니다.');
		history.back();
	}
</script>