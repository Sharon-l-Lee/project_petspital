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
<link href="${conPath }/css/mypage2.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../main/header.jsp"></jsp:include>
	<div id="wrap">
		<div id="content">
			<div class="container">
				<div class="mypage">
					<!-- 서브메뉴 -->
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
					<!-- 내 정보 보기 -->
					<div class="mypage_content">
						<div class="my_title">
							<h2>내 정보 보기</h2>
						</div>
						<div class="group">
							<div class="row">
								<div class="row_title">이름</div>
								<div class="row_cont">${member.mname }</div>
							</div>
							<div class="row">
								<div class="row_title">이메일</div>
								<div class="row_cont">${member.memail }</div>
							</div>
							<div class="row">
								<div class="row_title">생일</div>
								<div class="row_cont">${member.mbirth }</div>
							</div>
							<div class="row">
								<div class="row_title">연락처</div>
								<div class="row_cont">${member.mphone }</div>
							</div>
							<div class="row">
								<div class="row_title">주소</div>
								<div class="row_cont">${member.maddress  }
									${member.maddress2 }</div>
							</div>

						</div>
						<div class="content_btn">
							<button class="my_btn"
								onclick="location.href='${conPath }/myModifyView.do'">정보 수정</button>
						</div>

					</div>


				</div>

			</div>

		</div>
	</div>

	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>