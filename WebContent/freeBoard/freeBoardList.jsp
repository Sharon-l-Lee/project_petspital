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
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<script type="text/javascript">
	function access() {
		alert('로그인 후 이용해주세요');
		location.href = "${conPath}/loginView.do";
	}
/*
		function fbsearch() {
			var fsubject = $('.searchtext').val();
			$.ajax({
				// url : 요청경로
				// type : get방식 / post 방식
				// data : 요청 파라미터와 파라미터값
				// dataType : html/json/... 요청경로로 실행한 결과의 타입
				// success : 요청경로로 실행한 응답이 성공하였을 때 수행할 콜백함수
				// error :  요청경로로 실행한 응답이 실패되었을 때 수행할 콜백함수
					url : '${conPath }/fboardSearchList.do',
					type : 'post',
					data : "fsubejct="+fsubejct,
					dataType : 'html',
					success : function(data){
						$('#box').html(data);
					},
					error : function(code){
						alert(code.status);
					}
				}); 
		}*/
		/*	$(document).ready(function() {
		 $.ajax({
			// url : 요청경로
			// type : get방식 / post 방식
			// data : 요청 파라미터와 파라미터값
			// dataType : html/json/... 요청경로로 실행한 결과의 타입
			// success : 요청경로로 실행한 응답이 성공하였을 때 수행할 콜백함수
			// error :  요청경로로 실행한 응답이 실패되었을 때 수행할 콜백함수
				url : '${conPath }/fbCommentModifyView.do',
				type : 'post',
				data : "frnum="+frnum,
				dataType : 'html',
				success : function(data){
					$('#box').html(data);
				},
				error : function(code){
					alert(code.status);
				}
			}); 
	});*/

</script>
</head>
<body>
	<jsp:include page="../main/header.jsp"></jsp:include>
	<div id="wrap">
		<div id="content">
			<!-- 타이틀 -->

			<div class="title_area">
				<div class="info_title">
					<h2 class="tit">자유게시판</h2>
					<p class="tcol">자유롭게 글을 작성할 수 있습니다</p>
				</div>
			</div>
			<!-- 게시판 -->
			<div class="freeboard_wrap">
				<c:if test="${not empty member || not empty admin }">
					<button class="w_btn"
						onclick="location.href='${conPath }/noticeWriteView.let?pageNum=${pageNum }'">글쓰기</button>
				</c:if>
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
													<c:if test="${not empty member || not empty admin}">
														<c:if test="${fboard.findent eq 0 }">
															<a
																href="${conPath }/freeBoardContent.do?fnum=${fboard.fnum }&pageNum=${pageNum }">${fboard.fsubject }
															</a>
														</c:if>
														<c:if test="${fboard.findent > 0 }">
															<img src="${conPath }/img/ar2.png"
																width="${(fboard.findent)*20 }">
															<a
																href="${conPath }/freeBoardContent.do?fnum=${fboard.fnum }&pageNum=${pageNum }">${fboard.fsubject }
															</a>
														</c:if>
													</c:if>
													<c:if test="${empty member && empty admin}">
														<c:if test="${fboard.findent eq 0 }">
															<a href="#" onclick="access();">${fboard.fsubject } </a>
														</c:if>
														<c:if test="${fboard.findent > 0 }">
															<img src="${conPath }/img/ar2.png"
																width="${(fboard.findent)*20 }">
															<a href="#" onclick="access();">${fboard.fsubject } </a>
														</c:if>
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
				</div>



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

				<div id="search_area">
					<form action="">
						<input type="text" class="textbox" name="searchtext" value="${param.searchtext }">
						<input type="submit" value="검색" name="sbtn" style=width:25%;height:36px;border:0;background-color:#00A19D;color:#F9F7F7;>
					</form>
				</div>
			</div>
		</div>
	</div>



	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>