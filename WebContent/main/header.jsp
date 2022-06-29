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
<link href="${conPath }/css/header.css" rel="stylesheet">
</head>
<body>
	<header>
		<div id="top">
			<c:if test="${empty member }">
				<ul>
					<li><a href='${conPath }/main.do'>HOME</a></li>
					<li><a href='${conPath }/loginView.do'>로그인</a></li>
					<li><a href='${conPath }/joinView.do'>회원가입</a></li>
				</ul>
			</c:if>
			<c:if test="${not empty member }">
				<ul>
					<li><a href='${conPath }/main.do'>HOME</a></li>
					<li><a href='${conPath }/logout.do'>로그아웃</a></li>
					<li><a href='${conPath }/myView.do'>마이페이지</a></li>
				</ul>
			</c:if>
		</div>
		<div id="gnb">
			<div class="logo"></div>
			<div class="nav">
				<ul>
					<li><a href='${conPath }/freeBoardList.do'>자유게시판</a>
					
					<li><a href=''>Q&A</a>
						<ul class="sub_nav">
							<li><a href=''>메뉴 4-1</a></li>
							<li><a href=''>메뉴 4-2</a></li>
							<li><a href=''>메뉴 4-3</a></li>
						</ul></li>
					<li><a href=''>동물병원 검색</a>
						<ul class="sub_nav">
							<li><a href=''>메뉴 3-1</a></li>
							<li><a href=''>메뉴 3-2</a></li>
						</ul></li>
					<li><a href=''>증상검색</a>
						<ul class="sub_nav">
							<li><a href=''>메뉴 2-1</a></li>
							<li><a href=''>메뉴 2-2</a></li>
							<li><a href=''>메뉴 2-3</a></li>
						</ul></li>
					<li><a href=''>사이트 소개</a>
						<ul class="sub_nav">
							<li><a href=''>메뉴 1-1</a></li>
							<li><a href=''>메뉴 1-2</a></li>
							<li><a href=''>메뉴 1-3</a></li>
						</ul></li>
				</ul>

			</div>

		</div>
		<div id="lnb"></div>
	</header>
</body>
</html>