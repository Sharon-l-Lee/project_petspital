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
<link href="${conPath }/css/main.css" rel="stylesheet">
<script type="text/javascript">
</script>
</head>
<body>
	<jsp:include page="../main/header.jsp"></jsp:include>
	<div id="banner">
		<h1 class="maintitle">PETSPITAL</h1>
		<img src="${conPath }/img/banner3.png">
	</div>
	<div id="wrap">
	<h1 class="content_title">OVERVIEW</h1>
	<h1 class="content_title">▼</h1>
	<div id="content">
	
		<div class="content_box">
		
			<div class="title us">
				
				<img src ="${conPath }/img/overview2.jpg">
				<h4 class="sub_tit">ABOUT US</h4>
				<span class="sub_content">반려동물 케어의 질적 향상을 위해</span>
			</div>
			
		</div>
		<div class="content_box">
			<div class="title">
			
			<img src ="${conPath }/img/overview1.jpg">
				<h4 class="sub_tit">PET+HOSPITEL</h4><!-- 병원 검색 연결 -->
				<span class="sub_content">24시 응급실, 소동물 및 특수동물 진료 등<br> 맞춤 병원을 소개합니다</span>
			</div>
		</div>
		<div class="content_box">
			<div class="title">
			
			<img src ="${conPath }/img/overview3.jpg">
				<h4 class="sub_tit">= PETSPITAL</h4><!-- QNA연결 -->
				<span class="sub_content">진료비, 의료시설 등의 정보를 <br>투명하게 공개합니다</span>
			</div>
			</div>
		</div>
	<!-- 	<div class="content_box">
			<div class="title"></div>
		</div>
		<div class="content_box">
			<div class="title"></div>
		</div>
		<div class="content_box">
			<div class="title"></div>
		</div> -->
		
		<div id="board_area">
			
			<div id="board">
				<h3>NOTICE & NEWS</h3>
				<table>
					<tbody>
						<c:if test="${notice.size() !=0 }">
						<c:forEach var="i" items="${notice }">
							<tr><td><a href="${conPath }/noticeContent.let?nnum=${i.nnum }">${i.nsubject }</a></td></tr>
						</c:forEach>
						<!-- <tr><td>고양이</td></tr>
						<tr><td>쨱쨱</td></tr>
						<tr><td>토끼는 뭐라고울지?</td></tr> -->
						</c:if>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<jsp:include page="../main/footer.jsp"></jsp:include>

</body>
</html>