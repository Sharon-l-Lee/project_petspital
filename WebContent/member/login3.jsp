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
<link href="${conPath }/css/login.css" rel="stylesheet">
<link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-square.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../main/header.jsp"></jsp:include>
	<div id="loginForm_wrap">
		
		<form action="loginOk.jsp" method="post">
			<div id= "login_title">
				<h2>로그인</h2>
			</div>
			<table>
				
				<tr>
					<td><input type="text" id="id" name="id" required="required" placeholder="아이디를 입력하세요">
				</tr>
				<tr>
					
					<td><input type="password" id="pw" name="pw" required="required" placeholder="비밀번호를 입력하세요" ></td>
				</tr>
				
				<tr>
					<td><input type="submit" value="로그인" class="loginBtn_style"> 
				</tr>
			</table>

			<div id="id_pw_find">
				<p><a href="${conPath }/hmember/id_find.jsp">아이디/비밀번호 찾기</a>
			</div>
			<div id="go_join">
				<p><a href="${conPath }/hmember/join.jsp">회원가입 / Join Us →</a></p>
			</div>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>