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
	<!-- https://www.nirs.go.kr/ncia_MJS/board/dev/board/board.jsp?id=data_101 -->
	<div id="wrap">
		<div id="sub_content">
			<div class="sub_menu"></div>
			<div id="sub_content_area">
				<div class="sub_content">

					<div class="bonmun">
						<div id="content">
							<div id="sub_title">
								<div class="title_area">
									<div class="info_title">
										<h2 class="tit">자유게시판</h2>
									</div>
									<p class="tcol">자유게시판 입니다</p>
								</div>
								<div class="rspace"></div>
							</div>
							<div class="article-board">
								<table>
									<thead>
										<tr id="normalTableTitle">
											<th></th>
											<th ><span class="article_title">제목</span></th>
											<th class="th_name">작성자</th>
											<th>작성일</th>
											<th>조회</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td colspan="2" class="td_article">
												<div class="board-number">
													<div class="inner_number">47601</div>
												</div>
												<div class="board-list">
													<div class="inner_list">
														<a class="article"
															href="/ArticleRead.nhn?clubid=19039057&amp;page=1&amp;menuid=340&amp;boardtype=L&amp;articleid=47601&amp;referrerAllArticles=false"
															onclick="clickcr(this, 'gnr.title','','',event);">

															정보처리산업기사 리뷰 참여 </a> <span class="list-i-img"><i
															class="blind">사진</i></span> <span class="list-i-link"><i
															class="blind">링크</i></span>

													</div>
												</div>
											</td>
											<td class="td_name">
												<div class="pers_nick_area">
													<table role="presentation" cellspacing="0">
														<tbody>
															<tr>
																<td class="p-nick"><a href="#" class="m-tcol-c"
																	onclick="ui(event, 'ccRwRTTSjtvWIP4Mz_jFPQ',3,'심심한잉여','19039057','me', 'false', 'true', 'yjbooks', 'false', '340'); return false;">심심한잉여</a><span
																	class="mem-level"><img
																		src="https://cafe.pstatic.net/levelicon/1/13_110.gif"
																		width="11" height="11"></span></td>
															</tr>
														</tbody>
													</table>
												</div> <script type="text/javascript">
													wordBreak($("article_xhslqk2003_0"));
												</script>
											</td>
											<td class="td_date">2022.06.21.</td>
											<td class="td_view">5</td>

											<td class="td_likes">0</td>

										</tr>
									</tbody>
								</table>

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