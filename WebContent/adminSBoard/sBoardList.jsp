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
<link
	href="https://hangeul.pstatic.net/hangeul_static/css/nanum-square-round.css"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="../main/header.jsp"></jsp:include>

	<div id="wrap">
		<div class="info">
			<p>자주 보이는 질환</p>
		</div>
		<c:if test="${not empty admin }">
			<button class="w_btn">글쓰기</button>
		</c:if>
		<div class="content">
			<ul class="content_box">
				<li class="box_3">
					<dl class="search_list">
						<dt class="title">#눈 이상</dt>
						<hr>
						<c:forEach var="i" items="${sblist }">
							<c:if test="${i.scategoryid eq 1 }">
								<dd class="name">
									<a href="${conPath }/sBoardContent.let?snum=${i.snum } ">${i.ssubject}</a>
								</dd>
							</c:if>
						</c:forEach>
					</dl>
				</li>
				<li class="box_3">
					<dl class="search_list">
						<dt class="title">#코 이상</dt>
						<hr>
						<c:forEach var="i" items="${sblist }">
							<c:if test="${i.scategoryid eq 2 }">
								<dd class="name">
									<a href="${conPath }/sBoardContent.let?snum=${i.snum } ">${i.ssubject}</a>
								</dd>
							</c:if>
						</c:forEach>

					</dl>
				</li>
				<li class="box_3">
					<dl class="search_list">
						<dt class="title">#입 이상</dt>
						<hr>
						<c:forEach var="i" items="${sblist }">
							<c:if test="${i.scategoryid eq 3 }">
								<dd class="name">
									<a href="${conPath }/sBoardContent.let?snum=${i.snum } ">${i.ssubject}</a>
								</dd>
							</c:if>
						</c:forEach>

					</dl>
				</li>
				<li class="box_3">
					<dl class="search_list">
						<dt class="title">#귀 이상</dt>
						<hr>
						<c:forEach var="i" items="${sblist }">
							<c:if test="${i.scategoryid eq 4 }">
								<dd class="name">
									<a href="${conPath }/sBoardContent.let?snum=${i.snum } ">${i.ssubject}</a>
								</dd>
							</c:if>
						</c:forEach>

					</dl>
				</li>
				<li class="box_3">
					<dl class="search_list">
						<dt class="title">#피부 이상</dt>
						<hr>
						<c:forEach var="i" items="${sblist }">
							<c:if test="${i.scategoryid eq 5 }">
								<dd class="name">
									<a href="${conPath }/sBoardContent.let?snum=${i.snum } ">${i.ssubject}</a>
								</dd>
							</c:if>
						</c:forEach>

					</dl>
				</li>
				<li class="box_3">
					<dl class="search_list">
						<dt class="title">#구강 이상</dt>
						<hr>
						<c:forEach var="i" items="${sblist }">
							<c:if test="${i.scategoryid eq 6 }">
								<dd class="name">
									<a href="${conPath }/sBoardContent.let?snum=${i.snum } ">${i.ssubject}</a>
								</dd>
							</c:if>
						</c:forEach>

					</dl>
				</li>
				<li class="box_3">
					<dl class="search_list">
						<dt class="title">#다리 이상</dt>
						<hr>
						<c:forEach var="i" items="${sblist }">
							<c:if test="${i.scategoryid eq 7 }">
								<dd class="name">
									<a href="${conPath }/sBoardContent.let?snum=${i.snum } ">${i.ssubject}</a>
								</dd>
							</c:if>
						</c:forEach>

					</dl>
				</li>
				<li class="box_3">
					<dl class="search_list">
						<dt class="title">#숨소리 이상</dt>
						<hr>
						<c:forEach var="i" items="${sblist }">
							<c:if test="${i.scategoryid eq 8 }">
								<dd class="name">
									<a href="${conPath }/sBoardContent.let?snum=${i.snum } ">${i.ssubject}</a>
								</dd>
							</c:if>
						</c:forEach>

					</dl>
				</li>
				<li class="box_3">
					<dl class="search_list">
						<dt class="title">#행동 이상</dt>
						<hr>
						<c:forEach var="i" items="${sblist }">
							<c:if test="${i.scategoryid eq 9 }">
								<dd class="name">
									<a href="${conPath }/sBoardContent.let?snum=${i.snum } ">${i.ssubject}</a>
								</dd>
							</c:if>
						</c:forEach>

					</dl>
				</li>
				<li class="box_3">
					<dl class="search_list">
						<dt class="title">#음식섭취 문제</dt>
						<hr>
						<c:forEach var="i" items="${sblist }">
							<c:if test="${i.scategoryid eq 10 }">
								<dd class="name">
									<a href="${conPath }/sBoardContent.let?snum=${i.snum } ">${i.ssubject}</a>
								</dd>
							</c:if>
						</c:forEach>

					</dl>
				</li>
				<li class="box_3">
					<dl class="search_list">
						<dt class="title">#소화기 이상</dt>
						<hr>
						<c:forEach var="i" items="${sblist }">
							<c:if test="${i.scategoryid eq 11 }">
								<dd class="name">
									<a href="${conPath }/sBoardContent.let?snum=${i.snum } ">${i.ssubject}</a>
								</dd>
							</c:if>
						</c:forEach>

					</dl>
				</li>

			</ul>


		</div>
	</div>
	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>