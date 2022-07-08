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
<link href="${conPath }/js/jqueryui/jquery-ui.css" rel="stylesheet">
<link href="${conPath }/css/login.css" rel="stylesheet">
<link
	href="https://hangeul.pstatic.net/hangeul_static/css/nanum-square.css"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css"> -->
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="${conPath }/js/jqueryui/jquery-ui.js"></script>
<!-- <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script> -->
<script>
	$(function() {
		$("#tabs").tabs();
	});
</script>
</head>
<body>
	<c:if test="${not empty loginErrorMsg}">
		<script>
			alert('${loginErrorMsg}');
			history.back();
		</script>
	</c:if>
	<jsp:include page="../main/header.jsp"></jsp:include>

	<div id="loginForm_wrap">
		<div id="login_title">
			<h2>로그인</h2>
		</div>

		<div id="tabs">
			<ul>
				<li><a href="#member_tab">사용자 로그인</a></li>
				<li><a href="#admin_tab">관리자 로그인</a></li>
			</ul>

			<div id="member_tab">
				<form action="${conPath }/login.do" method="post">
					<div id="container">
						<div class="login_content">
							<div class="input_box">
								<input type="text" id="mid" name="mid" required="required"
									placeholder="아이디를 입력하세요" class="input">
							</div>
							<div class="input_box">
								<input type="password" id="mpw" name="mpw" required="required"
									placeholder="비밀번호를 입력하세요" class="input">
							</div>
							<input type="submit" value="로그인" class="loginBtn_style">


						</div>
					</div>
				</form>

				<div id="id_pw_find">
					<p>
						<a href="${conPath }/member/idfind.jsp">아이디/비밀번호 찾기</a>
				</div>
				<div id="go_join">
					<p>
						<a href="${conPath }/joinView.do">회원가입 / Join Us →</a>
					</p>
				</div>
			</div>

			<!-- 관리자 탭 -->

			<div id="admin_tab">
				<form action="${conPath }/adminlogin.let" method="post">
					<div id="container">
						<div class="login_content">
							<div class="input_box">
								<input type="text" id="aid" name="aid" required="required"
									placeholder="아이디를 입력하세요" class="input">
							</div>
							<div class="input_box">
								<input type="password" id="apw" name="apw" required="required"
									placeholder="비밀번호를 입력하세요" class="input">
							</div>
							<input type="submit" value="로그인" class="loginBtn_style">
						</div>
					</div>
				</form>
			</div>


		</div>
	</div>
	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>