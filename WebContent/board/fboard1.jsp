<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   	 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
		<c:set var="conPath" value="${pageContext.request.contextPath }"/>
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
		<div id = "sub_content">
			<div class="sub_menu">
			</div>
			<div id = "sub_content_area">
				<div class="sub_content">
					<div class="sub_title">
						<h1>자유게시판</h1>
					</div>
					<div class="sub_text">자유게시판입니다</div>
					<div class="bonmun">
						<div id = "content">
							<form action="">
								<ul class="">
									<li class=""></li>
								</ul>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>