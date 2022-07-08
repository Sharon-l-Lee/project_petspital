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
<link href="${conPath }/css/qnaview.css" rel="stylesheet">
<link href="${conPath }/js/jqueryui/jquery-ui.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css"> -->
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="${conPath }/js/jqueryui/jquery-ui.js"></script>
<script>
	$(function() {
		$("#accordion").accordion();
		var header = $("#accordion").accordion("option", "header");
		$("#accordion").accordion("option", "header", ".subj");

	});
</script>

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
							<h2 class="tit">QnA게시판</h2>
						</div>
						<p class="tcol">질문과 답변을 올릴 수 있습니다</p>
					</div>
					<!-- 게시판 -->
					<div class="freeboard_wrap">
						<c:if test="${not empty member }">
							<button class="w_btn"
								onclick="location.href='${conPath }/qWriteView.do?pageNum=${pageNum }'">글쓰기</button>
						</c:if>
						<div class="freeboard">

							<div id="accordion">
								<c:if test="${qnaList.size() != 0  }">
									<c:forEach var="qna" items="${qnaList }">

										<div class="subj">Q: ${qna.qsubject }</div>
										<div>
											<p>질문 내용 : ${qna.qcontent }</p>

											<c:if test="${not empty member || not empty admin }">
												<div class="re_btn">
													<button
														onclick="location.href='${conPath}/qWriteView.do?qgroup=${qna.qgroup }&qstep=${qna.qstep }&qindent=${qna.qindent }'"
														class="rebtn_style">답변하기</button>
													<button
														onclick="location.href='${conPath}/answerView.do?qgroup=${qna.qgroup }&qnum=${qna.qnum }'"
														class="rebtn_style">답변보기</button>

												</div>
											</c:if>
										</div>

									</c:forEach>
								</c:if>
							</div>
							<!-- <div id="append"></div> -->




							<div id="paging">
								<%-- 	<div class="move">
								<c:if test="${startPage > BLOCKSIZE}">
										<div class="prev"><a href="${conPath }/freeBoardList.do?pageNum=${startPage-1}">prev</a></div>
								</c:if>
								<c:if test="${startPage <= BLOCKSIZE}">
										<div class="prev">prev</div>
								</c:if>
							</div>
 --%>

								<div class="pagenum">
									<div class="move">
										<c:if test="${startPage > BLOCKSIZE }">
											<div class="prev">
												<a href="${conPath }/qnaList.do?pageNum=${startPage-1}">
													prev </a>
											</div>
										</c:if>
										<c:if test="${startPage <= BLOCKSIZE}">
											<div class="prev">prev</div>
										</c:if>
									</div>
									<c:if test="${pageNum > 1}">
										<div class="number">
											<a href="${conPath }/qnaList.do?pageNum=${pageNum-1 }"><</a>
										</div>
									</c:if>
									<c:if test="${pageNum <= 1}">
										<div class="number"><</div>
									</c:if>

									<c:forEach var="i" begin="${startPage }" end="${endPage }">

										<c:if test="${i == pageNum }">
											<div class="number">
												<b> ${i } </b>
											</div>
										</c:if>


										<c:if test="${i != pageNum }">
											<div class="number">
												<a href="${conPath }/qnaList.do?pageNum=${i }">${i }</a>
											</div>
										</c:if>

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
								<div class="move">

									<c:if test="${endPage<pageCnt }">
										<div class="next">
											<a href="${conPath }/qnaList.do?pageNum=${endPage+1}">next</a>
										</div>
									</c:if>
									<c:if test="${endPage>=pageCnt }">
										<div class="next">
											next
										</div>
									</c:if>

								</div>
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