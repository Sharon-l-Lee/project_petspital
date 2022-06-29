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
<link href="../css/find.css" rel="stylesheet">
<link
	href="https://hangeul.pstatic.net/hangeul_static/css/nanum-square-round.css"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="../main/header.jsp"></jsp:include>
	<div id="wrap">
		<div id="background"></div>
		<div id="search_menu">
			<ul>
				<li class="c_change"><a href="#">반려견</a></li>
				<li class="c_change"><a href="#">반려묘</a></li>
				<li class="c_change"><a href="#">기타 동물</a></li>
			</ul>

		</div>
		<div class="info">
			<p>자주 보이는 질환</p>
		</div>
		<div class="content">
			<ul class="content_box">
				<li class="box_3">
					<dl class="search_list">
						<dt class="title">#눈 이상</dt>
						<dd class="name">
							<a href="#">눈꺼풀이 벌겋게 붓는다</a>
						</dd>
						<dd class="name">
							<a href="#">눈을 자주 찌푸린다</a>
						</dd>
						<dd class="name">
							<a href="#">눈물을 많이 흘린다</a>
						</dd>
						<dd class="name">
							<a href="#">눈이 충혈된다</a>
						</dd>

					</dl>
				</li>
				<li class="box_3">
					<dl class="search_list">
						<dt class="title">#행동 이상</dt>
						<dd class="name">
							<a href="#">기지개를 자주 켠다</a>
						</dd>
						<dd class="name">
							<a href="#">특정 부위를 계속해서 핥는다</a>
						</dd>
						<dd class="name">
							<a href="#">한 방향으로 빙빙 돈다</a>
						</dd>
						<dd class="name">
							<a href="#">사물에 자주 부딪힌다</a>
						</dd>
						<dd class="name">
							<a href="#">산책을 나가기 싫어한다</a>
						</dd>
						<dd class="name">
							<a href="#">기력이 없다</a>
						</dd>

					</dl>
				</li>
				<li class="box_3">
					<dl class="search_list">
						<dt class="title">#코 이상</dt>
						<dd class="name">
							<a href="#">콧물을 많이 흘린다</a>
						</dd>
						<dd class="name">
							<a href="#">코피가 난다</a>
						</dd>
						<dd class="name">
							<a href="#">콧물, 재채기가 난다</a>
						</dd>
						<dd class="name">
							<a href="#">코를 곤다</a>
						</dd>
						<dd class="name">
							<a href="#">입안이나 코에서 출혈</a>
						</dd>

					</dl>
				</li>
					<li class="box_3">
					<dl class="search_list">
						<dt class="title">#코 이상</dt>
						<dd class="name">
							<a href="#">콧물을 많이 흘린다</a>
						</dd>
						<dd class="name">
							<a href="#">코피가 난다</a>
						</dd>
						<dd class="name">
							<a href="#">콧물, 재채기가 난다</a>
						</dd>
						<dd class="name">
							<a href="#">코를 곤다</a>
						</dd>
						<dd class="name">
							<a href="#">입안이나 코에서 출혈</a>
						</dd>

					</dl>
				</li>
				<li class="box_3">
					<dl class="search_list">
						<dt class="title">#코 이상</dt>
						<dd class="name">
							<a href="#">콧물을 많이 흘린다</a>
						</dd>
						<dd class="name">
							<a href="#">코피가 난다</a>
						</dd>
						<dd class="name">
							<a href="#">콧물, 재채기가 난다</a>
						</dd>
						<dd class="name">
							<a href="#">코를 곤다</a>
						</dd>
						<dd class="name">
							<a href="#">입안이나 코에서 출혈</a>
						</dd>

					</dl>
				</li>
				<li class="box_3">
					<dl class="search_list">
						<dt class="title">#코 이상</dt>
						<dd class="name">
							<a href="#">콧물을 많이 흘린다</a>
						</dd>
						<dd class="name">
							<a href="#">코피가 난다</a>
						</dd>
						<dd class="name">
							<a href="#">콧물, 재채기가 난다</a>
						</dd>
						<dd class="name">
							<a href="#">코를 곤다</a>
						</dd>
						<dd class="name">
							<a href="#">입안이나 코에서 출혈</a>
						</dd>

					</dl>
				</li>
				<li class="box_3">
					<dl class="search_list">
						<dt class="title">#코 이상</dt>
						<dd class="name">
							<a href="#">콧물을 많이 흘린다</a>
						</dd>
						<dd class="name">
							<a href="#">코피가 난다</a>
						</dd>
						<dd class="name">
							<a href="#">콧물, 재채기가 난다</a>
						</dd>
						<dd class="name">
							<a href="#">코를 곤다</a>
						</dd>
						<dd class="name">
							<a href="#">입안이나 코에서 출혈</a>
						</dd>

					</dl>
				</li>
			</ul>
			

		</div>
	</div>
	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>