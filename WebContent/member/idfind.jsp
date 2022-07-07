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
<link href="${conPath }/css/idpwfind.css" rel="stylesheet">
<link href="${conPath }/js/jqueryui/jquery-ui.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="${conPath }/js/jqueryui/jquery-ui.js"></script>
<script>
	$(function() {
		$("#tabs").tabs();
	});
</script>
</head>
<body>
	<jsp:include page="../main/header.jsp"></jsp:include>

	<div id="wrap">

		<div id="tabs">
			<ul>
				<li><a href="#idfind_tab">아이디 찾기</a></li>
				<li><a href="#pwfind_tab">비밀번호 찾기</a></li>
			</ul>


			<div id="idfind_tab">
				<form action="${conPath }/idfind.do" method="post">


					<div class="input_box">
						<input type="text" name="memail" class="input">
					</div>

					<input type="submit" value="아이디찾기" class="loginBtn_style">

				</form>
				<c:if test="${not empty fmid }">
					<div class="result">찾으시는 아이디는 : ${fmid} 입니다</div>
				</c:if>
				<c:if test="${empty fmid }">
					<div class="result">해당하는 아이디가 없습니다</div>
				</c:if>
				
			</div>


			<!-- 비밀번호 찾기 -->

			<div id="pwfind_tab">
				<form action="${conPath }/pwfind.do" method="post">


					<div class="input_box">
						<input type="text" name="memail" class="input">
					</div>

					<input type="submit" value="비밀번호 찾기" class="loginBtn_style">

				</form>

				<c:if test="${not empty fmpw }">
					<div class="result">찾으시는 비밀번호는 : ${fmpw} 입니다</div>
				</c:if>
				<c:if test="${empty fmpw }">
					<div class="result">해당하는 비밀번호가 없습니다</div>
				</c:if>
			</div>


		</div>



	</div>
	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>