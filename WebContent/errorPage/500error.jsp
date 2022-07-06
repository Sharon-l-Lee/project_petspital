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
<style>
	body{
		background-color:#eeeeee;
	}
	
	
	#error{
		text-align: center;
	}
	#error a {
		text-decoration: none;
		color:#00adb5;
		
		}
</style>
</head>
<body>
	<img src ="${conPath }/img/500error.png" style=width:100%;height:100%;>
	<div id="error">
	
		<a href="${conPath }/main.do"><img src="${conPath }/img/gomain.png"></a>
	</div>
</body>
</html>