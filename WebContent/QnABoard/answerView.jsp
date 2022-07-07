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
<link href="${conPath }/css/freeboard.css" rel="stylesheet">
<link href="${conPath }/js/jqueryui/jquery-ui.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css"> -->
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="${conPath }/js/jqueryui/jquery-ui.js"></script>


</head>
<body>
	<jsp:include page="../main/header.jsp"></jsp:include>
	<div id="wrap">
		<div id="sub_content">
			<div class="bonmun">
				<div id="content">
					<!-- 타이틀 -->

					<div class="title_area">
						<div class="info_title">
							<h2 class="tit">${qnum }번글 답변</h2>
						</div>
					</div>
					<!-- 게시판 -->
					
						<div class="freeboard">

							<div id="accordion">
								<c:if test="${answerView.size() != 0  }">
									<c:forEach var="answer" items="${answerView }">

										<div>
											<h4>A : ${answer.qsubject }</h4>
											<div>${answer.qcontent }</div>
											
											
										
										</div>

									</c:forEach>
								</c:if>
							</div>
							<!-- <div id="append"></div> -->




							<div id="paging">
								<div class="pagenum">
									<c:if test="${pageNum > 1}">
										<div class="number">
											<a href="${conPath }/qnaList.do?pageNum=${pageNum-1 }"><</a>
										</div>
									</c:if>
									<c:if test="${pageNum <= 1}">
										<div class="number"><</div>
									</c:if>

									<c:forEach var="i" begin="${startPage }" end="${endPage }">
										<div class="number">
											<a href="${conPath }/qnaList.do?pageNum=${i }">${i }</a>
										</div>
									</c:forEach>

									<c:if test="${pageNum < endPage}">
										<div class="number">
											<a href="${conPath }/qnaList.do?pageNum=${pageNum+1 }">></a>
										</div>
									</c:if>
									<c:if test="${pageNum >= endPage}">
										<div class="number">></div>
									</c:if>

								</div>
							
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	

	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>