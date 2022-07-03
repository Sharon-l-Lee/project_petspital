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
<link href="${conPath }/css/mypage.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../main/header.jsp"></jsp:include>
	<div id="wrap">
		<div id="content">
			<div class="container">
				<div class="mypage">
					<div class="mypage_nav">
						<ul class="subnav">
							<li><a href="${conPath }/memberView.let" class="menu"><span>회원 정보 및 등급관리</span></a></li>
							<li><a href="#" class="menu"><span>관리자 글 관리</span></a>
								<ul class="subm">
<<<<<<< HEAD
									<li><a href="${conPath }/noticeWriteView.let" class="submenu">공지사항</a></li>
=======
									<li><a href="#" class="submenu">공지사항</a></li>
>>>>>>> 23d53bae7ade4f8311f8f0f8c6970d46fb0a8bba
									<li><a href="${conPath }/sBoardWriteView.let" class="submenu">증상 검색</a></li>
								</ul></li>
							<li><a href="#" class="menu"><span>게시글 관리</span></a>
								<ul class="subm">
									<li><a href="#" class="submenu">자유게시판</a></li>
									<li><a href="#" class="submenu">QNA</a></li>
								</ul></li>
					<!-- 		<li><a href="#" class="menu"><span>북마크 보기</span></a></li> -->
						</ul>
					</div>
					<div class="mypage_content">


						<div class="my_title">
							<h2>내 정보 보기</h2>
						</div>
						<div class="group">
							<div class="row">
								<div class="row_title">이름</div>
								<div class="row_cont">${admin.aname }</div>
							</div>

							<div class="row">
								<div class="row_title">아이디</div>
								<div class="row_cont">${admin.aid  }</div>
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