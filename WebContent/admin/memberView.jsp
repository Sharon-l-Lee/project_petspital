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
<link href="${conPath }/css/memberview.css" rel="stylesheet">
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
							<h2 class="tit">멤버 목록</h2>
						</div>
						<p class="tcol">가입한 사람의 정보를 보거나 회원 등급을 조정할 수 있습니다</p>
					</div>
					
					<!-- 게시판 -->

					<div class="freeboard">
						<table>
							<thead>
								<tr id="tabletitle">
									<th class="th_title"><span>아이디</span></th>
									<th class="th_name">이름</th>
									<th class="birth">생일</th>
									<th class="th_email">이메일</th>
									<th class="th_phone">핸드폰</th>
									<th class="th_date">가입일</th>
									<th class="th_grade">등급</th>
									<th class="th_grade">등급 조정</th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${MemberView.size() != 0  }">
									<c:forEach var="mview" items="${MemberView }">
										<tr>
											<td class="boardcontent">
												<div class="boardnum">
													<div>${mview.mid }</div>
												</div>
											</td>
											<td class="boardcontent">
												<div class="boardname">
													<div>
														<a href="${conPath }/freeBoardContent.do?fnum=${fboard.fnum }&pageNum=${pageNum }">${mview.mname} </a>
													
													</div>
												</div>
											</td>
											<td class="boardcontent">
												<div class="boardwriter">
													<div>${mview.mbirth }</div>
												</div>
											</td>
											<td class="boardcontent">${mview.memail }</td>
											<td class="boardcontent">${mview.mphone }</td>
											<td class="boardcontent">${mview.mrdate }</td>
											<td class="boardcontent">${mview.mgrade }
												
											</td>
											<td class="boardcontent">
											
												<c:if test="${mview.mgrade eq 1 }">
													<button onclick="location.href='${conPath }/memberGradeUp.let?mid=${mview.mid }'">등급 업</button>
												</c:if>
												<c:if test="${mview.mgrade eq 2 }">
													<button onclick="location.href='${conPath }/memberGradeDown.let?mid=${mview.mid }'">등급 다운</button>
												</c:if>
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