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
<link href="${conPath }/css/board_.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../main/header.jsp"></jsp:include>


	<div id="wrap">
		<div class="question_container">
			<div class="question_area">
				<div class="q_title"></div>
				<div class="q_content"></div>
			</div>

		</div>

		<div class="answer_container">
			<div class="answer_area">
				<div class="answer_content" id="answer1">
					<div class="a_title"></div>
					<div class="a_content"></div>
				</div>
				<div class="answer_content" id="answer2">
					<div class="a_title"></div>
					<div class="a_content"></div>
				</div>
			</div>

		</div>

	</div>
	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>