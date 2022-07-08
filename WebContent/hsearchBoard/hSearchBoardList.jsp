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
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function() {
		$('#rcategoryname').change(function() {
			var cname = $(this).val();

			location.href = "hBoardList.do?rcategoryname=" + cname;

		});
	});

	function access() {
		alert('로그인 후 이용해주세요');
		location.href = "${conPath}/loginView.do";
	}
	function accessgrade() {

		alert('권한이 부족합니다');

	}
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
							<h2 class="tit">병원 목록</h2>
						</div>
						<p class="tcol">등록된 병원 목록입니다. 동물 별 병원 리스트 출력이 가능합니다.</p>
					</div>
					<!-- 게시판 -->
					<div class="freeboard_wrap">
						<c:if
							test="${not empty member && member.mgrade eq 2 || not empty admin  }">
							<button class="w_btn"
								onclick="location.href='${conPath }/hBoardWriteView.do?pageNum=${pageNum }'">글쓰기</button>
						</c:if>
						<c:if test="${empty admin && empty member }">
							<button class="w_btn" onclick="access();">글쓰기</button>
						</c:if>
						<c:if test="${not empty member && member.mgrade eq 1 }">
							<button class="w_btn" onclick="accessgrade();">글쓰기</button>
						</c:if>
						<div class="freeboard">
							<div>
								<select id="rcategoryname">
									<option value="default">동물선택</option>
									<c:forEach var="i" items="${rlist }">
										<option value="${i.rcategoryname }">${i.rcategoryname }</option>
									</c:forEach>

								</select>
							</div>
							<table>
								<thead>
									<tr id="tabletitle">
										<th class="num">NO</th>
										<th class="th_title"><span>제목</span></th>
										<th class="th_name">작성자</th>
										<th class="th_date">작성일</th>
										<th class="num">조회수</th>
									</tr>
								</thead>
								<tbody>
									<%-- 	<c:if test="${HboardView.size() != 0  && (rlist.categoryid != 0)}">
								
								</c:if> --%>
									<c:if test="${HboardView.size() eq 0  }">
										<tr>
											<td colspan="6" class="none">등록된 병원이 없습니다</td>
										</tr>
									</c:if>
									<c:if test="${HboardView.size() != 0  }">
										<c:forEach var="hboard" items="${HboardView }">
											<tr>
												<td class="boardcontent">
													<div class="boardnum">
														<div>${hboard.rnum }</div>
													</div>
												</td>
												<td class="boardcontent">
													<div class="boardtitle">
														<div>

															<c:if test="${not empty member || not empty admin}">
																<a
																	href="${conPath }/hBoardContent.do?rnum=${hboard.rnum }&pageNum=${pageNum }">${hboard.rsubject }
																</a>
															</c:if>
															<c:if test="${empty member && empty admin}">
																<a href="#" onclick="access();">${hboard.rsubject }</a>

															</c:if>

														</div>
													</div>
												</td>
												<td class="boardcontent">
													<div class="boardwriter">
														<div>${hboard.mname }</div>
													</div>
												</td>
												<td class="boardcontent">${hboard.rrdate }</td>
												<td class="boardcontent">${hboard.rhit }</td>

											</tr>
										</c:forEach>
									</c:if>
								</tbody>
							</table>




							<div id="paging">
								<	<div class="move">
								<c:if test="${startPage > BLOCKSIZE}">
										<div class="prev"><a href="${conPath }/freeBoardList.do?pageNum=${startPage-1}">prev</a></div>
								</c:if>
								<c:if test="${startPage <= BLOCKSIZE}">
										<div class="prev">prev</div>
								</c:if>
							</div>


								<div class="pagenum">
									<c:if test="${pageNum > 1}">
										<div class="number">
											<a href="${conPath }/hBoardList.do?pageNum=${pageNum-1 }"><</a>
										</div>
									</c:if>
									<c:if test="${pageNum <= 1}">
										<div class="number"><</div>
									</c:if>

									<c:forEach var="i" begin="${startPage }" end="${endPage }">
										<div class="number">
											<a href="${conPath }/hBoardList.do?pageNum=${i }">${i }</a>
										</div>
									</c:forEach>

									<c:if test="${pageNum < endPage}">
										<div class="number">
											<a href="${conPath }/hBoardList.do?pageNum=${pageNum+1 }">></a>
										</div>
									</c:if>
									<c:if test="${pageNum >= endPage}">
										<div class="number">></div>
									</c:if>

								</div>
								<div class="move">
								<c:if test="${pageCnt > endPage }">
										<div class="next"><a href="${conPath }/freeBoardList.do?pageNum=${endPage+1}">next</a></div>
								</c:if>
								<c:if test="${pageCnt <= endPage}">
										<div class="next">next</div>
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