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
	<link href="${conPath }/css/footer.css" rel="stylesheet">
</head>
<body>
	<footer>
		<div id="footer">
		<div class="logo">
			<img src="${conPath }/img/footerlogo.png">
		</div>
		<div class="address">
			<ul>
				<li>서울시 XX구 XX로 000 XXX빌딩 8F | TEL : 02-999-0101 | FAX : 02-999-0101</li>
				<li>사업자등록번호 : 000-08-02080 | 통신판매업신로 : 종로 제0316호 | 대표이사 : 홍길동</li>
				<li>펫스피텔 문의 메일 : petspital@naver.com</li>
			</ul>
		</div>
		<div class="copyright">
			ⓒ2022 PETSPITAL.Co.,Ltd. All Rights Reserved.
		</div>
		<div class="page">
			<button class="f_btn">사이트맵</button>
			<button class="f_btn">개인정보 취급방침</button>
			<button class="f_btn">홈페이지 이용약관</button>
		
		</div>
		</div>
	</footer>
</body>
</html>