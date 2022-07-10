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
<link href="${conPath }/css/sbcontent.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<jsp:include page="../main/header.jsp"></jsp:include>
	<div id="wrap">

		<article id="content">
			<section id="header">
				<header>
					<h2 class="boardname">${slistcon.ssubject }</h2>
				</header>
			</section>

			<!-- 본문 -->
			<section id="info">
				<p class="info_p">
					<span>${slistcon.scontent } </span>
				</p>

			</section>
			<div class="fboard_btn">
				<c:if test="${not empty admin }">
					<button
						onclick="location.href='${conPath }/sBoardModifyView.let?snum=${param.snum }'">수정</button>
					<button
						onclick="location.href='${conPath }/sBoardDelete.let?snum=${param.snum }'">삭제</button>
				</c:if>
				<button onclick="location.href='${conPath }/sBoardList.let'">글목록</button>
			</div>



		</article>


	</div>
	<jsp:include page="../main/footer.jsp" />


</body>
</html>