<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/find.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<div id="modify_comment">
		<form action="${conPath }/fbCommentModify.do">
			<textarea rows="3" cols="10" id="frcontent" class="frcontent"></textarea>
			<input type="submit" value="수정완료">
			<input type="reset" value="취소">
		<input type="hidden" name="frnum" class="frnum" value="${frnum }">	
		</form>
	</div>

</body>
</html>