<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <meta charset="utf-8" name="viewport"
      content="width=device-width, initial-scale=1.0"/>
	 -->
<title>Insert title here</title>
<link href="${conPath }/css/headermain.css" rel="stylesheet">
</head>
<body>
	<header>
		<div id="top">
			<!-- 비로그인 헤더 -->
			<c:if test="${empty member && empty admin }">
				<ul>
					<li><a href='${conPath }/main.do'>HOME</a></li>
					<li><a href='${conPath }/loginView.do'>로그인</a></li>
					<li><a href='${conPath }/joinView.do'>회원가입</a></li>
				</ul>
			</c:if>
			<!-- 사용자 로그인 헤더 -->
			<c:if test="${not empty member }">
				<ul>
					<li><a href='${conPath }/main.do'>HOME</a></li>
					<li><a href='${conPath }/logout.do'>로그아웃</a></li>
					<li><a href='${conPath }/myView.do'>마이페이지</a></li>
					<li><a href='#'>${member.mname }님</a></li>
				</ul>
			</c:if>
			<!-- 관리자 로그인 헤더 -->
			<c:if test="${not empty admin }">
				<ul>
					<li><a href='${conPath }/main.do'>HOME</a></li>
					<li><a href='${conPath }/logout.do'>로그아웃</a></li>
					<li><a href='${conPath }/adminView.let'>관리자 페이지</a></li>
					<li><a href='#'>관리자님</a></li>
				</ul>
			</c:if>
		</div>
		<div id="gnb">
			<div class="nav">
			<div class="logo">
				<img src="${conPath }/img/logo_transp.png" width=100%>
			</div>
				<ul>
					<li><a href='${conPath }/freeBoardList.do'>자유게시판</a>
					<li><a href=''>Q&A</a>
						</li>
					<li><a href=''>동물병원 검색</a>
						<ul class="sub_nav">
							<li><a href='${conPath }/hsearchBoard/mapboard.jsp'>지도로
									검색</a></li>
							<li><a href='${conPath }/hBoardList.do'>동물로 검색</a></li>
						</ul></li>
					<li><a href='${conPath }/sBoardList.let'>증상검색</a></li>
					<li><a href=''>사이트 소개</a>
						<ul class="sub_nav">
							<li><a href='${conPath }/noticeList.let'>공지사항</a></li>
							
						</ul></li>
				</ul>

			</div>

		</div>
		<div id="lnb"></div>
	</header>
</body>
</html>