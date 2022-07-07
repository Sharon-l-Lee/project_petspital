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
<link href="${conPath }/css/myboard.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../main/header.jsp"></jsp:include>
	<div id="wrap">
		<div id="content">
			<div class="container">
				<div class="mypage">
					<div class="mypage_nav">
						<ul class="subnav">
							<li><a href="${conPath }/myModifyView.do" class="menu">내
									정보</a></li>
							<li><a href="#" class="menu">게시글 관리</a>
								<ul class="subm">
									<li><a href="${conPath }/myFboardList.do" class="submenu">자유게시판</a></li>
									<li><a href="#" class="submenu">QNA</a></li>
								</ul></li>
							<li><a href="${conPath }/myBmarkList.do" class="menu">북마크
									보기</a></li>
							<li><a href="${conPath }/mWithdrawal.do" class="menu">회원
									탈퇴</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div id="sub_content">
				<div id="bonmun">
					
						<!-- 타이틀 -->

						<div class="title_area">
							<div class="info_title">
								<h2 class="tit">내 북마크</h2>
							</div>
							<p class="tcol">내 북마크를 볼 수 있습니다</p>
						</div>
						<!-- 게시판 -->

						<div class="freeboard">
							<table>
								<thead>
									<tr id="tabletitle">
										<th class="th_title"><span>번호</span></th>
										<th class="th_title"><span>제목</span></th>
										<th class="th_date">작성일</th>
										<th class="num">북마크 해제</th>
									</tr>
								</thead>
								<tbody>
									<c:if test="${bMarkVeiw.size() != 0  }">
										<c:forEach var="mybmark" items="${bMarkVeiw }">
											<tr>
												<td class="boardcontent">${mybmark.rnum }</td>
												<td class="boardcontent">
													<div class="boardtitle">
														<div>
															<a
																href="${conPath }/hBoardContent.do?rnum=${mybmark.rnum }&pageNum=${pageNum }">${mybmark.rsubject }
															</a>

														</div>
													</div>
												</td>

												<td class="boardcontent">${mybmark.rrdate }</td>
												<td class="boardcontent">

													<button
														onclick="location.href='${conPath}/hBookmarkOut.do?rnum=${mybmark.rnum }'">해제</button>
												</td>

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
									<c:if test="${pageNum > 1}">
										<div class="number">
											<a href="${conPath }/freeBoardList.do?pageNum=${pageNum-1 }"><</a>
										</div>
									</c:if>
									<c:if test="${pageNum <= 1}">
										<div class="number"><</div>
									</c:if>

									<c:forEach var="i" begin="${startPage }" end="${endPage }">
										<div class="number">
											<a href="${conPath }/freeBoardList.do?pageNum=${i }">${i }</a>
										</div>
									</c:forEach>

									<c:if test="${pageNum < endPage}">
										<div class="number">
											<a href="${conPath }/freeBoardList.do?pageNum=${pageNum+1 }">></a>
										</div>
									</c:if>
									<c:if test="${pageNum >= endPage}">
										<div class="number">></div>
									</c:if>

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