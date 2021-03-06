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
</head>
<body>


<div id="wrap">
		<div id="sub_content">
			<div class="bonmun">
				<div id="content">
					<!-- 타이틀 -->

					<div class="title_area">
						<div class="info_title">
							<h2 class="tit">병원 검색</h2>
						</div>
						<p class="tcol">동물별로 병원을 검색할 수 있습니다</p>
					</div>
					<!-- 게시판 -->

					<button class="w_btn" onclick="location.href='${conPath }/freeBoardWriteView.do?pageNum=${pageNum }'">글쓰기</button>
					<div class="freeboard">
						<table>
							<thead>
								<tr id="tabletitle">
									<th class="num">No</th>
									<th class="th_title"><span>제목</span></th>
									<th class="th_name">작성자</th>
									<th class="th_date">작성일</th>
									<th class="num">조회수</th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${freeBoardView.size() != 0  }">
									<c:forEach var="fboard" items="${freeBoardView }">
										<tr>
											<td class="boardcontent">
												<div class="boardnum">
													<div>${fboard.fnum }</div>
												</div>
											</td>
											<td class="boardcontent">
												<div class="boardtitle">
													<div>
														<c:if test="${fboard.findent eq 0 }">
															<a href="${conPath }/freeBoardContent.do?fnum=${fboard.fnum }&pageNum=${pageNum }">${fboard.fsubject } </a>
														</c:if>
														<c:if test="${fboard.findent > 0 }">
															<img src="${conPath }/img/ar2.png" width="${(fboard.findent)*20 }"><a href="${conPath }/freeBoardContent.do?fnum=${fboard.fnum }&pageNum=${pageNum }">${fboard.fsubject } </a>
														</c:if>
													</div>
												</div>
											</td>
											<td class="boardcontent">
												<div class="boardwriter">
													<div>${fboard.mname }</div>
												</div>
											</td>
											<td class="boardcontent">${fboard.frdate }</td>
											<td class="boardcontent">${fboard.fhit }</td>

										</tr>
									</c:forEach>
								</c:if>
							</tbody>
						</table>




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
							<c:if test="${pageNum > 1}"><div class="number"><a href="${conPath }/freeBoardList.do?pageNum=${pageNum-1 }"><</a></div></c:if>
							<c:if test="${pageNum <= 1}"><div class="number"><</div></c:if>
								
								<c:forEach var="i" begin="${startPage }" end="${endPage }">
									<div class="number"><a href="${conPath }/freeBoardList.do?pageNum=${i }">${i }</a></div>
								</c:forEach>
								
							<c:if test="${pageNum < endPage}"><div class="number"><a href="${conPath }/freeBoardList.do?pageNum=${pageNum+1 }">></a></div></c:if>
							<c:if test="${pageNum >= endPage}"><div class="number">></div></c:if>

							</div>
							<%-- <div class="move">
								<c:if test="${pageCnt > endPage }">
										<div class="next"><a href="${conPath }/freeBoardList.do?pageNum=${endPage+1}">next</a></div>
								</c:if>
								<c:if test="${pageCnt <= endPage}">
										<div class="next">next</div>
								</c:if>
							</div> --%>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>

	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>